package com.avalladares.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avalladares.interactivestory.R;
import com.avalladares.interactivestory.model.Page;
import com.avalladares.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();

    // Al igual que en la otra actividad, creamos las variables para almacenar las vistas

    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null) {
            mName = getString(R.string.null_name);
        }
        Log.d(TAG, mName);

        // Asignamos las vistas a las variables

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        // Cargamos la página inicial

        loadPage(0);
    }

    // Método loadPage que carga la página pasada por parametro
    private void loadPage(int pageLoad) {

        mCurrentPage = mStory.getPage(pageLoad);

        // Obtenemos la imagen desde el id en un objeto Drawable y la asignamos a la vista.

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), mCurrentPage.getImageId(), null);
        mImageView.setImageDrawable(drawable);

        // Obtenemos el texto de la pagina

        String pageText = getString(mCurrentPage.getText());

        // Sustituimos la cadena por el nombre que ha introducido el usuario

        pageText = String.format(pageText, mName);

        // Asignamos el texto modificado a la vista

        mTextView.setText(pageText);

        // Para los botones, obtenemos el texto de las opciones que tiene la pagina 0

        // Comprobamos si la variable getIsFinal es true (final del juego)

        if (mCurrentPage.getIsFinal()) {

            // Hacemos invisible el primer botón

            mChoice1.setVisibility(View.INVISIBLE);
            // Cambiamos el texto del segundo botón y creamos un evento en clic

            mChoice2.setText(getString(R.string.end_button));
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // De esta forma se termina esta actividad y se retorna a la actividad que la llamó

                    finish();
                }
            });


        } else {

            // Si no es el final obtenemos el texto de los dos botones

            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            /*
                Creamos los listener para los dos botones
                En esta ocasión los creamos de una vez, con una función anónima
                en lugar de crear el listener por un lado y asignarlo al clic del botón
            */

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Obtenemos cual es la siguiente página y la mostramos

                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);

                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Obtenemos cual es la siguiente página y la mostramos

                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);

                }
            });
        }
    }
}
