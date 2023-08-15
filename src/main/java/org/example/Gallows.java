package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gallows {
    private String word;
    private String hiddenWord;
    private String questions;
    private int randomNum = new Random().nextInt(0, 10);
    private List<String> wordsAndQuestions = new ArrayList<>();

    public Gallows(){
        this.word = getRandomWord();
        this.questions = getWordDefinition();
        this.hiddenWord = wordEncryption();
    }

    public String getRandomWord(){
        return getRandomStringToFile().split(" -- ")[1];
    }

    public String getHiddenWord(){
        return this.hiddenWord;
    }

    public String getWordDefinition(){
        return getRandomStringToFile().split(" -- ")[0];
    }

    private String wordEncryption(){
        String result = "";
        for(int i = 0; i < this.word.length(); i++){
            result += "_ ";
        }
        return result.trim();
    }

    private String getRandomStringToFile(){
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File(
                        getClass()
                                .getResource("/worldAndQuestions.txt")
                                .toURI()
                ))
        )){
            String line;
            while((line=reader.readLine()) != null){
                this.wordsAndQuestions.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return this.wordsAndQuestions.get(this.randomNum);
    }
}
