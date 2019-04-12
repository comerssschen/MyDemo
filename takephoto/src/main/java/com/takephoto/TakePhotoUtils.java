package com.takephoto;

/**
 * 作者：create by comersss on 2018/12/14 10:55
 * 邮箱：904359289@qq.com
 * 拍照或者从相册获取照片、裁剪等操作工具类
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class TakePhotoUtils {

    /**
     * 拍照
     */
    public static final int TAKE_PHOTO = 100;
    /**
     * 从相册取
     */
    public static final int CHOOSE_PICTURE = 101;

    private static final String FILE_CONTENT_FILEPROVIDER = "tecsun.jx.yt.phone.fileprovider";
    private static TakePhotoUtils mInstance;
    /**
     * 存放照片uri
     */
    public File mImageFile;

    public TakePhotoUtils() {
        // 设置图片路径
        String _imageDir = "temp.jpg";
        mImageFile = new File(Environment.getExternalStorageDirectory(), _imageDir);
    }

    public static TakePhotoUtils getInstance() {
        if (mInstance == null) {
            mInstance = new TakePhotoUtils();
        }

        return mInstance;
    }

    /**
     * 通过uri生成Bitmap
     *
     * @param context
     * @param uri
     * @return
     */
    public Bitmap decodeUriAsBitmap(Context context, Uri uri) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }

    /**
     * 拍照 TAKE_PHOTO
     */
    public void takePhoto(Context context) {
        takePhoto(context, TAKE_PHOTO);
    }

    /**
     * 拍照 TAKE_PHOTO
     */
    public void takePhoto(Context context, int requestCode) {
        PermissionUtils.permission(PermissionConstants.CAMERA).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {
            }

            @Override
            public void onDenied() {
                ToastUtils.showShort("请授权");
                return;
            }

        }).request();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  // "android.media.action.IMAGE_CAPTURE"
        intent.addCategory("android.intent.category.DEFAULT");
        //Android7.0以上URI
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            //通过FileProvider创建一个content类型的Uri
            Uri uri = FileProvider.getUriForFile(context, FILE_CONTENT_FILEPROVIDER, mImageFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mImageFile));
        }
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    /**
     * 拍照
     */
    public void takePhoto(Fragment fragment) {
        PermissionUtils.permission(PermissionConstants.CAMERA).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {
            }

            @Override
            public void onDenied() {
                ToastUtils.showShort("请授权");
                return;
            }

        }).request();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  // "android.media.action.IMAGE_CAPTURE"
        intent.addCategory("android.intent.category.DEFAULT");
        //Android7.0以上URI
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            //通过FileProvider创建一个content类型的Uri
            Uri uri = FileProvider.getUriForFile(fragment.getContext(), FILE_CONTENT_FILEPROVIDER, mImageFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mImageFile));
        }
        fragment.startActivityForResult(intent, TAKE_PHOTO);
    }


    /**
     * 从相册获取
     */
    public void pickPhoto(Context context, int requestCode) {
        PermissionUtils.permission(PermissionConstants.STORAGE).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {
            }

            @Override
            public void onDenied() {
                ToastUtils.showShort("请授权");
                return;
            }

        }).request();
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        // 开启一个带有返回值的Activity，请求码为PHOTO_ZOOM
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    /**
     * 从相册获取
     */
    public void pickPhoto(Context context) {
        pickPhoto(context, CHOOSE_PICTURE);
    }

    /**
     * 从相册获取
     */
    public void pickPhoto(Fragment fragment) {
        PermissionUtils.permission(PermissionConstants.STORAGE).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {
            }

            @Override
            public void onDenied() {
                ToastUtils.showShort("请授权");
                return;
            }

        }).request();
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        // 开启一个带有返回值的Activity，请求码为PHOTO_ZOOM
        fragment.startActivityForResult(intent, CHOOSE_PICTURE);
    }

}
