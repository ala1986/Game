package com.fr.beezen;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class TennisGameTest {

	
	private TennisPlayer playerUn;
    private TennisPlayer playerDeux;
    private TennisGame tennisGame;

    @Before
    public void beforetennisGameTest() {
    	playerUn = new TennisPlayer("PlayerUn");
    	playerDeux = new TennisPlayer("PlayerDeux");
    	tennisGame = new TennisGame(playerUn, playerDeux);
    }

    // zero devrait �tre la description du score 0
    @Test
    public void scoreZero() {
        TennisGame tennisGame = new TennisGame(playerUn, playerDeux);
        assertThat(tennisGame, hasProperty("score", is("zero, zero")));
    }
    // quinze devrait �tre la description du score 1
    @Test
    public void scoreFifteen() {
        playerUn.incrementScore();
        assertThat(tennisGame, hasProperty("score", is("zero, fifteen")));
    }
    // quarante devrait �tre la description du score 2
    @Test
    public void scoreThirty() {
    	playerDeux.incrementScore();
        playerDeux.incrementScore();
        playerUn.incrementScore();
        assertThat(tennisGame, hasProperty("score", is("thirty, fifteen")));
    }
    // quarante devrait �tre la description du score 3
    @Test
    public void scoreForty() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
                playerDeux.incrementScore();
        });
        assertThat(tennisGame, hasProperty("score", is("forty, zero")));
    }
    // avantage devrait �tre Description lorsque trois points au moins ont marqu� dix points de chaque c�t� et que le joueur a un point de plus que son adversaire
    @Test
    public void advantage() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	playerDeux.incrementScore();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        	playerUn.incrementScore();
        });
        assertThat(tennisGame, hasProperty("score", is("advantage Player Un")));
    }
    //deuce devrait �tre d�crit quand au moins trois points ont �t� marqu�s par chaque joueur et que les scores sont �gaux
    @Test
    public void deuce() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	playerDeux.incrementScore();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	playerUn.incrementScore();
        });
        assertThat(tennisGame, hasProperty("score", is("deuce")));
        playerDeux.incrementScore();
        assertThat(tennisGame, hasProperty("score", is(not("deuce"))));
        playerUn.incrementScore();
        assertThat(tennisGame, hasProperty("score", is("deuce")));
    }

    //Le premier joueur � avoir gagn� au moins quatre points au total et au moins deux points de plus que l'adversaire
    @Test
    public void tennisGameShouldBeWonByTheFirstPlayer() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
        	playerDeux.incrementScore();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
        	playerUn.incrementScore();
        });
        assertThat(tennisGame, hasProperty("score", is(not("Player Deux won"))));
        assertThat(tennisGame, hasProperty("score", is(not("Player Un won"))));
        playerDeux.incrementScore();
        assertThat(tennisGame, hasProperty("score", is("Player Deux won")));
    }
}
