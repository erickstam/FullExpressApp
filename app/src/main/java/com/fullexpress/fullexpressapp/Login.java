package com.fullexpress.fullexpressapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fullexpress.fullexpressapp.databinding.LoginBinding;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {
    private LoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Button btnLogin = binding.btnIngresar;
        Button login = (Button)findViewById(R.id.btn_ingresar);
        EditText usuario = (EditText)findViewById(R.id.edt_usuario);
        EditText pass = (EditText)findViewById(R.id.edt_pass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuarios = usuario.getText().toString().trim();
                String clave = pass.getText().toString().trim();

                if (usuarios.equals("") || clave.equals("")) {
                    // Mostrar un mensaje de error si los campos están vacíos
                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog.setTitleText("Oops...");
                    sweetAlertDialog.setContentText("Usuario y/o Contraseña son incorrectos.");
                    sweetAlertDialog.show();
                } else if (usuarios.equals("name") && clave.equals("123")) {
                    // Mostrar un mensaje de carga
                    SweetAlertDialog pDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.PROGRESS_TYPE);
                    pDialog.setTitleText("Ingresando");
                    pDialog.setCancelable(false);
                    pDialog.show();

                    // Simular una pausa para mostrar el mensaje de éxito después de un tiempo
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Cerrar el mensaje de carga
                            pDialog.dismiss();

                            // Mostrar el mensaje de éxito
                            SweetAlertDialog successDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.SUCCESS_TYPE);
                            successDialog.setTitleText("Éxito");
                            successDialog.setContentText("Usuario y contraseña correctos.");
                            successDialog.show();

                            Intent intent = new Intent(Login.this, Mapa.class);
                            startActivity(intent);
                        }
                    }, 2000); // Cambia el tiempo (en milisegundos) según tus necesidades
                } else {
                    // Mostrar un mensaje de error si los datos no son correctos
                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog.setTitleText("Oops...");
                    sweetAlertDialog.setContentText("Usuario y/o Contraseña son incorrectos.");
                    sweetAlertDialog.show();
                }

            }
        });
    }

    public void Registro(View v) {
        // Crear un Intent para abrir la SegundaActividad
        Intent registro = new Intent(Login.this, Registro.class);
        startActivity(registro);
    }
}