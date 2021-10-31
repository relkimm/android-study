package com.example.tutorial01.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tutorial01.R;
import com.example.tutorial01.activity.FragActivity;

public class MainFragment extends Fragment {
    private Button changeButton;
    private FragActivity fragActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragActivity = (FragActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragActivity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        changeButton = rootView.findViewById(R.id.change_button);
        changeButton.setOnClickListener(view -> fragActivity.changeFragment(2));

        return rootView;
    }
}
