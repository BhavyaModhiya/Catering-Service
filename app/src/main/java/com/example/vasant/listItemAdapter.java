package com.example.vasant;

import android.content.Intent;
import android.text.Editable;
import com.example.vasant.list_item_model;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class listItemAdapter extends RecyclerView.Adapter<listItemAdapter.Viewholder> {

    private List<list_item_model> ItemList;
    String title;

    public listItemAdapter(List<list_item_model> itemList, String title) {
        ItemList = itemList;
        this.title = title;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        Log.e("aftercratepdfview","view holder");
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.title.setText(ItemList.get(position).getList_Name());
        holder.qty.setText(ItemList.get(position).getList_qty());
        Log.d("Print","Yes");
        Log.e("aftercratebind","bind");

    }

    public List<list_item_model> getItemlist() {
        return ItemList;
    }

    @Override
    public int getItemCount()
    { return ItemList.size(); }
        class Viewholder extends RecyclerView.ViewHolder{

            private TextView title;
            private EditText qty;
            private Button pdfbtn;


            public Viewholder(@NonNull View itemView) {
                super(itemView);

                title=itemView.findViewById(R.id.list);
                qty=itemView.findViewById(R.id.quantityy);
                pdfbtn=itemView.findViewById(R.id.pdfbtn);
                qty.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                           ItemList.get(getAdapterPosition()).setList_qty(qty.getText().toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        ItemList.get(getAdapterPosition()).setList_qty(qty.getText().toString());
                        Log.e("afterTextcng",  ItemList.get(getAdapterPosition()).getList_qty());
                        Log.e("afterTextcng",  ItemList.get(getAdapterPosition()).getList_Name());

                    }


                });
            }



//            private void setData(final String categorylist){
//                this.title.setText(categorylist);
//                itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent questionIntent=new Intent(itemView.getContext(), Quetions.class);

//                        questionIntent.putExtra("title", title);
//                        itemView.getContext().startActivity(questionIntent);
//                    }
//                });
  //          }
        }
    }

