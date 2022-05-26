package com.example.samsung_project.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.samsung_project.R;
import com.example.samsung_project.databinding.FragmentSignInBinding;

public class SignIn extends Fragment {


    private static final String TAG = "EmailPassword";

    FragmentSignInBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentSignInBinding.bind(view);
        binding.SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.main_nav_graph);;
            }
        });
    }




    public void goToSignUp(View v) {
       NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
       navController.navigate(R.id.signUp);
    }
}
