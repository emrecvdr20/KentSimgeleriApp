package com.emrecavdar.kentsimgeleriapp;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.emrecavdar.kentsimgeleriapp.databinding.RecyclerRowBinding;
import java.util.ArrayList;
public class LandMarkAdapter extends RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder> {
    ArrayList<Landmark> landmarkArrayList;
    public LandMarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }
    @NonNull
    @Override
    public LandMarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandMarkHolder(recyclerRowBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull LandMarkHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                Singleton singleton=Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivities(new Intent[]{intent});
            }
        });
    }
    @Override
    public int getItemCount() {//xml in kaç kez oluşturulucağını gösterir
        return landmarkArrayList.size();
    }
    public class LandMarkHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;
        public LandMarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
