package com.example.vasant;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Category extends AppCompatActivity {

     Uri stringFileUri;
//    = Environment.getExternalStorageDirectory().getPath()+File.separator + "11.pdf";

    private RecyclerView recyclerView;
    private List<CategoryModel> list;
    private CategoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        // Toolbar toolbar = findViewById(R.id.toolbar1);

        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.rvcate);


        LinearLayoutManager layoutManager = new LinearLayoutManager(Category.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        list.add(new CategoryModel("ઓર્ડર માહિતી"));
        //  list.add(new CategoryModel("દળેલા મસાલા"));
        //  list.add(new CategoryModel("આખા મસાલા"));
        list.add(new CategoryModel("કરિયાણા મસાલા"));
        //  list.add(new CategoryModel("ખાવાનો કલર"));
        //  list.add(new CategoryModel("સૂકો મેવો"));
        //  list.add(new CategoryModel("કઠોળ"));
        //  list.add(new CategoryModel("લોટની યાદી"));
        list.add(new CategoryModel("લીલા શાકભાજી"));
        // list.add(new CategoryModel("ફ્રૂટની યાદી"));
        list.add(new CategoryModel("ડેરીની યાદી"));
        list.add(new CategoryModel("વાસણોનું લિસ્ટ"));

        CategoryAdapter adapter = new CategoryAdapter(list);
        recyclerView.setAdapter(adapter);
        //  Animatoo.animateZoom(Category.this);
        //   adapter.notifyDataSetChanged();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.sharebtn, menu);

        return super.onCreateOptionsMenu(menu);
    }

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

        if (item.getItemId() == R.id.sharebtn) {

            Intent filepath = new Intent(Intent.ACTION_GET_CONTENT);
            filepath.setType("*/*");
            startActivityForResult(filepath, 10);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("CheckingFileUri", "onActivityResult: uri: " + data.toString());
        if (requestCode == 10) {
            if (resultCode == RESULT_OK) {
                try {
                    stringFileUri = data.getData();
                    Log.d("CheckingFileUri", "onActivityResult: uri: " + stringFileUri.toString());
                    File file = new File(stringFileUri.toString());
//                    if (!file.exists()) {
//                        Toast.makeText(this, "File doesn't exists", Toast.LENGTH_LONG).show();
//                        //  return;
//                    }
                    file.setReadOnly();
                    Log.d("OnShareActivityResult", "onActivityResult: File content: " + file.canRead());
                    Log.d("OnShareActivityResult", "onActivityResult: Path: " + file.getAbsolutePath());
                    Log.d("OnShareActivityResult", "onActivityResult: stringFile: " + data.getData().getPath() + "-------" + File.separator);
                    Intent intentShare = new Intent(Intent.ACTION_SEND);
                    intentShare.setType("application/pdf");
                    intentShare.setAction(Intent.ACTION_SEND);
                    intentShare.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+file.getAbsolutePath()));
                    intentShare.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentShare.putExtra(Intent.EXTRA_SUBJECT, "Sharing this file");
                    intentShare.putExtra(Intent.EXTRA_TEXT, "Sharing this file");
//                    intentShare.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    intentShare.addFlags(Intent.FLAG_GRANT_PREFIX_URI_PERMISSION);
                    startActivity(Intent.createChooser(intentShare, "Share the file"));
                } catch (Exception e) {
                    Log.e("OnShareActivityResult", "onActivityResult: " + e.getStackTrace());
                }
            }
        }
    }
}
