package com.ekart.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CardDTO {

	
	@NotBlank(message = "Card type can not be null")
	private String cardType;
	private String cardNumber;
	private String nameOnCard;
	private String hashCvv;
	@NotNull(message = "Please enter the cvv of the card")
	private Integer cvv;
	private LocalDate expiryDate;
	@NotNull(message = "Card id can not be null")
	private Integer cardId;
	private String customerEmailId;
	
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
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	public String getHashCvv() {
		return hashCvv;
	}
	
	public void setHashCvv(String hashCvv) {
		this.hashCvv = hashCvv;
	}
	
	public Integer getCvv() {
		return cvv;
	}
	
	
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CardDTO  [ CardType " + this.getCardType() + "CardNumber : " + this.getCardNumber() + "\n" +
				"NameOnCard : " + this.getNameOnCard()  + "HashCvv : " + this.getHashCvv() + "Cvv : " + this.getCvv() + "\n" +
		      "ExpiryDate : " + this.getExpiryDate() + "CardId : " + this.getCardId() + "CustomerEmailId : " + this.customerEmailId;
	}
	
	
}
