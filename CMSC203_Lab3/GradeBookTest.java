import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook objectOne;
	private GradeBook testTwo;
	
	@BeforeEach
	void setUp() throws Exception {
		objectOne = new GradeBook(5);
		//Object One add scores
		objectOne.addScore(78);
		objectOne.addScore(58);
		objectOne.addScore(98);
		
		testTwo = new GradeBook(5);
		//Object Two add scores
		testTwo.addScore(85);
		testTwo.addScore(85);
		testTwo.addScore(74);
		testTwo.addScore(54);
	}

	@AfterEach
	void tearDown() throws Exception {
		objectOne = null;
		testTwo = null;
	}

	@Test
	void testAddScore() {
		//Object One
		System.out.println(objectOne.toString());
		objectOne.addScore(85.9);
		System.out.println(objectOne.toString());
		assertEquals(4, objectOne.getScoreSize());
		
		//Object Two
		System.out.println(testTwo.toString());
		testTwo.addScore(22.5);
		System.out.println(testTwo.toString());
		assertEquals(5,testTwo.getScoreSize());
		
	}

	@Test
	void testSum() {
		assertEquals(234, objectOne.sum());
		assertEquals(298, testTwo.sum());
	}

	@Test
	void testMinimum() {
		//Test for Object One
		assertEquals(58, objectOne.minimum());
		//Test for Object Two
		assertEquals(54,testTwo.minimum());
	}

	@Test
	void testFinalScore() {
		//Test for Object One
		assertEquals(176.0,objectOne.finalScore());
		
		//Test for Object Two
		assertEquals(244.0, testTwo.finalScore());
	}

}
