package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc
 **/
@Repository
public interface UserDao {
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	int count();

	List<User> getUsers();
}
