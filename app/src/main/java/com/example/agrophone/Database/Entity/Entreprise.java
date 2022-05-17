package com.example.agrophone.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "entreprise")
public class Entreprise {

    @PrimaryKey(autoGenerate = true)
    public int idEntrprise;

    @ColumnInfo(name = "Nom")
    public String nomEntreprise;

    @ColumnInfo(name = "Lieu")
    public String lieuEntreprise;

    @ColumnInfo(name = "NPA")
    public String npaEntreprise;

    @ColumnInfo(name = "Region")
    public String regionEntreprise;

    @ColumnInfo(name = "GPS")
    public String gps;

    public Entreprise(int idEntrprise, String nomEntreprise, String lieuEntreprise, String npaEntreprise, String regionEntreprise, String gps) {
        this.idEntrprise = idEntrprise;
        this.nomEntreprise = nomEntreprise;
        this.lieuEntreprise = lieuEntreprise;
        this.npaEntreprise = npaEntreprise;
        this.regionEntreprise = regionEntreprise;
        this.gps = gps;
    }

    public int getIdEntrprise() {
        return idEntrprise;
    }

    public void setIdEntrprise(int idEntrprise) {
        this.idEntrprise = idEntrprise;
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

    public String getNpaEntreprise() {
        return npaEntreprise;
    }

    public void setNpaEntreprise(String npaEntreprise) {
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
