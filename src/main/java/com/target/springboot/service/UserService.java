package com.target.springboot.service;


import java.util.List;

import com.target.springboot.model.ProductComment;
import com.target.springboot.model.User;

public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers();
	
	void deleteAllUsers();
	
	boolean isUserExist(User user);
	
	void postComment(ProductComment productComment);
	
	void updateComment(ProductComment productComment);
	
	void deleteCommentById(ProductComment productComment);
	
	List<ProductComment> getAllComments();
	
	
}
