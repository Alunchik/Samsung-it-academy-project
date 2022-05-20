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
import com.example.samsung_project.test.Answer;
import com.example.samsung_project.test.AnswerAdapter;

import java.util.ArrayList;


public class AddQuestion extends Fragment {


    private AnswerAdapter answerAdapter;
    private FragmentAddQuestionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentAddQuestionBinding.bind(view);
        ArrayList<Answer> answers = new ArrayList<>();
        for (int i=0; i<5; i++){
            answers.add(new Answer("1", false));
        }
        answerAdapter = new AnswerAdapter(answers);
        binding.answersView.setAdapter(answerAdapter);
        binding.answersView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.questionAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.addTest);
            }
        });
        binding.newAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answers.add(0, new Answer(binding.answerName.getText().toString(), false));
                answerAdapter.notifyItemInserted(0);
            }
        });
    }
}