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
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
import java.util.HashMap;
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
    private int pageWidth = 1240;
    private DateFormat dateFormat;
    //    private Bitmap bmp, scaledbmp;
    TextView kcsname, menu;
    EditText partyname, address, phonenum, eventdate, eventtime, person, priceperdish, place, additemname;
    private Button pdfbtn1, additembtn1,nextbtn, sharepdfbtn;
    ListView listViewitem;
    String[] menulistarray;
    ArrayList<String> menulist;
    ArrayAdapter<String> adapterlist;
    File file;


    String[] array1 = {
            "મીઠું",
            "હળદર",
            "મરચું",
            "કુમઠી કાશ્મીરી મરચું",
            "પંજાબી રસોઇ માટે",
            "નેચરલ હળદર",
            "ધાણા",
            "ધાણાજીરૂ",
            "અચાર મસાલા",
            "અચાર મસાલા સ્વીટ",
            "ચા મસાલો",
            "રજવાડી ગરમ મસાલો",
            "કિચન કિંગ મસાલા",
            "ચણા છોલે મસાલા",
            "પાંવભાજી મસાલા",
            "ચાટ મસાલા",
            "ઇડલી સંભાર મસાલા",
            "પાનીપુરી મસાલા",
            "કસૂરી મેથી",
            "સ્ટ્રોંગ હિંગ",
            "કરી પાવડર",
            "ખિચડી મસાલા",
            "સફેદ મરચાં પાવડર",
            "ચટપટું જીરાળુ પાવડર",
            "કેરી ઝોલીયા મસાલા બાફલા માટે",
            "સુંઠ પાવડર",
            "ગરાડું મસાલા",
            "આમચૂર પાવડર/જલજીરા",
            "તજપાન",
            "તજ",
            "લવિંગ",
            "આખુજીરૂ",
            "આખા ધાણાં",
            "વરીયાળી",
            "મરી",
            "બાદીયા",
            "ડગર ફુલી",
            "એલચી",
            "જાવંત્રી",
            "નાગકેસર",
            "ખસખસ",
            "જાયફળ",
            "એલચા",
            "શાહજીરૂ",
            "સુંઠ",
            "સીંધવ મીઠું",
            "કાળુ મીઠું",
            "કોપરાનું છીણ સિલોન",
            "સફેદ તલ",
            "નવી આમલી",
            "આખા મરચાં (વધાર માટે)",
            "મેથી",
            "રાઈ",
            "અજમો",
            "વઘારના લાલ મરચાં",
            "મગસ્તરી બી",
            "ખારેક",
            "સીંગદાણા કાચા",
            "સીંગદાણા શેકેલા",
            "ચા (ભૂકી)",
            "કોફી (નેસકેફે)",
            "મેથી કુરીયા",
            "રાઇ કુરીયા",
            "મુખવાસ",
            "લીંબુના ફુલ",
            "સાંજીના ફુલ",
            "સાંજીના મોટા",
            "ટાટા સોડા",
            "ફટકડી",
            "નારા છડી",
            "વોશીંગ પાવડર",
            "રસોઇની ખાંડ",
            "અંબોળીયા સફેદ",
            "ખજુર",
            "ગોળ કોલ્હાપુરી",
            "ગુંદર",
            "જાડા પૌવા",
            "નાઇલોન પૌવા",
            "મકાઇના પૌવા",
            "બુરૂ ખાંડ",
            "દળેલી ખાંડ",
            "સાબુદાણા",
            "કોપરાની કાચલી",
            "કોપરાની કતરણ",
            "દુધ પાવડર",
            "ટામેટા સોસ",
            "દીવાસળી",
            "પૂજાપો",
            "શ્રીફળ",
            "રૂ",
            "અગરબત્તી",
            "તેલના ડબ્બા",
            "વરખ (થોકડી)",
            "સાકર",
            "ડમરૂ સેવ",
            "પાપડી",
            "પાપડ",
            "મીક્ષ કેરીનું અથાણું",
            "રમકડા",
            "અરીઠા",
            "હેડ્રો ",
            "ગુલાબ કતરી(પીળી)",
            "ટોસ્ટ",
            "બ્રેડ",
            "આખી ખાંડ",
            "જામ",
            "મમરા",
            "સરસીયું તેલ",
            "દેશી ઘી / ડાલડા ઘી ",
            "લેમન મીઠો કલર",
            "લાલ કલર",
            "ચોકલેટ કલર",
            "રંગ મીઠા પીળા",
            "રંગ લીંબુ પીળા",
            "રંગ નારંગી(ઓરેન્જ)",
            "રંગ લીલો",
            "રંગ રાસબરી",
            "ગુલાબ જળ",
            "સંતરા એસેન્સ",
            "ગુલાબ એસેન્સ",
            "કેવડા એસેન્સ",
            "વેનીલા વ્હાઇટ એસેન્સ",
            "બેકીંગ પાવડર",
            "કસ્ટર્ડ પાવડર",
            "ચોકલેટ પાવડર",
            "મેંગો એસેન્સ",
            "ઓરેન્જ રસના",
            "કાજુ",
            "કાજુના ફાડા",
            "દ્રાક્ષ",
            "બદામ",
            "પીસ્તા",
            "કેસર",
            "ચારોળી",
            "બદામના ટુકડા",
            "પીસ્તાના ટુકડા",
            "મખાણા",
            "અંજીર",
            "અખરોટ",
            "બાસમતી ચોખા",
            "ખિચડીના ચોખા",
            "બોઇલ ચોખા",
            "તુવેર દાળ",
            "મગની દાળ",
            "ચણા દાળ",
            "છોલે ચણા",
            "લીલા વટાણા",
            "મઠ",
            "અડદ દાળ",
            "મસૂર દાળ",
            "સાબુદાણા ડબલ",
            "મુંગ દાલ છાલવાળી",
            "ચણા કાબુલી બોલ્ડ",
            "મસૂર આખી",
            "દેશી ચણા",
            "ચોળા દાળ",
            "રાજમા",
            "અડદ દાળ છોતરાવાળી",
            "વડી",
            "ઘઉંનો લોટ (કકરો)",
            "ઘઉંનો લોટ",
            "બેસણ ૧ નંબર",
            "બેસણ (મીલનું)",
            "લાપસી ફાડા",
            "ચોખાનો લોટ",
            "શીંગોડાનો લોટ",
            "આરાનો લોટ",
            "બાજરીનો લોટ",
            "મકાઇનો લોટ",
            "જુવારનો લોટ",
            "રવો",
            "મેંદો",
            "બેસણ દોઢ નંબર",
            "અડદનો લોટ",
            "ઇડલીનો લોટ",
            "સોજી"};

    String[] array2 = {
            "લીલા દેશી મરચાં",
            "લીલા ધાણાં",
            "પાલકની ભાજી",
            "આદું",
            "ફુદીનો",
            "લીંબુ",
            "પીળી આંબા હળદર",
            "મીઠો લીમડો",
            "લીલુ લસણ",
            "સુકું લસણ",
            "સુરણ",
            "મુળા",
            "સલાડની કાકડી",
            "ગાજર",
            "કોળુ",
            "બટાકા",
            "દુધી",
            "ટામેટાં લાલ/ લીલા",
            "ગરાડું",
            "ટીંડોળા",
            "રીંગણ",
            "કાંદા (ડુંગળી)",
            "ભીંડા",
            "બીટ (લાલ)",
            "વટાણાની સિંગ",
            "ફુલ ગોબી/ પત્તા ગોબી",
            "સરસો/ અરબી",
            "મેથી ભાજી/કારેલા",
            "ગલકા/તરોઇ",
            "શક્કરીયા",
            "સીમલા મરચાં",
            "અળવીના પાના",
            "કાચા કેળા",
            "લીલા ચણા (દાણા)",
            "કાકડી",
            "દોડા નરમ",
            "ગવાર ફળી",
            "પલુર",
            "સફરજન",
            "લાલ દાડમ",
            "લીલી દ્રાક્ષ",
            "પાકા કેળા",
            "પાઇનેપલ",
            "ચીકું",
            "પાકી કેરી",
            "કાચી કેરી",
            "મોસંબી",
            "તડબુચ",
            "ચેરી",
            "પપૈયુ",
            "સંતરા",
            "દ્રાક્ષ કાળી",
            "પાકી કેરી (બદામ)",
            "પાકી કેરી તોતાપુરી",
            "કેરી દસેરી",
            "કેરી લંગડા",
            "કેરી લાલ પટ્ટો",
            "શક્કરટેટી",
    };

    String[] array3 = {
            "ચીઝ",
            "માખણ (અમૂલ)",
            "પનીર",
            "ક્રીમ",
            "ગાયનું ઘી",
            "કેરીનો રસ",
            "શ્રીખંડ",
            "મઠો",
            "બરફ",
            "કોપરા પાકનો માવો",
            "માવો (દાનાદાર)",
            "માવા (બરફી)",
            "દહીં સર્પેટા",
            "દહીં (સવારે)",
            "દહીં (સાંજે)",
            "ખમીર",
    };
    String[] array4 = {
            "રસોઇના મોટા તપેલા",
            "રસોઇના નાના તપેલા",
            "છીબા (વાસણ મુકવાનું)",
            "મોટા થાળા (પતરા)",
            "નાના થાળા (પતરા)",
            "કમંડળ",
            "સ્ટીલની ડોલ",
            "ઘામા",
            "ચમચા (મોટા)",
            "ચમચી (નાની)",
            "જગ",
            "ભાતીયા",
            "વાટકા ડોયા",
            "વાસણ ધોવા માટે ટબ",
            "બુફેની મોટી ડીશ",
            "સ્ટીલના બાઉલ",
            "રાઇસ પ્લેટ",
            "થાળી",
            "વાટકી",
            "ગ્લાસ",
            "સ્ટીલની કોઠી નાની",
            "સ્ટીલની કોઠી મોટી",
            "પાણીના મોટા પીપ",
            "પીત્તળની પરાત નાની",
            "મીઠાઇની ચોરસ ટ્રે",
            "દુઘની કઢાઇ",
            "માવાની કઢાઇ",
            "બરફની કઢાઇ",
            "નાની કઢાઈ",
            "જલેબીની કઢાઇ",
            "પરોઠાનો તવો",
            "ભાંજીપાવનો તવો",
            "મોટા તપેલા (એલ્યુમિનિયમ)",
            "બેકીંગ ડીશની ચોકી",
            "તવેથા",
            "ઝારા",
            "કોલસાનો સગડો",
            "કોલસા",
            "કેરોસીન",
            "લાકડા",
            "મલમલનું કપડું",
            "ચીપીયો",
            "મિકસર ગ્રાઇન્ડર",
            "વોશ બેઝીન",
            "ફ્યુલ",
            "સિલ્વર ફોઇલ રોલ",
            "પાટલા",
            "આડણી",
            "ચપ્પુ",
            "કટર",
            "છીણી",
            "બટાકા છોલવાની કટર",
            "ગેસના સગડા",
            "ઢોસાની ભટ્ટી",
            "ગેસના બાટલા",
            "ઇંટો",
            "જાજમ શેતરંજી",
            "ઘઉંનો ચારણો",
            "ચોખાનો ચારણો",
            "ત્રાજવા, બાટ(વજનીયાં)",
            "વેસ્ટ ગાબા",
            "નવું કંતાન",
            "નવા ધોતીયા",
            "વાંસની ટોપલી",
            "પાણી માટે માદરપાટ",
            "સાવરણી",
            "પતરાળા",
            "કેસર ખરલ",
            "છાણ",
            "પડીયા",
            "પેપર રદ્દી",
            "પેપર નેપકીન",
            "પેપર ડીસ",
            "થર્મોકોલ વાટકી",
            "થર્મોકોલ ગ્લાસ",
            "પાવડો",
            "માટીના માટલા",
            "રસોડા ઉપર મંડપ",
            "ખાલી બારદાન",
            "હેલોજન",
            "પેડેસ્ટલ ફેન",
            "કુલર",
            "સેલો ખુરશી",
            "બુફે ટેબલ",
            "ગાદલા",
            "તકીયા",
            "લોટની ચારણી",
            "ચાની ચારણી",
            "ખાંડણી",
            "ગેસની સગડી (ઘરની)",
            "પુરીની કડાઇ",
            "સેવ કડાઇ મીડીયમ",
            "સેવ કડાઇ નાની",
            "તવા મોટા",
            "તવા મીડીયમ",
            "ટ્રે",
            "ઈડલી કુકર",
            "કનાત",
            "ચાનું થરમોસ",
            "બાફલા સુકાવવાની ચાદર",
            "પ્લાસ્ટીકની થેલી મોટી",
            "ચા ના કપ",
    };

    HashMap<String, String[]> map = new HashMap<String, String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        // Toolbar toolbar = findViewById(R.id.toolbar);

        title = getIntent().getStringExtra("title");
        pdfbtn = findViewById(R.id.pdfbtn);
        itemName = findViewById(R.id.list);
        qty = findViewById(R.id.quantityy);

        kcsname = findViewById(R.id.kcsname);
        partyname = findViewById(R.id.partyname);
        address = findViewById(R.id.sarnamu);
        phonenum = findViewById(R.id.phonenum);
        eventdate = findViewById(R.id.eventdate);
        eventtime = findViewById(R.id.eventtime);
        person = findViewById(R.id.person);
        priceperdish= findViewById(R.id.priceperdish);
        place = findViewById(R.id.place);
        sharepdfbtn=findViewById(R.id.sharepdfbtn);
        menu = findViewById(R.id.viewmenu);

        sharepdfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("application/pdf");
                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                startActivity(shareIntent);
            }
        });


        map.put("કરિયાણા મસાલા", array1);
        map.put("લીલા શાકભાજી", array2);
        map.put("ડેરીની યાદી", array3);
        map.put("વાસણોનું લિસ્ટ", array4);

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.kcspdfpic);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1240, 293, false);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("category"));

        rvlist = findViewById(R.id.rvlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        List<list_item_model> list = new ArrayList<>();
        switch (getIntent().getStringExtra("category")) {
            case "ઓર્ડર માહિતી":
                setContentView(R.layout.frontpage);

                nextbtn=findViewById(R.id.nextbtn);

                nextbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Order theOrder = Order.getInstance();
                        String phoneNum = ((EditText)findViewById(R.id.phonenum)).getText().toString();
                        String numberOfPersons = ((EditText)findViewById(R.id.person)).getText().toString();
                        String priceperdish = ((EditText)findViewById(R.id.priceperdish)).getText().toString();
                        Log.d("In data fetch: ", "onClick: number of persons = " + numberOfPersons);
                        theOrder.setData(
                                ((EditText)findViewById(R.id.partyname)).getText().toString(),
                                ((EditText)findViewById(R.id.sarnamu)).getText().toString(),
                                Long.parseLong(phoneNum.equals("") ? "0" : phoneNum),
                                ((EditText)findViewById(R.id.eventdate)).getText().toString(),
                                ((EditText)findViewById(R.id.eventtime)).getText().toString(),
                                Integer.parseInt(numberOfPersons.equals("") ? "0" : numberOfPersons),
                                Integer.parseInt(priceperdish.equals("") ? "0" : priceperdish),
                                ((EditText)findViewById(R.id.place)).getText().toString()
                        );

                        setContentView(R.layout.menuitems);
                        additemname = findViewById(R.id.itemname);
                        additembtn1 = findViewById(R.id.additembtn);
                        listViewitem = findViewById(R.id.listviewitem);
                        pdfbtn1 = findViewById(R.id.pdfbtn2);

                       // final ArrayList<String> menulist;
                       // final ArrayAdapter<String> adapterlist;

                        menulist = new ArrayList<>();
                        adapterlist = new ArrayAdapter<String>(list_items.this, R.layout.listviewshow, menulist);
                        View.OnClickListener addlistner = new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(additemname.getText().toString().isEmpty()){
                                       additemname.setError("Required");
                                }else {
                                menulist.add(additemname.getText().toString());
                                additemname.setText("");
                                adapterlist.notifyDataSetChanged();}
                              //  Log.e("menuitems", adapterlist);
                            }
                        };
                        additembtn1.setOnClickListener(addlistner);
                        listViewitem.setAdapter(adapterlist);
                        pdfbtn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                orderPDF();
                            }
                        });
                    }
                });

                break;
            default:
                String category = getIntent().getStringExtra("category");
                if(map.containsKey(category)) {
                    for (String s : map.get(category)) {
                        list.add(new list_item_model(s));
                    }
                }
        }

        rvlist.setLayoutManager(layoutManager);
        listItemAdapter adapter = new listItemAdapter(list, title);
        rvlist.setAdapter(adapter);
        createPDF(adapter);
        Log.e("aftercratepdf", "after");
    }

    private void orderPDF() {
        int pageNum = 1;
        int pageHeight = 1754;
        int pageWidth = 1240;
        int height=602;
        Paint myPaint1 = new Paint();
        Paint titlepaint1 = new Paint();
        PdfDocument myPdfDocument1 = new PdfDocument();

        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNum).create();
        PdfDocument.Page myPage = myPdfDocument1.startPage(myPageInfo);
        Canvas canvas = myPage.getCanvas();

        canvas.drawBitmap(scaledbmp, 0, 0, myPaint1);

