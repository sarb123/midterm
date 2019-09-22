package com.example.test;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    private ArrayList<datawe> weatherarray;
    private Context montcontext;

    public adapter(ArrayList<datawe> weatherarray, Context montcontext) {
        this.weatherarray = weatherarray;
        this.montcontext = montcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapt, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return weatherarray.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txt_temp, txt_day;

        public ViewHolder(View view) {
            super(view);
            txt_temp = view.findViewById(R.id.txt_temp);
            txt_day = view.findViewById(R.id.txt_day);
            image = view.findViewById(R.id.img_temp);



            itemView.setTag(this);

        }
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        setImage(holder.image, getWeImage(weatherarray.get(position).getWeatherStateAbbr()));
        setText(holder.txt_temp, weatherarray.get(position).getWeatherStateName());
        try {
            holder.txt_day.setText(getDay(weatherarray.get(position).getApplicableDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    public void setText(TextView txtv, String str) {
        txtv.setText(str);
    }

    public String getDay(String day) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(day);
        String days = (String) DateFormat.format("EPEE", date);

        return days;

    }
    public String getWeImage(String data) {
        return "https://www.metaweather.com/static/img/weather/png/" + data + ".png";
    }

    public void setImage(ImageView img, String link) {
        Picasso.get().load(link).into(img);
    }



}