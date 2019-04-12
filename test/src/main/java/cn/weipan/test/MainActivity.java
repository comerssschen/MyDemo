package cn.weipan.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CustomView customView = (CustomView) findViewById(R.id.main_cv);
//        new Thread(customView).start();


    }

    public void siy(View view) {
        startActivity(new Intent(MainActivity.this, RiLiActivity.class));
    }

    public void siyi(View view) {
        startActivity(new Intent(MainActivity.this, SiActivity.class));
    }
    public void siyifu(View view) {
        startActivity(new Intent(MainActivity.this, SiYiFuActivity.class));
    }
    public void siyifua(View view) {
        startActivity(new Intent(MainActivity.this, WanActivity.class));
    }
    public void showToast(String test) {
        toast = Toast.makeText(MainActivity.this, test, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
