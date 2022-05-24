package com.example.samsung_project.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsung_project.R;
import com.example.samsung_project.databinding.AnswerRecyclerViewItemBinding;
import com.example.samsung_project.model.Answer;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerHolder> {

    private static ArrayList<Answer> answers_transaction = new ArrayList<>();

    public static void setAnswers_transaction(ArrayList<Answer> answers_transaction) {
        AnswerAdapter.answers_transaction = answers_transaction;
    }

    public static ArrayList<Answer> getAnswers_transaction() {
        return answers_transaction;
    }

    ArrayList<Answer> answers = new ArrayList<>();

    public AnswerAdapter(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    private AnswerRecyclerViewItemBinding binding;

    @NonNull
    @Override
    public AnswerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_recycler_view_item, parent, false);
        return new AnswerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerHolder holder, int position) {
        holder.binding   .answerText.setText(answers.get(position).getText());
        if(answers.get(position).isCorrect()){ holder.binding.checkCorrect.isChecked();}
    }
//        if(position<answers.size()){
//
//        }
//        int pos = holder.getLayoutPosition();
//        Answer answer = (Answer) answers.get(pos);
//    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    static class AnswerHolder extends RecyclerView.ViewHolder {

        private AnswerRecyclerViewItemBinding binding;


        public AnswerHolder(@NonNull View itemView) {
            super(itemView);
            binding = AnswerRecyclerViewItemBinding.bind(itemView);
            binding.answerText.setText("1");
        }
    }
}
