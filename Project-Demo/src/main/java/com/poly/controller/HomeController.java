package com.poly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.repository.CustomerRepository;

@Controller
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public String customersPage(Model model,
		      @RequestParam(name = "page", required = false, defaultValue = "0") int page,
		      @RequestParam(name = "size", required = false, defaultValue = "5") int size,
		      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {

//		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
//			page = Integer.parseInt(request.getParameter("page")) - 1;
//		}
//
//		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
//			size = Integer.parseInt(request.getParameter("size"));
//		}
		System.out.println();
		model.addAttribute("customers", customerRepository.findAll(PageRequest.of(page, size)));
		return "customers";
	}

}
