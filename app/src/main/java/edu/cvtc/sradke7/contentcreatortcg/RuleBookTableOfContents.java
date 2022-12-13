package edu.cvtc.sradke7.contentcreatortcg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RuleBookTableOfContents extends AppCompatActivity implements View.OnClickListener {
    private TextView tvGeneral, tvPartsOfCards;
    private Class MyActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_table_of_contents);

        tvGeneral = (TextView)findViewById(R.id.general_link_textView);
        tvPartsOfCards = (TextView)findViewById(R.id.cards_link_textView);

        // bind listeners
        tvGeneral.setOnClickListener(this);
        tvPartsOfCards.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.general_link_textView:
                MyActivityName = RuleBookGeneral.class;
                break;
            case R.id.cards_link_textView:
                MyActivityName = RuleBookCards.class;
                break;
//            case R.id.button_three:
//                // i'm lazy, do nothing
//                break;
        }
        Intent myIntent = new Intent(this, MyActivityName);
        startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_rule_book_viewer).setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_card_viewer:
                Intent intent = new Intent(RuleBookTableOfContents.this, CardViewerActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_quickstart_guide:
                intent = new Intent(RuleBookTableOfContents.this, QuickstartGuide.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}