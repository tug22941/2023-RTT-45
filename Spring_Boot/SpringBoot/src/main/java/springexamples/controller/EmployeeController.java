package springexamples.controller;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    //maps to employee-search.jsp : logs url 'search' value
    /*
    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String search) {
        log.info("In the employee search controller method with search = " + search);

        ModelAndView response = new ModelAndView("employee/employee-search");

        List<Employee> employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(search, search);
        response.addObject("employeesList", employees);
        response.addObject("searchParam",search);
        return response;
    }
    */

    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName) {
        log.info("In the employee search controller method with firstName = " + firstName + " & lastName = " + lastName);

        ModelAndView response = new ModelAndView("employee/employee-search");
        List<Employee> employees = new ArrayList<>();

        //first and last name has value
        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            log.info("Both first name and last name has a value");
            employees = employeeDAO.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        }
        //only first name has value
        if(!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)){
            log.info("Both first name and last name has a value");
            employees = employeeDAO.findByFirstNameContainingIgnoreCase(firstName);
        }
        //only last name has value
        if(StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            log.info("Both first name and last name has a value");
            employees = employeeDAO.findByLastNameContainingIgnoreCase(lastName);
        }

        response.addObject("employeesList", employees);
        response.addObject("searchParamFirst",firstName);
        response.addObject("searchParamLast",lastName);

        return response;
    }

}
