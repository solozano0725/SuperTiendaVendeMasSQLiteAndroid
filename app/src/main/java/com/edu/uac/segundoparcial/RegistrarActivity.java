package com.edu.uac.segundoparcial;

import android.app.LoaderManager;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.uac.segundoparcial.data.DataBaseVentas;

public class RegistrarActivity extends AppCompatActivity{

    EditText edt_codigoalmacen, edt_codigoproducto, edt_nombre, edt_valor;
    Button btnguardar;

    DataBaseVentas db = new DataBaseVentas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edt_codigoalmacen = (EditText) findViewById(R.id.edit_codigoalmacen);
        edt_nombre = (EditText) findViewById(R.id.edit_nombre);
        edt_codigoproducto = (EditText) findViewById(R.id.edit_codigoproducto);
        edt_valor = (EditText) findViewById(R.id.edit_valorprod);

        btnguardar = (Button) findViewById(R.id.btnguardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addproducto();
                limpiar();

            }
        });
    }

    public void addproducto(){
        try{
            int codigo_almacen = Integer.parseInt(edt_codigoalmacen.getText().toString());
            int codigo_producto = Integer.parseInt(edt_codigoproducto.getText().toString());
            String nombre_producto= edt_nombre.getText().toString();
            int valor_producto=Integer.parseInt(edt_valor.getText().toString());

            if(db.buscarProducto_porcodalycodprod(codigo_almacen,codigo_producto).getCount()==0){
                db.agregarProducto(codigo_almacen, codigo_producto, nombre_producto, valor_producto);
                db.close();

                Toast.makeText(getApplicationContext(), getString(R.string.registroexitoso), Toast.LENGTH_SHORT).show();
            } else{

                Toast.makeText(getApplicationContext(), getString(R.string.registrodenegado), Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            System.out.print("Error: "+e.getMessage());
        }


    }

    public void limpiar(){
        edt_codigoalmacen.setText(null);
        edt_nombre.setText(null);
        edt_codigoproducto.setText(null);
        edt_valor.setText(null);
    }
}
