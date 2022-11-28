package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class RuleBookGeneral extends AppCompatActivity {

    // Variables used in class
    Button
            btnCards,
            btnGeneralMore,
            btnBack;
    private TextView
            txtGeneral,
            txtGeneralPage;
    private int
            txtGeneralSection = 1;
    private String
            string,
            pageCount;
    ScrollView
            generalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_general);

        Intent in = this.getIntent();

        generalScrollView = (ScrollView)findViewById(R.id.general_scrollView);
        generalScrollView.setSmoothScrollingEnabled(true);

        // First button is for switching the text in the text view
        btnCards = (Button)findViewById(R.id.btnCards);
        btnGeneralMore = (Button)findViewById(R.id.btnMore);
        btnBack = (Button)findViewById(R.id.btnBack);

        // Set the textview variable
        txtGeneral = (TextView)findViewById(R.id.concept_general_textView);
        txtGeneralPage = (TextView)findViewById(R.id.general_page_count_textView);

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
                changeText(txtGeneralSection);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtGeneralSection <= 1) {
                    // Do nothing
                } else {
                    changeText(txtGeneralSection - 2);
                }
            }
        });
    }

    // Test for less code

//        if (txtGeneralSection < 30) {
//
//            String generalRules = "R.string.general_rules_part_" + String.valueOf(txtGeneralSection);
//            string = getString(Integer.parseInt(generalRules));
////            string = String.valueOf(R.string.general_rules_part_2);
//            txtGeneral.setText(string);
//            txtGeneralSection++;
//        }

    private int changeText(int Section) {
        switch (Section) {
            case 0:
                string = getString(R.string.general_rules_part_1);
                pageCount = getString(R.string.page_1);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 1;
                break;
            case 1:
                string = getString(R.string.general_rules_part_2);
                pageCount = getString(R.string.page_2);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 2;
                break;
            case 2:
                string = getString(R.string.general_rules_part_3);
                pageCount = getString(R.string.page_3);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 3;
                break;
            case 3:
                string = getString(R.string.general_rules_part_4);
                pageCount = getString(R.string.page_4);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 4;
                break;
            case 4:
                string = getString(R.string.general_rules_part_5);
                pageCount = getString(R.string.page_5);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 5;
                break;
            case 5:
                string = getString(R.string.general_rules_part_6);
                pageCount = getString(R.string.page_6);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 6;
                break;
            case 6:
                string = getString(R.string.general_rules_part_7);
                pageCount = getString(R.string.page_7);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 7;
                break;
            case 7:
                string = getString(R.string.general_rules_part_8);
                pageCount = getString(R.string.page_8);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 8;
                break;
            case 8:
                string = getString(R.string.general_rules_part_9);
                pageCount = getString(R.string.page_9);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 9;
                break;
            case 9:
                string = getString(R.string.general_rules_part_10);
                pageCount = getString(R.string.page_10);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 10;
                break;
            case 10:
                string = getString(R.string.general_rules_part_11);
                pageCount = getString(R.string.page_11);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 11;
                break;
            case 11:
                string = getString(R.string.general_rules_part_12);
                pageCount = getString(R.string.page_12);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 12;
                break;
            case 12:
                string = getString(R.string.general_rules_part_13);
                pageCount = getString(R.string.page_13);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 13;
                break;
            case 13:
                string = getString(R.string.general_rules_part_14);
                pageCount = getString(R.string.page_14);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 14;
                break;
            case 14:
                string = getString(R.string.general_rules_part_15);
                pageCount = getString(R.string.page_15);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 15;
                break;
            case 15:
                string = getString(R.string.general_rules_part_16);
                pageCount = getString(R.string.page_16);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 16;
                break;
            case 16:
                string = getString(R.string.general_rules_part_17);
                pageCount = getString(R.string.page_17);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 17;
                break;
            case 17:
                string = getString(R.string.general_rules_part_18);
                pageCount = getString(R.string.page_18);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 18;
                break;
            case 18:
                string = getString(R.string.general_rules_part_19);
                pageCount = getString(R.string.page_19);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 19;
                break;
            case 19:
                string = getString(R.string.general_rules_part_20);
                pageCount = getString(R.string.page_20);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 20;
                break;
            case 20:
                string = getString(R.string.general_rules_part_21);
                pageCount = getString(R.string.page_21);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 21;
                break;
            case 21:
                string = getString(R.string.general_rules_part_22);
                pageCount = getString(R.string.page_22);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 22;
                break;
            case 22:
                string = getString(R.string.general_rules_part_23);
                pageCount = getString(R.string.page_23);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 23;
                break;
            case 23:
                string = getString(R.string.general_rules_part_24);
                pageCount = getString(R.string.page_24);

                txtGeneral.setText(string);
                txtGeneralPage.setText(pageCount);

                txtGeneralSection = 0;
                break;
        }

        generalScrollView.setScrollY(0);

        return txtGeneralSection;
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