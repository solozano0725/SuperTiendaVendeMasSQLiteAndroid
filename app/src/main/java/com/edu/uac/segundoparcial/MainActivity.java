package com.edu.uac.segundoparcial;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_registrar, btn_modificar, btn_consultar, btn_listar, btn_acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_registrar  = (Button) findViewById(R.id.btn_registrar);
        btn_modificar = (Button) findViewById(R.id.btn_modificar);
        btn_consultar = (Button) findViewById(R.id.btn_consultar);
        btn_listar = (Button) findViewById(R.id.btn_listar);
        btn_acerca = (Button) findViewById(R.id.btn_acerca);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirActivity(RegistrarActivity.class);
            }
        });

        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirActivity(ModificarActivity.class);
            }
        });

        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirActivity(ConsultarActivity.class);
            }
        });

        btn_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirActivity(ListarActivity.class);
            }
        });

        btn_acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirActivity(AcercaActivity.class);
            }
        });


    }

    public void AbrirActivity(Class activity)
    {
        Intent i=new Intent(this, activity);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.opcion_eliminar_producto:
                try{
                    AbrirActivity(EliminarActivity.class);
                }catch (Exception e){
                    System.out.print("Error: "+e.getMessage());
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
