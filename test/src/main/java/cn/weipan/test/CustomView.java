package cn.weipan.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：Created by cc on 2016/11/22 13:58.
 * 邮箱：904359289@QQ.com.
 * 类 ：
 */
public class CustomView extends View {

    private Paint paint;
    private Context mContext;
    private float radiu;//圆环半径

    public CustomView(Context context) {
        super(context);
        mContext = context;
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        //实例化画笔并打开抗锯齿
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        /*
     * 画笔样式分三种：
     * 1.Paint.Style.STROKE：描边
     * 2.Paint.Style.FILL_AND_STROKE：描边并填充
     * 3.Paint.Style.FILL：填充
     */
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.argb(255,255,128,103));//设置线条颜色
        paint.setStrokeWidth(10);//设置线条宽度

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, paint);
    }

//    @Override
//    public void run() {
//        while (true){
//            if (radiu<=200){
//                radiu +=10;
////                invalidate();//重绘
//                postInvalidate();//子线程重绘
//            }else {
//                radiu = 0;
//            }
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
