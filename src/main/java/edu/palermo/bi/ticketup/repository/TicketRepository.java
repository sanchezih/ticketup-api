package edu.palermo.bi.ticketup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.palermo.bi.ticketup.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}