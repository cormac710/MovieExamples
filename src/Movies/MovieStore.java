package Movies;

import java.util.ArrayList;

public class MovieStore {
	private int numberOfMoviesRented;
	private ArrayList<Movie> moviesList = new ArrayList<Movie>();

	public int getNmbOfMoviesInStore() {
		return moviesList.size();
	}

	public void addMovie(Movie aMovie) {
		moviesList.add(aMovie);
	}

	public void removeMovie(Movie aMovie) {
		moviesList.remove(aMovie);
	}

	public String rentMovie(String title) {
		String movieStatus = "Not Found";
		System.out.println(numberOfMoviesRented);
		if (numberOfMoviesRented < 2) {
			
			for (Movie mov : moviesList) {

				if (mov.getTitle().equals(title)) {
					if (mov.isOnLoan()) {
						movieStatus = "onLoan";
					} else {
						movieStatus = "ok";
						mov.setOnLoan(true);
						// when movie rented its added to count
						numberOfMoviesRented+=1;
					} // end If/Else (movie on loan)
				}

			} // end for
		} else {
			movieStatus = "Limit";
		}// end if count

		return movieStatus;
	}

	public int getNumMoviesWithGenre(String genre) {
		int countGenre = 0;
		for (Movie mov : moviesList) {
			if (mov.getGenre().equalsIgnoreCase(genre)) {
				countGenre++;
			}
		}

		return countGenre;

	}

}
