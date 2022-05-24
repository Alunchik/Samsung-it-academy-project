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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.samsung_project.databinding.FragmentAddTestBinding;
import com.example.samsung_project.model.Answer;
import com.example.samsung_project.model.Question;
import com.example.samsung_project.test.QuestionAdapter;
import com.example.samsung_project.model.Test;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddTest extends Fragment {

    private DatabaseReference testDataBase;
    private DatabaseReference questionDataBase;
    private QuestionAdapter questionAdapter;
    private FragmentAddTestBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        binding = FragmentAddTestBinding.bind(view);
        testDataBase = FirebaseDatabase.getInstance().getReference(Test.currentTest.getName());
        questionDataBase = FirebaseDatabase.getInstance().getReference();


        ArrayList<Question> questions = new ArrayList<>();
        testDataBase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                questions.add(new Question(Test.currentTest.getId(), snapshot.getValue(String.class), new ArrayList<Answer>(), 1));
                questionAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        questionAdapter = new QuestionAdapter(questions);
        binding.questionsView.setAdapter(questionAdapter);
        binding.questionsView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToAddQuestion();
            }
        });
//        if(Question.getCurrentQuestion()!=null){
//
//        }
    }

    public void GoToAddQuestion(){
        testDataBase.push().setValue(binding.testName.getText().toString());
        Test.currentTest.setName(binding.testName.getText().toString());
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.add_question_fragment);
    }
}
