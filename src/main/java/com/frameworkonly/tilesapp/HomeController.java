package com.frameworkonly.tilesapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = {"/page1","/"}, method = RequestMethod.GET)
	public String firstPage(Model model) {
		model.addAttribute("firstPageMessage", "This is the first page");
		return "firstpage";
	}
	
}
