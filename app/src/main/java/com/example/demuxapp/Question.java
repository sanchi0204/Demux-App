package com.example.demuxapp;

import java.util.ArrayList;

public class Question {

    private String Title, Difficulty;
    private boolean Trending, Internship, Full_Time, Online_Interview, Personal_Interview;
    private int Frequency;
    private ArrayList<String> Topics, Companies, College;

    public Question() {
    }

    public Question(String title, String difficulty, boolean trending, boolean internship, boolean full_Time,
                    boolean online_Interview,
                    boolean personal_Interview,
                    int frequency, ArrayList<String> topics,
                    ArrayList<String> companies,
                    ArrayList<String> college) {
        Title = title;
        Difficulty = difficulty;
        Trending = trending;
        Internship = internship;
        Full_Time = full_Time;
        Online_Interview = online_Interview;
        Personal_Interview = personal_Interview;
        Frequency = frequency;
        Topics = topics;
        Companies = companies;
        College = college;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String difficulty) {
        Difficulty = difficulty;
    }

    public boolean isTrending() {
        return Trending;
    }

    public void setTrending(boolean trending) {
        Trending = trending;
    }

    public boolean isInternship() {
        return Internship;
    }

    public void setInternship(boolean internship) {
        Internship = internship;
    }

    public boolean isFull_Time() {
        return Full_Time;
    }

    public void setFull_Time(boolean full_Time) {
        Full_Time = full_Time;
    }

    public boolean isOnline_Interview() {
        return Online_Interview;
    }

    public void setOnline_Interview(boolean online_Interview) {
        Online_Interview = online_Interview;
    }

    public boolean isPersonal_Interview() {
        return Personal_Interview;
    }

    public void setPersonal_Interview(boolean personal_Interview) {
        Personal_Interview = personal_Interview;
    }

    public int getFrequency() {
        return Frequency;
    }

    public void setFrequency(int frequency) {
        Frequency = frequency;
    }

    public ArrayList<String> getTopics() {
        return Topics;
    }

    public void setTopics(ArrayList<String> topics) {
        Topics = topics;
    }

    public ArrayList<String> getCompanies() {
        return Companies;
    }

    public void setCompanies(ArrayList<String> companies) {
        Companies = companies;
    }

    public ArrayList<String> getCollege() {
        return College;
    }

    public void setCollege(ArrayList<String> college) {
        College = college;
    }
}