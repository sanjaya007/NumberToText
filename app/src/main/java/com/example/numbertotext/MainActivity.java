package com.example.numbertotext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    EditText editNumberTxt;
    TextView inWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumberTxt = findViewById(R.id.editTxtNum);
        inWords = findViewById(R.id.inWords);

        TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( filterLongEnough() ){
                    int number = Integer.parseInt(editNumberTxt.getText().toString());
                    inWords.setText(NumToWord.toWord(number));
                }else{
                    inWords.setText("");
                }
            }

            private boolean filterLongEnough() {
                return editNumberTxt.getText().toString().trim().length() > 0;
            }
        };
        editNumberTxt.addTextChangedListener(fieldValidatorTextWatcher);
    }

}
