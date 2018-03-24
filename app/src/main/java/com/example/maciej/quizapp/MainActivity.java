package com.example.maciej.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int question1points = 0;
    private int question2points = 0;
    private int question3points = 0;
    private int question4points = 0;
    int score = 0;

    String finalscore;
    String positive = "";
    String negative = "";
    String answer = "";

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    EditText editText;
    RadioButton question2;
    RadioButton question4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        editText = findViewById(R.id.question3);
        question2 = findViewById(R.id.poprawne2);
        question4 = findViewById(R.id.poprawne4);
    }

    public void Question1(){
        if( (checkBox1.isChecked() == true) && (checkBox2.isChecked() == true) && (checkBox3.isChecked() == false) && (checkBox4.isChecked() == false) ){
            question1points = 1;
            positive += "1, ";
        }else{
            negative += "1, ";
        }
    }

    public void Question2(){
        if(question2.isChecked() == true){
            question2points = 1;
            positive += "2, ";
        }else{
            negative += "2, ";
        }
    }

    public void question3(){
        answer = editText.getText().toString();
        if (answer.equals("28")){
            question3points = 1;
            positive += "3, ";
        }else{
            negative += "3, ";
        }
    }

    public void Question4(){
        if(question4.isChecked() == true){
            question4points = 1;
            positive += "4";
        }else{
            negative += "4";
        }
    }

    public void calculatescore(){
        score = question1points + question2points + question3points + question4points;
    }

    public void check(View view){
        Question1();
        Question2();
        question3();
        Question4();
        calculatescore();
        finalscore = "You Give Good Answers for Questions : \n " + positive + "\n You give wrong answers for Questions : \n" + negative + "\n Your Final Score : \n" + score + "/4";
        Toast.makeText(getBaseContext(), finalscore, Toast.LENGTH_LONG).show();
        reset();
    }

    public void reset(){
        question1points = 0;
        question2points = 0;
        question3points = 0;
        question4points = 0;
        positive = "";
        negative = "";
        answer = "";
        finalscore = "You Give Good Answers for Questions : \n " + positive + "\n You give wrong answers for Questions : \n" + negative + "\n Your Final Score : \n" + score + "/4";
    }
}
