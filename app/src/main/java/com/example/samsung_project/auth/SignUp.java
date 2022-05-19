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
import com.example.samsung_project.databinding.FragmentSignUpBinding;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends Fragment {

    private FirebaseAuth auth;

    FragmentSignUpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentSignUpBinding.bind(view);
        binding.SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount(binding.EmailSignUp.getText().toString(), binding.PasswordSignUp.getText().toString());
            }
        });
    }


public void CreateAccount(String email, String password){
//    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
//        @Override
//        public void onComplete(@NonNull Task<AuthResult> task) {
//            if (task.isSuccessful()) {
//                FirebaseUser user = auth.getCurrentUser();
//            } else {
//                binding.errorText.setText("Wrong email address or password, try again");
//                }
//        }
//    });
    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
    navController.navigate(R.id.main_nav_graph);
}




}

