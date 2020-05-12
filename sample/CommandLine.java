package sample;

import sample.Strategy.FileStrategy;
import sample.Strategy.ReadFileStrategy;
import sample.Strategy.URLStrategy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Run application from command line.
 */
public class CommandLine {
    public ReadFileStrategy readFileStrategy;

    /**
     * set Strategy
     * @param readFileStrategy
     */
    public void setReadFileStrategy(ReadFileStrategy readFileStrategy) {
        this.readFileStrategy = readFileStrategy;
    }

    /**
     * Run appliction from command line
     * @param args text from command line
     */
    public void readFromCommandLine(String[] args){
        String resultText;
        String fileName = args[1];
        try {
            URL u = new URL(fileName);
            this.setReadFileStrategy(new URLStrategy());
            resultText = readFileStrategy.readFile(fileName);

        }catch (MalformedURLException e){
            File file = new File(fileName);
            this.setReadFileStrategy(new FileStrategy());
            resultText = readFileStrategy.readFile(fileName);




        }
        System.out.println(resultText);

    }
}
