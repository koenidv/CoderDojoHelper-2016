package foflelp.coderdojohelper;

import java.util.Random;

/**
 * Created by koeni on 04.02.2017.
 */

public class Titles {
    private String[] mTitles = {
            "Noch eine, noch eine!",
            "bzrbzrb... We got his data! Oh f* the mic is on!",
            "Los, tu es!",
            "SELBSTZERSTÖRUNG IN 3... 2... 1... Bum.",
            "Schreckliche Antwort... Ich wars nicht!",
            "Wenigstens gibt es da WLAN.",
            "Da bleib ich  ja lieber zuhause...",
            "Och nööö",
            "Tolle Idee!",
            "Jajajajajajajaja das mach ich!!! ... *spielt Minecraft",
            "Definitiv nein.",
            "ICH HAB DICH GEFRAGT WAS ICH  MACHEN SOLL!!! oh, eine antwort...",
            "Da! Eine Antwort!",
            "Diese Idee hätte von mir kommen können...",
            "(Hier könnte ihre Werbung stehen!)"
    };

    public String getTitle() {
        Random randomizer = new Random();
        int r = randomizer.nextInt(mTitles.length);
        return mTitles[r];
    }
}
