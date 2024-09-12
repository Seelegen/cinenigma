package com.example.android.datafrominternet;/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import com.example.android.cineenigma.R;



public class MainActivity extends AppCompatActivity {

    EditText editTextTitle, editTextDate, editTextCritique;
    RatingBar ratingBarScenario, ratingBarRealisateur, ratingBarMusique;
    Button buttonShare;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDate = findViewById(R.id.editTextDate);
        editTextCritique = findViewById(R.id.editTextCritique);
        ratingBarScenario = findViewById(R.id.ratingBarScenario);
        ratingBarRealisateur = findViewById(R.id.ratingBarRealisateur);
        ratingBarMusique = findViewById(R.id.ratingBarMusique);
        buttonShare = findViewById(R.id.buttonShare);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String date = editTextDate.getText().toString();
                float scenario = ratingBarScenario.getRating();
                float realisation = ratingBarRealisateur.getRating();
                float musique = ratingBarMusique.getRating();
                String critique = editTextCritique.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Critique de film");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Titre : " + title + "\n" +
                            "Date : " + date + "\n" +
                            "Note Scénario : " + scenario + "\n" +
                            "Note Réalisation : " + realisation + "\n" +
                            "Note Musique : " + musique + "\n" +
                            "Critique : " + critique);

                startActivity(Intent.createChooser(emailIntent, "Envoyer via"));
                }
        });
    }
}



