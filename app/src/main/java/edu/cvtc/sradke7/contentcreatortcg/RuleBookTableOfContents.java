package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class RuleBookTableOfContents extends AppCompatActivity implements View.OnClickListener {
    private TextView tvGeneral;
    private Class MyActivityName;


    private ImageView imageOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_table_of_contents);

        tvGeneral = (TextView)findViewById(R.id.general_link_textView);

        // bind listeners
        tvGeneral.setOnClickListener(this);

        imageOne = findViewById(R.id.image_one);



        // for gif
        Glide.with(RuleBookTableOfContents.this)
                .load("https://i.imgur.com/Li7100P.gif")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageOne);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.general_link_textView:
                MyActivityName = RuleBookGeneral.class;
                break;
//            case R.id.button_two:
//                // do something else
//                break;
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
            case R.id.action_rule_book_viewer:
                intent = new Intent(RuleBookTableOfContents.this, RuleBookGeneral.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}