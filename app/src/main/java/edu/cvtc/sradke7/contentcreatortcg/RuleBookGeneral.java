package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RuleBookGeneral extends AppCompatActivity {

    // Variables used in class
    Button
            btnCards,
            btnGeneralMore;
    private TextView
            txtGeneral;
    private int
            txtGeneralSection = 1;
    private String
            string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_general);

        Intent in = this.getIntent();

        // First button is for switching the text in the text view
        btnCards = (Button)findViewById(R.id.btnCards);
        btnGeneralMore = (Button)findViewById(R.id.btnMore);

        // Set the textview variable
        txtGeneral = (TextView)findViewById(R.id.concept_general_textView);

        // Not currently working, so commented out for now until a fix can be made.
//        {
//            // method to redirect to provided link
//            txtGeneral.setMovementMethod(LinkMovementMethod.getInstance());
//            // method to change color of link
//            txtGeneral.setLinkTextColor(Color.YELLOW);
//        }
        btnCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RuleBookGeneral.this, RuleBookCards.class));
            }
        });

        // Pattern to follow for changing the text
        btnGeneralMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (txtGeneralSection) {
                    case 0:
                        string = getString(R.string.general_rules_part_1);
                        txtGeneral.setText(string);
                        txtGeneralSection = 1;
                        break;
                    case 1:
                        string = getString(R.string.general_rules_part_2);
                        txtGeneral.setText(string);
                        txtGeneralSection = 2;
                        break;
                    case 2:
                        string = getString(R.string.general_rules_part_3);
                        txtGeneral.setText(string);
                        txtGeneralSection = 3;
                        break;
                    case 3:
                        string = getString(R.string.general_rules_part_4);
                        txtGeneral.setText(string);
                        txtGeneralSection = 0;
                        break;
                }
                // Test for less code

//                if (txtGeneralSection < 30) {
//
//                    String generalRules = "R.string.general_rules_part_" + String.valueOf(txtGeneralSection);
//                    string = getString(Integer.parseInt(generalRules));
////                    string = String.valueOf(R.string.general_rules_part_2);
//                    txtGeneral.setText(string);
//                    txtGeneralSection++;
//                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_card_viewer:
                Intent intent = new Intent(RuleBookGeneral.this, CardViewer.class);
                startActivity(intent);
                return true;
            case R.id.action_quickstart_guide:
                intent = new Intent(RuleBookGeneral.this, QuickstartGuide.class);
                startActivity(intent);
                return true;
            case R.id.action_rule_book_viewer:
                intent = new Intent(RuleBookGeneral.this, RuleBookGeneral.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}