package com.webapp.bankingportal.mapper;

import org.springframework.stereotype.Component;

import com.webapp.bankingportal.dto.TransactionDTO;
import com.webapp.bankingportal.entity.Transaction;

@Component
public class TransactionMapper {

    // Maps a Transaction entity to a TransactionDTO object.
    public TransactionDTO toDto(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        dto.setTransaction_type(transaction.getTransactionType());
        dto.setTransaction_date(transaction.getTransaction_date());
        dto.setSourceAccountNumber(transaction.getSourceAccount().getAccountNumber());
        
        // Check if the target account is not null and set its account number accordingly
        if (transaction.getTargetAccount() != null) {
            dto.setTargetAccountNumber(transaction.getTargetAccount().getAccountNumber());
        } else {
            // Handle the case where target account is null (e.g., set a default value or do nothing)
            dto.setTargetAccountNumber("N/A"); // Replace "N/A" with an appropriate default value
        }
        return dto;
    }
}
