package com.example.tutorial01.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;
import com.example.tutorial01.model.GenreResponse;
import com.example.tutorial01.service.GenreService;
import com.example.tutorial01.view.GenreItem;
import com.example.tutorial01.view.GenreViewAdapter;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GenreActivity extends AppCompatActivity {
    private RecyclerView genreListView;
    private GenreViewAdapter genreViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private GenreService genreService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        setView();
        setService();
        fetchGenres();
    }

    private void setView() {
        genreListView = findViewById(R.id.genre_list);
        genreViewAdapter = new GenreViewAdapter();
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        genreListView.setAdapter(genreViewAdapter);
        genreListView.setLayoutManager(linearLayoutManager);
    }

    private void setService() {
        genreService = GenreService.getInstance();
    }

    private void fetchGenres() {
        genreService.getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(GenreResponse::getGenres)
                .flatMap(Flowable::fromIterable)
                .map(GenreItem::of)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showGenres);
    }

    private void showGenres(List<GenreItem> genreItems) {
        genreViewAdapter.setItems(genreItems);
    }
}
