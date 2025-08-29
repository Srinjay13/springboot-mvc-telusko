package com.telusko.SpringMVCBoot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.SpringMVCBoot.model.Coder;

@Controller
public class HomeController {
	
	@Autowired
	CoderRepo repo;
	
	//Now let's say if we want to set a data value to a field in the JSP that can be set from here, how do we do that?
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Coders");
	}
	
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page is being requested by the user !");
		//If we just return "index.jsp and keep the method return type to String, it just downloads our jsp file when we hit the url
		//So to make this work, we will use a dependancy named Tomcat Jasper and add in the pom.xml and it will work
		return "index";
	}
	/*
	@RequestMapping("subtract")
	public String subtract(HttpServletRequest request) {
		//We are using like we used to do in Servlet 
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		int result = num1 - num2;
		HttpSession session = request.getSession();
		session.setAttribute("result", result);
		
		System.out.println("Result page is being requested by the user !");
		return "result.jsp";
	}
	*/
	//But the problem with this is we are using Spring, so is there any better way to do it? Obviously, YES !
	/*
	@RequestMapping("subtract")
	public String subtract(@RequestParam("num1") int num1, @RequestParam("num2") int num2,HttpSession session) {
		
		int result = num1 - num2;
		
		session.setAttribute("result", result);
		
		System.out.println("Result page is being requested by the user !");
		return "result.jsp";
		//But still can we remove the HttpSession in the parameter of the function, let's see how we can do that using Model and View
	}
	*/
	/*@RequestMapping("subtract")
	public ModelAndView subtract(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		ModelAndView model=new ModelAndView();
		int result = num1 - num2;
		model.addObject("result",result);
		model.setViewName("result.jsp");
		
		System.out.println("Result page is being requested by the user !");
		return model;
		//Now if we don't want anyone in the world to get access to the jsp pages then we can put it in a separate folder to make it private and if we want to remove the extension, i.e. ".jsp" from our java code, we can add something in the application.properties file, let's see how we can achieve that
	}
	*/
	@RequestMapping("subtract")
	public String subtract(@RequestParam("num1") int num1, @RequestParam("num2") int num2,Model m) {
		//ModelAndView model=new ModelAndView(); -- If we don't want to use ModelandView, we can simply use Model and return the string as we were doing earlier !
		
		int result = num1 - num2;
		m.addAttribute("result",result);
		
		System.out.println("Result page is being requested by the user !");
		return "result";
	}
	
	@RequestMapping("addCoder")
	public String addCoder(@ModelAttribute("c") Coder c) {
		// We can entirely remove the concept of Model object as it can be done by ModelAttribute on its own
		// ONE MORE IMP THING TO NOTICE is that if we want we can entirely remove @ModelAttribute if we use the same class name "Coder" in the jsp file as "coder" then it will work as it is now, but that is not a good convention
		//m.addAttribute("coder",c);
		repo.save(c);
		return "coders";
	}
	
	//If we want to use POST method, then we can simply use method="post" in the form we are using in the jsp page
	
    // If we want to restrict the user to only allow post in server side too, we can change this - @RequestMapping("addCoder") to @RequestMapping(value="addCoder",method=RequestMethod.POST)
	
	// Another way we could use @PostMapping attribute instead of RequestMapping which supports both GET and POST to avoid confusion
	
	
	//Now let's see how GetMapping works by doing 
	
	@GetMapping("showCoders")
	public String showCoders(Model m) {
		//List<Coder> coders = Arrays.asList(new Coder(1,"Srinjay Saha"),new Coder(2,"Sanjay Saha"));
		//We are getting the object from the DB now using JPA Repository Methods
		m.addAttribute("result",repo.findAll());
		return "showCoders";
	}
	
	@GetMapping("getCoder")
	public String getCoder(@RequestParam("coderId") int cid, Model m) {
		m.addAttribute("coder", repo.getOne(cid));
		return "coders";
	}
	
	@GetMapping("getCoderByName")
	public String getCoderByName(@RequestParam String cname, Model m) {
		// fetch matching coder(s) from DB
	    List<Coder> coders = repo.find(cname);

	    // add to model
	    m.addAttribute("result", coders);
		return "coders";
	}
}
