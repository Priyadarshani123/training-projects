package com.transporter.ioc.controller;

	import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.transporter.ioc.domain.Consignee;
import com.transporter.ioc.service.ConsigneeService;

	
@RestController
public class ConsigneeController {
	@Autowired
	private ConsigneeService consigneeService;
	
	@RequestMapping(value = "/addConsignee", method = RequestMethod.POST)
	public String addConsignee(@RequestBody String json, HttpSession session) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Consignee consignee = objectMapper.readValue(json, Consignee.class);
			if (consigneeService.addConsignee(consignee)) {
				return "Success";
			} else {
				return "Failure";
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			return "error";

		}
	}

	@RequestMapping(value = "/consignee", method = RequestMethod.GET)
	public ModelAndView getConsigneePage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		
			return new ModelAndView("consignee");
		}
	

	@RequestMapping(value = "/getConsignees/{shipperId}", method = RequestMethod.GET)
	public List<Consignee> getConsignees(@PathVariable("shipperId") long shipperId, HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException, InterruptedException {
		List<Consignee> consigneeList = new ArrayList<Consignee>();
		try {
			consigneeList = consigneeService.getConsigneeList(shipperId);
			if (consigneeList == null)
				consigneeList = Collections.emptyList();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			return Collections.emptyList();
		}
		return consigneeList;
	}

	@RequestMapping(value = "/getConsignees", method = RequestMethod.GET)
	public List<Consignee> getAllConsignees(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException, InterruptedException {
		List<Consignee> consigneeList = new ArrayList<Consignee>();
		try {
			consigneeList = consigneeService.getAllConsigneeList();
			if (consigneeList == null)
				consigneeList = Collections.emptyList();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			return Collections.emptyList();
		}
		return consigneeList;
	}
}


				