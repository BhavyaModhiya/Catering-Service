package com.example.vasant;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<CategoryModel> list;
    private CategoryAdapter adapter;


    private Dialog categoryDia;
    private EditText categoryname;
    private Button addbtn;
    private Uri image;
    private String downloadUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

       // Toolbar toolbar = findViewById(R.id.toolbar1);

        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rvcate);



        LinearLayoutManager layoutManager = new LinearLayoutManager(Category.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add(new CategoryModel("શાકભાજી"));
        list.add(new CategoryModel("Option_2"));
        list.add(new CategoryModel("Option_3"));
        list.add(new CategoryModel("Option_4"));
        list.add(new CategoryModel("Option_5"));
        list.add(new CategoryModel("Option_6"));

        CategoryAdapter adapter= new CategoryAdapter(list);
        recyclerView.setAdapter(adapter);
      //  Animatoo.animateZoom(Category.this);
     //   adapter.notifyDataSetChanged();

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu, menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }

//    public void onBackPressed() {
//        super.onBackPressed();
//        Animatoo.animateSwipeRight(Category.this);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.Addbt) {
           // Intent addcatIntent = new Intent(this, addcategory.class);
           // startActivity(addcatIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
