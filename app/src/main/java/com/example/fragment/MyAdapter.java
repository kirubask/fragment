package com.example.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Data>listItems;
    private ItemClickListener mItemClickListener;
    private Context context;

    public MyAdapter(List<Data> listItems,ItemClickListener itemClickListener) {
        this.listItems = listItems;
        this.context = context;
        this.mItemClickListener =itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = listItems.get(position);
    holder.name.setText(data.getName());
    holder.team.setText(data.getTeam());
    holder.itemView.setOnClickListener(View ->{
        mItemClickListener.onItemClick(listItems.get(position));
    });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
     public interface ItemClickListener{
        void onItemClick(Data data);
     }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView team;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            team = itemView.findViewById(R.id.team);
        }
    }
}
