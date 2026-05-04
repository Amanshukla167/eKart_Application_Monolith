package com.ekart.DTO;

import java.time.LocalDateTime;

import com.ekart.Enum.TransactionStatus;

import jakarta.validation.Valid;

public class TransactionDTO {
    
	
	private Integer transactionId;

	private Integer  orderID;
	
	private Integer  cardID;
	
	private Double totalPrice;
	
	private LocalDateTime transactionDate;
	
	private TransactionStatus transactionStatus;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", order=" + orderID + ", card=" + cardID
				+ ", totalPrice=" + totalPrice + ", transactionDate=" + transactionDate + ", transactionStatus="
				+ transactionStatus + "]";
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getCardID() {
		return cardID;
	}

	public void setCardID(Integer cardID) {
		this.cardID = cardID;
	}
	
}
