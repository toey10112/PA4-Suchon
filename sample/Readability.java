package sample;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Readability
 */
public class Readability {
    private int syllables = 0;
    private int words = 0;
    private int sentence = 0;
    private double fleschIndex = 0;
    private String readAbility;

    /**
     * Count syllable from text.
     * @param text text.
     * @return number of syllable.
     */

    public static int countSyllables(String text) {
        final Pattern p = Pattern.compile("([ayeiou]+)");
        final String lowerCase = text.toLowerCase();
        final Matcher m = p.matcher(lowerCase);
        int count = 0;
        while (m.find())
            count++;
        if (lowerCase.endsWith("e"))
            count--;
        return count < 0 ? 1 : count;
    }

    /**
     * Count word from text.
     * @param text text.
     * @return number of word.
     */

    private static int countWord(String text){
        int count = 0;
        String[] word = text.split(" ");
        for (String i:word){
            if ((!i.isBlank()||!i.isEmpty())){
                count++;

            }
        }return count;




    }

    /**
     * Count sentence from text
     * @param text text
     * @return number of sentence
     */

    private static  int countSentence(String text){

        int count = text.split("[!?.,]+ ").length;
        return count;


    }

    /**
     * calculate flesch index.
     * @return flesch index
     */

    private  double calFleschIndex(){
        double number = 206.835 - 84.6*(syllables/words) - 1.015*(words/sentence);
        return number;
    }

    /**
     * read file
     * @param read file name
     *
     */

    public  void readFile(String read) throws IOException {
           sentence  += countSentence(read);
            words += countWord(read);
            syllables += countSyllables(read);

        }
        public void calFleschIndexAndReadAbility(){
        fleschIndex = calFleschIndex();
        calReadAbility();
        }


    /**
     * calculate readability from flesch index
     */

    private void calReadAbility(){
        if (fleschIndex >100)
            readAbility = "4th grade student (elementary school)";
            else if (fleschIndex>90)
                readAbility = "5th grade student";
            else if (fleschIndex>80) readAbility = "6th grade student";
            else if (fleschIndex>70) readAbility = "7th grade student";
            else if (fleschIndex>65) readAbility = "8th grade student";
            else if (fleschIndex >60 ) readAbility = "9th grade student";
            else if (fleschIndex>50) readAbility = "High school student";
            else if (fleschIndex> 30) readAbility = "College student";
            else if (fleschIndex>0) readAbility = "College graduate";
            else readAbility = "Advanced degree graduate";
        }


    /**
     * get readability
     * @return readability
     */
    public String getReadAbility() {
        return readAbility;
    }

    /**
     * get number of syllables
     * @return number of syllables
     */

    public int getSyllables() {
        return syllables;
    }

    /**
     * get sentence
     * @return number of sentence
     */
    public int getSentence() {
        return sentence;
    }

    /**
     * get flesch index
     * @return number of flesch index
     */
    public double getFleschIndex() {
        return fleschIndex;
    }

    /**
     * get number of word
     * @return number of words
     */

    public int getWords() {
        return words;
    }




}
