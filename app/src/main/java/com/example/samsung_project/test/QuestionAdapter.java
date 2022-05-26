package com.example.samsung_project.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsung_project.R;
import com.example.samsung_project.databinding.QuestionItemBinding;
import com.example.samsung_project.model.Question;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {

    private static ArrayList<Question> questions_transaction = new ArrayList<>();

    public static void setQuestionTransaction(ArrayList<Question> answers_transaction) {
        QuestionAdapter.questions_transaction = answers_transaction;
    }

    public static ArrayList<Question> getQuestionTransaction() {
        return questions_transaction;
    }

    ArrayList<Question> questions = new ArrayList<>();

    public QuestionAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    private QuestionItemBinding binding;

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new QuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
        holder.binding.QuestionTextView.setText(questions.get(position).getQuestion());
    }
//        if(position<answers.size()){
//
//        }
//        int pos = holder.getLayoutPosition();
//        Answer answer = (Answer) answers.get(pos);
//    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    static class QuestionHolder extends RecyclerView.ViewHolder {

        private QuestionItemBinding binding;


        public QuestionHolder(@NonNull View itemView) {
            super(itemView);
            binding = QuestionItemBinding.bind(itemView);
        }
    }
}
