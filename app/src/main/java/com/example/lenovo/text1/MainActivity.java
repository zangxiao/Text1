package com.example.lenovo.text1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private static final String NAME = "name";
    private static final String SEX = "sex";
    private static final String CLASS = "detail";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (ListView) findViewById(R.id.list_test);
        String[] array = new String[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + "";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_list, array);

        int size = 10;
        String[] names = new String[size];
        String[] sexs = new String[size];
        String[] classes = new String[size];
        List<Map<String, String>> items = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            names[i] = NAME + i;
            sexs[i] = SEX + i;
            classes[i] = CLASS + i ;

            HashMap<String, String> map = new HashMap<>();
            map.put(NAME, names[i]);
            map.put(SEX, sexs[i]);
            map.put(CLASS, classes[i]);

            items.add(map);
        }

        SimpleAdapter adapter1 = new SimpleAdapter(this,
                items,
                R.layout.item_detail,
                new String[]{NAME, SEX, CLASS},
                new int[]{R.id.stu_name, R.id.stu_sex, R.id.stu_class}
        );
        list.setAdapter(adapter1);
    }
}
