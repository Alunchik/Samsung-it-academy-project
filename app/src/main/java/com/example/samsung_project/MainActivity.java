package com.example.samsung_project;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.samsung_project.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;

    public void goToAddTest() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();
        View view = binding.getRoot();
        setContentView(view);
    }

    public void goToSignUp(View v) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.signUp);
    }
}
