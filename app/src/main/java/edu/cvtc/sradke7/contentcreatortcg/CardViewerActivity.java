package edu.cvtc.sradke7.contentcreatortcg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import edu.cvtc.sradke7.contentcreatortcg.adapter.CardListAdapter;
import edu.cvtc.sradke7.contentcreatortcg.api.models.CardResponse;
import edu.cvtc.sradke7.contentcreatortcg.api.models.SearchResponse;
import edu.cvtc.sradke7.contentcreatortcg.api.service.CardServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardViewerActivity extends AppCompatActivity {

    RecyclerView cardRecyclerView;
    ImageView cardImage = null;
    ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        progressBar = findViewById(R.id.progress_bar);
        EditText searchBar = findViewById(R.id.search_bar);
        Button searchBtn = findViewById(R.id.search_card_btn);
        cardRecyclerView = findViewById(R.id.recycler_view);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchBar.getText() != null && !searchBar.getText().toString().equals("")) {

                    progressBar.setVisibility(View.VISIBLE);
                    fetchCard(searchBar.getText().toString());


                } else {

                    Toast.makeText(CardViewerActivity.this, "Please enter valid search term.", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
        });

    }

    // Top of page menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_card_viewer).setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_quickstart_guide:
                Intent intent = new Intent(CardViewerActivity.this, QuickstartGuide.class);
                startActivity(intent);
                return true;
            case R.id.action_rule_book_viewer:
                intent = new Intent(CardViewerActivity.this, RuleBookTableOfContents.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    private void fetchCard(String searchTerm) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.scryfall.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardServiceApi service = retrofit.create(CardServiceApi.class);

        Call<SearchResponse> searchRequest = service.fetchCard(searchTerm);

        searchRequest.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    if(response.body() != null) {
                        CardListAdapter adapter = new CardListAdapter(CardViewerActivity.this, response.body().getCards());
                        cardRecyclerView.setAdapter(adapter);
                        progressBar.setVisibility(View.GONE);
                    }
                } else {
                    Toast.makeText(CardViewerActivity.this, "No Results Found.", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(CardViewerActivity.this, "Unexpected Error Occurred.", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}