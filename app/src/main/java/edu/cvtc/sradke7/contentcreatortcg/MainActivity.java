package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cardViewerButton = (Button)findViewById(R.id.cardViewerBtn);
        Button ruleBookButton = (Button)findViewById(R.id.rulebookBtn);
        Button quickStartGuideButton = (Button)findViewById(R.id.quickstartGuideBtn);
        Button tutorialButton = (Button)findViewById(R.id.tutorialBtn);

        cardViewerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardViewerActivity.class));
            }
        });

        ruleBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RuleBookTableOfContents.class));
            }
        });

        quickStartGuideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuickstartGuide.class));
            }
        });

        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TutorialWalkthrough.class));
            }
        });

        };
}