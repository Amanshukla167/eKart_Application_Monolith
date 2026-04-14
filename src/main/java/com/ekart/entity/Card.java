package com.ekart.entity;

import java.time.LocalDate;

public class Card {
	
	private Integer cardID;
	private String cardType;
	private String cardNumber;
	private String cvv;
	private LocalDate expiryDate;
	private String nameOnCard;
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
