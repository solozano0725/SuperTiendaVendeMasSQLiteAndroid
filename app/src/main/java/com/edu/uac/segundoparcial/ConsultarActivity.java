package com.edu.uac.segundoparcial;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.uac.segundoparcial.data.DataBaseVentas;


public class ConsultarActivity extends AppCompatActivity {

    EditText edtb_codigoalmacen, edtb_codigoproducto;
    TextView txtnombreproducto, txtvalorproducto, txtcodigoalmacen, txtcodigoproducto;
    Button btnbuscar;

    DataBaseVentas db = new DataBaseVentas(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        edtb_codigoalmacen = (EditText) findViewById(R.id.editb_codigoalmacen);
        edtb_codigoproducto = (EditText) findViewById(R.id.editb_codigoproducto);

        txtnombreproducto = (TextView) findViewById(R.id.txtnombreproducto);
        txtvalorproducto = (TextView) findViewById(R.id.txtvalorproducto);
        txtcodigoproducto = (TextView) findViewById(R.id.txtcodigoproducto);
        txtcodigoalmacen = (TextView) findViewById(R.id.txtcodigoalmacen);
        btnbuscar = (Button) findViewById(R.id.btnbuscar);

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buscar();
                limpiar();

            }
        });

    }

    public void buscar(){

            int codigo_almacen = Integer.parseInt(edtb_codigoalmacen.getText().toString());
            int codigo_producto = Integer.parseInt(edtb_codigoproducto.getText().toString());

            Cursor c = db.buscarProducto_porcodalycodprod(codigo_almacen,codigo_producto);

            if(c.moveToFirst()){
                txtnombreproducto.setText(c.getString(0));
                txtvalorproducto.setText(String.valueOf(c.getInt(1)));
                txtcodigoalmacen.setText(edtb_codigoalmacen.getText().toString());
                txtcodigoproducto.setText(edtb_codigoproducto.getText().toString());
                Toast.makeText(getApplicationContext(), "Busqueda exitosa.", Toast.LENGTH_SHORT).show();
            } else{

                Toast.makeText(getApplicationContext(), "No se encuentra producto.", Toast.LENGTH_SHORT).show();

            }

    }

    public void limpiar(){
        edtb_codigoalmacen.setText(null);
        edtb_codigoproducto.setText(null);

    }
}
