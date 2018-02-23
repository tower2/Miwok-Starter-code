package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
 * Created by jermainegoins on 7/8/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    // Reference ID for background color for this list of words
    private int mColorReferenceID;

    public WordAdapter(Context context, ArrayList<Word> words, int colorReferenceID){
        super(context,0,words);
        mColorReferenceID = colorReferenceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID version_image
        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.picture_image_view);

        // Verifies if currentWord has an image in it.
        if (currentWord.hasImage()) {

            // Get the version image from the current AndroidFlavor object and
            // set this image on the image ImageView
            defaultImageView.setImageResource(currentWord.getImageResourceID());

            //Make sure image is VISIBLE
            defaultImageView.setVisibility(View.VISIBLE);

            // Return the whole list item layout (containing 2 TextViews and an ImageView) so that it can be shown in the ListView

        } else {
            // Removes the ImageView
            defaultImageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorReferenceID);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list layout so that it can be shown in the ListView (includes 2 TextViews)
        return listItemView;
    }
}