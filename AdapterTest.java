package br.com.jorlane.testerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

// Jorlane Brandão at Mai 15, 2018
//
// This project example shows how you can include items at the top or bottom in a RecyclerView.
// I used a LinkedList (it`s a double linked queue) to do this (see the code above and in the Adapter AdapterTest)
// My husband Anderson Berlim Melo gave me the idea to use a double linked queue.

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.AdapterTesteViewHolder> {


    private Context context;
    private LinkedList<TestObject> linkedList;

    public AdapterTest(Context context, LinkedList<TestObject> linkedList) {
        this.context = context;
        this.linkedList = linkedList;
    }

    @Override
    public AdapterTesteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_teste, parent, false);

        AdapterTesteViewHolder holder = new AdapterTesteViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterTesteViewHolder holder, int position) {
        holder.textView.setText(linkedList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return linkedList.size();
    }

    public void addItemAtFirst(TestObject item) {
        linkedList.addFirst(item);
        notifyItemInserted(0);
    }

    public void addItemAtLast(TestObject item) {
        linkedList.addLast(item);
        notifyItemInserted(linkedList.size());

    }

    public TestObject getFirstItem() {
        return linkedList.getFirst();
    }

    public TestObject getLastItem() {
        return linkedList.getLast();
    }

    public class AdapterTesteViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public AdapterTesteViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textExample);
        }


    }
}
