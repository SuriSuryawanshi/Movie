package com.suraj.movie.models;

import java.util.List;

public class ResponseMovie{
	private int page;
	private int totalPages;
	private List<Movies> results;
	private int totalResults;

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public List<Movies> getResults(){
		return results;
	}

	public int getTotalResults(){
		return totalResults;
	}
}