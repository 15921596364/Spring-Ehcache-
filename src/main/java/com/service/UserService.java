package com.service;

import com.model.User;

import java.util.List;

/**
 * @desc
 **/
public interface UserService {

	int deleteUser(String id);

	int insert(User record);

	int insertTest(User record);

	User findUser(String id);

	int updateUser(User record);

	int count();

	List<User> getUsers();

}
