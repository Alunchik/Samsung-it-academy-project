package com.example.samsung_project.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsung_project.R;
import com.example.samsung_project.databinding.TestItemBinding;
import com.example.samsung_project.model.Answer;
import com.example.samsung_project.model.Test;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    private static ArrayList<Test> tests_transaction = new ArrayList<>();

    public static void setAnswers_transaction(ArrayList<Answer> answers_transaction) {
        TestAdapter.tests_transaction = tests_transaction;
    }

    public static ArrayList<Test> get_tests_transaction() {
        return tests_transaction;
    }

    ArrayList<Test> tests = new ArrayList<>();

    public TestAdapter(ArrayList<Test> tests) {
        this.tests = tests;
    }

    private TestItemBinding binding;

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, parent, false);
        return new TestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        holder.binding   .testNameView.setText(tests.get(position).getName());
    }
//        if(position<answers.size()){
//
//        }
//        int pos = holder.getLayoutPosition();
//        Answer answer = (Answer) answers.get(pos);
//    }



    @Override
    public int getItemCount() {
        return tests.size();
    }

    static class TestHolder extends RecyclerView.ViewHolder {

        private TestItemBinding binding;


        public TestHolder(@NonNull View itemView) {
            super(itemView);
            binding = TestItemBinding.bind(itemView);
            binding.testNameView.setText("Unnamed");
        }
    }
}
