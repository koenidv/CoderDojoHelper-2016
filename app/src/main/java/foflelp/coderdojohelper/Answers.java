package foflelp.coderdojohelper;

import java.util.Random;

/**
 * Created by koeni on 04.02.2017.
 *
 */

class Answers {
    private String[] mAnswers = {
            "Mainkraft spielen (Nicht Minecraft!)",
            "In Java programmieren",
            "Schlaf nachholen",
            "Diese App deinstallieren",
            "Erklären, dass HTML keine Programmiersprache ist",
            "Windows verteufeln",
            "3D-Drucker in 3D drucken",
            "Nach Schraubendrehern suchen",
            "Auf das Essen warten",
            "Nokia-Handys gegen die Wand schmeißen",
            "Feinstaubsensoren in einen 15 Jahre alten PC legen",
            "3D-Druckfilament klauen",
            "Adobe CC cracken... oder es versuchen.",
            "Mehr von diesen Antworten schreiben",
            "Den AUX-Stecker weglassen",
            "Alles USB-C-ifieren",
            "Monitore schenken lassen",
            "Die Mehrsteckerleisten anderer ausschalten",
            "Lachen. Einfach nur lachen. Zwei Stunden lang lachen.",
            "Benjamin mit Fragen bombardieren",
            "Auf den Knopf da unten drücken",
            "Den Server zum Abstürzen bringen",
            "iOS auslachen, weil darauf diese App nicht läuft",
            "Hoffen, dass die Eltern Verspätung haben",
            "Ragequitten",
            "In 4D drucken",
            "So tun, als ob man etwas sinnvolles tun würde",
            "Windoof löschen",
            "Philosophieren",
            "Threema kaufen",
            "Für MinekensTV werben",
            "Die Mojang-Server blockieren",
            "Tischkicker spielen. Gegen einen Arduino",
            "Ein TTS-Programm erstellen",
            "Für die nächsten 10 Dojos anmelden",
            "Papierkugeln werfen",
            "Einen Fake-Virus schreiben",
            "Einen Server aufsetzen",
            "Nach Sicherheitslücken suchen",
            "Unnötige Sachen in die CoderDojo-Gruppe schreiben",
            "Über Hr. Wendel lästern",
            "In FreeCAD puzzeln"
    };

    String getAnswer() {
        Random randomizer = new Random();
        int r = randomizer.nextInt(mAnswers.length);
        return mAnswers[r];
    }
}
