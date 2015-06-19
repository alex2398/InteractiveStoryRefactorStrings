package com.avalladares.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.avalladares.interactivestory.R;


public class MainActivity extends ActionBarActivity {

    // Creamos las dos variables para el editText y el Button

    private EditText mNameText;
    private Button mStartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos las dos variables

        mNameText = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        // Creamos el listener para el boton Start

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameText.getText().toString();
                startStory(name);
            }
        };

        // Asociamos el listener al click en el boton Start

        mStartButton.setOnClickListener(listener);
    }

    /*
        Metodo startStory() para crear en intent que abre la nueva activity StoryActivity
        lo creamos con el parametro que queremos pasar a la siguiente actividad
        con el intent
    */
    private void startStory(String name) {

        // Creamos el intent, con el �mbito y la clase a la que se llamar� (activity)

        Intent intent = new Intent(this, StoryActivity.class);

        /*  Le añadimos un parametro al intent
            En un principio el valor es "name", pero despues lo cambiamos por el string resource
            que hemos creado en strings.xml
        */

        intent.putExtra(getString(R.string.key_name),name);

        // Llamamos a la actividad con el intent creado

        startActivity(intent);
    }

    // Este método se usa para controlar lo que pasa cuando se vuelve a esta activity

    @Override
    protected void onResume() {
        super.onResume();

        // En este caso limpiamos el campo nombre

        mNameText.setText("");
    }
}
