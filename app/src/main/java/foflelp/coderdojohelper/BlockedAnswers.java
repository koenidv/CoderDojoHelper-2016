package foflelp.coderdojohelper;

import java.util.ArrayList;

/**
 * Created by koeni on 13.02.2017.
 * Wollte ich einführen, habe ich aber nicht.
 *
 */

@SuppressWarnings("unused")
public class BlockedAnswers {
    private ArrayList<String> BlockedAnswers = new ArrayList<>();

    public void blockAnswer(String Answer) {
        BlockedAnswers.add(Answer);
    }
    public boolean blockedAnswersContains(String Answer) {
        return BlockedAnswers.contains(Answer);
    }
}
