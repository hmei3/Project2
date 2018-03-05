package com.hmei.hibernate.model;

public class SearchForm {
	private String category;
	private String keyword;
	
	public SearchForm() {}
	public SearchForm(String category, String keyword) {
		this.category = category;
		this.keyword = keyword;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
