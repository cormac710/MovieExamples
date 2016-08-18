package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Movies.Movie;

public class MovieTests {
	private Movie movie;
	
	@Before
	public void setUp(){
		movie = new Movie("Somebody", "Boxing", false);
	}
	
	@Test
	public void testMovieConstructor() {
		assertEquals("Somebody", movie.getTitle());
		assertEquals("Boxing", movie.getGenre());
		assertEquals(false, movie.isOnLoan());	
	}
	
	@Test
	public void testMovieChange(){
		movie.setTitle("Somebody1");
		movie.setGenre("Boxing1");
		movie.setOnLoan(true);
		
		assertEquals("Somebody1", movie.getTitle());
		assertEquals("Boxing1", movie.getGenre());
		assertEquals(true, movie.isOnLoan());	
	}

}
