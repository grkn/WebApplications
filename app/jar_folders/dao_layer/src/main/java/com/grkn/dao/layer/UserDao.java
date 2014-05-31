package com.grkn.dao.layer;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grkn.dao.layer.base.BaseDao;
import com.grkn.dao.models.UserModel;
import com.grkn.dao.rowMapper.UserRowMapper;

@Repository
public class UserDao extends BaseDao{

	
	private String selectStatement = "select users.id,users.name,users.surname,users.password,users.active from grkn.users ";
	
	public List<UserModel> getUsers(){
		return getJdbcTemplate().query(selectStatement, new UserRowMapper());
	}
	
	public UserModel getUserById(Long id){
		StringBuffer buf = new StringBuffer(selectStatement).append("where ").append("id = ").append(id);
		return getJdbcTemplate().queryForObject(buf.toString(),new UserRowMapper());
	}
}
