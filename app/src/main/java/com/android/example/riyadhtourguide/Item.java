package com.android.example.riyadhtourguide;

/**
 * Created by MOHANAAD on 3/25/17.
 */

public class Item {

    private int mPlaceNameId;

    private int mPlaceInformationId;

    private int mImageResurseId = NO_IMAGE_PROVIDED;

    private int mSoundResourseId = NO_SOUND_PROVIDED;

    private int mSoundImageResourseId = R.id.voice_image;

    private static final int NO_IMAGE_PROVIDED = -1;

    private static final int NO_SOUND_PROVIDED = -1;

    public Item(int placeNameId, int placeInformationId, int imageResourseId) {
        mPlaceNameId = placeNameId;
        mPlaceInformationId = placeInformationId;
        mImageResurseId = imageResourseId;
    }


    public Item(int placNameId, int placeInformaionId, int imageResurseId, int soundResourseId, int soundImageResourseId) {
        mPlaceNameId = placNameId;
        mPlaceInformationId = placeInformaionId;
        mImageResurseId = imageResurseId;
        mSoundResourseId = soundResourseId;
        mSoundImageResourseId = soundImageResourseId;
    }

    public int getPlaceName() {
        return mPlaceNameId;
    }

    public int getPlaceInformation() {
        return mPlaceInformationId;
    }

    public int getImageResurseId() {
        return mImageResurseId;
    }

    public int getSoundImageResourseId() {
        return mSoundImageResourseId;
    }

    public int getSoundResourseId() {
        return mSoundResourseId;
    }

    public boolean hasImage() {
        return mImageResurseId != NO_IMAGE_PROVIDED;
    }

    public boolean hasSound() {
        return mSoundResourseId != NO_SOUND_PROVIDED;
    }
}
