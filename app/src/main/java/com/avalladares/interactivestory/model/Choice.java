package com.avalladares.interactivestory.model;

import com.avalladares.interactivestory.R;

/**
 * Created by avalladares on 16/06/2015.
 */
public class Choice {

    private int mText_id;
    private int mNextPage;

    // Constructor
    // Asignamos el texto del botón y la página a la que irá al pulsarlo

    public Choice(int text, int nextPage){
        mText_id = text;
        mNextPage = nextPage;
    }


    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }

    public int getText() {
        return mText_id;
    }

    public void setText(int text) {
        mText_id = text;
    }
}
