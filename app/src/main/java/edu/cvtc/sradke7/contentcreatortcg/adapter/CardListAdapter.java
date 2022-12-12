package edu.cvtc.sradke7.contentcreatortcg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.cvtc.sradke7.contentcreatortcg.CardViewerActivity;
import edu.cvtc.sradke7.contentcreatortcg.R;
import edu.cvtc.sradke7.contentcreatortcg.api.models.CardResponse;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {

    private LayoutInflater layoutInflater;
    private List<CardResponse> cards;
    private Context context;

    public CardListAdapter(Context context, List<CardResponse> cards) {

        this.layoutInflater = LayoutInflater.from(context);
        this.cards = cards;
        this.context = context;


    }

    @NonNull
    @Override
    public CardListAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_item, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardListAdapter.CardViewHolder holder, int position) {

        Glide.with(context)
                .load(cards.get(position).getImageUri().getImageUrl())
                .into(holder.cardImage);

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    // This stores data from each cell.
    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView cardImage;

        CardViewHolder(View cardView) {

            super(cardView);
            cardImage = cardView.findViewById(R.id.card_image);
        }

    }

}
