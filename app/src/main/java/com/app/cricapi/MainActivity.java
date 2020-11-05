package com.app.cricapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.cricapi.adapter.MatchAdapter;
import com.app.cricapi.model.Match;
import com.app.cricapi.model.Root;
import com.app.cricapi.services.CricApiServices;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnGetNewMatches;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        btnGetNewMatches=findViewById(R.id.btnGetNewMatches);

        btnGetNewMatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Getting data...", Toast.LENGTH_SHORT).show();

                retrofit=new Retrofit.Builder()
                        .baseUrl("https://cricapi.com/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                CricApiServices apiServices=retrofit.create(CricApiServices.class);

                Call<Root> call=apiServices.getNewMatches();

                call.enqueue(new Callback<Root>() {
                    @Override
                    public void onResponse(Call<Root> call, Response<Root> response) {
                        if(response.isSuccessful()){
                            Root root=response.body();
                            List<Match> matchList=root.getMatches();

                            MatchAdapter matchAdapter=new MatchAdapter(MainActivity.this,matchList);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            recyclerView.setAdapter(matchAdapter);
                        }
                        else {
                            Toast.makeText(MainActivity.this, response.code()+" "+response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Root> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Something went wrong\n"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



    }
}