package com.example.demuxapp;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class QuesAdapter extends RecyclerView.Adapter<QuesAdapter.QuesViewHolder>  implements Filterable {

    Context context;
    ArrayList<Question> questions;
    ArrayList<Question> questionsFull;



    public QuesAdapter(Context context, ArrayList<Question> questions) {
        this.context = context;
        this.questions = questions;
        questionsFull = new ArrayList<>(questions);

    }



    @NonNull
    @Override
    public QuesAdapter.QuesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuesViewHolder(LayoutInflater.from(context).inflate(R.layout.content_recycler, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull QuesAdapter.QuesViewHolder holder, int position) {

        holder.title.setText(questions.get(position).getTitle());

        String diff = questions.get(position).getDifficulty();
        if(diff.equals("Easy")) {
            holder.difficulty.setText(diff);
            holder.difficulty.setChipBackgroundColorResource(R.color.green);
        }
        else if(diff.equals("Medium")) {
            holder.difficulty.setText(diff);
            holder.difficulty.setChipBackgroundColorResource(R.color.yellow);
        }
        else {
            holder.difficulty.setText(diff);
            holder.difficulty.setChipBackgroundColorResource(R.color.red);
        }

        String topic1 = questions.get(position).getTopics().get(0);
        String topic2 = questions.get(position).getTopics().get(1);
        String topic3 = questions.get(position).getTopics().get(2);


        if(!(topic1.equals(" "))) {
            holder.topic1.setText(topic1);
            holder.topic1.setVisibility(View.VISIBLE);
        }

        if(!(topic2.equals(" "))) {
            holder.topic2.setText(topic2);
            holder.topic2.setVisibility(View.VISIBLE);
        }

        if(!(topic3.equals(" "))) {
            holder.topic3.setText(topic3);
            holder.topic3.setVisibility(View.VISIBLE);
        }

        String clg1 = questions.get(position).getCollege().get(0);
        String clg2 = questions.get(position).getCollege().get(1);
        String clg3 = questions.get(position).getCollege().get(2);


        if(!(clg1.equals(" "))) {
            holder.clg1.setText(clg1);
            holder.clg1.setVisibility(View.VISIBLE);
        }

        if(!(clg2.equals(" "))) {
            holder.clg2.setText(clg2);
            holder.clg2.setVisibility(View.VISIBLE);
        }

        if(!(clg3.equals(" "))) {
            holder.clg3.setText(clg3);
            holder.clg3.setVisibility(View.VISIBLE);
        }

        String cmp1 = questions.get(position).getCompanies().get(0);
        String cmp2 = questions.get(position).getCompanies().get(1);
        String cmp3 = questions.get(position).getCompanies().get(2);


        if(!(cmp1.equals(" "))) {
            holder.company1.setText(cmp1);
            holder.company1.setVisibility(View.VISIBLE);
        }

        if(!(cmp2.equals(" "))) {
            holder.company2.setText(cmp2);
            holder.company2.setVisibility(View.VISIBLE);
        }

        if(!(cmp3.equals(" "))) {
            holder.company3.setText(cmp3);
            holder.company3.setVisibility(View.VISIBLE);
        }


        boolean flag_internship = questions.get(position).isInternship();
        boolean flag_online = questions.get(position).isOnline_Interview();
        boolean flag_personal = questions.get(position).isPersonal_Interview();
        boolean flag_fulltime= questions.get(position).isFull_Time();
        boolean flag_trending = questions.get(position).isTrending();

        if(flag_internship) {
            holder.internship.setVisibility(View.VISIBLE);
        }

        if(flag_online) {

            holder.onlineInterview.setVisibility(View.VISIBLE);
        }

        if(flag_personal) {

            holder.personalInterview.setVisibility(View.VISIBLE);
        }

        if(flag_fulltime) {

            holder.fullTime.setVisibility(View.VISIBLE);
        }

        if(flag_trending) {

            holder.trending.setVisibility(View.VISIBLE);
        }

        int frequency = questions.get(position).getFrequency();
        holder.frequency.setProgress(frequency, true);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    static class QuesViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        Chip difficulty, internship, onlineInterview, personalInterview, fullTime, trending;
        Chip topic1, topic2, topic3, clg1,clg2,clg3, company1,company2,company3;
        ProgressBar frequency;

        public QuesViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ques_title);
            difficulty = (Chip) itemView.findViewById(R.id.chip_difficulty);

            internship = (Chip) itemView.findViewById(R.id.chip_internship);
            onlineInterview = (Chip) itemView.findViewById(R.id.chip_online);
            personalInterview = (Chip) itemView.findViewById(R.id.chip_personal_interview);
            fullTime = (Chip) itemView.findViewById(R.id.chip_full_time);
            trending = (Chip) itemView.findViewById(R.id.chip_trending);

            frequency = (ProgressBar) itemView.findViewById(R.id.progress_frequency);

            topic1 = (Chip) itemView.findViewById(R.id.chip_topic_1);
            topic2 = (Chip) itemView.findViewById(R.id.chip_topic_2);
            topic3 = (Chip) itemView.findViewById(R.id.chip_topic_3);

            clg1 = (Chip) itemView.findViewById(R.id.chip_clg_1);
            clg2 = (Chip) itemView.findViewById(R.id.chip_clg_2);
            clg3 = (Chip) itemView.findViewById(R.id.chip_clg_3);

            company1 = (Chip) itemView.findViewById(R.id.chip_cmp_1);
            company2 = (Chip) itemView.findViewById(R.id.chip_cmp2_2);
            company3 = (Chip) itemView.findViewById(R.id.chip_cmp3_3);


        }

    }

    @Override
    public android.widget.Filter getFilter() {
        return quesFilter;
    }


    private Filter quesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Question> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(questionsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Question item : questionsFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern) ||
                    item.getDifficulty().toLowerCase().contains(filterPattern) ||
                    item.getCollege().toString().toLowerCase().contains(filterPattern) ||
                    item.getTopics().toString().toLowerCase().contains(filterPattern) ||
                    item.getCompanies().toString().toLowerCase().contains(filterPattern))
                    {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {

            questions.clear();
            questions.addAll((Collection<? extends Question>) results.values);
            notifyDataSetChanged();
        }
    };



}
