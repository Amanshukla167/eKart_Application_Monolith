package com.ekart.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.DTO.CardDTO;
import com.ekart.DTO.TransactionDTO;
import com.ekart.Enum.TransactionStatus;
import com.ekart.entity.Card;
import com.ekart.entity.Transaction;
import com.ekart.exception.EKartException;
import com.ekart.repo.CardRepository;
import com.ekart.repo.TransactionRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
class PaymentServiceImpl implements PaymentService {
	
	    
	    @Autowired
	    private CardRepository cardRepository;
	    
	    @Autowired
	    private TransactionRepository transactionRepository;
       
	   @Override
		public Integer addCustomerCard(String customerEmailId, CardDTO cardDTO) throws EKartException, NoSuchAlgorithmException {
			 
		     Integer CardID = 0;
		     
		     List<Card> cardobj = cardRepository.findByCustomerEmailId(customerEmailId);
		     
		     for(Card card :cardobj ) {
		    	 if(card.getCardNumber().equals(cardDTO.getCardNumber()) ) {
		    		 throw new EKartException("this card already exist plese enrter diffrent card");
		    	 }  

		     }
		   
		    	 Card card = new Card();
		    	 card.setCardNumber(cardDTO.getCardNumber());
	    		 card.setCardType(cardDTO.getCardType());
	    		 card.setCvv(cardDTO.getCvv().toString());
	    		 card.setExpiryDate(cardDTO.getExpiryDate());
	    		 card.setNameOnCard(cardDTO.getNameOnCard());
	    		 card.setCustomerEmailId(customerEmailId);
	    		 cardRepository.save(card);
	    		 CardID =  card.getCardID();
		     
		  
			return CardID;
		}
	     
	   
	   
	   
	    @Override
	    public Integer addTransaction(TransactionDTO transactionDTO) throws EKartException {
	    	 
	         Transaction transaction = new Transaction();
	         
	         transaction.setOrderID(transactionDTO.getOrderID());
	         transaction.setCardId(transactionDTO.getCardID());
	       
	         transaction.setStatus(TransactionStatus.valueOf(transactionDTO.getTransactionStatus().toString().toUpperCase()));
	         transaction.setTotalPrice(transactionDTO.getTotalPrice());
	         transaction.setTractionDate(transactionDTO.getTransactionDate());
	         
	         transactionRepository.save(transaction);
	    	
	    	return transaction.getTrancationID();
	    }
	    
	    
	    
	    
	    @Override
	    public TransactionDTO authenticatePayment(String customerEmailId, TransactionDTO transactionDTO)
	    		throws EKartException, NoSuchAlgorithmException {
	    		
	    	return null;
	    }
	    
	    
	    
	    
	    @Override
	    public void deleteCustomerCard(String customerEmailId, Integer cardId) throws EKartException {
	    	 
	          List<Card> cardobj = cardRepository.findByCustomerEmailId(customerEmailId);
			     
			     for(Card card :cardobj ) {
			    	 if(card.getCardID().equals(cardId)) {
			    		 cardRepository.delete(card);
			    		break;
			    	 }
			     }
	    	
	    }
	    
	    
	    
	    
	    
	    @Override
	    public CardDTO getCard(Integer cardId) throws EKartException {
	    	Optional<Card> cardobj = cardRepository.findById(cardId);
	    	
	    	Card card = cardobj.orElseThrow(()-> new EKartException("this card does not exist"));
	    	
	    	CardDTO cardDTO = new CardDTO();
	    	
	    	cardDTO.setCardNumber(card.getCardNumber());
	    	cardDTO.setCardType(card.getCardType());
	    	cardDTO.setCustomerEmailId(card.getCustomerEmailId());
	    	cardDTO.setHashCvv(card.getCvv());
	    	cardDTO.setExpiryDate(card.getExpiryDate());
	    	cardDTO.setNameOnCard(card.getNameOnCard());
	    	
	    	return cardDTO;
	    }
	    
	    
	    
	    
	    @Override
	    public List<CardDTO> getCardsOfCustomer(String customerEmailId) throws EKartException {
	    	 
	    	List<CardDTO>  cardDTOs = new ArrayList<CardDTO>();
	    	
	        List<Card> cardobj = cardRepository.findByCustomerEmailId(customerEmailId);
	        
	        if(cardobj == null || cardobj.isEmpty()) {
	        	throw new EKartException("the  is no card avalible by the customer id " + customerEmailId);
	        } 
	        
	        for(Card card : cardobj) {
	        	
	        	
	        		
	        		CardDTO cardDTO = new CardDTO();
			    	
			    	cardDTO.setCardNumber(card.getCardNumber());
			    	cardDTO.setCardType(card.getCardType());
			    	cardDTO.setCustomerEmailId(card.getCustomerEmailId());
			    	cardDTO.setHashCvv(card.getCvv());
			    	cardDTO.setExpiryDate(card.getExpiryDate());
			    	cardDTO.setNameOnCard(card.getNameOnCard());
			    	
			    	cardDTOs.add(cardDTO);
	        	
	        	
	        }
	    	
	    	return cardDTOs;
	    }
	    
	    
	    
	    
	    @Override
	    public List<CardDTO> getCustomerCardOfCardType(String customerEmailId, String cardType) throws EKartException {
	    	
           List<CardDTO>  cardDTOs = new ArrayList<CardDTO>();
	    	
	        List<Card> cardobj = cardRepository.findByCustomerEmailId(customerEmailId);
	        
	        if(cardobj == null || cardobj.isEmpty()) {
	        	throw new EKartException("the  is no card avalible by the customer id " + customerEmailId);
	        } 
	        
	        for(Card card : cardobj) {
	        	
	        	if(cardType.equalsIgnoreCase(card.getCardType())) {
	        		
	        		CardDTO cardDTO = new CardDTO();
			    	
			    	cardDTO.setCardNumber(card.getCardNumber());
			    	cardDTO.setCardType(card.getCardType());
			    	cardDTO.setCustomerEmailId(card.getCustomerEmailId());
			    	cardDTO.setHashCvv(card.getCvv());
			    	cardDTO.setExpiryDate(card.getExpiryDate());
			    	cardDTO.setNameOnCard(card.getNameOnCard());
			    	
			    	cardDTOs.add(cardDTO);
	        	}
	        	
	        }
	    	
	    	
	    	return cardDTOs;
	    }
	    
	    
	    
	    
	    @Override
	    public void updateCustomerCard(CardDTO cardDTO) throws EKartException, NoSuchAlgorithmException {
	    	 
	    	Optional<Card> cardobj = cardRepository.findById(cardDTO.getCardId());
	    	
	        Card card =	cardobj.orElseThrow(()-> new EKartException("this card does not exist, please try with diffrent id"));
	        
	        card.setCardNumber(cardDTO.getCardNumber());
	        card.setCardType(cardDTO.getCardType());
	        card.setCustomerEmailId(cardDTO.getCustomerEmailId());
	        card.setCvv(cardDTO.getCvv().toString());
	        card.setExpiryDate(cardDTO.getExpiryDate());
	        card.setNameOnCard(cardDTO.getNameOnCard());
	    	
	    	cardRepository.save(card);
	    	
	    }
	     
	   
	    
}
