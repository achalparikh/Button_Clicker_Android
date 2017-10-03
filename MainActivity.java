package com.example.achal.buttonclicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText userInput;
    private Button btn;
    private TextView text;
    private int counter = 0;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "textcontents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the view to the Variables

        userInput =  (EditText) findViewById(R.id.editText);
        userInput.setText("");
        btn = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.textView);
        text.setText("");
        text.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener mocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                String result = "The button was clicked " + counter + " time";
                if (counter > 1) {
                    result += "s";
                }
                String input = userInput.getText().toString();
                if (input.length() <= 0) {
                    text.append(result + "\n");
                } else {
                    text.append(input + "\n");
                    text.append(result + "\n");
                }
                userInput.setText("");
            }
        };
        btn.setOnClickListener(mocl);
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text.setText(savedInstanceState.getString(TEXT_CONTENTS));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(TEXT_CONTENTS, text.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

