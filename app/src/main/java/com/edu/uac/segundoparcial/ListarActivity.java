package com.edu.uac.segundoparcial;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.edu.uac.segundoparcial.data.DataBaseVentas;


public class ListarActivity extends AppCompatActivity {

    SimpleCursorAdapter adaptador;
    Cursor cur;
    ListView lista;

    DataBaseVentas db = new DataBaseVentas(this);

    EditText editl_codigoalmacen;
    Button btnlistar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        editl_codigoalmacen = (EditText) findViewById(R.id.editl_codigoalmacen);
        btnlistar = (Button) findViewById(R.id.btnlistar);

        btnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listarProducto();
            }
        });

    }

    public void listarProducto(){
        int codigoalmacen = Integer.parseInt(editl_codigoalmacen.getText().toString());

        Cursor c = db.listarpreciosporproducto(codigoalmacen);

        if (c!=null)
        {
            c.moveToFirst();
        }

        db.close();


        String col[] = new String[]{"_id","codigoproducto","nombre","precio"};
        int[] destino = new int[]{R.id.txtcodigoalmacen, R.id.txtcodigoproducto, R.id.txtnombreproducto, R.id.txtvalorproducto};
        cur = c;
        adaptador = new SimpleCursorAdapter(getApplicationContext(),R.layout.layout_item,cur,col,destino,0);
        lista = (ListView) findViewById(R.id.listar);
        adaptador.notifyDataSetChanged();
        lista.setAdapter(adaptador);
    }


}