//        myPaint1.setStrokeWidth(4);
//        canvas.drawLine(20,  371, pageWidth - 20, 371 , myPaint1);
//
//        canvas.drawLine(20,  371, 20, 600 , myPaint1);
//
//        canvas.drawLine(pageWidth  - 20,  371, pageWidth - 20, 600 , myPaint1);
        myPaint1.setStrokeWidth(2);
        myPaint1.setTextSize(28);
        canvas.drawText("પાર્ટીનું નામ :", 30, 317, myPaint1);
        Order myOrder = Order.getInstance();
        canvas.drawText(myOrder.getPartyName()+"", 163, 317, myPaint1);
        Log.d("TryingOutOrders", "orderPDF: myOrder: " + myOrder.getPartyName());
        myPaint1.setStrokeWidth(1);
        canvas.drawLine(151,  322, pageWidth-40, 322 , myPaint1);

        myPaint1.setTextSize(28);
        canvas.drawText("સરનામું :", 30, 355, myPaint1);
        canvas.drawText(myOrder.getAddress(), 123, 355, myPaint1);
        canvas.drawLine(115,  357, pageWidth-40, 357 , myPaint1);

        myPaint1.setTextSize(28);
        canvas.drawText("વ્યક્તિ :", 30, 387, myPaint1);
        canvas.drawText(myOrder.getNoOfPerson()+"", 119, 387, myPaint1);
        canvas.drawLine(108,  392, 440, 392 , myPaint1);

        myPaint1.setTextSize(28);
        canvas.drawText("ભાવ(વ્યક્તિદીઠ) :", 480, 391, myPaint1);
        canvas.drawText(myOrder.getPriceperdish()+"", 665, 391, myPaint1);
        canvas.drawLine(658,  396, pageWidth-40, 394 , myPaint1);

        myPaint1.setTextSize(28);
        canvas.drawText("ભોજન સમારંભની તારીખ :", 30, 422, myPaint1);
        canvas.drawText(myOrder.getDate()+"", 297, 422, myPaint1);
        canvas.drawLine(288,  427, pageWidth-40, 427 , myPaint1);

        myPaint1.setTextSize(28);
        canvas.drawText("સમય :", 30, 457, myPaint1);
        canvas.drawText(myOrder.getTime()+"", 108, 457, myPaint1);
        canvas.drawLine(99,  462, 440, 462 , myPaint1);

        myPaint1.setTextSize(28);
        canvas.drawText("ફોન નંબર :", 480, 457, myPaint1);
        canvas.drawText(myOrder.getPhoneNum()+"", 592, 457, myPaint1);
        canvas.drawLine(586,  462, pageWidth-40, 462 , myPaint1);

        myPaint1.setTextSize(28);
        canvas.drawText("સ્થળ :", 30, 492, myPaint1);
        canvas.drawText(myOrder.getPlace()+"", 109, 492, myPaint1);
        canvas.drawLine(99,  497, pageWidth-40, 497 , myPaint1);

        titlepaint1.setTextAlign(Paint.Align.CENTER);
        titlepaint1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        titlepaint1.setTextSize(35);
        canvas.drawText("વાનગીઓનો રસથાળ", pageWidth / 2, 557, titlepaint1);
        titlepaint1.setStrokeWidth(3);
        canvas.drawLine(482,  562, 762, 562 , titlepaint1);



