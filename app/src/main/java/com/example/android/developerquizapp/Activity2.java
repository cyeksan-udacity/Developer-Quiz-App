package com.example.android.developerquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Cansu on 25.01.2018.
 */

public class Activity2 extends Activity {

    private static final String CHECKBOX41_CHECKED_KEY = "is_checkbox_checked";
    private static final String CHECKBOX42_CHECKED_KEY = "is_checkbox_checked";
    private static final String CHECKBOX43_CHECKED_KEY = "is_checkbox_checked";
    private static final String CHECKBOX44_CHECKED_KEY = "is_checkbox_checked";
    private static final String CHECKBOX45_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON21_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON22_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON23_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON2CORRECT_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON31_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON32_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON33_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON3CORRECT_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON51_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON5CORRECT_CHECKED_KEY = "is_checkbox_checked";
    private static final String BUTTON_CLICKED_KEY = "buttonIsClicked";
    private static final String RESULT_KEY = "resultKey";
    private static final int CLICK_NUMBER = 0;
    private static final long START_TIME_IN_MILLIS = 0;
    Button finishButton;
    EditText answer1;
    EditText enterName;
    TextView rightAnswer;
    Chronometer chronometer;
    boolean c1;
    boolean c2;
    boolean c3;
    boolean checkAnswer41;
    boolean checkAnswer42;
    boolean checkAnswer43;
    boolean checkAnswer44;
    boolean checkAnswer45;
    boolean c4;
    boolean c5;
    String correct;
    String result;
    private boolean buttonIsClicked = false;
    private int clickNumber = CLICK_NUMBER;
    private long mTimePassedInMillis = START_TIME_IN_MILLIS;
    private RadioButton answer2;
    private RadioButton wrongAnswer21;
    private RadioButton wrongAnswer22;
    private RadioButton wrongAnswer23;
    private RadioButton answer3;
    private RadioButton wrongAnswer31;
    private RadioButton wrongAnswer32;
    private RadioButton wrongAnswer33;
    private RadioButton wrongAnswer51;
    private RadioButton answer5;
    private CheckBox answer41;
    private CheckBox answer42;
    private CheckBox answer43;
    private CheckBox answer44;
    private CheckBox answer45;

