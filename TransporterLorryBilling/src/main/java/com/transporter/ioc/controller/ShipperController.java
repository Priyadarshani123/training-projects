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
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.servlet.ModelAndView;

    import com.transporter.ioc.domain.Shipper;
    import com.transporter.ioc.service.ShipperService;

	@RestController
	public class ShipperController {

		@Autowired
		private ShipperService shipperService;
		
		@RequestMapping(value = "/addShipper", method = RequestMethod.POST)
		public String addShipper(@RequestBody String json, HttpSession session) {
			return null;
			

			}
		
		@RequestMapping(value = "/shipper", method = RequestMethod.GET)
		public ModelAndView getShipperPage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			try {
				
                  return new ModelAndView("login");
			} catch (Exception e)  {
			
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
				return new ModelAndView("error");
			}
			}
		

		@RequestMapping(value = "/getShippers", method = RequestMethod.GET)
		public List<Shipper> getShippers(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, InterruptedException {
			List<Shipper> shipperList = new ArrayList<Shipper>();
			try {
				shipperList = shipperService.getShipperList();
				if (shipperList == null)
					shipperList = Collections.emptyList();
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				return Collections.emptyList();
			}
			return shipperList;
		}

	}


