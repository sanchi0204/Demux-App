package com.example.demuxapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Filter extends AppCompatActivity {

    private Spinner spinnerDifficulty, spinnerCompany, spinnerCollege, spinnerTopic;
    private  String difficultyItem, companyItem, collegeItem, topicItem;
    private  String cmpItem, diffItem, clgItem, topItem;


    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Question> list;
    QuesAdapter adapter;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        InitiateSpinners();
        difficultyItem = PopulateDifficulty();
        topicItem = PopulateTopics();
       collegeItem =  PopulateCollege();
        companyItem = PopulateCompany();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_ques);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("Questions");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Question>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Question ques = dataSnapshot1.getValue(Question.class);
                    list.add(ques);
                }
                adapter = new QuesAdapter(Filter.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Filter.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private String PopulateCompany() {


        List<String> company = new ArrayList<>();
        company.add(0, getString(R.string.company));
        company.add("Adobe");
        company.add("Amazon");
        company.add("Morgan Stanley");
        company.add("Goldman Sachs");
        company.add("Cognizant");

        ArrayAdapter<String> TopicList;
        TopicList = new ArrayAdapter(this, android.R.layout.simple_spinner_item, company);
        TopicList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompany.setAdapter(TopicList);
        spinnerCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (!(adapterView.getItemAtPosition(i).equals(getString(R.string.company)))) {
                     cmpItem = adapterView.getItemAtPosition(i).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return cmpItem;
    }

    private String PopulateCollege() {

        List<String> clg = new ArrayList<>();
        clg.add(0, getString(R.string.clg));
        clg.add("NIT Warangal");
        clg.add("IIT Delhi");
        clg.add("NIT Allahbad");
        clg.add("BITS Pilani");
        clg.add("IIIT Hyderabad");
        clg.add("DTU");
        clg.add("NSUT");
        clg.add("IGDTUW");

        ArrayAdapter<String> TopicList;
        TopicList = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clg);
        TopicList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollege.setAdapter(TopicList);
        spinnerCollege.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (!(adapterView.getItemAtPosition(i).equals(getString(R.string.clg)))) {
                     clgItem = adapterView.getItemAtPosition(i).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return clgItem;
    }

    private void InitiateSpinners() {

        spinnerDifficulty = findViewById(R.id.spinner_difficulty);
        spinnerCompany = findViewById(R.id.spinner_company);
        spinnerCollege = findViewById(R.id.spinner_college);
        spinnerTopic = findViewById(R.id.spinner_topic);
    }

    private String PopulateTopics() {

        List<String> topics = new ArrayList<>();
        topics.add(0, getString(R.string.topics));
        topics.add(getString(R.string.array));
        topics.add(getString(R.string.hashTable));
        topics.add(getString(R.string.dc));
        topics.add(getString(R.string.linkedList));
        topics.add(getString(R.string.string));

        ArrayAdapter<String> TopicList;
        TopicList = new ArrayAdapter(this, android.R.layout.simple_spinner_item, topics);
        TopicList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTopic.setAdapter(TopicList);
        spinnerTopic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (!(adapterView.getItemAtPosition(i).equals(getString(R.string.topics)))) {
                    topItem = adapterView.getItemAtPosition(i).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return topItem;
    }

    private String PopulateDifficulty() {

        List<String> difficulty = new ArrayList<>();
        difficulty.add(0, getString(R.string.difficulty));
        difficulty.add(getString(R.string.easy));
        difficulty.add(getString(R.string.medium));
        difficulty.add(getString(R.string.hard));

        ArrayAdapter<String> difficultyType;
        difficultyType = new ArrayAdapter(this, android.R.layout.simple_spinner_item, difficulty);
        difficultyType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(difficultyType);

        spinnerDifficulty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (!(adapterView.getItemAtPosition(i).equals(getString(R.string.difficulty)))) {
                    diffItem = adapterView.getItemAtPosition(i).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
return diffItem;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}