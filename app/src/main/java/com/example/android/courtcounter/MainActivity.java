package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Saves the score instance state for both teams
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("scoreTeamA", scoreTeamA);
        savedInstanceState.putInt("scoreTeamB", scoreTeamB);
    }

    /**
     * Restores the score instance state for both teams in case of screen mode change
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for both teams.
     */
    public void score(View view) {
        String points = view.getTag().toString();
        if (points.indexOf("A") > -1) {
            points = points.substring(0,1);
            scoreTeamA = scoreTeamA + Integer.valueOf(points);
            displayForTeamA(scoreTeamA);
        }
        else if (points.indexOf("B") > -1){
            points = points.substring(0,1);
            scoreTeamB = scoreTeamB + Integer.valueOf(points);
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Reset Score for both
     */
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
