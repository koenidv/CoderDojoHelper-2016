package foflelp.coderdojohelper;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by koeni on 04.02.2017.
 *
 */

public class Colors {
    private String[] mColors = {
                "#3079ab",
                "#f9845b",
                "#838cc7",
                "#53bbb4",
                "#51b46d",
                "#e0ab18"
    };

    public int getColor() {
        Random randomizer = new Random();
        int r = randomizer.nextInt(mColors.length);
        //noinspection UnnecessaryLocalVariable
        int colorAsInt = Color.parseColor(mColors[r]);
        return colorAsInt;
    }
}
