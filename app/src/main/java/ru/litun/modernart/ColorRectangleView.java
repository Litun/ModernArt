package ru.litun.modernart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Litun on 23.07.2015.
 */
public class ColorRectangleView extends View {
    //private final Paint paint = new Paint();
    //PaintDrawable drawable = new PaintDrawable();
    private final MyColor currentColor = new MyColor();

    public ColorRectangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorRectangleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ColorRectangleView(Context context) {
        super(context);
        init();
    }

    private void init() {
        //paint.setColor(getContext().getResources().getColor(R.color.primary));
        currentColor.setColor(getContext().getResources().getColor(R.color.primary));
    }

    public void setColors(int from, int to) {
        currentColor.setColors(from, to);
    }

    public void updateColor(int progress) {
        currentColor.proportionChanges(progress);
//        refreshDrawableState();
//        drawableStateChanged();
        postInvalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(currentColor.getCurrentColor());
        //Rect rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        //drawable.draw(canvas);
        canvas.restore();
    }

}