package com.ekart.entity;

import java.time.LocalDateTime;

import com.ekart.Enum.TransactionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "EK_TRANSACTION")
public class Transaction {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trancationID;
	
	@Column(name = "ORDER_ID")
	private Integer orderID;
	
	@Column(name = "CARD_ID")
	private Integer cardId;
	
	@Column(name = "TOTAL_PRICE")
	private Double totalPrice;
	
	@Column(name = "TRANSACTION_DATE")
	private LocalDateTime tractionDate;
	
	@Column(name = "TRANSACTION_STATUS")
	@Enumerated(EnumType.STRING)
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
