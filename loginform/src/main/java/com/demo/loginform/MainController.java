package com.demo.loginform;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		System.out.println("welcome");
		return "welcomePage";
	}

	@GetMapping("/admin")
	public String adminPage(Model model) {
		System.out.println("admin");
		return "adminPage";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		System.out.println("login");
		return "loginPage";

	}

	@GetMapping("/logoutSuccessful")
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "logout");
		System.out.println("successful");
		return "logoutSuccessfulPage";

	}

	@GetMapping("/userInfo")
	public String userInfo(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("hi");

		System.out.println("User Name: " + userName);
		return "userInfoPage";

	}

	@GetMapping("/403")
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}
}
