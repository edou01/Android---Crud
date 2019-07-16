package com.example.gescom;

public class Categorie {

    private int idCat;
    private String libelle;

    public Categorie() {
    }

    public Categorie(int idCat) {
        this.idCat = idCat;
    }

    public Categorie(int idCat, String libelle) {
        this.idCat = idCat;
        this.libelle = libelle;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "idCat=" + idCat +
                ", libelle='" + libelle + '\'' +
                '}';
    }

}
