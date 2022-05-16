package com.example.agrophone.Database.Entity;


import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "animationByParticipant",
foreignKeys = {@ForeignKey(entity = Animation.class, parentColumns = "IDAnimation",childColumns = "IDAnimation", onDelete = ForeignKey.CASCADE),
@ForeignKey(entity = Participant.class, parentColumns = "IDParticipant", childColumns = "IDParticipant", onDelete = ForeignKey.CASCADE)})
public class AnimationByParticipant {

}
