package com.example.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wecare.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList date_id;
    private ArrayList time_id;

    public MyAdapter(Context context, ArrayList date_id, ArrayList time_id) {
        this.context = context;
        this.date_id = date_id;
        this.time_id = time_id;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.date_id.setText(String.valueOf(date_id.get(position)));
        holder.time_id.setText(String.valueOf(time_id.get(position)));
    }
    @Override
    public int getItemCount()
    {
        return date_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date_id, time_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date_id = itemView.findViewById(R.id.textDate);
            time_id = itemView.findViewById(R.id.textTime);

        }
    }
}
