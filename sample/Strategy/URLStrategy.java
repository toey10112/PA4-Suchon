package sample.Strategy;

import sample.Readability;

import java.net.URL;
import java.util.Scanner;

/**
 * Strategy read file from URL
 */
public class URLStrategy implements ReadFileStrategy {

    @Override
    public String readFile(String fileName) {
        Readability readability = new Readability();
       try{ URL url = new URL(fileName);
           Scanner s = new Scanner(url.openStream());
           while(s.hasNextLine()){
               String read = s.nextLine().strip();
               readability.readFile(read);

           }
           readability.calFleschIndexAndReadAbility();


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
