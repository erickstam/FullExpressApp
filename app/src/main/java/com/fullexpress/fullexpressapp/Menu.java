package com.fullexpress.fullexpressapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.view.Gravity;
import android.view.Window;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Habilita las transiciones de escena antes de cargar el contenido de la ventana
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        // Configura la animación de entrada Explode
        Explode explodeTransition = new Explode();
        explodeTransition.setDuration(100); // Establece la duración de la animación (en milisegundos)
        explodeTransition.excludeTarget(android.R.id.statusBarBackground, true); // Excluye la barra de estado
        explodeTransition.excludeTarget(android.R.id.navigationBarBackground, true); // Excluye la barra de navegación
        explodeTransition.setMode(Explode.MODE_IN);
        getWindow().setGravity(Gravity.TOP | Gravity.START);
        getWindow().setEnterTransition(explodeTransition);

        setContentView(R.layout.menu);
    }
}