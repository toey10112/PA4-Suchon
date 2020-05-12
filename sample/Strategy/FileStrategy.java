package sample.Strategy;

import sample.Readability;

import java.io.File;
import java.util.Scanner;

/**
 * Strategy read file from File
 */

public class FileStrategy implements ReadFileStrategy {
    @Override
    public String readFile(String fileName) {
        Readability readability = new Readability();
        try{
            File file = new File(fileName);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()){
                String read = s.nextLine();
                readability.readFile(read);

            }readability.calFleschIndexAndReadAbility();
//

        }catch (Exception e){
            System.out.println(e);
        }
        return String.format("Filename: " + fileName
                +"\n" +"Number of Syllables: "+ readability.getSyllables()+ "\n"
                +"Number of words: " + readability.getWords() + "\n"
                +"Number of Sentence: "+readability.getSentence()+"\n"
                +"Flesch Index: "+readability.getFleschIndex()+"\n"
                +"Readability: " + readability.getReadAbility());
    }
}
