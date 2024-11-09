package edu.palermo.bi.ticketup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.palermo.bi.ticketup.service.TicketService;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

	private final TicketService ticketService;

	/*----------------------------------------------------------------------------*/

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	/*----------------------------------------------------------------------------*/

	@PostMapping("/upload")
	public ResponseEntity<?> uploadCSV(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo esta vacio.");
		}

		ticketService.saveTicketsFromCSV(file);
		return ResponseEntity.ok("Archivo CSV cargado correctamente.");
	}
}