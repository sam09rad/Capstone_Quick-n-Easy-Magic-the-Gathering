package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RuleBookTableOfContents extends AppCompatActivity implements View.OnClickListener{
    private TextView tvGeneral;
    private Class MyActivityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_book_table_of_contents);

        tvGeneral = (TextView)findViewById(R.id.general_link_textView);

        // bind listeners
        tvGeneral.setOnClickListener(this);
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
}