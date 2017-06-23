package com.edu.uac.segundoparcial;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.uac.segundoparcial.data.DataBaseVentas;

public class EliminarActivity extends AppCompatActivity {
    EditText edte_codigoalmacen, edte_codigoproducto;
    Button btneliminar;

    DataBaseVentas db = new DataBaseVentas(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        edte_codigoalmacen = (EditText) findViewById(R.id.edite_codigoalmacen);
        edte_codigoproducto = (EditText) findViewById(R.id.edite_codigoproducto);

        btneliminar = (Button) findViewById(R.id.btneliminar);

        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               eliminar();
               limpiar();
            }
        });

    }

    public void limpiar(){

        edte_codigoalmacen.setText(null);
        edte_codigoproducto.setText(null);

    }


    public void eliminar(){

        int codigo_almacen = Integer.parseInt(edte_codigoalmacen.getText().toString());
        int codigo_producto = Integer.parseInt(edte_codigoproducto.getText().toString());

        db.eliminarProducto(codigo_almacen,codigo_producto);

        Toast.makeText(getApplicationContext(), "Borrado exitoso!", Toast.LENGTH_SHORT).show();

    }
}
