package com.example.samsung_project.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsung_project.R;
import com.example.samsung_project.databinding.FragmentAddTestBinding;
import com.example.samsung_project.databinding.QuestionItemBinding;
import com.example.samsung_project.model.Question;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {

    ArrayList<Question> questions = new ArrayList<>();

    public QuestionAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    private FragmentAddTestBinding binding;

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new QuestionHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
        //holder.binding.
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    static class QuestionHolder extends RecyclerView.ViewHolder {

        private QuestionItemBinding binding;


        public QuestionHolder(@NonNull View itemView) {
            super(itemView);
            binding = QuestionItemBinding.bind(itemView);
            binding.textView.setText("1");
        }
    }
}
