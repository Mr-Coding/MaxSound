package com.frank.maxsound.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class WidgetBackground extends View {
    public WidgetBackground(Context context) {    super(context); }
    public WidgetBackground(Context context, AttributeSet attrs) {  super(context, attrs);  }

    private int color = Color.GRAY;

    public void setColor(int color){
        this.color = color;
        requestLayout();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);

        RectF r1=new RectF(); //RectF对象  
        r1.left=8;   //左边  
        r1.top=8;   //上边  
        r1.right=getWidth()-8; //右边
        r1.bottom=getHeight()-8;//下边
        canvas.drawRoundRect(r1,20,20,paint);
    }
}
