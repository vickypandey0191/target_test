package com.target.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.target.springboot.model.ProductComment;
import com.target.springboot.model.User;



@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	private static List<ProductComment> comments;
	
	static{
		users= populateDummyUsers();
		comments = populateDummyComments();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Sam"));
		users.add(new User(counter.incrementAndGet(),"Tom"));
		users.add(new User(counter.incrementAndGet(),"Jerome"));
		users.add(new User(counter.incrementAndGet(),"Silvia"));
		return users;
	}

	private static List<ProductComment> populateDummyComments()
	{
		List<ProductComment> comments = new ArrayList<ProductComment>();
		comments.add(new ProductComment(counter.incrementAndGet(),"Good Product"));
		comments.add(new ProductComment(counter.incrementAndGet(),"Nice packaging"));
		comments.add(new ProductComment(counter.incrementAndGet(),"Too expensive"));
		comments.add(new ProductComment(counter.incrementAndGet(),"Not worth it"));
		return comments;
	}
	
	@Override
	public void postComment(ProductComment productComment) 
	{
		productComment.setId(counter.incrementAndGet());
		comments.add(productComment);
	}

	@Override
	public void updateComment(ProductComment productComment) {
		
	}

	@Override
	public void deleteCommentById(ProductComment productComment) {
		
	}

	@Override
	public List<ProductComment> getAllComments() {
		return comments;
	}

}
