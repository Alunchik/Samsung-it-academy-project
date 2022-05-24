package com.example.samsung_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.samsung_project.databinding.TestsPageBlankBinding;
import com.example.samsung_project.model.Test;


public class TestsPage extends Fragment {

    TestsPageBlankBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tests_page_blank, container, false);
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = TestsPageBlankBinding.bind(view);
        binding.addTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTestClick(v);
            }
        });
    }

    private void AddTestClick(View view){
        Test.currentTest=new Test("1");
        Test.currentTest.setName(" ");
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.addTest);
    }


}