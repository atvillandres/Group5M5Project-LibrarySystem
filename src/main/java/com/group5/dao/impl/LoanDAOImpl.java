package com.group5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;

import com.group5.dao.LoanDAO;
import com.group5.exception.DuplicateLoanIdException;
import com.group5.util.DBUtil;


public class LoanDAOImpl implements LoanDAO {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoanDAOImpl.class);
	
	private final String FIND_LOAN_ID =
			"SELECT l.id, l.userid, l.bookid, b.title, u.name, b.isBorrowed FROM loan l "
			+ "JOIN book b ON l.bookid = b.id "
			+ "JOIN users u ON l.userid = u.id "
			+ "WHERE l.id = ?";
	
	private final String ADD_LOAN_BOOK =
			"INSERT INTO loan(id, bookid, userid) VALUES(?,?,?)";

	@Override
	public String findLoanId(String loanId) throws DuplicateLoanIdException {
		
		try 
			(Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(FIND_LOAN_ID)) {
			
			ps.setInt(1, Integer.valueOf(loanId));
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				logger.warn("Duplicate Loan ID");
				throw new DuplicateLoanIdException("Duplicate Loan ID.");
			}
			
		} catch (SQLException e) {
			logger.info("Encountered error on Loan table.");
			System.out.println("Encountered error on Loan table.");
		}
		return loanId;
	}

	@Override
	public void addLoanBook(String loanId, String bookId, String userId) {
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(ADD_LOAN_BOOK)) {
			ps.setInt(1, Integer.valueOf(loanId));
			ps.setInt(2, Integer.valueOf(bookId));
			ps.setInt(3, Integer.valueOf(userId));
			ps.executeUpdate();
			
			logger.info("Added to Loan table. ID: {}, BookID: {}, UserID: {}.", loanId, bookId, userId);
			
		} catch (SQLException e) {
			logger.info("Encountered error on adding to loan book.");
			System.out.println("Encountered error on adding to loan book.");
		}
	}

}
