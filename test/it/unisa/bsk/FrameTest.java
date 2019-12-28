package it.unisa.bsk;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void testCreateNewFrame() throws InvalidInputException {
		Frame frame = new Frame(2,4);
	}

	@Test
	public void testGetFirstThrow() throws InvalidInputException {
		Frame frame = new Frame(2,4);
		int firstT =frame.getFirst();
		assertEquals(2,firstT);
	}
	@Test
	public void testGetSecondThrow() throws InvalidInputException {
		Frame frame = new Frame(2,4);
		int secondT =frame.getSecond();
		assertEquals(4,secondT);
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateNewFrameWithInvalidScoreOnFirstThrow() throws InvalidInputException {
		Frame frame = new Frame(-22,4);
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateNewFrameWithInvalidScoreOnSecondThrow() throws InvalidInputException {
		Frame frame = new Frame(2,14);
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateNewFrameWithInvalidScore() throws InvalidInputException {
		Frame frame = new Frame(6,5);
	}

	@Test
	public void testComputeScore() throws InvalidInputException {
		Frame frame = new Frame (2,6);
		int score = frame.getScore();
		assertEquals(8,score);
	}

	@Test
	public void testFrameisStrike() throws InvalidInputException {
		Frame frame = new Frame (10,0);
		boolean strike = frame.isStrike();
		assertTrue(strike);
	}

	@Test
	public void testFrameisNotStrike() throws InvalidInputException {
		Frame frame = new Frame (9,1);
		boolean strike = frame.isStrike();
		assertFalse(strike);
	}


	@Test(expected = InvalidInputException.class)
	public void testInvalidInputWithStrike() throws InvalidInputException{
		Frame frame = new Frame(10,1);
	}

	@Test
	public void testFrameIsSpare() throws InvalidInputException {
		Frame frame = new Frame (9,1);
		boolean spare = frame.isSpare();
		assertTrue(spare);
	}

	@Test
	public void testFrameIsNotSpare() throws InvalidInputException {
		Frame frame = new Frame (9,0);
		boolean spare = frame.isSpare();
		assertFalse(spare);
	}

}
