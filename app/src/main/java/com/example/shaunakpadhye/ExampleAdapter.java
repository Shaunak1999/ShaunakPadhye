package com.example.shaunakpadhye;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ExampleItem> mExampleList;
    private static final int TYPE_LEFT = 0;
    private static final int TYPE_RIGHT = 1;
    private static final int TYPE_CENTER = 2;

    public static class LeftViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.textView1);
        }
    }

    public static class RightViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView1);
        }
    }

    public static class CenterViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public CenterViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView1);
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        if(viewType == TYPE_LEFT) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_left,parent,false);
            return new LeftViewHolder(v);
        }
        else if(viewType == TYPE_RIGHT){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_right,parent,false);
            return new RightViewHolder(v);
        }
        else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_center,parent,false);
            return new CenterViewHolder(v);
        }

    }

    @Override
    public int getItemViewType(int position) {
        ExampleItem currentItem = mExampleList.get(position);
        int a = currentItem.getAlign();
        if(a==0)
            return TYPE_LEFT;
        else if(a==1)
            return  TYPE_RIGHT;
        else
            return TYPE_CENTER;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        switch (holder.getItemViewType()) {
            case TYPE_LEFT:
                LeftViewHolder leftViewHolder = (LeftViewHolder)holder;
                leftViewHolder.mTextView.setText(currentItem.getText());
                break;

            case TYPE_RIGHT:
                RightViewHolder rightViewHolder = (RightViewHolder)holder;
                rightViewHolder.mTextView.setText(currentItem.getText());
                break;

            case TYPE_CENTER:
                CenterViewHolder centerViewHolder = (CenterViewHolder)holder;
                centerViewHolder.mTextView.setText(currentItem.getText());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
