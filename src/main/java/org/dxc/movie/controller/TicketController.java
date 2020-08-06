package org.dxc.movie.controller;

import java.util.HashMap;

import java.util.Map;

import org.dxc.movie.model.Ticket;
import org.dxc.movie.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RequestMapping("/movie")
@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;

	@RequestMapping("/")
	public String showIndexPage() {
		return "index";
	}

	@RequestMapping("/bookTicket")
	public String showPage(@ModelAttribute("ticket") Ticket ticket) {
		return "showpage";
	}
	
	
	@RequestMapping(value="/calculateCost",method=RequestMethod.POST)
	public String calculateTotalCost(@ModelAttribute("ticket")Ticket ticket,BindingResult result,ModelMap map) {
		if(result.hasErrors())
			return "showpage";
		else 
		map.addAttribute("cost",ticketService.calculateTotalCost(ticket));
			return "success";
	}
	@ModelAttribute (name="circleList")
	public Map<String,String> buildState(){
	Map<String, String> list = new HashMap<String, String>(); 
	list.put("King", new String("150")); 
	list.put("Queen", new String("250"));
	return list;
	}
}
