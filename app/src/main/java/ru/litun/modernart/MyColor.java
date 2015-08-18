package ru.litun.modernart;

import android.graphics.Color;

/**
 * Created by Litun on 23.07.2015.
 */
public class MyColor {
    private int from;
    private int to;
    private int currentColor;

    public void proportionChanges(int proportion) {
        float amount = (float) proportion / 100;
        currentColor = blendColors(to, from, amount);
    }

    private int blendColors(int color1, int color2, float ratio) {
        final float inverseRation = 1f - ratio;
        float r = (Color.red(color1) * ratio) + (Color.red(color2) * inverseRation);
        float g = (Color.green(color1) * ratio) + (Color.green(color2) * inverseRation);
        float b = (Color.blue(color1) * ratio) + (Color.blue(color2) * inverseRation);
        return Color.rgb((int) r, (int) g, (int) b);
    }

    public void setColors(int from, int to) {
        this.from = from;
        this.to = to;
        currentColor = from;
    }

    public void setColor(int color) {
        this.from = color;
        this.to = color;
        currentColor = color;
    }

    public int getCurrentColor() {
        return currentColor;
    }
}
