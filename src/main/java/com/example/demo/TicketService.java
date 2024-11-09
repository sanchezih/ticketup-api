package com.example.demo;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

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


			//ticket.setUpdatedAt(LocalDateTime.parse(record[12], DateTimeFormatter.ISO_DATE_TIME));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

                
                String dateString = record[12]; // Ajusta el índice según la posición de `updated_at` en tu CSV
                LocalDateTime updatedAt = LocalDateTime.parse(dateString, formatter);
                ticket.setUpdatedAt(updatedAt);

				ticketRepository.save(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}