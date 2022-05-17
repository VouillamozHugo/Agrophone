package com.example.agrophone.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "participant")
public class Participant {


    @PrimaryKey(autoGenerate = true)
    public int idParticipant;

    @ColumnInfo(name="Nom")
    public String nomParticipant;

    @ColumnInfo(name="Prenom")
    public String prenomParticipant;

    @ColumnInfo(name="Email")
    public String email;

    @ColumnInfo(name="Password")
    public String password;

    @ColumnInfo(name="NoTelephone")
    public String noTelephone;

    @ColumnInfo(name="Addresse")
    public String addresse;

    @ColumnInfo(name="LieuParticipant")
    public String lieuParticipant;

    @ColumnInfo(name="NPAParticipant")
    public String npaParticipant;

    @ColumnInfo(name="RegionParticipant")
    public String regionParticipant;

    @ColumnInfo(name="Pays")
    public String pays;


    public Participant(int idParticipant, String nomParticipant, String prenomParticipant, String email, String password, String noTelephone, String addresse, String lieuParticipant, String npaParticipant, String regionParticipant, String pays) {
        this.idParticipant = idParticipant;
        this.nomParticipant = nomParticipant;
        this.prenomParticipant = prenomParticipant;
        this.email = email;
        this.password = password;
        this.noTelephone = noTelephone;
        this.addresse = addresse;
        this.lieuParticipant = lieuParticipant;
        this.npaParticipant = npaParticipant;
        this.regionParticipant = regionParticipant;
        this.pays = pays;
    }


    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getNomParticipant() {
        return nomParticipant;
    }

    public void setNomParticipant(String nomParticipant) {
        this.nomParticipant = nomParticipant;
    }

    public String getPrenomParticipant() {
        return prenomParticipant;
    }

    public void setPrenomParticipant(String prenomParticipant) {
        this.prenomParticipant = prenomParticipant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoTelephone() {
        return noTelephone;
    }

    public void setNoTelephone(String noTelephone) {
        this.noTelephone = noTelephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getLieuParticipant() {
        return lieuParticipant;
    }

    public void setLieuParticipant(String lieuParticipant) {
        this.lieuParticipant = lieuParticipant;
    }

    public String getNpaParticipant() {
        return npaParticipant;
    }

    public void setNpaParticipant(String npaParticipant) {
        this.npaParticipant = npaParticipant;
    }

    public String getRegionParticipant() {
        return regionParticipant;
    }

    public void setRegionParticipant(String regionParticipant) {
        this.regionParticipant = regionParticipant;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
