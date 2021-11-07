package com.example.tutorial01.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;
import com.example.tutorial01.model.MovieResponse;
import com.example.tutorial01.service.MovieService;
import com.example.tutorial01.view.MovieItem;
import com.example.tutorial01.view.NowPlayingAdapter;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NowPlayingMovieFragment extends Fragment {
    private RecyclerView nowPlayingMovieListView;
    private NowPlayingAdapter nowPlayingAdapter;
    private LinearLayoutManager linearLayoutManager;
    private MovieService movieService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_now_playing_movie, container, false);
        setInnerView(fragmentView);
        setService();
        fetchPopularMovies();

        return fragmentView;
    }

    private void setInnerView(View fragmentView) {
        nowPlayingMovieListView = fragmentView.findViewById(R.id.now_playing_movie_list);
        nowPlayingAdapter = new NowPlayingAdapter();
        linearLayoutManager = new LinearLayoutManager(this.getActivity(), RecyclerView.HORIZONTAL, false);
        nowPlayingMovieListView.setAdapter(nowPlayingAdapter);
        nowPlayingMovieListView.setLayoutManager(linearLayoutManager);
    }

    private void setService() {
        movieService = MovieService.getInstance();
    }

    private void fetchPopularMovies() {
        movieService.getPopular(1)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(MovieResponse::getResults)
                .flatMap(Flowable::fromIterable)
                .map(MovieItem::of)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showMovies);
    }

    private void showMovies(List<MovieItem> movieItems) {
        nowPlayingAdapter.addItems(movieItems);
    }
}
