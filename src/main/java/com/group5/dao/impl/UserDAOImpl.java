package com.group5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group5.dao.UserDAO;
import com.group5.model.User;
import com.group5.util.DBUtil;

public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Override
	public User isUserExisting(String id, String username) {
		
		final String GET_LOGIN_ID =
				"SELECT id,name FROM users WHERE id = ? AND name = ?";
		
		User userLogin = new User();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_LOGIN_ID)) {
				
			ps.setInt(1, Integer.valueOf(id));
			ps.setString(2, username);

			try (ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()) {
					
					userLogin.setId(String.valueOf(rs.getInt("id")));
					userLogin.setName(rs.getString("name"));
					
					return userLogin;
				}
				
			} catch (SQLException e) {
				logger.error("Error on query execution." + e);
			}
			
		} catch (SQLException e) {
			logger.error("Unable to connect to users table. " + e);
		}
		
		return null;
		
	}

}
