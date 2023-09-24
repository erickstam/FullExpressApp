package com.fullexpress.fullexpressapp;

import static com.fullexpress.fullexpressapp.R.id.edtFechaNacimiento;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.fullexpress.fullexpressapp.R;

import java.util.Calendar;

public class Registro extends AppCompatActivity {

    private EditText edtFechaNacimiento;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento);

        // Agregar un OnClickListener para mostrar el DatePicker al hacer clic en el EditText
        edtFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatePicker();
            }
        });
    }

    private void mostrarDatePicker() {
        final Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // La fecha seleccionada se muestra en el EditText
                        String fechaSeleccionada = dayOfMonth + " / " + (monthOfYear + 1) + " / " + year;
                        edtFechaNacimiento.setText(fechaSeleccionada);
                    }
                }, anio, mes, dia);

        datePickerDialog.show();
    }
}
