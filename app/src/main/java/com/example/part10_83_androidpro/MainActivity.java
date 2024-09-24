package com.example.part10_83_androidpro;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    showCustomToast(this, "Hello World!", 100); // Задержка 1000 мс = 1 секунда

    ListView myListView = findViewById(R.id.listView);

    ArrayList<String> colorList = new ArrayList<>();
    colorList.add("Orange");
    colorList.add("Red");
    colorList.add("Blue");
    colorList.add("Black");
    colorList.add("Pink");

    ArrayAdapter myArrayAdapter = new ArrayAdapter(this,
            android.R.layout.simple_list_item_1, colorList);
        myListView.setAdapter(myArrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = colorList.indexOf(colorList.get(i));
                showCustomToast(MainActivity.this, "Number "+ position + " "+colorList.get(i), 1000);
            }
        });


    }
    private void showCustomToast(Context context, String message, int durationInMillis) {
        final Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);

        // Показать Toast
        toast.show();

        // Используем Handler для настройки времени отображения
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel(); // Отменяем Toast через 1 секунду
            }
        }, durationInMillis);
    }

}