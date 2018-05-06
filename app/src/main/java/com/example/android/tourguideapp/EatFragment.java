package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EatFragment extends Fragment {


    public EatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //create a list of places
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString( R.string.sanmarino2 ), getString( R.string.sanmarino1 ),R.drawable.bizza));
        places.add(new Place(getString( R.string.nachbar2 ), getString( R.string.nachbar1 ), R.mipmap.food));
        places.add(new Place(getString( R.string.fez2 ), getString( R.string.fez1 ), R.mipmap.bar));
        places.add(new Place(getString( R.string.toast2 ), getString( R.string.toast1 ), R.mipmap.food));

        /**the drawable in the Array is supposed to be a kind of preview image of the spot
         * because I don't have any pictures it needs to be an replacement image
         */

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.blue);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        // Start  InfoActivity when clicking on ListItem
        // Set a click listener on that View
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView a , View view, int i, long l){
                //  Intent PlayIntent = new Intent(SeeFragment.this.getActivity(), InfoActivity.class );

                // SeeFragment.this.getActivity().startActivity( PlayIntent );
                Intent PlayIntent = new Intent(EatFragment.this.getActivity()
                        , InfoActivity.class);
                // Start the new activity
                startActivity(PlayIntent);
            }
        });
        return rootView;
    }
}


