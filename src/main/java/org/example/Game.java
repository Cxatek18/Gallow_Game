package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Game {
    private Gallows gallow;
    private int numberOfErrors;
    private String[] listEncryptingWord;
    private final int MAX_COUNT_ERRORS = 7;

    public Game(){
        this.gallow = new Gallows();
        this.numberOfErrors = 0;
        this.listEncryptingWord = this.gallow.getHiddenWord().split(" ");
        System.out.println("Вопрос: %s".formatted(this.gallow.getQuestions()));
    }

    public void stepGame(char word){
        if(!checkingLetterInHiddenWord(word)){
            this.numberOfErrors++;
            System.out.println();
            drawingGallows();
        }
        wordOutput();
        System.out.println();
    }

    public int getMaxCountErrors(){
        return this.MAX_COUNT_ERRORS;
    }

    public String getHiddenWord(){
        return this.gallow.getWord();
    }

    public int getNumberOfErrors(){
        return this.numberOfErrors;
    }

    public void checkingHiddenLetters(){
        if(!Arrays.asList(this.listEncryptingWord).contains("_")){
            System.out.println("Вы победили!!! Ура");
            System.exit(0);
        }
    }

    private boolean checkingLetterInHiddenWord(char word){
        String hiddenWord = this.gallow.getWord();
        if(hiddenWord.contains(Character.toString(word))){
            for(int i = 0; i < hiddenWord.length(); i++){
                if(hiddenWord.charAt(i) == word){
                    this.listEncryptingWord[i] = Character.toString(hiddenWord.charAt(i));
                }
            }
            return true;
        }else{
            return false;
        }
    }

    private void wordOutput(){
        Arrays.stream(this.listEncryptingWord).forEach(System.out::print);
    }

    private void drawingGallows(){
        try (BufferedReader reader = new BufferedReader(
                new FileReader("%s.txt".formatted(this.numberOfErrors))
        )){
            String line;
            while((line=reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
