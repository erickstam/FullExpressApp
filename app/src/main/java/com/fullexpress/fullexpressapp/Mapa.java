package com.fullexpress.fullexpressapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        // Coordenadas de San Salvador
        LatLng sanSalvador = new LatLng(13.698889, -89.191389);

        // Mueve la cámara al centro de San Salvador y establece un nivel de zoom adecuado
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sanSalvador, 12)); // Puedes ajustar el nivel de zoom

        // Puedes agregar marcadores, polilíneas, etc., en este punto para personalizar tu mapa.
    }

    public void abrirMenu(View v) {
        Intent intent = new Intent(Mapa.this, Menu.class);

        // Configura la animación de transición compartida
        View menuButton = findViewById(R.id.btn_flotante_menu); // Reemplaza con el ID de tu botón
        String transitionName = "menu_transition"; // Reemplaza con el nombre de la transición
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(Mapa.this, menuButton, transitionName);

        startActivity(intent, options.toBundle());
    }
}