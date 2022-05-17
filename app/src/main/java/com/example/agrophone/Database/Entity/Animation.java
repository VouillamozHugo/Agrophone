package com.example.agrophone.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName="animation",
        foreignKeys = {@ForeignKey(entity = Entreprise.class, parentColumns = "IdEntreprise", childColumns = "IdEntreprise", onDelete = ForeignKey.CASCADE)})
public class Animation {

    @PrimaryKey(autoGenerate = true)
    public int idAnimation;

    @ColumnInfo(name ="IdEntreprise")
    public int IdEntreprise;

    @ColumnInfo(name ="Nom")
    public String nomAnimation;

    @ColumnInfo(name ="Type")
    public String typeAnimation;

    @ColumnInfo(name ="NombreMaxParticipants")
    public int nombreMaxParticipants;

    @ColumnInfo(name ="NombreMinParticipants")
    public int nombreMinParticipants;

    @ColumnInfo(name ="NombreActuelParticipant")
    public int nombreActuelParticipant;

    @ColumnInfo(name ="NPA")
    public int npa;

    @ColumnInfo(name ="Lieu")
    public String ville;

    @ColumnInfo(name ="Region")
    public String region;

    @ColumnInfo(name ="Prix")
    public double prix;

    @ColumnInfo(name ="HeureDebut")
    public String heureDebut;

    @ColumnInfo(name ="HeureFin")
    public String heureFin;

    public Animation(){}

    public Animation(int idEntreprise, String nomAnimation, String typeAnimation, int nombreMaxParticipants, int nombreMinParticipants,
                     int nombreActuelParticipant, int npa, String ville, String region, double prix, String heureDebut, String heureFin) {
        this.IdEntreprise = idEntreprise;
        this.nomAnimation = nomAnimation;
        this.typeAnimation = typeAnimation;
        this.nombreMaxParticipants = nombreMaxParticipants;
        this.nombreMinParticipants = nombreMinParticipants;
        this.nombreActuelParticipant = nombreActuelParticipant;
        this.npa = npa;
        this.ville = ville;
        this.region = region;
        this.prix = prix;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIDAnimation() {
        return idAnimation;
    }

    public void setIDAnimation(int IDAnimation) {
        this.idAnimation = IDAnimation;
    }

    public String getNomAnimation() {
        return nomAnimation;
    }

    public void setNomAnimation(String nomAnimation) {
        this.nomAnimation = nomAnimation;
    }

    public String getTypeAnimation() {
        return typeAnimation;
    }

    public void setTypeAnimation(String typeAnimation) {
        this.typeAnimation = typeAnimation;
    }

    public int getNombreMaxParticipants() {
        return nombreMaxParticipants;
    }

    public void setNombreMaxParticipants(int nombreMaxParticipants) {
        this.nombreMaxParticipants = nombreMaxParticipants;
    }

    public int getNombreMinParticipants() {
        return nombreMinParticipants;
    }

    public void setNombreMinParticipants(int nombreMinParticipants) {
        this.nombreMinParticipants = nombreMinParticipants;
    }

    public int getNombreActuelParticipant() {
        return nombreActuelParticipant;
    }

    public void setNombreActuelParticipant(int nombreActuelParticipant) {
        this.nombreActuelParticipant = nombreActuelParticipant;
    }

    public int getNpa() {
        return npa;
    }

    public void setNpa(int npa) {
        this.npa = npa;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public int getIdAnimation() {
        return idAnimation;
    }

    public void setIdAnimation(int idAnimation) {
        this.idAnimation = idAnimation;
    }

    public int getIDEntreprise() {
        return IdEntreprise;
    }

    public void setIDEntreprise(int IDEntreprise) {
        this.IdEntreprise = IDEntreprise;
    }
}