//        myPaint1.setStrokeWidth(4);
//        canvas.drawLine(20,  600, pageWidth - 20, 600 , myPaint1);
        myPaint1.setStyle(Paint.Style.STROKE);
        myPaint1.setStrokeWidth(3);
        canvas.drawRect(20, 286, pageWidth - 20, 512, myPaint1);

        myPaint1.setStyle(Paint.Style.STROKE);
        myPaint1.setStrokeWidth(3);
        canvas.drawRect(20, 572, pageWidth - 20, 607, myPaint1);

        myPaint1.setTextAlign(Paint.Align.CENTER);
        myPaint1.setStyle(Paint.Style.FILL);
        myPaint1.setTextSize(28);
        canvas.drawText("Sr. No.", 152, 598, myPaint1);
        myPaint1.setTextSize(28);
        canvas.drawText("Item Name", pageWidth/2, 598, myPaint1);
        canvas.drawLine(370, 572, 370, 607, myPaint1);

        int i=0;
        while (i<menulist.size()){
            height=height+35;
            canvas.drawText(i+1+".", 160, height, myPaint1);
            canvas.drawText(adapterlist.getItem(i), pageWidth/2, height, myPaint1);
            myPaint1.setStrokeWidth(1);
            canvas.drawLine(45, height +10, pageWidth - 45, 10 + height, myPaint1);

            // Log.e("menuitemss",adapterlist.getItem(i)+i);
            i++;
        }

        myPdfDocument1.finishPage(myPage);
        try {
            File file = new File(Environment.getExternalStorageDirectory(), myOrder.getPartyName()+" "+getIntent().getStringExtra("category") + ".pdf");
            myPdfDocument1.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myPdfDocument1.close();
        Toast.makeText(getApplicationContext(), "PDF Is Created", Toast.LENGTH_LONG).show();
        Intent listintent = new Intent(list_items.this, Category.class);
        startActivity(listintent);
        Animatoo.animateSpin(list_items.this);
    }

    private void createPDF(final listItemAdapter adapter) {
        pdfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Dialog = new ProgressDialog(list_items.this);
//                Dialog.setMessage("Please wait...");
//                Dialog.setIndeterminate(false);
//                Dialog.setCancelable(false);
//                Dialog.show();
                List<list_item_model> itemList = adapter.getItemlist();

                if (itemList.get(0).getList_qty()==null){
                    Toast.makeText(getApplicationContext(), "Enter Values of Quantity", Toast.LENGTH_LONG).show();

                }
                else {
                Log.e("afterTextcng", itemList.get(0).toString());
                final PdfDocument myPdfDocument = new PdfDocument();
                dateobj = new Date();
                int height = 378;
                Paint myPaint = new Paint();
                Paint titlepaint = new Paint();
                int pageNum = 1;
                int pageHeight = 1754;
                int pageWidth = 1240;


                PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNum).create();
                PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);
                Canvas canvas = myPage.getCanvas();

                canvas.drawBitmap(scaledbmp, 0, 0, myPaint);
                titlepaint.setTextAlign(Paint.Align.CENTER);
                titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                titlepaint.setTextSize(35);
                canvas.drawText(getIntent().getStringExtra("category") + "", pageWidth / 2, 320, titlepaint);

