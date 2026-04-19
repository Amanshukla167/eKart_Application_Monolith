package com.ekart.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.ekart.DTO.CardDTO;
import com.ekart.DTO.TransactionDTO;
import com.ekart.exception.EKartException;

public interface PaymentService {
    
	Integer addCustomerCard(String customerEmailId, CardDTO cardDTO) throws EKartException, NoSuchAlgorithmException;

	void updateCustomerCard(CardDTO cardDTO) throws EKartException, NoSuchAlgorithmException;

	void deleteCustomerCard(String customerEmailId, Integer cardId) throws EKartException;

	CardDTO getCard(Integer cardId) throws EKartException;

	List<CardDTO> getCustomerCardOfCardType(String customerEmailId, String cardType) throws EKartException;

	Integer addTransaction(TransactionDTO transactionDTO) throws EKartException;

	TransactionDTO authenticatePayment(String customerEmailId, TransactionDTO transactionDTO) throws EKartException, NoSuchAlgorithmException;

	List<CardDTO> getCardsOfCustomer(String customerEmailId, String cardType) throws EKartException;

	
}
