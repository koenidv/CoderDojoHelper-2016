package foflelp.coderdojohelper; //Das Paket festlegen
/*
Alle benötigten Bibliotheken importieren
 */

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    /*
    Variablen definieren
    LastAnswer: Die verherige Antwort
    LastTitle: Der vorherige Titel
    ActiveColor: Hauptfarbe (Hintergrund, Farbe des Textes auf einem Button)
    AccentColor: Akzentfarbe (Textfarbe, Hintergrund der Buttons)
    LastActiveColor: Die vorherige verwendete Hauptfarbe
    LastAccentColor: Die vorherige verwendete Akzentfarbe
    PassNumber: Nummer des Durchlaufs, damit bei der ersten Antwort 'mBackButton' nicht angezeigt wird
    LastSwState: Der vorherige Zustand des Farbschalters

     */
    private String mLastAnswer; //Den String 'mLastAnswer' erstellen
    private String mLastTitle; //Den String 'mLastTitle' erstellen
    private int mActiveColor; //Den Integer 'mActiveColor' erstellen
    private int mAccentColor; //Den Integer 'mAccentColor' erstellen
    private int mLastActiveColor; //Den Integer 'mLastActiveColor' erstellen
    private int mLastAccentColor; //Den Integer 'mLastAccentColor' erstellen
    private int mPassNumber; //Den Integer 'mPassNumber' erstellen
    private boolean mLastSwState; //Den Boolean 'mLastSwState' erstellen
    private boolean mUpdateLast = false; //Den Boolean 'mUpdateLast' erstellen und auf Falsch setzen
    /*
    Die anderen Klassen festlegen
    Answers: Gibt den Text für mAnswerTextView
    Colors: Gibt eine zufällige Farbe, die in setColor, setColorSw und setColorAccent genutzt werden
    Titles: Gibt den Text für mTitleTextView
    BlockedAnswers: Speichert blockierte Antworten
     */
    private Answers mAnswers = new Answers(); //Die Klasse 'Ansers' als 'mAnswers' definieren
    private Colors mColors = new Colors(); //Die Klasse 'Colors' als 'mColors' definieren
    private Titles mTitles = new Titles(); //Die Klasse 'Titles' als 'mTitles' definieren
    //Wollte ich machen, habe ich aber nicht.
    //private BlockedAnswers mBlockedAnswers = new BlockedAnswers();
    /*
    Die Elemte aus activity_main.xml
    TitleTextView: Der Titel
    AnswerTextView: Die Antwort
    BackIconTextView: Button für "Zurück"
    QuestionButton: Button, um eine neue Antwort Antwort, Farbe und einen Titel zu bekommen @listener @longListener
    NewColorButton: Button, um nur eine neue Akzentfarbe zu bekommen (reColorAccent) @ncListener
    SwToggleButton: ToggleButton - EIN: Farben sind aktiv AUS: Schwarz/Weiß (+ reColorAccent = Weißer Hintergrund, farbige Akzente) @SwListener
    RelativeLayout: Die Main Activity
     */
    private TextView mTitleTextView; //Einen neuen TextView 'mTitleTextView' erstellen
    private TextView mAnswerTextView; //Einen neuen TextView 'mAnswerTextview' erstellen
    private Button mBackButton; //Einen neuen Button 'mBackButton' erstellen
    private Button mQuestionButton; //Einen neuen Button 'mQuestionButton' erstellen
    private Button mNewColorButton; //Einen neuen Button 'mAnswerButton' erstellen
    private ToggleButton mSwToggleButton; //Einen neuen ToggleButton 'mSwToggleButton' erstellen
    private RelativeLayout mRelativeLayout; //Ein neues RelativeLayout erstellen

    private void reColor() { //Funktion um allen Elementen eine neue Farbe zu geben
        /*
        Farben erstellen, es sollen nicht die gleichen Farben wie das letzte Mal,
        und bei der Akzentfarbe nicht die gleiche wie die Hauptfarbe sein.
         */
        while (mActiveColor == mLastActiveColor) { //Während die Hauptfarbe den gleichen Wert wie die vorherige Hauptfarbe hat...
            mActiveColor = mColors.getColor(); //wird von der Klasse Colors.java eine neue generiert
        }

        while (mAccentColor == mActiveColor || mAccentColor == mLastAccentColor) { //Während die Akzentfarbe den gleichen Wert wie die jeztige Hauptfarbe oder die vorherige Akzentfarbe hat...
            mAccentColor = mColors.getColor(); //wird von der Klasse Colors.java eine neue generiert
        }

        /*
        Die beiden Farben anwenden
         */
        mRelativeLayout.setBackgroundColor(mActiveColor);
        mQuestionButton.setTextColor(mActiveColor);
        mNewColorButton.setTextColor(mActiveColor);
        mSwToggleButton.setTextColor(mActiveColor);
        mBackButton.setBackgroundColor(mActiveColor);
        mAnswerTextView.setTextColor(mAccentColor);
        mQuestionButton.setBackgroundColor(mAccentColor);
        mTitleTextView.setTextColor(mAccentColor);
        mNewColorButton.setBackgroundColor(mAccentColor);
        mSwToggleButton.setBackgroundColor(mAccentColor);
        mBackButton.setTextColor(mAccentColor);
        /*
        Sicherstellen, dass der Farbschalter auf EIN steht
        */
        mSwToggleButton.setChecked(true); //'mSwToggleButton' auf AN setzen
    }

    private void reColorSw() { //Um alle Elemte Schwarz, bzw. Weiß sein zu lassen
        String tmpcblck = "black"; //Temporär, um "tmpc" zu parsen
        int tmpc = Color.parseColor(tmpcblck); //'black' sollte zu -16777216 werden

        mActiveColor = -1; //Hauptfarbe ist -1; Weiß
        mAccentColor = -16777216; //Akzentfarbe ist -16777216; Schwarz
        /*
        Die Farben werden angewandt
         */
        mRelativeLayout.setBackgroundColor(-1);
        mQuestionButton.setTextColor(-1);
        mNewColorButton.setTextColor(-1);
        mSwToggleButton.setTextColor(-1);
        mBackButton.setBackgroundColor(-1);
        mAnswerTextView.setTextColor(tmpc);
        mQuestionButton.setBackgroundColor(tmpc);
        mTitleTextView.setTextColor(tmpc);
        mNewColorButton.setBackgroundColor(tmpc);
        mSwToggleButton.setBackgroundColor(tmpc);
        mBackButton.setTextColor(tmpc);
        /*
        Sicherstellen, dass der Farbschalter aus ist
         */
        mSwToggleButton.setChecked(false); //'mSwToggleButton auf AUS setzen
    }

    private void reColorAccent() { //Um nur allen Elementen, die die Akzentfarbe nutzen eine neue farbe zu geben
        /*
        Eine neue Akzentfarbe, die nicht den gleichen Wert wie die aktive Hauptfarbe oder die letzte Akzentfarbe hat, wird erstellt
         */
        mAccentColor = mColors.getColor(); // Eine Farbe setzen; das wird beim ersten Aufruf der Funktion benötigt
        while (mAccentColor == mActiveColor || mAccentColor == mLastAccentColor) { //Während die Akzentfarbe den gleichen Wert wie die jeztige Hauptfarbe oder die vorherige Akzentfarbe hat...
            mAccentColor = mColors.getColor(); //wird von der Klasse Colors.java eine neue generiert
        }
        /*
        Diese Farbe wird auf die Elemente angewandt
         */
        mAnswerTextView.setTextColor(mAccentColor);
        mQuestionButton.setBackgroundColor(mAccentColor);
        mTitleTextView.setTextColor(mAccentColor);
        mNewColorButton.setBackgroundColor(mAccentColor);
        mSwToggleButton.setBackgroundColor(mAccentColor);
        mBackButton.setTextColor(mAccentColor);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main aufgerufen (angezeigt)
        /*
        Die oben definierten Elemte mit denen aus activity_main.xml verbinden
         */
        mBackButton = findViewById(R.id.BackIconTextView);
        mTitleTextView = findViewById(R.id.titleTextView);
        mAnswerTextView = findViewById(R.id.answerTextView);
        mQuestionButton = findViewById(R.id.questionButton);
        mNewColorButton = findViewById(R.id.newcolorButton);
        mSwToggleButton = findViewById(R.id.swToggleButton);
        mRelativeLayout = findViewById(R.id.activity_main);
        /*
        Die Startfarben geben
         */
        reColorAccent(); //Die Elemte, die die Akzentfarben nutzen neu einfärben
        mSwToggleButton.setChecked(false); //Am Anfang ist die Hauptfarbe aus, bzw. Weiß und der Hintergrund Grau
        mBackButton.setVisibility(View.INVISIBLE);

        /*
        FontAwesome als Schriftart setzen
         */
        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf"); //Die Variable 'font' erstellen und mit FontAwesome ('fontawesome-webfont.ttf') belegen
        mBackButton.setTypeface(font); //'mBackButton' mit der Schriftart FontAwesome versehen, damit das Icon korrekt dargestellt wird


        View.OnClickListener listener = new View.OnClickListener() { //Einen neuen onClickListener erstellen
            /*
            Dieser soll nach einem Klick auf 'mQuestionButton'...
            ...falls 'mBackButton' sichtbar ist:
                Den aktuellen Titel in 'mLastTitle' schreiben
                Die aktuelle Anwtort in 'mLastAnswer' schreiben
                Die aktive Hauptfarbe in 'mLastActiveColor' schreiben
                Die Aktive Akzentfarbe in 'mLastAccentColor' schreiben
                Den Status des Farbschalters in 'mLastSwState' schreiben

            danach, und falls 'mBackButton' nicht sichtbar ist
                'mBackButton' sichtbar machen, da es das möglicherweise nicht ist, beim nächsten Durchlauf aber sein soll, sofern nicht wieder "Zurück" ausgeführt wird
                Eine neue Antwort erzeugen, die der jetzigen nicht identisch ist
                Einen neuen Titel erzeugen, der dem jetzigen nicht identisch ist
                Diese Texte anwenden
                Falls der Farbschalter auf AN steht, alles neu einfärben, (reColor)
                    falls selbiger auf AUS steht und die Akzentfarbe schwarz ist nichts tun,
                    und falls ersteres zutrifft, letzeres jedoch nicht die Akzentfarbe neu definieren (reColorAccents)

             Warum?: Die aktuellen Eigenschaften wie Antwort, farbe, etc. werden in den mLast...-Variablen gespeichert und neue Eigenschaften generiert.
                Es wird 'mBackButton' angeklickt, die vorherigen Eigenschaften aus diesen Variablen "geladen", die Farben jedoch nicht in die "aktiven" Variablen gespeichert.
                'mBackButton' ist dann nicht mehr sichtbar. Damit die Eigenschaften vor der Wiederherstellung aus den Variablen nicht gespeichert wird,
                werden diese nur abgespeichert, wenn 'mBackButton' sichtbar ist, es also nicht direkt zuvor angeklickt wurde. #brnfq
             Alternative Lösung: Einfach bei der Wiederherstellung die aktuellen Farben in die "aktiv-Variablen" speichern! (Nach einem SEHR kurzen Test scheint es doch nicht zu funktionieren)
                Aber warum sollte man es sich leicht machen, wenn es auch kompliziert geht?!
             */
            @Override
            public void onClick(View v) {

                if (mUpdateLast) { //Falls 'mBackButton' sichtbar ist... (Wahr == (Wahr == Wahr))
                    mLastTitle = mTitleTextView.getText().toString(); //wird 'mLastTitle' auf den aktuellen Text von 'mTitleTextView',
                    mLastAnswer = mAnswerTextView.getText().toString(); //'mLastAnswer' auf den aktuellen Text von 'mAnswerTextView',
                    mLastActiveColor = mActiveColor; //'mLastActiveColor' auf die aktive Hauptfarbe ('mActiveColor'),
                    mLastAccentColor = mAccentColor; //'mLastAccentColor' auf die aktive Akzentfarbe (mAccentColor)
                    mLastSwState = mSwToggleButton.isChecked(); //und 'mLastSwState' auf den aktuellen Zustand des Farbschalters ('mSwToggleButton') gesetzt.
                }   //Die if-Anweisung beenden

                if (mPassNumber > 0) {
                    mBackButton.setVisibility(View.VISIBLE); //'mBackButton' sichtbar machen
                }

                mUpdateLast = true;
                mPassNumber++;

                String mNewAnswer = mAnswers.getAnswer();
                while (mNewAnswer.equals(mLastAnswer)) { //.equals vergleicht den Inhalt des Strings, == die Herkunft
                    mNewAnswer = mAnswers.getAnswer();
                }

                String mNewTitle = mTitles.getTitle();
                while (mNewTitle.equals(mLastTitle)) {
                    mNewTitle = mTitles.getTitle();
                }

                mAnswerTextView.setText(mNewAnswer);
                mTitleTextView.setText(mNewTitle);

                if (mSwToggleButton.isChecked()) {
                    reColor();
                } else if (mAccentColor != -16777216) {
                    reColorAccent();
                }
            }
        };
        mQuestionButton.setOnClickListener(listener);

        View.OnClickListener ncListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reColorAccent();
            }
        };
        mNewColorButton.setOnClickListener(ncListener);

        View.OnClickListener swListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSwToggleButton.isChecked()) {
                    reColor();
                } else {
                    reColorSw();
                }
            }
        };
        mSwToggleButton.setOnClickListener(swListener);

        View.OnClickListener backListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwToggleButton.setChecked(mLastSwState);

                mTitleTextView.setText(mLastTitle);
                mAnswerTextView.setText(mLastAnswer);

                if (mLastActiveColor != 0) { //Falls 'mlastActiveColor' nicht 0 ist...
                    mRelativeLayout.setBackgroundColor(mLastActiveColor);
                    mQuestionButton.setTextColor(mLastActiveColor);
                    mNewColorButton.setTextColor(mLastActiveColor);
                    mSwToggleButton.setTextColor(mLastActiveColor);
                }
                if (mLastAccentColor != 0) { //Falls 'mlastAccentColor' nicht 0 ist...
                    mAnswerTextView.setTextColor(mLastAccentColor);
                    mQuestionButton.setBackgroundColor(mLastAccentColor);
                    mTitleTextView.setTextColor(mLastAccentColor);
                    mNewColorButton.setBackgroundColor(mLastAccentColor);
                    mSwToggleButton.setBackgroundColor(mLastAccentColor);
                    mBackButton.setTextColor(mLastAccentColor);
                }

                mBackButton.setVisibility(View.INVISIBLE);
                mUpdateLast = false;
            }
        };
        mBackButton.setOnClickListener(backListener);

        View.OnLongClickListener longListener = new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) { //Dies ist ein Easteregg. Wenn man gedrückt hält...
                mTitleTextView.setText("Osterei!"); // Wird der Text von 'mTitleTextView' auf "Osterei!",
                mAnswerTextView.setText(""); //und der von 'mAnswerTextView' auf "" gesetzt (Also praktisch geleert)
                return (true); //Wenn man den Button loslässt, bleibt das ganze trotzdem in diesem Zusatnd
            }
        };
        mQuestionButton.setOnLongClickListener(longListener); // 'longListener' wird 'mQuestionButton' zugeordnet
    }
}