package edu.cvtc.sradke7.contentcreatortcg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class TutorialWalkthrough extends AppCompatActivity {

    // Variables used in class
    Button btnWalkthroughMore;

    ProgressBar progressBarWlk = null;

    private ImageView gif;

    private int link = 1;

    private String[] gifArray = {
            "https://i.imgur.com/T5x3SV5.gif", "https://i.imgur.com/8xhf3L2.gif", "https://i.imgur.com/vGT8ZpA.gif",
            "https://i.imgur.com/MSWYhzm.gif", "https://i.imgur.com/ltZZ09w.gif", "https://i.imgur.com/t3u2bKe.gif",
            "https://i.imgur.com/64FjfZW.gif"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_walkthrough);

        progressBarWlk = findViewById(R.id.progress_bar_wlk);

        // Set the button variables
        btnWalkthroughMore = findViewById(R.id.btnWalkthroughMore);

        gif = findViewById(R.id.gif_one);
        swapGif();

        btnWalkthroughMore.setOnClickListener(view -> {
            swapGif();
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
                Intent intent = new Intent(TutorialWalkthrough.this, CardViewerActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_quickstart_guide:
                intent = new Intent(TutorialWalkthrough.this, QuickstartGuide.class);
                startActivity(intent);
                return true;
            case R.id.action_rule_book_viewer:
                intent = new Intent(TutorialWalkthrough.this, RuleBookTableOfContents.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    public void swapGif() {
        String load = null;
        if (link == 1) {
            load = gifArray[0];
            link++;
        } else if (link == 2) {
            load = gifArray[1];
            link++;
        } else if (link == 3) {
            load = gifArray[2];
            link++;
        } else if (link == 4) {
            load = gifArray[3];
            link++;
        } else if (link == 5) {
            load = gifArray[4];
            link++;
        } else if (link == 6) {
            load = gifArray[5];
            link++;
        } else if (link == 7) {
            load = gifArray[6];
            btnWalkthroughMore.setText(R.string.walkthrough_restart_set_text);
            link++;
        } else if (link == 8) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

        Glide.with(this)
                .asGif()
                .load(load)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable @org.jetbrains.annotations.Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        progressBarWlk.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        resource.setLoopCount(1);
                        progressBarWlk.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .into((gif));
    }
}