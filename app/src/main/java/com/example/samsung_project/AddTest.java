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
import com.example.samsung_project.model.Question;
import com.example.samsung_project.model.Test;
import com.example.samsung_project.test.QuestionAdapter;
import com.google.firebase.database.DatabaseReference;

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
        binding.testName.setText(Test.currentTest.getName());
//        testDataBase = FirebaseDatabase.getInstance().getReference(Test.currentTest.getName());
//        questionDataBase = FirebaseDatabase.getInstance().getReference();

        ArrayList<Question> questions = Test.currentTest.getQuestions();
        questionAdapter = new QuestionAdapter(questions);
        binding.questionsView.setAdapter(questionAdapter);
        binding.questionsView.setLayoutManager(new LinearLayoutManager(requireContext()));

        binding.saveTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test.currentTest.setQuestions(questions);
                Test.existingTests.add(Test.currentTest);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.testsPage);
            }
        });

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
        //testDataBase.push().setValue(binding.testName.getText().toString());
        if(binding.testName.getText()==null){}
        else {Test.currentTest.setName(binding.testName.getText().toString());}
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.add_question_fragment);
    }
}
