package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static final String SCORE_A = "team_a_score";
    static final String FOULS_A = "number_of_fouls_a";
    static final String RED_CARDS_A = "number_of_red_cards_a";
    static final String SCORE_B = "team_b_score";
    static final String FOULS_B = "number_of_fouls_b";
    static final String RED_CARDS_B = "number_of_red_cards_b";
    int scoreA = 0;
    int foulA = 0;
    int redCardA = 0;
    int scoreB = 0;
    int foulB = 0;
    int redCardB = 0;
    TextView TeamAScoreTV;
    TextView TeamAFoulsTV;
    TextView TeamARedCardsTV;
    TextView TeamBScoreTV;
    TextView TeamBFoulsTV;
    TextView TeamBRedCardsTV;

    /**
     * OnCreate with view initializations
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TeamAScoreTV = (TextView) findViewById(R.id.team_a_score);
        TeamAFoulsTV = (TextView) findViewById(R.id.number_of_fouls_a);
        TeamARedCardsTV = (TextView) findViewById(R.id.number_of_red_cards_a);
        TeamBScoreTV = (TextView) findViewById(R.id.team_b_score);
        TeamBFoulsTV = (TextView) findViewById(R.id.number_of_fouls_b);
        TeamBRedCardsTV = (TextView) findViewById(R.id.number_of_red_cards_b);
    }

    /**
     * Functions to save and restore the current state
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SCORE_A, scoreA);
        savedInstanceState.putInt(FOULS_A, foulA);
        savedInstanceState.putInt(RED_CARDS_A, redCardA);
        savedInstanceState.putInt(SCORE_B, scoreB);
        savedInstanceState.putInt(FOULS_B, foulB);
        savedInstanceState.putInt(RED_CARDS_B, redCardB);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreA = savedInstanceState.getInt(SCORE_A);
        foulA = savedInstanceState.getInt(FOULS_A);
        redCardA = savedInstanceState.getInt(RED_CARDS_A);
        scoreB = savedInstanceState.getInt(SCORE_B);
        foulB = savedInstanceState.getInt(FOULS_B);
        redCardB = savedInstanceState.getInt(RED_CARDS_B);
        displayForTeamA(scoreA, foulA, redCardA);
        displayForTeamB(scoreB, foulB, redCardB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score, int fouls, int cards) {
        TeamAScoreTV.setText(String.valueOf(score));
        TeamAFoulsTV.setText(String.valueOf(fouls));
        TeamARedCardsTV.setText(String.valueOf(cards));
    }

    public void goalTeamA(View view) {
        scoreA += 1;
        displayForTeamA(scoreA, foulA, redCardA);
    }

    public void foulTeamA(View view) {
        foulA += 1;
        displayForTeamA(scoreA, foulA, redCardA);
    }

    public void redCardTeamA(View view) {
        if (redCardA < 5) {
            redCardA += 1;
            foulA += 1;
        }
        displayForTeamA(scoreA, foulA, redCardA);

    }

    /**
     * Displays the given score for Team B.
     * and other functions the handle the score changes with Team B
     */
    public void displayForTeamB(int score, int fouls, int cards) {
        TeamBScoreTV.setText(String.valueOf(score));
        TeamBFoulsTV.setText(String.valueOf(fouls));
        TeamBRedCardsTV.setText(String.valueOf(cards));
    }

    public void goalTeamB(View view) {
        scoreB += 1;
        displayForTeamB(scoreB, foulB, redCardB);
    }

    public void foulTeamB(View view) {
        foulB += 1;
        displayForTeamB(scoreB, foulB, redCardB);
    }

    public void redCardTeamB(View view) {
        if (redCardB < 5) {
            redCardB += 1;
            foulB += 1;
        }
        displayForTeamB(scoreB, foulB, redCardB);

    }


    /**
     * resets everything back to default
     */
    public void reset(View view) {
        scoreA = 0;
        foulA = 0;
        redCardA = 0;
        scoreB = 0;
        foulB = 0;
        redCardB = 0;
        displayForTeamA(scoreA, foulA, redCardA);
        displayForTeamB(scoreB, foulB, redCardB);
    }
}
