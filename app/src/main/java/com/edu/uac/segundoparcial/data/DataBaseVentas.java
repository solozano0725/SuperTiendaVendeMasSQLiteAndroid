package com.edu.uac.segundoparcial.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sol Mayra on 01/05/2017.
 */

public class DataBaseVentas extends SQLiteOpenHelper {

    String bd = "CREATE TABLE productos (codigoalmacen INTEGER NOT NULL, "
            +"codigoproducto INTEGER NOT NULL, "
            +"nombre TEXT NOT NULL, "
            +"precio INTEGER NOT NULL,"
            +"PRIMARY KEY(codigoalmacen, codigoproducto));";

    public DataBaseVentas(Context context) {
        super(context, "productos", null, 1);
    }

    public void agregarProducto(int codigoalmacen, int codigoproducto, String nombre, int precio)
    {
        SQLiteDatabase basedatos = this.getWritableDatabase();
        String insert = "INSERT INTO productos (codigoalmacen, codigoproducto, nombre, precio) "
                +"VALUES ("+codigoalmacen+", "+codigoproducto+", '"+nombre+"', "+precio+")";

        basedatos.execSQL(insert);
    }

    public void eliminarProducto(int codigoalmacen, int codigoproducto)
    {
        SQLiteDatabase basedatos = this.getWritableDatabase();
        String delete = "DELETE FROM productos "
                +" WHERE codigoalmacen = "
                +codigoalmacen
                +" AND codigoproducto = "
                +codigoproducto
                +"";

        basedatos.execSQL(delete);
    }

    public void modificarProducto(int codigoalmacen,  int codigoproducto, int precio)
    {
        SQLiteDatabase basedatos = this.getWritableDatabase();
        String update = "UPDATE productos "
                +"SET precio = "
                +precio
                +" WHERE codigoalmacen = "
                +codigoalmacen
                +" AND codigoproducto = "
                +codigoproducto
                +"";

        basedatos.execSQL(update);
    }

    public Cursor buscarProducto_porcodalycodprod(int codigoalmacen, int codigoproducto)
    {
        SQLiteDatabase basedatos = this.getWritableDatabase();
        String search = "SELECT nombre, precio "
                +"FROM productos "
                +"WHERE codigoalmacen = "
                +codigoalmacen
                +" AND codigoproducto = "
                +codigoproducto
                +"";

        Cursor c = basedatos.rawQuery(search, null);
        c.moveToFirst();
        return c;
    }

    public Cursor buscarProducto_porcodigo(int codigoalmacen)
    {
        SQLiteDatabase basedatos = this.getWritableDatabase();
        String search = "SELECT codigoproducto, nombre, precio "
                +"FROM productos "
                +"WHERE codigoalmacen = "
                +codigoalmacen
                +"";

        Cursor c = basedatos.rawQuery(search, null);
        c.moveToFirst();
        return c;
    }

    public Cursor listarpreciosporproducto(int codigoalmacen)
    {
        SQLiteDatabase basedatos = this.getWritableDatabase();
        String show = "SELECT codigoalmacen as _id, codigoproducto, nombre, precio "
                +"FROM productos "
                +"WHERE codigoalmacen = "
                +codigoalmacen
                +"";

        Cursor c = basedatos.rawQuery(show, null);
        c.moveToFirst();
        return c;
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(bd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS productos");
        db.execSQL(bd);
    }


}
