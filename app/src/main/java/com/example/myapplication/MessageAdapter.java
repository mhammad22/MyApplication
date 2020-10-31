package com.example.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    //View Holder Number 1
    public class MessageViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;
        TextView tme;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.ImgPerson);
            txt = (TextView) itemView.findViewById(R.id.TextPerson);
            tme = (TextView) itemView.findViewById(R.id.text_message_time_p);
        }

        public TextView getLabel1() {
            return txt;
        }

        public void setLabel1(TextView label1) {
            this.txt = label1;
        }

        public TextView getLabel3() {
            return tme;
        }

        public void setLabel3(TextView label3) {
            this.tme = label3;
        }

        public ImageView getLabel2() {
            return img;
        }

        public void setLabel2(ImageView label2) {
            this.img = label2;
        }

        private void configureViewHolder2(MessageViewHolder vh2, int position) {
            String st = (String) msg.get(position);
            if (st != null) {
                vh2.getLabel1().setText(st);
                vh2.getLabel3().setText(java.text.DateFormat.getTimeInstance().format(new Date()));
            }
        }

    }

    //View Holder Number 2
    public class MeViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;
        TextView tm;

        public MeViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.Imgme);
            txt = (TextView) itemView.findViewById(R.id.Textme);
            tm = (TextView) itemView.findViewById(R.id.text_message_time_me);
        }

        public TextView getLabel1() {
            return txt;
        }

        public void setLabel1(TextView label1) {
            this.txt = label1;
        }

        public ImageView getLabel2() {
            return img;
        }

        public void setLabel2(ImageView label2) {
            this.img = label2;
        }

        public TextView getLabel3() {
            return tm;
        }

        public void setLabel3(TextView label3) {
            this.tm = label3;
        }

        private void configureViewHolder1(MeViewHolder vh1, int position) {
            String st = (String) msg.get(position);
            if (st != null) {
                vh1.getLabel1().setText(st);
                vh1.getLabel3().setText(java.text.DateFormat.getTimeInstance().format(new Date()));
            }
        }

    }


    List<String> msg = new ArrayList<>();


    public MessageAdapter(List<String> obj) {
        this.msg = obj;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewgroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewgroup.getContext());

        switch (viewType) {
            case 0:
                View v1 = inflater.inflate(R.layout.layout_me, viewgroup, false);
                viewHolder = new MeViewHolder(v1);
                break;

            case 1:
                View v2 = inflater.inflate(R.layout.layout_person, viewgroup, false);
                viewHolder = new MessageViewHolder(v2);
                break;

            default:
                viewHolder = new MeViewHolder(inflater.inflate(R.layout.layout_me, viewgroup, false));
                break;
        }
        return viewHolder;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case 0:
                MeViewHolder vh1 = (MeViewHolder) viewHolder;
                vh1.configureViewHolder1(vh1, position);
                break;
            case 1:
                MessageViewHolder vh2 = (MessageViewHolder) viewHolder;
                vh2.configureViewHolder2(vh2, position);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return msg.size();
    }


}
