package com.takephoto;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("照相机");
                builder.setTitle("提示");
                builder.setPositiveButton("拍照", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        TakePhotoUtils.getInstance().takePhoto(MainActivity.this);
                    }
                });

                builder.setNegativeButton("相册", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        TakePhotoUtils.getInstance().pickPhoto(MainActivity.this);
                        dialog.dismiss();
                    }
                });
                builder.create().show();


            }
        });

    }


    @Override
    public void onActivityResult(int pRequestCode, int pResultCode, Intent pData) {
        if (pResultCode == Activity.RESULT_OK) {
            switch (pRequestCode) {
                // 从相册取
                case TakePhotoUtils.CHOOSE_PICTURE:
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(pData.getData()));
                        image.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    break;

                case TakePhotoUtils.TAKE_PHOTO:
                    // 剪大图用uri
                    if (TakePhotoUtils.getInstance().mImageFile != null) {
                        Bitmap bitmap = TakePhotoUtils.getInstance().decodeUriAsBitmap(MainActivity.this, Uri.fromFile
                                (TakePhotoUtils.getInstance().mImageFile));
                        image.setImageBitmap(bitmap);
                    }

                    break;

            }
        }
        super.onActivityResult(pRequestCode, pResultCode, pData);
    }
}
