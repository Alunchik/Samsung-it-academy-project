package com.example.samsung_project.user;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class UserViewModel extends ViewModel {

    protected static FirebaseAuth auth = FirebaseAuth.getInstance();

    public void signIn(){
        String email, password;
        //auth.signInWithEmailAndPassword(email,password);
    }
    public void signInWithGoogle(String idToken){
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential).addOnCompleteListener(task -> {
            if(task.isSuccessful()){

            }
        });
        }
    }

