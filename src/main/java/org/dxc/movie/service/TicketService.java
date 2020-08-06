package org.dxc.movie.service;

import java.util.Map;

import org.dxc.movie.controller.TicketController;
import org.dxc.movie.model.Ticket;
import org.springframework.stereotype.Service;


	@Service
	public class TicketService {
		
		public double calculateTotalCost(Ticket ticket) {
			double result=0d;
			TicketController ticketController=new TicketController();
			Map<String,String> list=ticketController.buildState();
			for (Map.Entry<String,String>entry : list.entrySet()) {
				if (entry.getKey().equals(ticket.getCircleType())) {
					result=ticket.getNoOfTickets()*Integer.parseInt(entry.getValue());
				}
				}
			return result;
			}
		}



