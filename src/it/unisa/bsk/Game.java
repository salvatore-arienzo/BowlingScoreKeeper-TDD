package it.unisa.bsk;

import java.util.ArrayList;
import java.util.List;


public class Game {

	private static ArrayList<Frame> frames;
	private int nFrame;
	private int score;
	private int firstBonusThrow;
	private int secondBonusThrow;

	public Game(ArrayList<Frame> f) throws InvalidInputException {
		this.frames = f;
		this.nFrame = frames.size();
		this.score = score;
		if(nFrame != 10) {
			throw new InvalidInputException("Invalid Input");
		}	


		for (int i= 0; i<=frames.size()-1;i++) {
			score += computeFrameScore(i);
		}
	}
	public Game(ArrayList<Frame> f, int fBonusT) throws InvalidInputException {
		this.frames = f;
		this.nFrame = frames.size();
		this.score = score;
		this.firstBonusThrow=fBonusT;

		if(nFrame != 10) {
			throw new InvalidInputException("Invalid Input");
		}	
		if(firstBonusThrow > 10 || firstBonusThrow < 0 ) {
			throw new InvalidInputException("Invalid Input");
		}
		for (int i= 0; i<=frames.size()-1;i++) {
			score += computeFrameScore(i);
		}
	}
	public Game(ArrayList<Frame> f, int fBonusT, int sBonusT) throws InvalidInputException {
		this.frames = f;
		this.nFrame = frames.size();
		this.score = score;
		this.firstBonusThrow=fBonusT;
		this.secondBonusThrow=sBonusT;

		if(nFrame != 10) {
			throw new InvalidInputException("Invalid Input");
		}	
		if((firstBonusThrow > 10 || firstBonusThrow < 0 ) || (secondBonusThrow > 10 || secondBonusThrow < 0)) {
			throw new InvalidInputException("Invalid Input");
		}
		for (int i= 0; i<=frames.size()-1;i++) {
			score += computeFrameScore(i);
		}
	}
	public int getSize() {
		return nFrame;

	}
	public int getScore() {
		return score;
	}
	public int computeFrameScore(int i) {
		int frameScore;
		if(frames.get(i).isStrike()) {
			if(i==9) {
				frameScore = frames.get(i).getScore() + firstBonusThrow + secondBonusThrow;
			} else {
				frameScore = frames.get(i).getScore() + frames.get(i+1).getScore();

				if(frames.get(i+1).isStrike()) {
					if(i==8) {
						frameScore = frames.get(i).getScore() + frames.get(i+1).getScore() + firstBonusThrow;
					} else {
						frameScore =  frames.get(i).getScore() + frames.get(i+1).getScore() + frames.get(i+2).getFirst();
					}
				}
			}
		} 
		else if(frames.get(i).isSpare()){
			if(i==9) {
				frameScore = frames.get(i).getScore() + firstBonusThrow;
			}
			else {
				frameScore = frames.get(i).getScore() + frames.get(i+1).getFirst();
			}
		}
		else {
			frameScore = frames.get(i).getScore();	
		}
		return frameScore;
	}
}
