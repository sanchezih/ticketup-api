package edu.palermo.bi.ticketup.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	private String ticketId;

	private String purchaseReference;

	private String type;

	private String grandstand;

	private String sector;

	private String eventCode;

	private String eventType;

	@Column(name = "mean_price", precision = 15, scale = 6)
	private BigDecimal meanPrice;

	private String countryName;

	private String countryCode;

	private String sportOrganizationCode;

	private String dimUser;

	private LocalDateTime updatedAt;

	/*----------------------------------------------------------------------------*/

	public Ticket(String ticketId, String purchaseReference, String type, String grandstand, String sector,
			String eventCode, String eventType, BigDecimal meanPrice, String countryName, String countryCode,
			String sportOrganizationCode, String dimUser, LocalDateTime updatedAt) {
		super();
		this.ticketId = ticketId;
		this.purchaseReference = purchaseReference;
		this.type = type;
		this.grandstand = grandstand;
		this.sector = sector;
		this.eventCode = eventCode;
		this.eventType = eventType;
		this.meanPrice = meanPrice;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.sportOrganizationCode = sportOrganizationCode;
		this.dimUser = dimUser;
		this.updatedAt = updatedAt;
	}

	public Ticket() {
	}

	/*----------------------------------------------------------------------------*/

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getPurchaseReference() {
		return purchaseReference;
	}

	public void setPurchaseReference(String purchaseReference) {
		this.purchaseReference = purchaseReference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGrandstand() {
		return grandstand;
	}

	public void setGrandstand(String grandstand) {
		this.grandstand = grandstand;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public BigDecimal getMeanPrice() {
		return meanPrice;
	}

	public void setMeanPrice(BigDecimal meanPrice) {
		this.meanPrice = meanPrice;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getSportOrganizationCode() {
		return sportOrganizationCode;
	}

	public void setSportOrganizationCode(String sportOrganizationCode) {
		this.sportOrganizationCode = sportOrganizationCode;
	}

	public String getDimUser() {
		return dimUser;
	}

	public void setDimUser(String dimUser) {
		this.dimUser = dimUser;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}