package com.crud.example.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crud.example.Dao.EmployeeDAO;
import com.crud.example.Model.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {

	    @Autowired
	    private EmployeeDAO employeeDAO;

	    @RequestMapping(value = "/employee",method=RequestMethod.POST)
	    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee)
	    {
	        try
	        {
	            if(employeeDAO.getEmployeeById(employee.getId()) != null);
	            employeeDAO.updateEmployee(employee);
	        }
	        catch(EmptyResultDataAccessException e)
	        {
	            System.out.println("inside catch");
	            employeeDAO.saveEmployee(employee);
	        }
	        return new ModelAndView("redirect:/employees");
	    }

	    @RequestMapping(value = "/edit/{id}")
	    public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee,@PathVariable("id") int id)
	    {
	        ModelAndView model = new ModelAndView("employees");

	        employee = employeeDAO.getEmployeeById(id);
	        List employeeList = employeeDAO.getAllEmployees();

	        model.addObject("employee",employee);
	        model.addObject("employeeList",employeeList);

	        return model;
	    }

	    @RequestMapping(value = "/delete/{id}")
	    public ModelAndView deleteEmployee(@ModelAttribute("employee") Employee employee,@PathVariable("id") int id)
	    {
	        employeeDAO.deleteEmployee(id);

	        return new ModelAndView("redirect:/employees");
	    }

	    @RequestMapping(value = "/employees")
	    public ModelAndView listEmployees(@ModelAttribute("employee") Employee employee)
	    {
	        ModelAndView model = new ModelAndView("employees");

	        List employeeList = employeeDAO.getAllEmployees();
	        System.out.println(employeeList);
	        model.addObject("employeeList", employeeList);

	        return model;
	    }

}
