package com.example.android.miwok;

/**
 * Contains the default translaion and the Miwok translation related to the default word
 * Created by jermainegoins on 7/8/17.
 */

public class Word {

    // Default translation for the word
    private String mDefaultTranslation;

    // Miwok translation for the word
    private String mMiwokTranslation;

    // Image resource ID for the word
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    // Set Image resource ID to -1 when an image is not necessary
    private static final int NO_IMAGE_PROVIDED = -1;

    // Audio resource ID associated with word or phrase
    private int mAudioResourceID;

    /*
        Create a new Word object

        @param defaultTranslation is the word in the language that the user is using (english)

        @param miwokTranslation is the word in the Miwok language

        @param imageResourceId is the drawable resource ID for the image asset

        @param audioResourceId is the drawable resource ID for the image asset

     */

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mAudioResourceID) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceID = mAudioResourceID;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceID, int mAudioResourceID) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceID = mImageResourceID;
        this.mAudioResourceID = mAudioResourceID;
    }

    // Default translation for the word
    public String getmDefaultTranslation() {

        return mDefaultTranslation;
    }

    // Miwok translation for the word
    public String getmMiwokTranslation() {

        return mMiwokTranslation;
    }

    // Image resource ID for the word
    public int getImageResourceID(){

        return mImageResourceID;
    }

    // Audio resource ID for the word
    public int getmAudioResourceID() {
        return mAudioResourceID;
    }

    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
