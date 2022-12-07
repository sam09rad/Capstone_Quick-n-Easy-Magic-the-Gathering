package edu.cvtc.sradke7.contentcreatortcg;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TutorialWalkthrough extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView txtWalkthrough, txtWalkthroughPage, txtWalkthroughHeader;
    private ImageView gifOne;

    Button btnWalkthroughMore;

    ScrollView walkThroughScrollView;

    private int txtWalkthroughSection = 2;

    private Spinner walkThroughSpinner;

    private int[] walkthroughPageSectionHeaders = {
            R.string.walkthrough_header_1, R.string.walkthrough_header_2
    };

    private int[] walkthroughPageParagraphs = {
            R.string.walkthrough_paragraph_1, R.string.walkthrough_paragraph_2
    };

    private int[] walkthroughPageNumbers = {
            R.string.walkthrough_page_1, R.string.walkthrough_page_2
    };

    private String[] gifArray = {
            "https://i.imgur.com/2IIcyqm.gif", "https://i.imgur.com/Li7100P.gif"
    };

    Map<String, String> map = new HashMap<>();

    int testIndex = 1;

    private int link = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_walkthrough);

        walkThroughScrollView = (ScrollView)findViewById(R.id.walkthrough_scrollView);
        walkThroughScrollView.setSmoothScrollingEnabled(true);

        btnWalkthroughMore = (Button)findViewById(R.id.btnWalkthroughMore);

        txtWalkthrough = (TextView)findViewById(R.id.walkthrough_general_textView);
        txtWalkthroughPage = (TextView)findViewById(R.id.walkthrough_page_count_textView);
        txtWalkthroughHeader = (TextView)findViewById(R.id.walkthrough_header_textView);

        map.put("0", "Beginning");

        Set<Map.Entry<String ,String> > set = map.entrySet();

        List<Map.Entry<String ,String>> walkthroughList = new ArrayList<>(set);



//        txtWalkthrough.setMovementMethod(BetterLinkMovementMethod.getInstance());
//        txtWalkthrough.setLinkTextColor(Color.YELLOW);
        gifOne = findViewById(R.id.gif_one);

        walkThroughSpinner = findViewById(R.id.walkthroughSpinner);

        final String[] walkthroughPages = getResources().getStringArray(R.array.walkthrough_pages);
        ArrayAdapter<CharSequence> walkthroughAdapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_list_item_1, walkthroughPages) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                view.setVisibility(View.GONE);

                return view;
            }
        };

        walkthroughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        walkThroughSpinner.setAdapter(walkthroughAdapter);

        walkThroughSpinner.setOnItemSelectedListener(this);





        // for gif
//        Glide.with(this)
//                .asGif()
//                .load("https://i.imgur.com/2IIcyqm.gif")
//                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
//                .listener(new RequestListener<GifDrawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable @org.jetbrains.annotations.Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
//                        resource.setLoopCount(1);
//                        return false;
//                    }
//                })
//                .into((gifOne));

        swapGif();

        btnWalkthroughMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(TutorialWalkthrough.this, "test worky.", Toast.LENGTH_LONG).show();


                if (txtWalkthroughSection <= 2) {

//                    txtWalkthrough.setText(walkthroughPageParagraphs[txtWalkthroughSection]);
//                    txtWalkthroughPage.setText(walkthroughPageNumber[txtWalkthroughSection]);
//                    txtWalkthroughSection ++;

                    txtWalkthroughHeader.setText(walkthroughPageSectionHeaders[txtWalkthroughSection]);
                    txtWalkthrough.setText(walkthroughPageParagraphs[txtWalkthroughSection]);
                    txtWalkthroughPage.setText(walkthroughPageNumbers[txtWalkthroughSection]);
                    txtWalkthroughSection ++;

                } else {
                    txtWalkthroughSection = 0;
                    txtWalkthrough.setText(walkthroughPageParagraphs[txtWalkthroughSection]);
                    txtWalkthroughPage.setText(walkthroughPageNumbers[txtWalkthroughSection]);
                }
                scrollAnim();
                swapGif();
            }
        });

//        btnWalkthroughBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (txtGeneralSection <= 1) {
//                    // Do nothing
//                } else {
//                    txtGeneralSection -= 2;
//                    txtGeneral.setText(walkthroughPageParagraphs[txtGeneralSection]);
//                    txtGeneralPage.setText(pageNumbers[txtGeneralSection]);
//                    txtGeneralSection ++;
//                    scrollAnim();
//                }
//            }
//        });

    }

    private void scrollAnim() {
        int generalScrollViewBottom = walkThroughScrollView.getBottom();

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(walkThroughScrollView, "scrollY", generalScrollViewBottom, 0).setDuration(1000);
        objectAnimator.start();
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        int valueFromSpinner2 = Integer.parseInt(parent.getItemAtPosition(position).toString());

        int valueFromSpinner = Arrays.asList(gifArray).indexOf(String.valueOf(txtWalkthroughSection));

        // If user selects a different page from the list, this will
        // change the page to the one selected then, prep the next
        // page if they then use the buttons
        if (parent.getId() == R.id.walkthroughSpinner) {

//            switch (testIndex) {
//                case 0:
//                    txtWalkthroughSection = 0;
//                    testIndex = 1;
//                    break;
//                case 1:
//                    txtWalkthroughSection = 0;
//                    testIndex = 2;
//                    break;
//                case 2:
//                    txtWalkthroughSection = 0;
//                    testIndex = 3;
//                    break;
//            }
            txtWalkthroughHeader.setText(walkthroughPageSectionHeaders[txtWalkthroughSection]);
            txtWalkthrough.setText(walkthroughPageParagraphs[txtWalkthroughSection]);
            txtWalkthroughPage.setText(walkthroughPageNumbers[txtWalkthroughSection]);

            txtWalkthroughSection = valueFromSpinner;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void swapGif() {
        String load;
        if (link == 1) {
            load = gifArray[0];
            link = 2;
        } else {
            load = gifArray[1];
            link = 1;
        }

        Glide.with(this)
                .asGif()
                .load(load)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable @org.jetbrains.annotations.Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    // had to research this to stop thee gif loop
                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        resource.setLoopCount(1);
                        return false;
                    }
                })
                .into((gifOne));
    }

}
