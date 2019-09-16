package com.cjd.demo_arithmetic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.cjd.demo_arithmetic.data.BaseSort;
import com.cjd.demo_arithmetic.data.BubbleSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenjidong
 * @data Description:
 **/
public class BubbleSortActivity extends BaseActivity {
    private TextInputLayout tilNumber;
    private EditText etNumber;
    private Button btnSort;
    private int[] arraySort;
    private BubbleSort bubbleSort;
    private ListView lv;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> list;
    private CheckBox cb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);
        tilNumber = findViewById(R.id.til_number);
        etNumber = findViewById(R.id.et_number);
        btnSort = findViewById(R.id.btn_sort);
        lv = findViewById(R.id.lv);
        cb = findViewById(R.id.cb);

        init();
    }

    private void init() {
        etNumber.setText(Constant.arr);
        bubbleSort = new BubbleSort();
        list = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(arrayAdapter);
        bubbleSort.setSortCallbackListener(new BaseSort.OnSortCallbackListener() {
            @Override
            public void onCallback(int[] arr, int count) {
                String value = "第：" + count + " 次遍历：" + bubbleSort.toString(arr);
                list.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFinish(int[] arr) {
                String value = "结果：" + bubbleSort.toString(arr);
                list.add(value);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = etNumber.getText().toString().trim();
                String[] arr = value.split("\\.");
                if (arr.length <= 0) {
                    Toast.makeText(BubbleSortActivity.this, "请输入有效的数字", Toast.LENGTH_SHORT).show();
                    return;
                }
                arraySort = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    arraySort[i] = Integer.valueOf(arr[i].trim());
                }
                sort();
            }
        });
    }

    private void sort() {
        list.clear();
        bubbleSort.bubbleSort(arraySort, cb.isChecked());
    }
}
