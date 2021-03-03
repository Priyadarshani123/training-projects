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
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.transporter.ioc.domain.Location;
import com.transporter.ioc.domain.States;
import com.transporter.ioc.service.LocationService;

	
	@RestController
	public class LocationController {
		@Autowired
		private LocationService locationService;

		@RequestMapping(value = "/addLocation", method = RequestMethod.POST)
		public String addLocation(@RequestBody String json, HttpSession session) {
			return null;
					
			}
	

		@RequestMapping(value = "/location", method = RequestMethod.GET)
		public ModelAndView getLocationPage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			try {
				
					return new ModelAndView("login");
			} catch (Exception e) {

				
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return new ModelAndView("error");

			}
		}

		@RequestMapping(value = "/getLocations", method = RequestMethod.GET)
		public List<Location> getLocations(HttpServletRequest request, HttpServletResponse response, HttpSession session
				) throws IOException, InterruptedException {
			List<Location> locationList = new ArrayList<Location>();
			try {
				locationList = locationService.listLocations();
				if (locationList == null)
					locationList = Collections.emptyList();
			} catch (Exception e) {

			}
			return locationList;
		}

		@RequestMapping(value = "/getLocations/{stateid}", method = RequestMethod.GET)
		public List<Location> getLocationsInState(@PathVariable("stateid") long stateId, HttpServletRequest request,
				HttpServletResponse response, HttpSession session)
				throws IOException, InterruptedException {
			List<Location> locationList = new ArrayList<Location>();
			try {
				locationList = locationService.getLocationInState(stateId);
				if (locationList == null)
					locationList = Collections.emptyList();
			} catch (Exception e) {

			}
			return locationList;
		}

		@RequestMapping(value = "/getStates", method = RequestMethod.GET)
		public List<States> getStates(HttpServletRequest request, HttpServletResponse response, HttpSession session
				) throws IOException, InterruptedException {
			List<States> locationList = new ArrayList<States>();
			try {
				locationList = locationService.listStates();
				if (locationList == null)
					locationList = Collections.emptyList();
			} catch (Exception e) {

			}
			return locationList;
		}

		@RequestMapping(value = "/addStates", method = RequestMethod.POST)
		public String addStates(@RequestBody String json, HttpSession session) {
			

			return "Failure";
		}
		
		
			}
		


