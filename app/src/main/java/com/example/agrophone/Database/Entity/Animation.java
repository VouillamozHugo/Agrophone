package com.example.agrophone.Database.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName="animation",
        foreignKeys = {@ForeignKey(entity = Entreprise.class, parentColumns = "IDEntreprise", childColumns = "IDEntreprise", onDelete = ForeignKey.CASCADE)})
public class Animation {

}
