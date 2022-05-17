package com.example.agrophone.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "entreprise")
public class Entreprise {

    @PrimaryKey(autoGenerate = true)
    public int IdEntreprise;

    @ColumnInfo(name = "Nom")
    public String nomEntreprise;

    @ColumnInfo(name = "Lieu")
    public String lieuEntreprise;

    @ColumnInfo(name = "NPA")
    public int npaEntreprise;

    @ColumnInfo(name = "Region")
    public String regionEntreprise;

    @ColumnInfo(name = "GPS")
    public String gps;


    public Entreprise() {

    }
    public Entreprise( String nomEntreprise, String lieuEntreprise, int npaEntreprise, String regionEntreprise, String gps) {
        this.nomEntreprise = nomEntreprise;
        this.lieuEntreprise = lieuEntreprise;
        this.npaEntreprise = npaEntreprise;
        this.regionEntreprise = regionEntreprise;
        this.gps = gps;
    }

    public int getIdEntrprise() {
        return IdEntreprise;
    }

    public void setIdEntrprise(int idEntrprise) {
        this.IdEntreprise = idEntrprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getLieuEntreprise() {
        return lieuEntreprise;
    }

    public void setLieuEntreprise(String lieuEntreprise) {
        this.lieuEntreprise = lieuEntreprise;
    }

    public int getNpaEntreprise() {
        return npaEntreprise;
    }

    public void setNpaEntreprise(int npaEntreprise) {
        this.npaEntreprise = npaEntreprise;
    }

    public String getRegionEntreprise() {
        return regionEntreprise;
    }

    public void setRegionEntreprise(String regionEntreprise) {
        this.regionEntreprise = regionEntreprise;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }
}
