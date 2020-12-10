package com.example.vasant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vasant.list_item_model;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.example.vasant.list_item_model;



public class list_items extends AppCompatActivity {

    private RecyclerView rvlist;
    private ProgressDialog Dialog;
    Button pdfbtn;
    String title;
    TextView itemName;
    EditText qty;
    private Bitmap bmp, scaledbmp;
    private listItemAdapter adapter;
    private Date dateobj;
    private int pageWidth = 1200;
    private DateFormat dateFormat;
//    private Bitmap bmp, scaledbmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        // Toolbar toolbar = findViewById(R.id.toolbar);

        title = getIntent().getStringExtra("title");
        pdfbtn = findViewById(R.id.pdfbtn);
        itemName = findViewById(R.id.list);
        qty = findViewById(R.id.quantityy);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.kcspdfpic);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1200, 381, false);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("category"));

        rvlist = findViewById(R.id.rvlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        List<list_item_model> list = new ArrayList<>();
        switch (getIntent().getStringExtra("category")) {
            case "શાકભાજી":
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_3"));
                list.add(new list_item_model("શાકભાજી"));
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("શાકભાજી"));


                break;
            case "Option_2":
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("Item_3"));

                break;
            case "Option_3":
                list.add(new list_item_model("Item_1"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("Item_4"));
                break;
            case "Option_4":
                list.add(new list_item_model("Item_4"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("Item_4"));
                break;
            case "Option_5":
                list.add(new list_item_model("Item_5"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("Item_4"));
                break;
            case "Option_6":
                list.add(new list_item_model("Item_6"));
                list.add(new list_item_model("Item_2"));
                list.add(new list_item_model("Item_4"));
                break;
            default:
        }

        rvlist.setLayoutManager(layoutManager);
        listItemAdapter adapter = new listItemAdapter(list, title);
        rvlist.setAdapter(adapter);
        createPDF(adapter);
        Log.e("aftercratepdf", "after");
    }

    private void createPDF(final listItemAdapter adapter) {
        pdfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog = new ProgressDialog(list_items.this);
                Dialog.setMessage("Please wait...");
                Dialog.setIndeterminate(false);
                Dialog.setCancelable(false);
                Dialog.show();
                Log.e("afterTextcng", adapter.getItemlist().get(0).toString());
                PdfDocument myPdfDocument = new PdfDocument();
                dateobj = new Date();
                int height = 0;
                Paint myPaint = new Paint();
                Paint titlepaint= new Paint();

                PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                PdfDocument.Page myPage1 = myPdfDocument.startPage(myPageInfo1);
                Canvas canvas = myPage1.getCanvas();

                canvas.drawBitmap(scaledbmp, 0, 0, myPaint);
                titlepaint.setTextAlign(Paint.Align.CENTER);
                titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
                titlepaint.setTextSize(35);
                canvas.drawText(getIntent().getStringExtra("category")+"",pageWidth/2,400,titlepaint);

                dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                canvas.drawText("Date:" + dateFormat.format(dateobj), pageWidth - 115, 400, myPaint);

                myPaint.setStyle(Paint.Style.STROKE);
                myPaint.setStrokeWidth(2);
                canvas.drawRect(20, 440, pageWidth - 20, 470, myPaint);

                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setStyle(Paint.Style.FILL);
                canvas.drawText("Sr. No.", 40, 460, myPaint);
                canvas.drawText("Item Name", 200, 460, myPaint);
                canvas.drawText("Quantity", 900, 460, myPaint);
                Log.e("itemlist", adapter.getItemlist().size() + "");
                Log.e("forloop2", adapter.getItemlist().get(1).getList_qty());


                canvas.drawLine(180, 440, 180, 470, myPaint);
                canvas.drawLine(880, 440, 880, 470, myPaint);
                for (int z = 0; z < adapter.getItemlist().size(); z++) {
                    if (adapter.getItemlist().get(z).getList_qty() != null) {
                        height = height + 20;
                        Log.d("forloopz", z + "---" + adapter.getItemlist().get(z).getList_qty());
                        //  if(qty.getText().toString()==""){
                        canvas.drawText(z + 1 + "", 40, 480 + height, myPaint);
                        canvas.drawText(adapter.getItemlist().get(z).getList_Name(), 200, 480 + height, myPaint);
                        canvas.drawText(adapter.getItemlist().get(z).getList_qty(), 900, 480 + height, myPaint);
                    }
                    Log.e("After if", "onClick: Outside the if statement");
                }
                myPdfDocument.finishPage(myPage1);
                try {
                    File file = new File(Environment.getExternalStorageDirectory(), getIntent().getStringExtra("category") + ".pdf");
                    myPdfDocument.writeTo(new FileOutputStream(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myPdfDocument.close();
                Dialog.dismiss();
            }
        });
    }



//  );}

    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSwipeRight(list_items.this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

//class thread extends Thread{
//    private listItemAdapter adapter;
//    private Date dateobj;
//    private int pageWidth = 1200;
//    private DateFormat dateFormat;
//    private Bitmap bmp, scaledbmp;
//
//
//
//     public thread(listItemAdapter adapter,Bitmap scaledbmp){
//        this.adapter=adapter;
//        this.scaledbmp=scaledbmp;
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        PdfDocument myPdfDocument = new PdfDocument();
//        dateobj = new Date();
//        int height = 0;
//        Paint myPaint = new Paint();
//
//        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
//        PdfDocument.Page myPage1 = myPdfDocument.startPage(myPageInfo1);
//        Canvas canvas = myPage1.getCanvas();
//
//        canvas.drawBitmap(scaledbmp, 0, 0, myPaint);
//
//        dateFormat = new SimpleDateFormat("dd/mm/yy");
//        canvas.drawText("Date:" + dateFormat.format(dateobj), pageWidth - 110, 400, myPaint);
//
//        myPaint.setStyle(Paint.Style.STROKE);
//        myPaint.setStrokeWidth(2);
//        canvas.drawRect(20, 440, pageWidth - 20, 470, myPaint);
//
//        myPaint.setTextAlign(Paint.Align.LEFT);
//        myPaint.setStyle(Paint.Style.FILL);
//        canvas.drawText("Sr. No.", 40, 460, myPaint);
//        canvas.drawText("Item Name", 200, 460, myPaint);
//        canvas.drawText("Quantity", 900, 460, myPaint);
//        Log.e("itemlist", adapter.getItemlist().size() + "");
//        Log.e("forloop2", adapter.getItemlist().get(2).getList_qty());
//        for (int z = 0; z <=adapter.getItemlist().size(); z++) {
//            height = height + 10;
//            Log.e("forloopz",z+"---"+adapter.getItemlist().get(z).getList_qty());
//            canvas.drawLine(180, 440, 180, 470, myPaint);
//            //canvas.drawLine(680,790,680,840,myPaint);
//            canvas.drawLine(880, 440, 880, 470, myPaint);
//
//            if (adapter.getItemlist().get(z).getList_qty() != "") {
//                //  if(qty.getText().toString()==""){
//                Log.e( "run: ",adapter.getItemlist().get(z).getList_qty());
//                canvas.drawText(z + 1 + "", 40, 480 + height, myPaint);
//                canvas.drawText(adapter.getItemlist().get(z).getList_Name(), 200, 480 + height, myPaint);
//                canvas.drawText(adapter.getItemlist().get(z).getList_qty(), 900, 480 + height, myPaint);
//                //Log.e("edit", qty.getText().toString());
//            }
//            // Log.e("EditText",qty.getText().toString());
//
//            myPdfDocument.finishPage(myPage1);
//
//            File file = new File(Environment.getExternalStorageDirectory(), "bhavya" + ".pdf");
//            try {
//                myPdfDocument.writeTo(new FileOutputStream(file));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        myPdfDocument.close();
//
//
//    }
// }