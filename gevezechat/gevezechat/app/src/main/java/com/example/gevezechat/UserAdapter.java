package com.example.gevezechat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    List<String> list;
    Activity activity;

    public UserAdapter(MainActivity mainActivity, List<String> list, MainActivity activity) {
        this.list = list;
    }

    public UserAdapter(Context context) {
        this.context = context;
        this.list = list;
        this.activity = activity;

    }

    public UserAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           holder.textView.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



    TextView textView;
    public ViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.userName);

         }
      }
 }
