package com.ekart.entity;

import java.time.LocalDateTime;

import org.hibernate.resource.transaction.spi.TransactionStatus;

public class Transaction {
   
	
	private Integer trancationID;
	
	private Integer orderID;
	
	private Integer cardId;
	
	private Double totalPrice;
	
	private LocalDateTime tractionDate;
	 
	private TransactionStatus  status;
	
	

	public Integer getTrancationID() {
		return trancationID;
	}

	public void setTrancationID(Integer trancationID) {
		this.trancationID = trancationID;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getTractionDate() {
		return tractionDate;
	}

	public void setTractionDate(LocalDateTime tractionDate) {
		this.tractionDate = tractionDate;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	
	
	
	
	
	
}
