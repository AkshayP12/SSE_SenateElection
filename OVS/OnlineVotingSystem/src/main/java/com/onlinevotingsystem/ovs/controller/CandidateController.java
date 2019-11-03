package com.onlinevotingsystem.ovs.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.onlinevotingsystem.ovs.model.Employee;
import com.onlinevotingsystem.ovs.service.EmployeeService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
	private EmployeeService employeeService;
	public CandidateController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees)
		return "candidates/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "candidates/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		// get employee from the service
		Employee theEmployee = employeeService.findById(theId);
		//Changing name mapping
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		// send over to our form
		return "candidates/employee-form";			
	}

	@PostMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee theEmployee, Model model) {
		ModelAndView modelView= new ModelAndView();
		String fName=theEmployee.getFirstName();
		String lName=theEmployee.getLastName();
		String email=theEmployee.getEmail();
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (!((fName != null) 
                && (!fName.equals("")) 
                && (fName.matches("^[a-zA-Z]*$")))) {
			model.addAttribute("nameError", "First name is Invalid");
			modelView.setViewName("candidates/employee-form");
			return modelView;
		}
		else if (!((lName != null) 
                && (!lName.equals("")) 
                && (lName.matches("^[a-zA-Z]*$")))) {
			model.addAttribute("nameError", "Last name is Invalid");
			modelView.setViewName("candidates/employee-form");
			return modelView;		
		}
		else if(!email.matches(regex)) {
			model.addAttribute("nameError", "Please Enter a Valid Email");
			modelView.setViewName("candidates/employee-form");
			return modelView;
		}

		// save employee
		employeeService.save(theEmployee);
		// use a redirect to prevent duplicate submissions
		modelView.setViewName("redirect:/candidates/list");
		return modelView;
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		// delete employee
		employeeService.deleteById(theId);
		// redirect to /employees/list
		return "redirect:/candidates/list";
	}
}




