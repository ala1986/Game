package com.fr.beezen;

import java.util.Arrays;
import java.util.List;

public class TennisPlayer {

	public static final List<String> pointsDescription = Arrays.asList("zero", "fifteen", "thirty", "forty");

	private int score;
	private String name;

	public TennisPlayer(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void incrementScore() {
		this.score = this.score + 1;
	}

	public String getScoreDescription() {
		return pointsDescription.get(score);
	}

}
