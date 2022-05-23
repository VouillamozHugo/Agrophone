package com.example.agrophone.ArrayAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.R;
import com.example.agrophone.UI.AnimationListActivity;

import java.util.List;


public class AnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView descriptionAnimation;
        public TextView nameAnimation;
        public TextView lieuAnimation;
        public Button selectAnimation;

        public ViewHolder(View itemView) {
            super(itemView);

            descriptionAnimation = itemView.findViewById(R.id.description_animation);
            lieuAnimation = itemView.findViewById(R.id.animation_lieu_fragment);
            selectAnimation = itemView.findViewById(R.id.selectAnimationFragment);
            nameAnimation = itemView.findViewById(R.id.animation_name_fragment);
        }
    }

    private final List<Animation> animations;
    private AnimationListActivity animationListActivity;

    public AnimationAdapter(List<Animation> animations) {
        this.animations = animations;
    }


    @Override
    public AnimationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.fragment_animations_list, parent, false);
        // Return a new holder instance
        AnimationAdapter.ViewHolder viewHolder = new AnimationAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimationAdapter.ViewHolder holder, int position) {
        Animation animation = animations.get(position);
        holder.descriptionAnimation.setText(animation.getDescription());
        holder.lieuAnimation.setText(animation.getVille());
        holder.nameAnimation.setText(animation.getNomAnimation());
        holder.selectAnimation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                animationListActivity.generateAnimationDetail(String.valueOf(animation.getIDAnimation()));
            }

        });
//        holder
//        holder.row_view.setBackground(holder.allPictures.get(position));
//        holder.ride_location.setText(ride.location);
//        holder.textRide_Description.setText(ride.description);
//        holder.ride_specification.setText("Difficulty :    " + ride.difficulty + "/5" + "     " + "Length :    " + ride.length + " km" + "\nDuration :    " + ride.duration + " h.");
//        holder.buttonSelectCourse.setOnClickListener(new View.OnClickListener() {

    }

    @Override
    public int getItemCount() {
        return animations.size();
    }


    public void setPage(AnimationListActivity animationListActivity){
        this.animationListActivity = animationListActivity;
    }
}
