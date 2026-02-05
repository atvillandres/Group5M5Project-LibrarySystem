package com.group5.service.impl;

import com.group5.dao.LoanDAO;
import com.group5.exception.DuplicateLoanIdException;
import com.group5.exception.InvalidBorrowedBookIdException;
import com.group5.model.Loan;
import com.group5.service.LoanService;

public class LoanServiceImpl implements LoanService {
	
	private final LoanDAO loanDAO;
	
	public LoanServiceImpl (LoanDAO loanDAO) {
		this.loanDAO = loanDAO;
	}

	@Override
	public String findLoanId(String loanId) throws DuplicateLoanIdException {
		return this.loanDAO.findLoanId(loanId);
	}

	@Override
	public void addLoanBook(String loanId, String bookId, String userId) {
		loanDAO.addLoanBook(loanId, bookId, userId);
	}

	@Override
	public Loan findReturnBookId(String loanId) throws InvalidBorrowedBookIdException{
		return loanDAO.findReturnBookId(loanId);
	}

	@Override
	public void deleteLoanId(String loanId) {
		loanDAO.deleteLoanId(loanId);
	}

}
