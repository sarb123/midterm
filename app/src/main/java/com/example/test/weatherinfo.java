package com.example.test;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class weatherinfo extends Fragment {

    TextView txt_imgname,txt_weaname,txt_mintemp,txt_maxtemp,txt_actualtemp,txt_humidity,txt_predict;
    FirebaseUser user;
    FirebaseFirestore db;
    ImageView img_weather;
    ArrayList<datawe> weather;
    RecyclerView recyclerView ;

    public weatherinfo() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = getArguments().getParcelable("user");
        db = FirebaseFirestore.getInstance();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_weatherinfo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_imgname = view.findViewById(R.id.name);
        txt_weaname = view.findViewById(R.id.wename);
        img_weather = view.findViewById(R.id.imgwe);
        txt_mintemp = view.findViewById(R.id.tmintemp);
        txt_maxtemp = view.findViewById(R.id.tmaxtemp);
        txt_actualtemp = view.findViewById(R.id.tactemp);

        txt_humidity = view.findViewById(R.id.humidity);
        txt_predict = view.findViewById(R.id.pric);

        recyclerView = view.findViewById(R.id.recycle);



        readFireStore();
        getWeather();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void readFireStore()
    {
        DocumentReference docref = db.collection("users").document(user.getUid());

        docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful())
                {
                    DocumentSnapshot doc = task.getResult();
                    if (doc.exists())
                    {
                        System.out.println(doc.getData());

                        txt_imgname.setText("Welcome "+doc.get("name")+"!");
                    }

                }

            }
        });
    }

    public void getWeather()
    {

        GetDataService service = retrofitclass.getRetrofitInstance().create(GetDataService.class);
        Call<montreal> call = service.getWeather();

        call.enqueue(new Callback<montreal>() {
            @Override
            public void onResponse(Call<montreal> call, Response<montreal> response) {



                montreal montreal = response.body();

                weather = new ArrayList<>(montreal.getDataWe());
                System.out.println("Montreal Array Size :"+weather.size());

                setData(weather);
            }

            @Override
            public void onFailure(Call<montreal> call, Throwable t) {

            }
        });

    }

    public void setData(ArrayList<datawe> weatherarray)
    {
        System.out.println("Array size:"+weatherarray.size());
        txt_weaname.setText(weatherarray.get(0).getWeatherStateName());
        setImage(img_weather,getWeImage(weatherarray.get(0).getWeatherStateAbbr()));
        String mintemp = String.format("%.3f",weatherarray.get(0).getMinTemp());
        String maxtemp = String.format("%.3f",weatherarray.get(0).getMaxTemp());
        String thetemp = String.format("%.3f",weatherarray.get(0).getTheTemp());

        txt_maxtemp.setText(maxtemp);
        txt_actualtemp.setText(thetemp);
        txt_mintemp.setText(mintemp);
        txt_predict.setText("Predictability : "+weatherarray.get(0).getPredictability().toString()+"%");
        txt_humidity.setText("Humidity : "+weatherarray.get(0).getHumidity().toString());


        initView(weatherarray);

    }


    public void initView(ArrayList<datawe> weatherarray)
    {
        weatherarray.remove(0);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);
        adapter adapter = new adapter(weatherarray,getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
    public String getWeImage(String data)
    {
        return "https://www.metaweather.com/static/img/weather/png/"+data+".png";
    }

    public void setImage(ImageView img, String link)
    {
        Picasso.get().load(link).into(img);
    }


}
