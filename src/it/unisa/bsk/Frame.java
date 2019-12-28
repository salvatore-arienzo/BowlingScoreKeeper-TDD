package it.unisa.bsk;

public class Frame {
	private int firstT;
	private int secondT;
	private int score;

	public Frame(int firstThrow, int secondThrow) throws InvalidInputException{
		this.firstT=firstThrow;
		this.secondT=secondThrow;
		if(isValidScore(firstT) == false || isValidScore(secondT) == false) {
			throw new InvalidInputException("Invalid Input");

		}
		if(firstT + secondT > 10) {
			throw new InvalidInputException("Invalid Input");
		}
		if(firstT==10 && secondT != 0) {

			throw new InvalidInputException("Invalid Input");
		}
		this.score= firstT + secondT;
	}

	private boolean isValidScore(int t) {
		if (t>=0 && t<=10) { 
			return true;
		} else 
			return false;
	}
	public int getScore() {
		return score;
	}

	public int getFirst() {
		return firstT;
	}
	public int getSecond() {
		return secondT;
	}

	public boolean isStrike() {
		if(firstT==10)return true;
		else return false;
	}
	public boolean isSpare() {
		if(firstT+secondT == 10 ) return true;
		else return false;
	}

}
