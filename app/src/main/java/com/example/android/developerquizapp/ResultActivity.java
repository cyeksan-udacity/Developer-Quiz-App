package com.example.android.developerquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cansu on 24.01.2018.
 */

public class ResultActivity extends Activity {

    String inData;
    String inScore;
    String clickNumber;
    TextView name;
    String time;
    TextView scoreTextView;
    TextView timeView;
    ProgressBar progressBar;
    int score;
    Button mailButton;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);
        progressBar = findViewById(R.id.progressBar);
        name = findViewById(R.id.name);
        timeView = findViewById(R.id.time);
        scoreTextView = findViewById(R.id.score_text_view);
        mailButton = findViewById(R.id.mail_button);


        Intent i = getIntent();
        this.inData = i.getStringExtra("outData"); // User's name is get from Activity1 or Activity2.
        this.clickNumber = i.getStringExtra("clickNumber"); // click number (on finish button) is get from Activity1 or Activity2.

        if (inData.equals("")) {
            name.setText(getText(R.string.your_score)); //if user name is not entered, "Your Score" is displayed at the top of the page.
        } else {

            name.setText(inData + getText(R.string.score));

        }
        this.time = i.getStringExtra("time");
        timeView.setText(getText(R.string.elapsed_time) + " " + time); // Elapsed time is get from Activity1 or Activity2.
        this.inScore = i.getStringExtra("out"); //Correct number is get from Activity1 or Activity2.
        scoreTextView.setText(inScore + getText(R.string.total_score));

        score = Integer.parseInt(inScore);

        for (int j = 1; j <= 5; j++) {

            if (Integer.parseInt(inScore) == j) {
                progressBar.setProgress(j * 20); // bar is progressed by each correct answers in the ratio of 20%.
                if (savedInstanceState == null && Integer.parseInt(clickNumber) == 0) {
                    Toast.makeText(ResultActivity.this,
                            //at the first click on the finish button, below toast message is displayed. At the later clicks, this message is not needed.
                            getString(R.string.message1) + " " + inScore + " " + getString(R.string.message2) + "\n" + getString(R.string.toast_message), Toast.LENGTH_LONG).show();
                }

            }

        }

    }

    public void send(View v) {

        //if "SEND RESULTS" button is clicked, user chooses one of the send options (message, e-mail, Whatsapp etc.) and results are sent as text/plain:
        String message = getText(R.string.message1) + " " + inScore + " " + getText(R.string.message2) + "\n\n" + getText(R.string.elapsed_time) + " " + time;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("text/plain");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }

    }

}
