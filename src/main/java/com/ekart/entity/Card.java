package com.ekart.entity;

import java.time.LocalDate;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ek_card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARD_ID")
	private Integer cardID;
	
	@Column(name = "CARD_TYPE")
	private String cardType;
	
	@Column(name = "CARD_NUMBER")
	private String cardNumber;
	
	@Column(name = "CVV")
	private String cvv;
	
	@Column(name = "EXPIRY_DATE")
	private LocalDate expiryDate;
	
	@Column(name = "NAME_ON_CARD")
	private String nameOnCard;
	
	@Column(name = "CUSTOMER_EMAIL_ID")
	private String customerEmailId;
	
	public Integer getCardID() {
		return cardID;
	}
	
	public void setCardID(Integer cardID) {
		this.cardID = cardID;
	}
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCvv() {
		return cvv;
	}
	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	
	
	
    
}
