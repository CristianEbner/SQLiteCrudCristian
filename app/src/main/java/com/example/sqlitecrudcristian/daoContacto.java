package com.example.sqlitecrudcristian;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class daoContacto {

    SQLiteDatabase bd;//Instancia de la base de datos

    ArrayList<Contacto>Lista = new ArrayList<Contacto>();//Almacena una lista de objetos de tipo contacto

    Contacto c;//Instancia de la clase contacto

    Context ct;//Contexto de la app

    String nombreBD= "BDContactos";//Nombre de la base de datos

    //Cadena de sentencia sql que crea la tabla  contacto si no existe, define las columnas de las tablas

    String tabla = "create table if not exists contacto(id integer primary ket autoincrement, nombre text, apellido text, email text, telefono text, ciudad text)";

    public daoContacto(Context c){
    //Constructor de la clase, acepta  un parametro de tipo context y utiliza para inicializar la clase
    this.ct=c;
    bd=c.openOrCreateDatabase(nombreBD, Context.MODE_PRIVATE, null);
    bd.execSQL(tabla);
    }

    public boolean insertar(Contacto c){
        //metodo para insertar un nuevo contacto en la base de datos
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("apellido", c.getApellido());
        contenedor.put("email", c.getEmail());
        contenedor.put("telefono", c.getTelefono());
        contenedor.put("ciudad", c.getCiudad());
        return (bd.insert("contacto",null, contenedor))>0;
    }

    public boolean editar(Contacto c){
        //Metodo para actualizar la informacion de un contacto
    }
}
