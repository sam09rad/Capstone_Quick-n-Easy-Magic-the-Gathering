package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.Toast;

import java.util.Arrays;

import me.saket.bettermovementmethod.BetterLinkMovementMethod;

public class RuleBookCards extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    // Variables used in class
    Button
            btnCardsTypes,
            btnCardsMore,
            btnCardsBack;
    private TextView
            txtPartsOfCards,
            txtPartsOfCardsHeader,
            txtPartsOfCardsPage;
    private int
            txtPartsOfCardsSection = 1;
    ScrollView
            partsOfCardsScrollView;
    private Spinner partsOfCardsSpinner;

    // Pages arrays
    private int[] pageSectionHeaders = {
            R.string.parts_of_a_card_header_1, R.string.parts_of_a_card_header_2, R.string.parts_of_a_card_header_3, R.string.parts_of_a_card_header_4, R.string.parts_of_a_card_header_5,
            R.string.parts_of_a_card_header_6, R.string.parts_of_a_card_header_7, R.string.parts_of_a_card_header_8, R.string.parts_of_a_card_header_9, R.string.parts_of_a_card_header_10,
            R.string.parts_of_a_card_header_11, R.string.parts_of_a_card_header_12, R.string.parts_of_a_card_header_13
    };
    private int[] pageParagraphs = {
            R.string.parts_of_a_card_1, R.string.parts_of_a_card_2, R.string.parts_of_a_card_3, R.string.parts_of_a_card_4, R.string.parts_of_a_card_5,
            R.string.parts_of_a_card_6, R.string.parts_of_a_card_7, R.string.parts_of_a_card_8, R.string.parts_of_a_card_9, R.string.parts_of_a_card_10,
            R.string.parts_of_a_card_11, R.string.parts_of_a_card_12, R.string.parts_of_a_card_13
    };
    // Page numbers array
    private int[] pageNumbers = {
            R.string.page_1, R.string.page_2, R.string.page_3, R.string.page_4, R.string.page_5,
            R.string.page_6, R.string.page_7, R.string.page_8, R.string.page_9, R.string.page_10,
            R.string.page_11, R.string.page_12, R.string.page_13
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_cards);

        Intent in = this.getIntent();

        partsOfCardsScrollView = (ScrollView)findViewById(R.id.cards_scrollView);
        partsOfCardsScrollView.setSmoothScrollingEnabled(true);

        // Set the button variables
        btnCardsTypes = (Button)findViewById(R.id.btnCardTypes);
        btnCardsMore = (Button)findViewById(R.id.btnMoreCards);
        btnCardsBack = (Button)findViewById(R.id.btnBackCards);

        // Set the textview variables
        txtPartsOfCardsHeader = (TextView)findViewById(R.id.cards_header_textView);
        txtPartsOfCards = (TextView)findViewById(R.id.concept_cards_textView);
        txtPartsOfCardsPage = (TextView)findViewById(R.id.cards_page_count_textView);

        // Makes every link clickable in the textView and changes their color to yellow
        txtPartsOfCards.setMovementMethod(BetterLinkMovementMethod.getInstance());
        txtPartsOfCards.setLinkTextColor(Color.YELLOW);

        partsOfCardsSpinner = findViewById(R.id.parts_of_cards_spinner);

        final String[] pagesPartsOfCards = getResources().getStringArray(R.array.parts_of_card_pages);
        ArrayAdapter<CharSequence> adapterPartsOfCards = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_list_item_1, pagesPartsOfCards) {
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

        adapterPartsOfCards.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        partsOfCardsSpinner.setAdapter(adapterPartsOfCards);

        partsOfCardsSpinner.setOnItemSelectedListener(this);

        btnCardsTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(RuleBookPartsOfCards.this, RuleBookCards.class));
                Toast.makeText(RuleBookCards.this, "Under development", Toast.LENGTH_SHORT).show();
            }
        });
        // Pattern to follow for changing the text
        btnCardsMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txtPartsOfCardsSection < 13) {

                    txtPartsOfCardsHeader.setText(pageSectionHeaders[txtPartsOfCardsSection]);
                    txtPartsOfCards.setText(pageParagraphs[txtPartsOfCardsSection]);
                    txtPartsOfCardsPage.setText(pageNumbers[txtPartsOfCardsSection]);
                    txtPartsOfCardsSection ++;

                } else {
                    txtPartsOfCardsSection = 0;
                    txtPartsOfCards.setText(pageParagraphs[txtPartsOfCardsSection]);
                    txtPartsOfCardsPage.setText(pageNumbers[txtPartsOfCardsSection]);
                }
                scrollAnim();
            }
        });

        btnCardsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPartsOfCardsSection <= 1) {
                    // Do nothing
                } else {
                    txtPartsOfCardsSection -= 2;
                    txtPartsOfCardsHeader.setText(pageSectionHeaders[txtPartsOfCardsSection]);
                    txtPartsOfCards.setText(pageParagraphs[txtPartsOfCardsSection]);
                    txtPartsOfCardsPage.setText(pageNumbers[txtPartsOfCardsSection]);
                    txtPartsOfCardsSection ++;
                    scrollAnim();
                }
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
                Intent intent = new Intent(RuleBookCards.this, CardViewerActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_quickstart_guide:
                intent = new Intent(RuleBookCards.this, QuickstartGuide.class);
                startActivity(intent);
                return true;
            case R.id.action_rule_book_viewer:
                intent = new Intent(RuleBookCards.this, RuleBookTableOfContents.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
    
    // Scroll animation
    private void scrollAnim() {
        int partsOfCardsScrollViewBottom = partsOfCardsScrollView.getBottom();

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(partsOfCardsScrollView, "scrollY", partsOfCardsScrollViewBottom, 0).setDuration(1000);
        objectAnimator.start();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int valueFromCardsSpinner = Integer.parseInt(parent.getItemAtPosition(position).toString());

        // If user selects a different page from the list, this will
        // change the page to the one selected then, prep the next
        // page if they then use the buttons
        if (parent.getId() == R.id.parts_of_cards_spinner) {
            txtPartsOfCardsSection = (valueFromCardsSpinner - 1);

            txtPartsOfCardsHeader.setText(pageSectionHeaders[txtPartsOfCardsSection]);
            txtPartsOfCards.setText(pageParagraphs[txtPartsOfCardsSection]);
            txtPartsOfCardsPage.setText(pageNumbers[txtPartsOfCardsSection]);

            txtPartsOfCardsSection = valueFromCardsSpinner;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}