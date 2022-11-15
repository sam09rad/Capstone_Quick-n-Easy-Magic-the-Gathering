package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CardViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        Button cardViewBrowser = (Button)findViewById(R.id.viewCardBrowserBtn);

        cardViewBrowser.setOnClickListener(view -> {
            Intent webpageIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://scryfall.com")
            );
            startActivity(webpageIntent);
        });


    }
}