package com.grkn.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grkn.dao.models.UserModel;

public class UserRowMapper implements RowMapper<UserModel>{

	public UserModel mapRow(ResultSet rs, int arg1) throws SQLException {
		UserModel user = new UserModel();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
		user.setPassword(rs.getString("password"));
		user.setActive(rs.getBoolean("active"));
		return user;
	}
}
