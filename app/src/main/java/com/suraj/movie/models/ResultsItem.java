package com.suraj.movie.models;

import java.util.List;

 class ResultsItem{
	private String overview;
	private String originalLanguage;
	private String originalTitle;
	private boolean video;
	private String title;
	private List<Integer> genreIds;
	private String posterPath;
	private String backdropPath;
	private String releaseDate;
	private String popularity;
	private String voteAverage;
	private int id;
	private boolean adult;
	private int voteCount;

	public String getOverview(){
		return overview;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public boolean isVideo(){
		return video;
	}

	public String getTitle(){
		return title;
	}

	public List<Integer> getGenreIds(){
		return genreIds;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getPopularity(){
		return popularity;
	}

	public String getVoteAverage(){
		return voteAverage;
	}

	public int getId(){
		return id;
	}

	public boolean isAdult(){
		return adult;
	}

	public int getVoteCount(){
		return voteCount;
	}
}