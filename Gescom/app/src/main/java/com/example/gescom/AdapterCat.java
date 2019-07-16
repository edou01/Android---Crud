package com.example.gescom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/*** Adapter fait le lien entre la vue et l'interface**/

public class AdapterCat extends BaseAdapter {

    private Context context;
    private List<Categorie> listeCat;

    /*LayoutInflater = classe sert a injecter les ressoursces dans notre vue*/
    private LayoutInflater inflater;


    public AdapterCat(Context context, List<Categorie> listeCat) {
        this.context = context;
        this.listeCat = listeCat;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        /**Affiche toute les categories dans une liste**/
        return  this.listeCat.size();
    }

    @Override
    public Categorie getItem(int position) {
        return this.listeCat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.layout_cat,null);

        Categorie cat  = getItem(position);

        TextView txtIdCat =convertView.findViewById(R.id.txtIdCat);
        txtIdCat.setText(""+cat.getIdCat());

        TextView txtLibelle = convertView.findViewById(R.id.txtLibelle);
        txtLibelle.setText(""+cat.getLibelle());



        return convertView;
    }
}
