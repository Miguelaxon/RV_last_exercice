package com.crisspian.recyclerMiguel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.crisspian.recyclerMiguel.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private String urlImage;
    private String descImage;
    private FragmentSecondBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            descImage = getArguments().getString("itemDescription");
            urlImage = getArguments().getString("itemUrl");
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        binding.tvDescription.setText(descImage);
        Glide.with(getContext()).load(urlImage).centerCrop().into(binding.ivDescription);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //binding.tvDescription.setText(descImage);
    }
}