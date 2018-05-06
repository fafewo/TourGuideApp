package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    /**
     * Resource ID for the background color to this list of words
     */
    private int mColorResourceId;

    public PlaceAdapter(Activity context, ArrayList<Place> words, int colorResourceId) {
        //  initializing the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
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
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentPlace.getNameSpot());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the see TextView
        descriptionTextView.setText(currentPlace.getDescriptionSpot());

        //FInd the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

       if(currentPlace.hasImage()) {
            //Set the ImageView to the image resource specified in the current place
            imageView.setImageResource(currentPlace.getImageResourceId());

            //MAke sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            //Otherwise hide the ImageView(set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}