package com.example.agrophone.ArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.R;
import com.example.agrophone.UI.AnimationListActivity;

import org.w3c.dom.Text;

import java.util.List;

public class UserAnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView descriptionAnimation;
        public TextView nameAnimation;
        public TextView lieuAnimation;

        public ViewHolder(View itemView) {
            super(itemView);

            descriptionAnimation = itemView.findViewById(R.id.userAnimationDescription);
            nameAnimation = itemView.findViewById(R.id.userAnimationName);
            lieuAnimation = itemView.findViewById(R.id.userAnimationLieu);
        }
    }



    private final List<Animation> animations;
   // private AnimationListActivity animationListActivity;

    public UserAnimationAdapter(List<Animation> animations) {
        this.animations = animations;
    }


    @Override
    public AnimationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.fragment_user_animation_list, parent, false);
        // Return a new holder instance
        AnimationAdapter.ViewHolder viewHolder = new AnimationAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimationAdapter.ViewHolder holder, int position) {
        Animation animation = animations.get(position);
        holder.descriptionAnimation.setText(animation.getDescription());
        holder.nameAnimation.setText(animation.getNomAnimation());
        holder.lieuAnimation.setText(animation.getVille());
    }

    @Override
    public int getItemCount() {
        return animations.size();
    }

}