    //save the states:

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CLICK_NUMBER", clickNumber);
        outState.putBoolean(BUTTON2CORRECT_CHECKED_KEY, answer2.isChecked());
        outState.putBoolean(BUTTON21_CHECKED_KEY, wrongAnswer21.isChecked());
        outState.putBoolean(BUTTON22_CHECKED_KEY, wrongAnswer22.isChecked());
        outState.putBoolean(BUTTON23_CHECKED_KEY, wrongAnswer23.isChecked());
        outState.putBoolean(BUTTON3CORRECT_CHECKED_KEY, answer3.isChecked());
        outState.putBoolean(BUTTON31_CHECKED_KEY, wrongAnswer31.isChecked());
        outState.putBoolean(BUTTON32_CHECKED_KEY, wrongAnswer32.isChecked());
        outState.putBoolean(BUTTON33_CHECKED_KEY, wrongAnswer33.isChecked());
        outState.putBoolean(CHECKBOX41_CHECKED_KEY, answer41.isChecked());
        outState.putBoolean(CHECKBOX42_CHECKED_KEY, answer42.isChecked());
        outState.putBoolean(CHECKBOX43_CHECKED_KEY, answer43.isChecked());
        outState.putBoolean(CHECKBOX44_CHECKED_KEY, answer44.isChecked());
        outState.putBoolean(CHECKBOX45_CHECKED_KEY, answer45.isChecked());
        outState.putBoolean(BUTTON5CORRECT_CHECKED_KEY, answer5.isChecked());
        outState.putBoolean(BUTTON51_CHECKED_KEY, wrongAnswer51.isChecked());
        outState.putBoolean(BUTTON_CLICKED_KEY, buttonIsClicked);
        outState.putString(RESULT_KEY, result);
        outState.putInt("clickNumber", clickNumber);
        outState.putLong("mTimePassedInMillis", chronometer.getBase());
        answer2.setTextColor(0xAA76FF03);
        answer3.setTextColor(0xAA76FF03);
        answer5.setTextColor(0xAA76FF03);
        answer41.setTextColor(0xAA76FF03);
        answer42.setTextColor(0xAA76FF03);
        answer43.setTextColor(0xAA76FF03);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_new_page);
        finishButton = findViewById(R.id.finish_button);
        enterName = findViewById(R.id.enter_name);
        answer1 = findViewById(R.id.answer_1);
        answer2 = findViewById(R.id.answer2);
        wrongAnswer21 = findViewById(R.id.wrong_answer21);
        wrongAnswer22 = findViewById(R.id.wrong_answer22);
        wrongAnswer23 = findViewById(R.id.wrong_answer23);
        answer3 = findViewById(R.id.answer3);
        wrongAnswer31 = findViewById(R.id.wrong_answer31);
        wrongAnswer32 = findViewById(R.id.wrong_answer32);
        wrongAnswer33 = findViewById(R.id.wrong_answer33);
        answer5 = findViewById(R.id.answer5);
        wrongAnswer51 = findViewById(R.id.wrong_answer51);
        answer41 = findViewById(R.id.answer41);
        answer42 = findViewById(R.id.answer42);
        answer43 = findViewById(R.id.answer43);
        answer44 = findViewById(R.id.answer44);
        answer45 = findViewById(R.id.answer45);
        chronometer = findViewById(R.id.chronometer);
        chronometer.start();


        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick();
            }

        });

        //if orientation is changed, restore the states:

        if (savedInstanceState != null) {

            buttonIsClicked = savedInstanceState.getBoolean(BUTTON_CLICKED_KEY);
            result = savedInstanceState.getString(RESULT_KEY);

            //restore the chronometer before finish button is clicked:

            if (!buttonIsClicked) {

                chronometer.setBase(savedInstanceState.getLong("mTimePassedInMillis"));
                chronometer.start();
                int hours = (int) (mTimePassedInMillis) / 3600000;
                int minutes = (int) (mTimePassedInMillis - hours * 3600000) / 60000;
                int seconds = (int) (mTimePassedInMillis - hours * 3600000 - minutes * 60000) / 1000;
                String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                chronometer.setText(timeFormatted);
            }

            //restore the chronometer after finish button is clicked:

            if (buttonIsClicked) {

                chronometer.stop();
                chronometer.setText(result);
                clickNumber = 1;

                //restore disabled states after finish button is clicked:
                answer1.setEnabled(false);
                enterName.setEnabled(false);
                answer2.setEnabled(false);
                wrongAnswer21.setEnabled(false);
                wrongAnswer22.setEnabled(false);
                wrongAnswer23.setEnabled(false);
                answer3.setEnabled(false);
                wrongAnswer31.setEnabled(false);
                wrongAnswer32.setEnabled(false);
                wrongAnswer33.setEnabled(false);
                answer41.setEnabled(false);
                answer42.setEnabled(false);
                answer43.setEnabled(false);
                answer44.setEnabled(false);
                answer45.setEnabled(false);
                answer5.setEnabled(false);
                wrongAnswer51.setEnabled(false);

            }

            //restore other states:

            answer2.setChecked(savedInstanceState.getBoolean(BUTTON2CORRECT_CHECKED_KEY));
            wrongAnswer21.setChecked(savedInstanceState.getBoolean(BUTTON21_CHECKED_KEY));
            wrongAnswer22.setChecked(savedInstanceState.getBoolean(BUTTON22_CHECKED_KEY));
            wrongAnswer23.setChecked(savedInstanceState.getBoolean(BUTTON23_CHECKED_KEY));
            answer3.setChecked(savedInstanceState.getBoolean(BUTTON3CORRECT_CHECKED_KEY));
            wrongAnswer31.setChecked(savedInstanceState.getBoolean(BUTTON31_CHECKED_KEY));
            wrongAnswer32.setChecked(savedInstanceState.getBoolean(BUTTON32_CHECKED_KEY));
            wrongAnswer33.setChecked(savedInstanceState.getBoolean(BUTTON33_CHECKED_KEY));
            answer41.setChecked(savedInstanceState.getBoolean(CHECKBOX41_CHECKED_KEY));
            answer42.setChecked(savedInstanceState.getBoolean(CHECKBOX42_CHECKED_KEY));
            answer43.setChecked(savedInstanceState.getBoolean(CHECKBOX43_CHECKED_KEY));
            answer44.setChecked(savedInstanceState.getBoolean(CHECKBOX44_CHECKED_KEY));
            answer45.setChecked(savedInstanceState.getBoolean(CHECKBOX45_CHECKED_KEY));
            answer2.setChecked(savedInstanceState.getBoolean(BUTTON5CORRECT_CHECKED_KEY));
            wrongAnswer51.setChecked(savedInstanceState.getBoolean(BUTTON51_CHECKED_KEY));
            savedInstanceState.getInt("clickNumber");


        }

        if (buttonIsClicked) {
            checkAnswersEtc();
        }
    }

    private void buttonClick() {
        checkAnswersEtc();
        startResultsActivity(); // results page is displayed when finish button is clicked.
        setDisabled(); // all options are disabled when finish button is clicked.
        chronometer.stop(); // when finish button is clicked, chronometer stops.
        result = chronometer.getText().toString(); // when finish button is clicked, time result is saved.
        clickNumber++;
    }


    private void checkAnswersEtc() {
        buttonIsClicked = true;

        String checkAnswer1 = answer1.getText().toString();
        rightAnswer = findViewById(R.id.right_answer1);
        rightAnswer.setVisibility(View.VISIBLE); // after finish button is clicked, correct answer of 1st question is made visible.

        //check whether the correct answer for 1st question is given:
        if (checkAnswer1.equals(getText(R.string.android_q1_answer1)) || checkAnswer1.equals(getText(R.string.android_q1_answer1) + " ")) {

            c1 = true;

        } else {

            c1 = false;

        }

        rightAnswer.setTextColor(0xAA76FF03);
        rightAnswer.setText(R.string.android_q1_correct);

        //check whether the correct option for 2nd question is selected:
        c2 = answer2.isChecked();

        //check whether the correct option for 3rd question is selected:
        c3 = answer3.isChecked();
        checkAnswer41 = answer41.isChecked();
        checkAnswer42 = answer42.isChecked();
        checkAnswer43 = answer43.isChecked();
        checkAnswer44 = answer44.isChecked();
        checkAnswer45 = answer45.isChecked();
        c5 = answer5.isChecked();

        //check whether the correct options for 4th question are selected (1st, 2nd, and 3rd checkboxes must be selected for correct answer)
        if (checkAnswer41 && checkAnswer42 && checkAnswer43 && !checkAnswer44 && !checkAnswer45) {

            c4 = true;


        } else {

            c4 = false;
        }

        // if a question is answered correctly, score of that question is 1. Otherwise, it is 0.
        int q1 = (c1) ? 1 : 0;
        int q2 = (c2) ? 1 : 0;
        int q3 = (c3) ? 1 : 0;
        int q4 = (c4) ? 1 : 0;
        int q5 = (c5) ? 1 : 0;

        int correctNumber = q1 + q2 + q3 + q4 + q5; //total score
        correct = Integer.toString(correctNumber);

        //Correct answers are displayed in green after finish button is clicked:
        answer2.setTextColor(0xAA76FF03);
        answer3.setTextColor(0xAA76FF03);
        answer5.setTextColor(0xAA76FF03);
        answer41.setTextColor(0xAA76FF03);
        answer42.setTextColor(0xAA76FF03);
        answer43.setTextColor(0xAA76FF03);
    }

    //set disabled editTexts and options after the quiz is finished:

    private void setDisabled() {

        answer1.setEnabled(false);
        enterName.setEnabled(false);
        answer2.setEnabled(false);
        wrongAnswer21.setEnabled(false);
        wrongAnswer22.setEnabled(false);
        wrongAnswer23.setEnabled(false);
        answer3.setEnabled(false);
        wrongAnswer31.setEnabled(false);
        wrongAnswer32.setEnabled(false);
        wrongAnswer33.setEnabled(false);
        answer41.setEnabled(false);
        answer42.setEnabled(false);
        answer43.setEnabled(false);
        answer44.setEnabled(false);
        answer45.setEnabled(false);
        answer5.setEnabled(false);
        wrongAnswer51.setEnabled(false);
    }

    // chronometer time data just before finish button is clicked, name data, correct number data and click number of finish button data are sent to the ResultsActivity:
    private void startResultsActivity() {
        Intent i = new Intent();
        i.setClass(Activity2.this, ResultActivity.class);
        i.putExtra("time", chronometer.getText().toString());
        i.putExtra("outData", enterName.getText().toString());
        i.putExtra("out", correct);
        i.putExtra("clickNumber", Integer.toString(clickNumber));

        startActivity(i);
    }
}




