package com.example.tutorial01.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;
import com.example.tutorial01.model.Genre;
import com.example.tutorial01.model.GenreResponse;
import com.example.tutorial01.service.GenreService;
import com.example.tutorial01.view.GenreItem;
import com.example.tutorial01.view.GenreViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreActivity extends AppCompatActivity {
    private RecyclerView genreListView;
    private GenreViewAdapter genreViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        genreListView = findViewById(R.id.genre_list);
        genreViewAdapter = new GenreViewAdapter();
        genreListView.setAdapter(genreViewAdapter);
        genreListView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        GenreService.getInstance()
                .getGenres()
                .enqueue(new Callback<GenreResponse>() {
                    @Override
                    public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                        if(!response.isSuccessful()) {
                            Log.e("연결 성공X", "response code : " + response.code());
                            return;
                        }
                        Log.d("연결 성공", "response code : " + response.code());
                        final List<Genre> genres = response.body().getGenres();
                        final List<GenreItem> genreItems = new ArrayList<>();
                        for(Genre genre : genres) {
                            final GenreItem genreItem = GenreItem.of(genre);
                            genreItems.add(genreItem);
                        }
                        genreViewAdapter.setItems(genreItems);
                    }

                    @Override
                    public void onFailure(Call<GenreResponse> call, Throwable t) {
                        Log.e("연결 실패", t.getMessage());
                    }
                });
    }
}
