package it.unisa.bsk;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class GameTest {

	@Test
	public void testCreateNewGame() throws InvalidInputException  {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;

		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);

		int numOfFrames = game.getSize();
		assertEquals(10,numOfFrames);

	}



	@Test(expected=InvalidInputException.class)
	public void testCreateNewGameWithNoFrames() throws InvalidInputException{

		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game = new Game(frames);
	}


	@Test(expected=InvalidInputException.class)
	public void testCreateNewGameWithTooManyFrames() throws InvalidInputException{

		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		frames.add(new Frame(2,6));		
		game = new Game(frames);
	}

	@Test
	public void testScoreComputation() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);

		int score = game.getScore();
		assertEquals(81,score);

	}

	@Test
	public void testComputeStrikeScore() throws InvalidInputException{
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(10,0));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);

		int strikeScore = game.computeFrameScore(0);
		assertEquals(19, strikeScore);
	}

	@Test
	public void testGameScoreWithStrike() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(10,0));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);
		int score = game.getScore();
		assertEquals(94,score);

	}

	@Test
	public void testComputeSpareScore() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,9));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);
		int spareScore = game.computeFrameScore(0);
		assertEquals(13,spareScore);

	}

	@Test
	public void testGameScoreWithSpare() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,9));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);
		int score = game.getScore();
		assertEquals(88,score);

	}

	@Test
	public void testGameScoreWithStrikeAndSpare() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(10,0));
		frames.add(new Frame(4,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);
		int score = game.getScore();
		assertEquals(103,score);

	}

	@Test
	public void testFrameScoreWithTwoStrikesInARow() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);
		int strikeScore = game.computeFrameScore(0);
		assertEquals(27,strikeScore);

	}
	@Test
	public void testGameScoreWithTwoStrikesInARow() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);
		int gameScore = game.getScore();
		assertEquals(112,gameScore);

	}

	@Test
	public void testGameScoreWithTwoSparesInARow() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(8,2));
		frames.add(new Frame(5,5));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,6));
		game = new Game(frames);
		int gameScore = game.getScore();
		assertEquals(98,gameScore);

	}

	@Test
	public void testFrameScoreWithSpareInTheLastFrame() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,8));
		int firstBonusThrow = 7;
		game = new Game(frames, firstBonusThrow);
		int frameScore = game.computeFrameScore(9);
		assertEquals(17,frameScore);

	}
	@Test(expected=InvalidInputException.class)
	public void testInvalidBonusThrow() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(10,0));
		int firstBonusThrow = -1;
		game = new Game(frames, firstBonusThrow);
	}

	@Test
	public void testGameScoreWithSpareInTheLastFrame() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,8));
		int firstBonusThrow = 7;
		game = new Game(frames, firstBonusThrow);
		int gameScore = game.getScore();
		assertEquals(90,gameScore);

	}

	@Test
	public void testFrameScoreWithStrikeInTheLastFrame() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(10,0));
		int firstBonusThrow = 7;
		int secondBonusThrow = 2;
		game = new Game(frames, firstBonusThrow,secondBonusThrow);
		int frameScore = game.computeFrameScore(9);
		assertEquals(19,frameScore);

	}

	@Test
	public void testGameScoreWithStrikeInTheLastFrame() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(10,0));
		int firstBonusThrow = 7;
		int secondBonusThrow = 2;
		game = new Game(frames, firstBonusThrow,secondBonusThrow);
		int gameScore = game.getScore();
		assertEquals(92,gameScore);

	}

	@Test
	public void testGameScoreWithStrikeInBonusThrow() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(1,5));
		frames.add(new Frame(3,6));
		frames.add(new Frame(7,2));
		frames.add(new Frame(3,6));
		frames.add(new Frame(4,4));
		frames.add(new Frame(5,3));
		frames.add(new Frame(3,3));
		frames.add(new Frame(4,5));
		frames.add(new Frame(8,1));
		frames.add(new Frame(2,8));
		int firstBonusThrow = 10;
		game = new Game(frames, firstBonusThrow);
		int gameScore = game.getScore();
		assertEquals(93,gameScore);

	}

	@Test
	public void testGameWithPerfectScore() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		int firstBonusThrow = 10;
		int secondBonusThrow = 10;
		game = new Game(frames, firstBonusThrow, secondBonusThrow);
		int gameScore = game.getScore();
		assertEquals(300,gameScore);

	}

	@Test
	public void testRealGameScore() throws InvalidInputException {
		ArrayList<Frame> frames = new ArrayList<Frame>();
		Game game;
		frames.add(new Frame(6,3));
		frames.add(new Frame(7,1));
		frames.add(new Frame(8,2));
		frames.add(new Frame(7,2));
		frames.add(new Frame(10,0));
		frames.add(new Frame(6,2));
		frames.add(new Frame(7,3));
		frames.add(new Frame(10,0));
		frames.add(new Frame(8,0));
		frames.add(new Frame(7,3));
		int firstBonusThrow = 10;
		game = new Game(frames, firstBonusThrow);
		int gameScore = game.getScore();
		assertEquals(135,gameScore);

	}

}

