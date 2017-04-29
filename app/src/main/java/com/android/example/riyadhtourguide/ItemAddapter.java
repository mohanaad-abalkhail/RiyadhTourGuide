package com.android.example.riyadhtourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MOHANAAD on 3/25/17.
 */

public class ItemAddapter extends ArrayAdapter<Item> {

    private int mColorResorseId;

    public ItemAddapter(Activity context, ArrayList<Item> items, int colorResorseId) {

        super(context, 0, items);
        mColorResorseId = colorResorseId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Item currentItem = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentItem.hasImage()) {
            imageView.setImageResource(currentItem.getImageResurseId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        ImageView arrowImageView = (ImageView) listItemView.findViewById(R.id.voice_image);
        if (currentItem.hasSound()) {
            arrowImageView.setImageResource(currentItem.getSoundImageResourseId());
            arrowImageView.setVisibility(View.VISIBLE);
        } else {
            arrowImageView.setVisibility(View.GONE);
        }

        TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.place_name);
        placeNameTextView.setText(currentItem.getPlaceName());

        TextView placeInformationTextView = (TextView) listItemView.findViewById(R.id.place_information);
        placeInformationTextView.setText(currentItem.getPlaceInformation());

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResorseId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
