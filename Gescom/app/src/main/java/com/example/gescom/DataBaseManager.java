package com.example.gescom;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManager extends SQLiteOpenHelper {


    /*  Création de la base de données qui aura le nom de gescom*/
    private static final String DATABASE_NAME = "gescom";
    private static final int DATABASE_VERSION= 1;

    /*  */
    public DataBaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String requete = "create table categorie(idCat integer primary key autoincrement, libelle text not null)";

    db.execSQL(requete);

        Log.i("DB", "Création Ok");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion , int newVersion) {
        Log.i("DB", "OnUpgrade");
    }

    public void insertCategorie (String libelle){
        String req = "INSERT INTO categorie (libelle) values('"+libelle+"')";
        this.getReadableDatabase().execSQL(req);

        Log.i("DB", "Insert Ok");
    }


    public void deleteCategorie (int idCat){

     String req = "DELETE FROM categorie  WHERE idCat = '"+idCat+"'";
     this.getReadableDatabase().execSQL(req);

     Log.i("DB", "Delete Ok");
    }

    public void updateCategorie (String libelle, int idCat){
        String req = "UPDATE categorie SET libelle = '"+libelle+"' WHERE idCat = '"+idCat+"'" ;
        this.getReadableDatabase().execSQL(req);

        Log.i("DB", "Update Ok");

    }

    public List<Categorie> getAllCategorie(){
        List<Categorie> listeCat = new ArrayList<>();
        String req = "SELECT * FROM categorie";
        Cursor cursor = this.getReadableDatabase().rawQuery(req, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Categorie cat = new Categorie(cursor.getInt(0), cursor.getString(1));
            listeCat.add(cat);
            cursor.moveToNext();
        }
        cursor.close();
        return listeCat;
    }
/*
    public void updateCategorie (int idCat, String Libelle){
    String req = "SELECT idCat, libelle FROM categorie WHERE idCat = 2"
    }
    public Categorie getOneCategorie(int idCat) {
        Categorie cat = null;

    }


*/





    }

