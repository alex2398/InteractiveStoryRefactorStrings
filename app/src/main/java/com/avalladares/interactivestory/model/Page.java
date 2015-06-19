package com.avalladares.interactivestory.model;

/**
 * Created by avalladares on 16/06/2015.
 */
public class Page {

    /*
        Nombramos a estas variables con m delante por "Method variable"
        Creamos una variable para almacenar el id (int) de la imagen.
        Como es habitual en java, las hacemos privadas y serán accesibles
        a través de métodos (get, set ...)
    */

    private int mImageId;
    private int mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private Boolean mIsFinal = false;

    // Constructor
    // Asignamos la imagen, el texto que aparecerá y las dos opciones que tendrá el usuario

    public Page(int imageId, int text, Choice choice1, Choice choice2){
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;

    }

    public Page(int imageId, int text){
        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;

    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public int getImageId() {
        return mImageId;
    }

    public Boolean getIsFinal() {

        return mIsFinal;
    }

    public void setIsFinal(Boolean isFinal) {
        mIsFinal = isFinal;
    }


    public int getText() {
        return mText;
    }

    public void setText(int text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
}
