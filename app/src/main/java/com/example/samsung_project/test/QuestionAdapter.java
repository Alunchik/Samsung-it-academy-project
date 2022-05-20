package com.example.samsung_project.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsung_project.R;
import com.example.samsung_project.databinding.AnswerRecyclerViewItemBinding;
import com.example.samsung_project.databinding.FragmentAddTestBinding;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {

    ArrayList<Question> questions = new ArrayList<>();

    public QuestionAdapter(ArrayList<Answer> questions) {
        this.questions = q;
    }

    private FragmentAddTestBinding binding;

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ite, parent, false);
        return new QuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
        holder.binding.
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    static class QuestionHolder extends RecyclerView.ViewHolder {

        private AnswerRecyclerViewItemBinding binding;


        public QuestionHolder(@NonNull View itemView) {
            super(itemView);
            binding = AnswerRecyclerViewItemBinding.bind(itemView);
            binding.answerText.setText("1");
        }
    }
}
