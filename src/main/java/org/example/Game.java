package org.example;

import java.io.*;
import java.net.URISyntaxException;
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
        System.out.println("Вопрос: %s".formatted(this.gallow.getWordDefinition()));
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

    public String declassificationOfTheWord(){
        return this.gallow.getRandomWord();
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
        String hiddenWord = this.gallow.getRandomWord();
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
                new FileReader(new File(
                        getClass()
                                .getResource("/drawing_templates/%s.txt".formatted(this.numberOfErrors))
                                .toURI()
                ))
        )){
            String line;
            while((line=reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
