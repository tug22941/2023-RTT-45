package springexamples.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springexamples.database.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    //this is a JPA hibernate query
    @Query("FROM Employee e")
    List<Employee> getAllEmployee();

    //this is a native query - SpringBoot does the work (TRUE POWAH!!)
    //appended "IgnoreCase" onto the variable name to remove case sensitivity
    List<Employee> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);

    //find Employee using JPA Query
    @Query("Select e from Employee e where lower(e.firstName) = lower(:firstName)")
    List<Employee> findByName(String firstName, String lastName);

    //ex1) using native query
    @Query(value="select * from employees where lower(firstname) = lower(:firstName);", nativeQuery = true)
    List<Employee> usingNativeQuery(String firstName, String lastName);

    //ex2) using JPA query
    @Query("Select e from Employee e where lower(e.firstName) = lower(:firstName)")
    List<Employee> usingJPAQuery(String firstName, String lastName);


}
