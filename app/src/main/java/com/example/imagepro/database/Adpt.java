package com.example.imagepro.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagepro.R;

import java.util.ArrayList;

public class Adpt extends RecyclerView.Adapter<Adpt.MyViewHOlder> {
    private Context context ;
    private ArrayList  word , mean  ;

    Adpt(Context context ,ArrayList word,ArrayList mean  ) {
        this.context=context;
        this.word=word;
        this.mean=mean;


    }

    @NonNull
    @Override
    public MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.his,parent,false);
        return  new MyViewHOlder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHOlder holder, int position) {
        holder.word.setText(String.valueOf(word.get(position)));
        holder.mean.setText(String.valueOf(mean.get(position)));


    }

    @Override
    public int getItemCount() {

        return mean.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder {
        TextView mean , word ;
        public MyViewHOlder(@NonNull View itemView) {

            super(itemView);
            mean= itemView.findViewById(R.id.text4);
            word= itemView.findViewById(R.id.text2);


        }
    }
}
