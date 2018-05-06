package com.example.android.tourguideapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
public class SeeFragment extends Fragment {


    public SeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.place_list,container, false);

       //create a list of places
        final ArrayList<Place>places = new ArrayList<>();
        places.add(new Place(getString( R.string.bergpark2 ),getString( R.string.bergpark1 ),R.mipmap.land));
        places.add(new Place(getString( R.string.ballhaus2 ),getString( R.string.ballhaus1 ),R.mipmap.house));
        places.add(new Place(getString( R.string.orangerie2 ),getString( R.string.Orangerie1 ),R.mipmap.land));
        places.add(new Place(getString( R.string.löwenburg2 ),getString( R.string.löwenburg1 ),R.mipmap.loewenburg));
        places.add(new Place(getString( R.string.herkules2 ),getString( R.string.herkules1 ),R.mipmap.land));
        places.add(new Place(getString( R.string.schloss2 ),getString( R.string.schloss1 ),R.mipmap.house));

        /**the drawable in the Array is supposed to be a kind of preview image of the spot
         * because I don't have any pictures it needs to be an replacement image
         */
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.purple);

        ListView listView =(ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Start  InfoActivity when clicking on ListItem
        // Set a click listener on that View
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView a , View view, int i, long l){
              //  Intent PlayIntent = new Intent(SeeFragment.this.getActivity(), InfoActivity.class );

               // SeeFragment.this.getActivity().startActivity( PlayIntent );
                Intent PlayIntent = new Intent(SeeFragment.this.getActivity()
                        , InfoActivity.class);
                // Start the new activity
                startActivity(PlayIntent);
            }
        });
        return rootView;
    }
}
