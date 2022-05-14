package com.example.dictionnry;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.dictionnry.Adapters.MeaningAdapter;
import com.example.dictionnry.Adapters.PhoneticsAdapter;
import com.example.dictionnry.Models.APIRespone;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionnry.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Definition of Objects from the UI like search view
    //noting that the instance name should have the same name that we give the id in the xml file
    SearchView search_view;
    TextView textView_word;
    RecyclerView recycler_phonetics ,recycler_meanings;
    //define a progress dialog
    //prevents the user from interacting with the app.
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Finds a view that was identified by the android:id XML
        search_view=findViewById(R.id.search_view);
        textView_word=findViewById(R.id.textView_word);
        recycler_phonetics=findViewById(R.id.recycler_phonetics);
        recycler_meanings=findViewById(R.id.recycler_meanings);
        //initalise progress dialog
        progressDialog =new ProgressDialog(this);
        progressDialog.setTitle("Loading ...");
        progressDialog.show();
        RequestManager manager=new RequestManager(MainActivity.this);
        //when opening the app , search hello will be there ,ofc you can change it after
        manager.getWordMeaning(listener,"hello");
        //type something in the search view and query it
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
            progressDialog.setTitle("Fetching response for "+ query);
            progressDialog.show();
            RequestManager manager=new RequestManager(MainActivity.this);
            manager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
    final OnFetchDataListener listener=new OnFetchDataListener() {
        @Override
        public void onFetchData(APIRespone apiRespone, String message) {
            progressDialog.dismiss();
            //check if the response null or not
            if(apiRespone==null){
                Toast.makeText(MainActivity.this,"no data found",Toast.LENGTH_SHORT).show();
                return;
            }
            //call the method show data
            showData(apiRespone);
        }



        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(APIRespone apiRespone) {
        //add data to view
        textView_word.setText("Word"+apiRespone.getWord());
        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter=new PhoneticsAdapter(this,apiRespone.getPhonetics());
        recycler_phonetics.setAdapter(phoneticsAdapter);
        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter= new MeaningAdapter(this,apiRespone.getMeanings());
        recycler_meanings.setAdapter(meaningAdapter);
    }

}