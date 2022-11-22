package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class QuickstartGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quickstart_guide);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_card_viewer:
                Intent intent = new Intent(QuickstartGuide.this, CardViewer.class);
                startActivity(intent);
                return true;
            case R.id.action_quickstart_guide:
                intent = new Intent(QuickstartGuide.this, QuickstartGuide.class);
                startActivity(intent);
                return true;
            case R.id.action_rule_book_viewer:
                intent = new Intent(QuickstartGuide.this, RuleBookGeneral.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}