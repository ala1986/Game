package com.fr.beezen;

public class TennisGame {

	private TennisPlayer playerUn;
	private TennisPlayer playerDeux;

	public TennisGame(TennisPlayer playerUn, TennisPlayer playerDeux) {
		this.playerUn = playerUn;
		this.playerDeux = playerDeux;
	}

	public String getScore() {
		if (playerUn.getScore() >= 3 && playerDeux.getScore() >= 3) {
			if (Math.abs(playerDeux.getScore() - playerUn.getScore()) >= 2) {
				return getWinnerPlayer().getName() + " won";
			} else if (playerUn.getScore() == playerDeux.getScore()) {
				return "deuce";
			} else {
				return "advantage " + getWinnerPlayer().getName();
			}
		} else {
			return playerUn.getScoreDescription() + ", " + playerDeux.getScoreDescription();
		}
	}

	public TennisPlayer getWinnerPlayer() {
		return (playerUn.getScore() > playerDeux.getScore()) ? playerUn : playerDeux;
	}

}
