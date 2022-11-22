package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RuleBookGeneral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_general);
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