package com.example.gescom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**Création d'un objet de tyope DATABASE MANAGER*/

    private DataBaseManager dbm;
    private ListView lvCat;
    private Button btnInsert, btnDelete, btnUpdate, btnReset;
    private EditText txtIdCat, txtLibelleCat;
    private String chaine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initilisation des bouttons
        iniButton();
        // écouteur des BTN
        iniButtonListener();



        dbm = new DataBaseManager(this);
        lvCat = findViewById(R.id.lvCat);
        chaine ="";
        maj();


/*
        dbm.insertCategorie("DVD");
        dbm.insertCategorie("LIVRES");
        dbm.insertCategorie("ROMAN");
        dbm.insertCategorie("VOITURE");
        dbm.insertCategorie("VELO");
        dbm.insertCategorie("TROTINETTE");
        dbm.insertCategorie("TEST");
*/

      // Log.i("ListeCat",""+dbm.getAllCategorie());

        //dbm.deleteCategorie(10);




    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnInsert)) {
            // Toast sert à envoyer une pop-up
            Toast.makeText(this, "insert", Toast.LENGTH_LONG).show();
            String req = txtLibelleCat.getText().toString();
            // appel à la méthode insertCategorie de DataBaseManager
            dbm.insertCategorie(req);
            maj();
        }
        if (v.equals(btnDelete)){
            // Toast sert à envoyer une pop-up
           // Toast.makeText(this, "Supprimer", Toast.LENGTH_LONG).show();

          String del = txtIdCat.getText().toString();
          //Toast.makeText(this, ""+del,Toast.LENGTH_LONG).show();
          dbm.deleteCategorie(Integer.parseInt(del));
           // dbm.deleteCategorie(Integer.parseInt(txtIdCat.getText().toString()));
            txtLibelleCat.setText(chaine);
            txtIdCat.setText(chaine);
          maj();
        }
        if (v.equals(btnUpdate)){
            // Toast sert à envoyer une pop-up
            Toast.makeText(this, "Update", Toast.LENGTH_LONG).show();
            String req = txtLibelleCat.getText().toString();
            String idup = txtIdCat.getText().toString();
            dbm.updateCategorie(req, Integer.parseInt(idup));
            maj();

        }


        if (v.equals(btnReset)){
            // Toast sert à envoyer une pop-up
            Toast.makeText(this, "Reset", Toast.LENGTH_LONG).show();
            txtLibelleCat.setText(chaine);
            txtIdCat.setText(chaine);
        }


    }


    public void iniButton () {

        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnReset = findViewById(R.id.btnReset);

        txtIdCat = findViewById(R.id.txtIdCat);
        txtLibelleCat = findViewById(R.id.txtLibelleCat);
        lvCat = findViewById(R.id.lvCat);

            }
    public void iniButtonListener (){

        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        txtIdCat.setOnClickListener(this);
        txtLibelleCat.setOnClickListener(this);
        lvCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Categorie cat = dbm.getAllCategorie().get(i);
                txtIdCat.setText(""+cat.getIdCat());
                txtLibelleCat.setText(cat.getLibelle());

            }
        });
    }
    public void maj (){
        lvCat.setAdapter(new AdapterCat(this, dbm.getAllCategorie()));
    }



}
