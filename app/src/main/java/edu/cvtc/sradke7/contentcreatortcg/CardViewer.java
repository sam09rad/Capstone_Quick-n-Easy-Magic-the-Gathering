package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class CardViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        Button cardViewBrowser = (Button)findViewById(R.id.viewCardBrowserBtn);

        cardViewBrowser.setOnClickListener(view -> {
            Intent webpageIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://scryfall.com")
            );
            startActivity(webpageIntent);
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
                Intent intent = new Intent(CardViewer.this, CardViewer.class);
                startActivity(intent);
                return true;
            case R.id.action_quickstart_guide:
                intent = new Intent(CardViewer.this, QuickstartGuide.class);
                startActivity(intent);
                return true;
            case R.id.action_rule_book_viewer:
                intent = new Intent(CardViewer.this, RuleBookGeneral.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}