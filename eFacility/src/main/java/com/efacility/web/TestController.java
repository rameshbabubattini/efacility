package com.efacility.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.efacility.model.Employee;
import com.efacility.service.EmployeeService;
import com.efacility.service.TestService;

@Controller
@RequestMapping("/employee")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestService testService;
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/get.html", method = RequestMethod.GET)
	public ModelAndView get() {
		logger.trace("1. Trace");
		logger.debug("2. Debug");
		logger.info("3. Info");
		logger.warn("4. Warn");
		logger.error("5. Error");
		ModelAndView model = new ModelAndView();
		model.setViewName("testView");
		model.addObject("list", employeeService.list());
		System.out.println("end get..");
		return model;
	}
	
	@RequestMapping(value = "/addemployeeform.html", method = RequestMethod.GET)
	public ModelAndView addEmployeeForm() {
		logger.debug("start add()");
		ModelAndView model = new ModelAndView();
		Employee e = new Employee();
		e.setId("Enter employee id");
		e.setName("Enter employee name");
		model.addObject("e", e);
		model.setViewName("addemployee");
		return model;
	}
	
	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("e") Employee e, ModelAndView model) {
		logger.debug("start add()");
		logger.error("start add()");
		logger.trace("start add()");
		logger.info("start add()");
		logger.error("e=" + e);
		employeeService.add(e);
		model.addObject("message", "New employee added successfully.");
		model.setViewName("addemployee");
		return model;
	}
	
	/**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }
	
}