//                dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//                myPaint.setTextSize(22);
//                canvas.drawText("Date:" + dateFormat.format(dateobj), pageWidth - 173, 312, myPaint);

                
                
                myPaint.setStyle(Paint.Style.STROKE);
                myPaint.setStrokeWidth(3);
                canvas.drawRect(20, 344, pageWidth - 20, 383, myPaint);

                myPaint.setTextAlign(Paint.Align.LEFT);
                myPaint.setStyle(Paint.Style.FILL);
                myPaint.setTextSize(28);
                canvas.drawText("Sr. No.", 50, 372, myPaint);
                myPaint.setTextSize(28);
                canvas.drawText("Item Name", 260, 372, myPaint);
                myPaint.setTextSize(28);
                canvas.drawText("Quantity", 940, 372, myPaint);
                Log.e("itemlist", itemList.size() + "");
                Log.e("forloop2", itemList.get(1).getList_qty());


                canvas.drawLine(180, 344, 180, 383, myPaint);
                canvas.drawLine(880, 344, 880, 383, myPaint);
                int k = 0;

                int numberXMargin = 65;
                int nameXMargin = 260;
                int quantityXMargin = 940;

                Order myOrder = Order.getInstance();

                if (myOrder.getPartyName()!=""){
                    myPaint.setTextSize(25);
                    canvas.drawText(myOrder.getPartyName()+"", 30, 312, myPaint);}

                if (myOrder.getDate()!=""){
                    myPaint.setTextSize(25);
                    canvas.drawText(myOrder.getDate()+"", pageWidth - 170, 312, myPaint);}

                for (list_item_model item: itemList) {
                    if (item.getList_qty() != null) {
                        if (item.getList_qty().length() > 0) {
                            if(height + 40 <= pageHeight - 20) {
                                k++;
                                height = height + 40;
                                myPaint.setTextSize(28);
                                canvas.drawText(String.valueOf(k)+".", numberXMargin, height, myPaint);
                                myPaint.setTextSize(28);
                                canvas.drawText(item.getList_Name(), nameXMargin, height, myPaint);
                                myPaint.setTextSize(28);
                                canvas.drawText(item.getList_qty(), quantityXMargin, height, myPaint);
                                myPaint.setStrokeWidth(1);
                                canvas.drawLine(20, height + 12, pageWidth - 20, 12 + height, myPaint);
                            }
                            else {
                                int topMargin = 50;
                                myPdfDocument.finishPage(myPage);
                                myPageInfo = new PdfDocument.PageInfo.Builder(pageWidth, pageHeight, ++pageNum).create();
                                myPage = myPdfDocument.startPage(myPageInfo);
                                canvas = myPage.getCanvas();
                                myPaint.setStyle(Paint.Style.STROKE);
                                myPaint.setStrokeWidth(3);
                                canvas.drawRect(20, topMargin - 20, pageWidth - 20, topMargin + 19, myPaint);
                                myPaint.setTextAlign(Paint.Align.LEFT);
                                myPaint.setStyle(Paint.Style.FILL);
                                myPaint.setTextSize(28);
                                canvas.drawText("Sr. No.", numberXMargin, topMargin+10, myPaint);
                                myPaint.setTextSize(28);
                                canvas.drawText("Item Name", nameXMargin, topMargin+10, myPaint);
                                myPaint.setTextSize(28);
                                canvas.drawText("Quantity", quantityXMargin, topMargin+10, myPaint);
                                Log.e("itemlist", itemList.size() + "");
                                Log.e("forloop2", itemList.get(1).getList_qty());


                                canvas.drawLine(180,topMargin - 20 , 180, topMargin + 19, myPaint);
                                canvas.drawLine(880, topMargin - 20, 880, topMargin + 19, myPaint);

                                height = topMargin + 20;
                                k++;
                                height = height + 40;
                                myPaint.setStrokeWidth(2);
                                myPaint.setTextSize(28);
                                canvas.drawText(String.valueOf(k)+".", numberXMargin, height, myPaint);
                                myPaint.setTextSize(28);
                                canvas.drawText(item.getList_Name(), nameXMargin, height, myPaint);
                                myPaint.setTextSize(28);
                                canvas.drawText(item.getList_qty(), quantityXMargin, height, myPaint);
                                myPaint.setStrokeWidth(1);
                                canvas.drawLine(20, height + 12, pageWidth - 20, height + 12, myPaint);
                            }
                        }
                    }
                }
             //   Dialog.dismiss();
                myPdfDocument.finishPage(myPage);
                try {
                 //   final File
                            file = new File(Environment.getExternalStorageDirectory(), myOrder.getPartyName() +" "+ getIntent().getStringExtra("category") + ".pdf");
                    myPdfDocument.writeTo(new FileOutputStream(file));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                myPdfDocument.close();
                Toast.makeText(getApplicationContext(), "PDF Is Created", Toast.LENGTH_LONG).show();
//                Intent listintent = new Intent(list_items.this, Category.class);
//                startActivity(listintent);
//                Animatoo.animateSpin(list_items.this);

            }}
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