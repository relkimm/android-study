package com.example.tutorial01.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial01.view.MovieViewAdapter;
import com.example.tutorial01.R;
import com.example.tutorial01.model.Movie;
import com.example.tutorial01.model.MovieResponse;
import com.example.tutorial01.service.MovieService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.list);


        MovieService.getInstance()
            .getPopular(1)
            .enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                    if(response.isSuccessful() == false) {
                        Log.e("연결 성공X", "response code: " + response.code());
                        return;
                    }

                    Log.d("연결 성공", "response code: " + response.code());
                    final List<Movie> movies = response.body().getResults();
                    final MovieViewAdapter movieViewAdapter = new MovieViewAdapter();
                    movieViewAdapter.addItems(movies);
                    listView.setAdapter(movieViewAdapter);
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Log.e("연결 실패", t.getMessage());
                }
            });
    }
}
