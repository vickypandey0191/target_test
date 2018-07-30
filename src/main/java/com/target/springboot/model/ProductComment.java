package com.target.springboot.model;

public class ProductComment 
{
	private long id;
	
	private String commentOnProduct;
	
	public ProductComment(){
		id=0;
	}
	
	public ProductComment(long id, String commentOnProduct) {
		this.id = id;
		this.commentOnProduct = commentOnProduct;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentOnProduct() {
		return commentOnProduct;
	}

	public void setCommentOnProduct(String commentOnProduct) {
		this.commentOnProduct = commentOnProduct;
	}
	
}
