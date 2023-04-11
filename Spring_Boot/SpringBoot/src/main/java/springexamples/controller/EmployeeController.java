package springexamples.controller;

import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.dao.OfficeDAO;
import springexamples.database.entity.Employee;
import springexamples.database.entity.Office;
import springexamples.formbeans.EmployeeFormBean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
@PreAuthorize("hasAuthority('ADMIN')")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private OfficeDAO officeDAO;

    //maps to employee-search.jsp : logs url 'search' value
    /*
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String search) {
        log.debug("In the employee search controller method with search = " + search);

        ModelAndView response = new ModelAndView("employee/employee-search");

        List<Employee> employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(search, search);
        response.addObject("employeesList", employees);
        response.addObject("searchParam",search);
        return response;
    }
    */

    /*
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName) {
        log.debug("In the employee search controller method with firstName = " + firstName + " & lastName = " + lastName);

        ModelAndView response = new ModelAndView("employee/search");
        List<Employee> employees = new ArrayList<>();

        employees = employeeDAO.usingANativeQuery(firstName,lastName);
        //employees = employeeDAO.usingJPAQuery(firstName,lastName);

        log.debug("Searching for both First and Last name.");

        response.addObject("searchParamFirst", firstName);
        response.addObject("searchParamLast", lastName);
        response.addObject("employeesList", employees);

        return response;
    }
    */



    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName) {
        log.debug("In the employee search controller method with firstName = " + firstName + " & lastName = " + lastName);

        ModelAndView response = new ModelAndView("employee/search");
        List<Employee> employees = new ArrayList<>();

        //first and last name has value
        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            log.debug("Both first name and last name has a value");
            employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        }
        //only first name has value
        if(!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)){
            log.debug("Both first name and last name has a value");
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstName);
        }
        //only last name has value
        if(StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            log.debug("Both first name and last name has a value");
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastName);
        }

        response.addObject("employeesList", employees);
        response.addObject("searchParamFirst",firstName);
        response.addObject("searchParamLast",lastName);

        return response;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id){

        log.debug("In employee detail controller method with id = " + id);

        ModelAndView response = new ModelAndView("employee/detail");
        Employee employee = employeeDAO.findById(id);

        response.addObject("employee", employee);

        log.debug(employee + "");
        return response;
    }

    @GetMapping("/create")
    public ModelAndView create(){

        log.debug("In employee create controller method");
        ModelAndView response = new ModelAndView("employee/create");

        List<Office> offices = officeDAO.getAllOffice();

        response.addObject("offices",offices);

        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(EmployeeFormBean form){

        log.debug("In employee create-SUBMIT controller method");
        log.debug(form.toString());

        ModelAndView response = new ModelAndView("employee/create");

        Employee emp = new Employee();
        if(form.getId() != null && form.getId() > 0){
           emp =  employeeDAO.findById(form.getId());
        }
        emp.setProfileImage(form.getProfileImage());
        emp.setFirstName(form.getFirstName());
        emp.setLastName(form.getLastName());
        emp.setOfficeId(form.getOfficeId());
        emp.setExtension(form.getExtension());
        emp.setEmail(form.getEmail());
        emp.setJobTitle(form.getJobTitle());
        emp.setVacationHours(form.getVacationHours());
        emp.setOfficeId(form.getOfficeId());
        employeeDAO.save(emp);

        response.addObject("form",form);

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id){

        log.debug("In employee edit controller method");
        ModelAndView response = new ModelAndView("employee/create");

        Employee emp = employeeDAO.findById(id);
        EmployeeFormBean form = new EmployeeFormBean();

        //set the employee form fields: to be added to the model and passed to the jsp page
        form.setProfileImage(emp.getProfileImage());
        form.setId(emp.getId());
        form.setFirstName(emp.getFirstName());
        form.setLastName(emp.getLastName());
        form.setOfficeId(emp.getOfficeId());
        form.setExtension(emp.getExtension());
        form.setEmail(emp.getEmail());
        form.setJobTitle(emp.getJobTitle());
        form.setVacationHours(emp.getVacationHours());
        response.addObject("form",form);

        List<Office> offices = officeDAO.getAllOffice();
        response.addObject("offices",offices);

        return response;
    }


}
