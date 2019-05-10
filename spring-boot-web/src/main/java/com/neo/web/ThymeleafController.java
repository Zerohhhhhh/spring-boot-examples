package com.neo.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.neo.model.User;
import com.neo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

	@Autowired
	private UserRepository userRepository;
	
    @RequestMapping("/hi")
	public String hello(Locale locale, Model model) {
		model.addAttribute("greeting", "Hello!");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);        
		String formattedDate = dateFormat.format(date);
		model.addAttribute("currentTime", formattedDate);

		List<User> users = userRepository.findAll();
		model.addAttribute("users",users);

		return "hello";
	}

}