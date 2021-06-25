package com.example.courtcounter;

public class Word {



    private String mDefaultTranslation;
    private String mMiowkTranslation;
private  int mImageResourseId=NO_IMAGE_PROVIDED;

private static  final int NO_IMAGE_PROVIDED=-1;
private int mAudioResourceId;


    public Word(String defaultTranslation, String miowkTranslation, int audioResourceId){
        mDefaultTranslation=defaultTranslation;
        mMiowkTranslation=miowkTranslation;
        mAudioResourceId=audioResourceId;

    }
    public Word(String defaultTranslation,
                String miowkTranslation,
                int imageResourseId,int audioResourceId){
        mDefaultTranslation=defaultTranslation;
        mMiowkTranslation=miowkTranslation;
        mImageResourseId=imageResourseId;
        mAudioResourceId=audioResourceId;

    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }
    public String getMiowkTranslation()
    {
        return mMiowkTranslation;
    }
public int getmImageResourseId()
{
    return mImageResourseId;
}

public boolean hasImage()
{
return  mImageResourseId!=NO_IMAGE_PROVIDED;
}
public  int getAudioResourceId(){
        return mAudioResourceId;
}


}
