package com.artalos.fernweh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.List;

public class ShowProfiles extends AppCompatActivity {

    int MIN_SCORE = 2;
    LinearLayout layout = (LinearLayout) findViewById(R.id.trial);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profiles);
        User c = new User(123, "harshit", "email", "123", "Boston", "12", "20", "hi me", "Hiking");
        DatabaseHandler db = new DatabaseHandler(this);
        get_scores(c, db.getAllUsers());
    }

    private void get_scores(User c, List<User> people){
        int current_score = 0;
        for (User p: people) {
            current_score = compute_score_for_user(c,p);
            if(current_score > MIN_SCORE){
                display_user(p);
            }
        }
    }

    private int compute_score_for_user(User c, User p){
        int match_score = 0;
        if (c.getUserCity().equals(p.getUserCity())){
            match_score++;
        }
        if (c.getUserBudgetMin().equals(p.getUserBudgetMin())){
            match_score++;
        }
        if (c.getUserBudgetMax().equals(p.getUserBudgetMax())){
            match_score++;
        }if (c.getUserInterests().equals(p.getUserInterests())){
            match_score++;
        }
        return match_score;
    }

    private void display_user(User p){
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        btnTag.setText(p.getUserName());
        btnTag.setId(p.getUserID());
        layout.addView(btnTag);
        //display user
    }



}

