package com.edu.uac.segundoparcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.uac.segundoparcial.data.DataBaseVentas;

public class ModificarActivity extends AppCompatActivity {

    EditText edt_codigoalmacen, edt_codigoproducto, edt_valor;
    Button btnmodificar;

    DataBaseVentas db = new DataBaseVentas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        edt_codigoalmacen = (EditText) findViewById(R.id.editm_codigoalmacen);
        edt_codigoproducto = (EditText) findViewById(R.id.editm_codigoproducto);
        edt_valor = (EditText) findViewById(R.id.editm_valorprod);

        btnmodificar = (Button) findViewById(R.id.btnmodificar);

        btnmodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int codigo_almacen = Integer.parseInt(edt_codigoalmacen.getText().toString());
                int codigo_producto = Integer.parseInt(edt_codigoproducto.getText().toString());
                int valor_producto = Integer.parseInt(edt_valor.getText().toString());

                db.modificarProducto(codigo_almacen,codigo_producto,valor_producto);

                edt_codigoalmacen.setText(null);
                edt_codigoproducto.setText(null);
                edt_valor.setText(null);

                Toast.makeText(getApplicationContext(), getString(R.string.cambioexitoso), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
