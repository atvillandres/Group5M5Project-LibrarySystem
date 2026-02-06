package com.group5.service;

import com.group5.exception.DuplicateLoanIdException;
import com.group5.exception.InvalidBorrowedBookIdException;
import com.group5.model.Loan;

public interface LoanService {

	String findLoanId(String loanId) throws DuplicateLoanIdException;

	void addLoanBook(String loanId, String bookId, String userId);

	Loan findReturnBookId(String loanId) throws InvalidBorrowedBookIdException;

	void deleteLoanId(String loanId);
}
