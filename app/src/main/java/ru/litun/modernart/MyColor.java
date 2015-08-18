package ru.litun.modernart;

import android.graphics.Color;

/**
 * Created by Litun on 23.07.2015.
 */
public class MyColor {
    private int from;
    private int to;
    private int currentColor;

    private final byte ALPHA_CHANNEL = 24;
    private final byte RED_CHANNEL = 16;
    private final byte GREEN_CHANNEL = 8;
    private final byte BLUE_CHANNEL = 0;


    public void proportionChanges(int proportion) {
        float amount = (float) proportion / 100;
//        final float inverseAmount = 1.0f - amount;
//
//        int a = ((int) (((float) (from >> ALPHA_CHANNEL & 0xff) * amount) +
//                ((float) (to >> ALPHA_CHANNEL & 0xff) * inverseAmount))) & 0xff;
//        int r = ((int) (((float) (from >> RED_CHANNEL & 0xff) * amount) +
//                ((float) (to >> RED_CHANNEL & 0xff) * inverseAmount))) & 0xff;
//        int g = ((int) (((float) (from >> GREEN_CHANNEL & 0xff) * amount) +
//                ((float) (to >> GREEN_CHANNEL & 0xff) * inverseAmount))) & 0xff;
//        int b = ((int) (((float) (from & 0xff) * amount) +
//                ((float) (to & 0xff) * inverseAmount))) & 0xff;
//
//        currentColor = a << ALPHA_CHANNEL | r << RED_CHANNEL | g << GREEN_CHANNEL | b << BLUE_CHANNEL;
        currentColor = blendColors(to, from, amount);
        //currentColor = proportion > 50 ? to : from;
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
