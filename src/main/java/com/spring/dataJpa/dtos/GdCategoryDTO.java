package com.spring.dataJpa.dtos;

import java.io.Serializable;

public class GdCategoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long categoryID;
	private String categoryName;
	
	
	
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	
	
}
