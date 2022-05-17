package com.example.agrophone.Database.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "animationByParticipant",
foreignKeys = {@ForeignKey(entity = Animation.class, parentColumns = "IDAnimation",childColumns = "IDAnimation", onDelete = ForeignKey.CASCADE),
@ForeignKey(entity = Participant.class, parentColumns = "IDParticipant", childColumns = "IDParticipant", onDelete = ForeignKey.CASCADE)})
public class AnimationByParticipant {


    @PrimaryKey(autoGenerate = false)
    public int idAnimation;

    @PrimaryKey(autoGenerate = false)
    public int idParticipant;

    public AnimationByParticipant(int idAnimation, int idParticipant) {
        this.idAnimation = idAnimation;
        this.idParticipant = idParticipant;
    }


    public int getIdAnimation() {
        return idAnimation;
    }

    public void setIdAnimation(int idAnimation) {
        this.idAnimation = idAnimation;
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }
}
