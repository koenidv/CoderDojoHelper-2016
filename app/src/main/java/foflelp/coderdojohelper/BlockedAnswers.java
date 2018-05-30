package foflelp.coderdojohelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koeni on 13.02.2017.
 */

public class BlockedAnswers {
    ArrayList<String> BlockedAnswers = new ArrayList<String>();

    public void blockAnswer(String Answer) {
        BlockedAnswers.add(Answer);
    }
    public boolean blockedAnswersContains(String Answer) {
        return BlockedAnswers.contains(Answer);
    }
}
