package cn.weipan.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;

/**
 * 作者：Created by cc on 2016/11/22 15:50.
 * 邮箱：904359289@QQ.com.
 * 类 ：
 */
public class RiLiActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rili);
        DatePicker datePicker = (DatePicker) findViewById(R.id.picker);

        datePicker.setDate(2016, 11);
        datePicker.setMode(DPMode.SINGLE);
        datePicker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                Toast.makeText(RiLiActivity.this, date, Toast.LENGTH_LONG).show();
            }
        });

//        datePicker.setMode(DPMode.MULTIPLE);
//        datePicker.setDate(2016, 11);
//        datePicker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(List<String> date) {
//                String result = "";
//                Iterator iterator = date.iterator();
//                while (iterator.hasNext()) {
//                    result += iterator.next();
//                    if (iterator.hasNext()) {
//                        result += "\n";
//                    }
//                }
//                Toast.makeText(RiLiActivity.this, result, Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
