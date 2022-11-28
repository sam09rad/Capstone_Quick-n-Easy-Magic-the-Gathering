package edu.cvtc.sradke7.contentcreatortcg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.Console;

import edu.cvtc.sradke7.contentcreatortcg.api.models.SearchResponse;
import edu.cvtc.sradke7.contentcreatortcg.api.service.CardServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        //ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);
        //AnimationDrawable animationDrawable = (StateListDrawable) constraintLayout.getBackground();
        //animationDrawable.setEnterFadeDuration(2500);
        //animationDrawable.setExitFadeDuration(5000);
        //animationDrawable.start();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.scryfall.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardServiceApi service = retrofit.create(CardServiceApi.class);

        Call<SearchResponse> searchResponse = service.fetchCard("asdf");

        searchResponse.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("Test", response.body().getCards().get(0).getCardName());
                } else {
                    Toast.makeText(CardViewer.this, "No Results Found.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(CardViewer.this, "Unexpected Error Occurred.", Toast.LENGTH_LONG).show();
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