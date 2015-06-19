package com.avalladares.interactivestory.model;

import com.avalladares.interactivestory.R;

/**
 * Created by avalladares on 16/06/2015.
 */
public class Story {

    // En esta clase crearemos la historia
    // Creamos un array llamado mPages

    private Page[] mPages;

    // Creamos el constructor, con un array de 7 paginas

    public Story() {
        mPages = new Page[7];

        // En el constructor creamos una nueva página en la posicion [0] con los datos que le pasamos al constructor de páginas

        mPages[0] = new Page(
                R.mipmap.page0,
                R.string.text_story_0,
                new Choice(R.string.choice1_1, 1),
                new Choice(R.string.choice1_2, 2));

        mPages[1] = new Page(
                R.mipmap.page1,
                R.string.text_story_1,
                new Choice(R.string.choice2_1, 3),
                new Choice(R.string.choice2_2, 4));

        mPages[2] = new Page(
                R.mipmap.page2,
                R.string.text_story_2,
                new Choice(R.string.choice3_1, 4),
                new Choice(R.string.choice3_2, 6));

        mPages[3] = new Page(
                R.mipmap.page3,
                R.string.text_story_3,
                new Choice(R.string.choice4_1, 4),
                new Choice(R.string.choice4_2, 5));

        mPages[4] = new Page(
                R.mipmap.page4,
                R.string.text_story_4,
                new Choice(R.string.choice5_1, 5),
                new Choice(R.string.choice5_2, 6));

        mPages[5] = new Page(
                R.mipmap.page5,
                R.string.text_story_5);

        mPages[6] = new Page(
                R.mipmap.page6,
                R.string.text_story_6);

    }

    public Page getPage(int p) {

        return mPages[p];
    }

}

