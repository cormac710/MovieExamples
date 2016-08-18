package Movies;

public class Movie {
	private String title;
	private String genre;
	public boolean onLoan;
	
	public Movie(String title, String genre, boolean onLoan) {
		super();
		this.title = title;
		this.genre = genre;
		this.onLoan = onLoan;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isOnLoan() {
		return onLoan;
	}
	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}
	
	

}
