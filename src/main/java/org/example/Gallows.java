package org.example;

import java.util.Random;

public class Gallows {
    private String word;
    private String hiddenWord;
    private String questions;

    public Gallows(){
        WordStorage wordStorage = new WordStorage();
        Random random = new Random();
        int randomNum = random.nextInt(0, 10);
        this.word = wordStorage.getWords().get(randomNum);
        this.questions = wordStorage.getQuestions().get(randomNum);
        this.hiddenWord = wordEncryption();
    }

    public String getWord(){
        return this.word;
    }

    public String getHiddenWord(){
        return this.hiddenWord;
    }

    public String getQuestions(){
        return this.questions;
    }

    private String wordEncryption(){
        String result = "";
        for(int i = 0; i < this.word.length(); i++){
            result += "_ ";
        }
        return result.trim();
    }
}
