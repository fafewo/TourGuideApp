package com.example.android.tourguideapp;

/**
 * {@link Place} is a spot to visit at a location the user may want to visit
 * it contains the name of the place and a line of Information
 */
public class Place {

    /**description of the spot*/
    private String mDescriptionSpot;
    /**name of the spot*/
    private String mNameSpot;
    /**image resource ID for the word*/
    private int mImageResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * create a new Place Object
     *
     * @param descriptionSpot ist the the description in a few words for a specific place
     * @param nameSpot is the name of the place
     * @param imageResourceId the drwable resource ID for the image associated
     */

    public Place(String descriptionSpot, String nameSpot, int imageResourceId) {
        mDescriptionSpot = descriptionSpot;
        mNameSpot = nameSpot;
        mImageResourceId = imageResourceId;
    }


    /**REturn the image resource ID of the word*/
    public int getImageResourceId(){
        return mImageResourceId;
    }
    /**
     * Get the  description of the spot
     */
    public String getDescriptionSpot(){return mDescriptionSpot;
    }

    /**
     * get the name of the spot
     */
    public String getNameSpot(){return mNameSpot;
    }
    /**
     * Returns  whether or not there is an image for this word.
     *
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
