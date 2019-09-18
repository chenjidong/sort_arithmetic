package com.cjd.demo_arithmetic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjd.demo_arithmetic.data.BaseSort;
import com.cjd.demo_arithmetic.data.BubbleSort;
import com.cjd.demo_arithmetic.data.BucketSort;
import com.cjd.demo_arithmetic.data.CountSort;
import com.cjd.demo_arithmetic.data.InsertionSort;
import com.cjd.demo_arithmetic.data.MergeSort;
import com.cjd.demo_arithmetic.data.QuickSort;
import com.cjd.demo_arithmetic.data.SelectionSort;
import com.cjd.demo_arithmetic.data.ShellSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenjidong
 * @data Description:
 * @link{https://mp.weixin.qq.com/s/xSm4Gutudq1VdKuXGFoDMg}
 **/
public class SortActivity extends BaseActivity {
    private TextInputLayout tilNumber;
    private EditText etNumber;
    private Button btnSort;
    private int[] arraySort;
    private BaseSort baseSort;
    private ListView lv;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> list;
    private String sort;
    private TextView tvDesc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);
        tilNumber = findViewById(R.id.til_number);
        etNumber = findViewById(R.id.et_number);
        btnSort = findViewById(R.id.btn_sort);
        lv = findViewById(R.id.lv);
        tvDesc = findViewById(R.id.tv_desc);


        init();
    }

    private void init() {

        sort = getIntent().getStringExtra("sort");

        if (TextUtils.equals("bubble", sort)) {
            baseSort = new BubbleSort();
        } else if (TextUtils.equals("selection", sort)) {
            baseSort = new SelectionSort();
        } else if (TextUtils.equals("insertion", sort)) {
            baseSort = new InsertionSort();
        } else if (TextUtils.equals("shell", sort)) {
            baseSort = new ShellSort();
        } else if (TextUtils.equals("merge", sort)) {
            baseSort = new MergeSort();
        } else if (TextUtils.equals("quick", sort)) {
            baseSort = new QuickSort();
        } else if (TextUtils.equals("count", sort)) {
            baseSort = new CountSort();
        } else if (TextUtils.equals("bucket", sort)) {
            baseSort = new BucketSort();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(baseSort.title());
        }
        tvDesc.setText(baseSort.desc());
        etNumber.setText(Constant.arr);

        list = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(arrayAdapter);
        baseSort.setSortCallbackListener(new BaseSort.OnSortCallbackListener() {
            @Override
            public void onCallback(int[] arr, int count) {
                String value = "第:" + count + "次遍历:" + baseSort.toString(arr);
                list.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFinish(int[] arr) {
                String value = "结果:" + baseSort.toString(arr);
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
                    Toast.makeText(SortActivity.this, "请输入有效的数字", Toast.LENGTH_SHORT).show();
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
        baseSort.sort(arraySort);
    }
}
