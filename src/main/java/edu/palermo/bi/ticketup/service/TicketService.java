package edu.palermo.bi.ticketup.service;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

import edu.palermo.bi.ticketup.model.Ticket;
import edu.palermo.bi.ticketup.repository.TicketRepository;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;

	/*----------------------------------------------------------------------------*/

	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	/*----------------------------------------------------------------------------*/

	public void saveTicketsFromCSV(MultipartFile file) {

		try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {

			List<String[]> records = csvReader.readAll();
			records.remove(0); // Elimina el encabezado del CSV

			for (String[] record : records) {
				Ticket ticket = new Ticket();
				ticket.setTicketId(record[0]);
				ticket.setPurchaseReference(record[1]);
				ticket.setType(record[2]);
				ticket.setGrandstand(record[3]);
				ticket.setSector(record[4]);
				ticket.setEventCode(record[5]);
				ticket.setEventType(record[6]);
				ticket.setMeanPrice(new BigDecimal(record[7]));
				ticket.setCountryName(record[8]);
				ticket.setCountryCode(record[9]);
				ticket.setSportOrganizationCode(record[10]);
				ticket.setDimUser(record[11]);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
				String dateString = record[12];

				LocalDateTime updatedAt = LocalDateTime.parse(dateString, formatter);
				ticket.setUpdatedAt(updatedAt);

				ticketRepository.save(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}