package com.example.android.quizonmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method that calculates the total number of correct answers.
    public int calculateCorrectAnswers() {
        int correctAnswers = 0;
        // Question 1
        RadioButton gameOfThronesRadioButton = (RadioButton) findViewById(R.id.gameOfThronesChecked);
        boolean gameOfThronesChecked = gameOfThronesRadioButton.isChecked();
        if (gameOfThronesChecked) {
            correctAnswers = correctAnswers + 1;
        }
        // Question 2
        CheckBox laLaLandCheckBox = (CheckBox) findViewById(R.id.laLaLandChecked);
        boolean laLaLandIsChecked = laLaLandCheckBox.isChecked();
        CheckBox spotlightCheckBox = (CheckBox) findViewById(R.id.spotlightChecked);
        boolean spotlightIsChecked = spotlightCheckBox.isChecked();
        CheckBox deadpoolCheckBox = (CheckBox) findViewById(R.id.deadpoolChecked);
        boolean deadpoolIsChecked = deadpoolCheckBox.isChecked();
        CheckBox revenantCheckBox = (CheckBox) findViewById(R.id.revenantChecked);
        boolean revenantIsChecked = revenantCheckBox.isChecked();
        if (laLaLandIsChecked) {
            // correctAnswers is unchanged and we continue to the next question
        } else {
            if (deadpoolIsChecked) {
                // correctAnswers is unchanged and we continue to the next question
            } else {
                if (spotlightIsChecked) {
                    if (revenantIsChecked) {
                        correctAnswers = correctAnswers + 1;
                    } else {
                        // correctAnswers is unchanged and we continue to the next question
                    }
                } else {
                    // correctAnswers is unchanged and we continue to the next question
                }
            }
        }
        // Question 3
        TextView titanicTextView = (TextView) findViewById(R.id.titanicEditText);
        String userInput = titanicTextView.getText().toString();
        String correctString = getResources().getString(R.string.iceberg);
        boolean titanicQuestionIsCorrect = userInput.equals(correctString);
        if (titanicQuestionIsCorrect) {
            correctAnswers = correctAnswers + 1;
        }
        // Question 4
        RadioButton question4TrueRadioButton = (RadioButton) findViewById(R.id.question4True);
        boolean question4TrueIsChecked = question4TrueRadioButton.isChecked();
        if (question4TrueIsChecked) {
            correctAnswers = correctAnswers + 1;
        }
        // Question 5
        RadioButton question5FalseRadioButton = (RadioButton) findViewById(R.id.question5False);
        boolean question5FalseIsChecked = question5FalseRadioButton.isChecked();
        if (question5FalseIsChecked) {
            correctAnswers = correctAnswers + 1;
        }
        // Question 6
        RadioButton question6TrueRadioButton = (RadioButton) findViewById(R.id.question6True);
        boolean question6TrueIsChecked = question6TrueRadioButton.isChecked();
        if (question6TrueIsChecked) {
            correctAnswers = correctAnswers + 1;
        }
        // And finally we return the score
        return correctAnswers;
    }

    public void submitButtonClicked(View view) {
        //Calculate correct and incorrect answers that will be displayed in the Toast.
        int scoreToDisplay = calculateCorrectAnswers();
        int incorrectAnswers = 6 - scoreToDisplay;
        //Text that is supposed to appear in the Toast.
        String toastText = getResources().getString(R.string.correct) + " " + scoreToDisplay;
        toastText += "\n" + getResources().getString(R.string.incorrect) + " " + incorrectAnswers;
        //Toast message
        Toast toast = Toast.makeText(this, toastText, Toast.LENGTH_LONG);
        toast.show();
    }
}
