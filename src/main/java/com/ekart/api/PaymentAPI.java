package com.ekart.api;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.DTO.CardDTO;
import com.ekart.DTO.TransactionDTO;
import com.ekart.exception.EKartException;
import com.ekart.service.PaymentService;

import jakarta.validation.constraints.Email;

@RestController
@RequestMapping(value = "/payment")
public class PaymentAPI {
   
	        @Autowired 
	        private PaymentService paymentServiceimpl;
	
	       @PostMapping(value = "/addCustomerCard/{customerEmailId}")
	       public ResponseEntity<String>addCustomerCard(@PathVariable @Email String customerEmailId, @RequestBody CardDTO cardDTO)
	    		   throws EKartException ,NoSuchAlgorithmException{
	    	   
	    	Integer cardID = paymentServiceimpl.addCustomerCard(customerEmailId, cardDTO);
	    	   
	        String msg = "your card has been added and you id is : " + cardID;
	    	   
	    	   return new ResponseEntity<String>(msg , HttpStatus.CREATED);
	       }
	       
	       
	       @PostMapping(value = "/addTrasaction")
	       public ResponseEntity<String>addTransaction( @RequestBody TransactionDTO transactionDTO) throws EKartException{
	    	   
	    	  Integer transId = paymentServiceimpl.addTransaction(transactionDTO);
	    	  
	    	  String msg = "your transaction have been succesfully done your transaction id is :"+ transId;
	    	  
	    	  return new ResponseEntity<String>(msg , HttpStatus.CREATED);
	    	   
	       }
	       
	       
	       @DeleteMapping(value = "/deleteCard/{customerEmailId}/cardID/{cardId}")
	       public ResponseEntity<String>deleteCustomerCard(@PathVariable  String customerEmailId, @PathVariable Integer cardId)throws EKartException{
	    	   
	    	          paymentServiceimpl.deleteCustomerCard(customerEmailId, cardId);
	    	          
	    	          String msg = "your card has beeb delated sucusseccfully your card ID :";
	    	          
	    	          return new ResponseEntity<String>(msg , HttpStatus.OK);
	       }
	      
	       @GetMapping(value = "/getCard/{cardId}")
	       public ResponseEntity<CardDTO> getCard(@PathVariable Integer cardId) throws EKartException{
	    	   
	    	 CardDTO cardDTO =  paymentServiceimpl.getCard(cardId);
	    	 
	    	return new  ResponseEntity<CardDTO>(cardDTO,HttpStatus.OK);
	       }
	       
	       
	       
	       @GetMapping(value = "/getAllCardDetails/{customerEmailId}")
	       public ResponseEntity<List<CardDTO>> getCardsOfCustomer(@PathVariable String customerEmailId) throws EKartException {
	    	   
	    	   List<CardDTO> cardDTOs =  paymentServiceimpl.getCardsOfCustomer(customerEmailId);
	    	   
	    	   return new ResponseEntity<List<CardDTO>>(cardDTOs , HttpStatus.OK);
	    	   
	    	   
	       }
	       
	       @GetMapping(value = "/getCardDetailsByCardType/{customerEmailId}/CardType/{cardType}")
	       public ResponseEntity<List<CardDTO>> getCustomerCardOfCardType(@PathVariable String customerEmailId,@PathVariable String cardType) throws EKartException{
	    	   
	    	   List<CardDTO> cardDTOs =  paymentServiceimpl.getCustomerCardOfCardType(customerEmailId, cardType);
	    	   
	    	   return new ResponseEntity<List<CardDTO>>(cardDTOs, HttpStatus.OK);
	    	   
	       }
	       
	       
	       @PutMapping(value = "/updateCustomerCard")
	       public ResponseEntity<String>updateCustomerCard( @RequestBody CardDTO cardDTO) throws EKartException, NoSuchAlgorithmException{
	    	   
	    	     paymentServiceimpl.updateCustomerCard(cardDTO);
	    	   
	    	    String msg = "your card has been updated succesfully!!";
	    	   
	    	   return new ResponseEntity<String>(msg , HttpStatus.OK);
	    	   
	       }
	       
}
