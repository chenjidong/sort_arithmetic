package com.cjd.demo_arithmetic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @Author chenjidong
 * @data Description:
 **/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void jumpBubbleSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "bubble");
        startActivity(intent);
    }

    public void jumpSelectionSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "selection");
        startActivity(intent);
    }

    public void jumpInsertionSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "insertion");
        startActivity(intent);
    }

    public void jumpShellSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "shell");
        startActivity(intent);
    }

    public void jumpMergeSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "merge");
        startActivity(intent);
    }

    public void jumpQuickSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "quick");
        startActivity(intent);
    }
    public void jumpCountSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "count");
        startActivity(intent);
    }

    public void jumpBucketSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "bucket");
        startActivity(intent);
    }

    public void jumpRadixSort(View view) {
        Intent intent = new Intent(MainActivity.this, SortActivity.class);
        intent.putExtra("sort", "radix");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
