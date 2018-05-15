package br.com.jorlane.testerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

// Jorlane Brandão at Mai 15, 2018
//
// This project example shows how you can include items at the top or bottom in a RecyclerView.
// I used a LinkedList (it`s a double linked queue) to do this (see the code above and in the Adapter AdapterTest)
// My husband Anderson Berlim Melo gave me the idea to use a double linked queue.

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinkedList<TestObject>  lista;

    private AdapterTest adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // The lista starts with 5 items

        lista = new LinkedList<TestObject>();
        for (int i = 1; i <=5; i++) {
            TestObject o = new TestObject();
            o.setId(i);
            o.setName("number " + i);

            lista.addLast(o);
        }

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new AdapterTest(this, lista);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);

    }

    public void addFirst(View view) {
        // Add item at the top of double linked list

        TestObject test = new TestObject();
        test.setId(adapter.getFirstItem().getId() - 1);
        test.setName("Added at Top " + test.getId());
        adapter.addItemAtFirst(test);
    }

    public void addLast(View view) {

        //Add item at the bottom of double linked list

        TestObject test = new TestObject();
        test.setId(adapter.getLastItem().getId() + 1);
        test.setName("Added at Bottom " + test.getId());
        adapter.addItemAtLast(test);
    }
}
