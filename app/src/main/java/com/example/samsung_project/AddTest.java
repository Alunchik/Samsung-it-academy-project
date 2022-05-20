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

import com.example.samsung_project.databinding.FragmentAddQuestionBinding;
import com.example.samsung_project.databinding.FragmentAddTestBinding;
import com.example.samsung_project.test.Answer;
import com.example.samsung_project.test.AnswerAdapter;
import com.example.samsung_project.test.Question;
import com.example.samsung_project.test.QuestionAdapter;

import java.util.ArrayList;

public class AddTest extends Fragment {


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
        ArrayList<Question> questions = new ArrayList<>();
        questionAdapter = new QuestionAdapter(questions);
        binding.questionsView.setAdapter(questionAdapter);
        binding.questionsView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToAddQuestion();
            }
        });
        if(Question.getCurrentQuestion()!=null){

        }
    }

    public void GoToAddQuestion(){
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.add_question_fragment);
    }
}