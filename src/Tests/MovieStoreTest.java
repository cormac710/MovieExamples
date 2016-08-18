package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Movies.Movie;
import Movies.MovieStore;

public class MovieStoreTest {

	private MovieStore ms;

	@Before
	public void setUp() {
		ms = new MovieStore();
	}

	// User Story 1
	@Test // Test1-1
	public void testNoMoviesInStore() {
		assertEquals(0, ms.getNmbOfMoviesInStore());
	}

	// User Story 2
	@Test // Test 2-1
	public void testOneMovieInStore() {
		Movie movie = new Movie("abc", "aa", false);
		ms.addMovie(movie);
		assertEquals(1, ms.getNmbOfMoviesInStore());
	}
	
	@Test // Test 2-2
	public void testTwoMoviesInStore(){
		Movie movie = new Movie("abc", "aa", false);
		Movie movie1 = new Movie("abcd", "ab", true);
		ms.addMovie(movie);
		ms.addMovie(movie1);
		assertEquals(2, ms.getNmbOfMoviesInStore());
	}
	
	// User Story 3
	@Test // Test 3-1
	public void testRemoveMovieFromStore(){
		Movie movie = new Movie("abc", "aa", false);
		Movie movie1 = new Movie("abcd", "ab", true);
		ms.addMovie(movie);
		ms.addMovie(movie1);
		assertEquals(2, ms.getNmbOfMoviesInStore());
		
		// remove a movie
		ms.removeMovie(movie1);
		
		//check only one in store now
		assertEquals(1, ms.getNmbOfMoviesInStore());	
	}
	
	// User Story 4
	@Test //Test 4-1
	public void testNumMoviesWithGere(){
		// add 2 with drama
		Movie movie = new Movie("abc", "drama", false);
		Movie movie1 = new Movie("abcd", "drama", true);
		// add 1 action
		Movie movie2 = new Movie("abcd", "action", true);
		
		ms.addMovie(movie);
		ms.addMovie(movie1);
		ms.addMovie(movie2);
		
		assertEquals(2, ms.getNumMoviesWithGenre("drama"));
	}
	
	// User Story 5
	@Test //Test 5-1
	public void testRentMovieOK(){
		Movie movie = new Movie("abc", "drama", false);
		ms.addMovie(movie);
		assertEquals("ok", ms.rentMovie("abc"));
		assertTrue(movie.isOnLoan());
	}
	
	@Test //Test 5-2
	public void testRentAlreadyRented(){
		Movie movie = new Movie("abc", "drama", false);
		ms.addMovie(movie);
		assertEquals("ok", ms.rentMovie("abc"));
		assertTrue(movie.isOnLoan());
		assertEquals("onLoan", ms.rentMovie("abc"));
	}
	
	@Test //Test 5-3
	public void testMovieNotInStore(){
		Movie movie = new Movie("abc", "drama", false);
		ms.addMovie(movie);
		
		assertEquals("Not Found", ms.rentMovie("abffc"));
	}
	
	@Test //Test 5-4
	public void testRentalLimitExceeded(){
		Movie movie = new Movie("abfc", "drama", false);
		ms.addMovie(movie);
		Movie movie1 = new Movie("absc", "drama", false);
		ms.addMovie(movie1);
		Movie movie2 = new Movie("abc", "drama", false);
		ms.addMovie(movie2);
		
		ms.rentMovie("abfc");
		ms.rentMovie("absc");
		
		assertEquals("Limit", ms.rentMovie("abc"));
	}
	
	
}










