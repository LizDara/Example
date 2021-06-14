package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.codigo_editText)
    EditText codigo_editText;
    @BindView(R.id.codigo_textView)
    TextView codigo_textView;
    @BindView(R.id.numeros_spinner)
    Spinner numeros_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("APARATO");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(20);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        List<String> numeros = new LinkedList<>();
        numeros.add("123 Juan");
        numeros.add("456 Carlos");
        numeros.add("987 Alicia");
        numeros.add("654 Mario");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numeros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numeros_spinner.setAdapter(adapter);
        int position = numeros_spinner.getSelectedItemPosition();
    }

    @OnClick(R.id.mostrar_button)
    public void mostrar(View view) {
        String codigo = codigo_editText.getText().toString();
        codigo_textView.setText(codigo);
    }

    @OnClick(R.id.next_button)
    public void next(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
