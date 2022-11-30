package edu.cvtc.sradke7.contentcreatortcg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Field;

import me.saket.bettermovementmethod.BetterLinkMovementMethod;

public class RuleBookGeneral extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

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
    ScrollView
            generalScrollView;
    private Spinner spinner;
    // Pages array
    private int[] pageParagraphs = {
            R.string.general_rules_part_1, R.string.general_rules_part_2, R.string.general_rules_part_3, R.string.general_rules_part_4, R.string.general_rules_part_5,
            R.string.general_rules_part_6, R.string.general_rules_part_7, R.string.general_rules_part_8, R.string.general_rules_part_9, R.string.general_rules_part_10,
            R.string.general_rules_part_11, R.string.general_rules_part_12, R.string.general_rules_part_13, R.string.general_rules_part_14, R.string.general_rules_part_15,
            R.string.general_rules_part_16, R.string.general_rules_part_17, R.string.general_rules_part_18, R.string.general_rules_part_19, R.string.general_rules_part_20,
            R.string.general_rules_part_21, R.string.general_rules_part_22, R.string.general_rules_part_23, R.string.general_rules_part_24
    };
    // Page numbers array
    private int[] pageNumbers = {
            R.string.page_1, R.string.page_2, R.string.page_3, R.string.page_4, R.string.page_5,
            R.string.page_6, R.string.page_7, R.string.page_8, R.string.page_9, R.string.page_10,
            R.string.page_11, R.string.page_12, R.string.page_13, R.string.page_14, R.string.page_15,
            R.string.page_16, R.string.page_17, R.string.page_18, R.string.page_19, R.string.page_20,
            R.string.page_21, R.string.page_22, R.string.page_23, R.string.page_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_general);

        Intent in = this.getIntent();

        generalScrollView = (ScrollView)findViewById(R.id.general_scrollView);
        generalScrollView.setSmoothScrollingEnabled(true);

        // Set the button variables
        btnCards = (Button)findViewById(R.id.btnCards);
        btnGeneralMore = (Button)findViewById(R.id.btnMore);
        btnBack = (Button)findViewById(R.id.btnBack);

        // Set the textview variables
        txtGeneral = (TextView)findViewById(R.id.concept_general_textView);
        txtGeneralPage = (TextView)findViewById(R.id.general_page_count_textView);

        // Makes every link clickable in the textView and changes their color to yellow
        txtGeneral.setMovementMethod(BetterLinkMovementMethod.getInstance());
        txtGeneral.setLinkTextColor(Color.YELLOW);

        spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        String[] pages = getResources().getStringArray(R.array.general_pages);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_list_item_1, pages) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
                // this part is needed for hiding the original view
                View view = super.getView(position, convertView, parent);
                view.setVisibility(View.GONE);
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



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

                if (txtGeneralSection < 24) {

                    txtGeneral.setText(pageParagraphs[txtGeneralSection]);
                    txtGeneralPage.setText(pageNumbers[txtGeneralSection]);
                    txtGeneralSection ++;

                } else {
                    txtGeneralSection = 0;
                    txtGeneral.setText(pageParagraphs[txtGeneralSection]);
                    txtGeneralPage.setText(pageNumbers[txtGeneralSection]);
                }

                scrollAnim();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtGeneralSection <= 1) {
                    // Do nothing
                } else {
                    txtGeneralSection -= 2;
                    txtGeneral.setText(pageParagraphs[txtGeneralSection]);
                    txtGeneralPage.setText(pageNumbers[txtGeneralSection]);
                    txtGeneralSection ++;
                    scrollAnim();
                }
            }
        });
    }

    // Scroll animation
    private void scrollAnim() {
        int generalScrollViewBottom = generalScrollView.getBottom();

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(generalScrollView, "scrollY", generalScrollViewBottom, 0).setDuration(1000);
        objectAnimator.start();
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner) {
            int valueFromSpinner = Integer.parseInt(parent.getItemAtPosition(position).toString());
            txtGeneral.setText(pageParagraphs[(valueFromSpinner - 1)]);
            txtGeneralPage.setText(pageNumbers[(valueFromSpinner - 1)]);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}