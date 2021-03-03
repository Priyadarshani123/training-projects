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

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.servlet.ModelAndView;

import com.transporter.ioc.domain.Load;
import com.transporter.ioc.service.LoadService;

	
	@RestController
	public class LoadController {
		@Autowired
		LoadService loadService;
		@RequestMapping(value = "/loads", method = RequestMethod.GET)
		
		public ModelAndView getConsigneePage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
			
      try {
    	  return new ModelAndView("error");
      } catch (Exception e)
      {      
      
				StringWriter errors = new StringWriter(); 
				e.printStackTrace(new PrintWriter(errors));
				return new ModelAndView("error");
				
			}
		
	}
		@RequestMapping(value = "/Loads", method = RequestMethod.GET)
		public List<Load> getAllLoads(HttpServletRequest request, HttpServletResponse response, HttpSession session
				) throws IOException, InterruptedException {
			List<Load> loadList = new ArrayList<Load>();
			try {
				loadList = loadService.getUnAssignedLoads();
				if (loadList == null)
					loadList = Collections.emptyList();
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return Collections.emptyList();
			}
			return loadList;
		}

	}


