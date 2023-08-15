package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GallowsTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в игру виселица");

        Game game = new Game();

        KeyboardGame keyboardGame = new KeyboardGame();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(game.getNumberOfErrors() < game.getMaxCountErrors()){
            game.checkingHiddenLetters();
            System.out.println("Буквы которые вы ещё не пробовали: ");
            keyboardGame.getAllLetter();
            System.out.println("\nВведите букву: ");
            char letter = reader.readLine().charAt(0);
            keyboardGame.delLetter(letter);
            game.stepGame(letter);
        }
        System.out.println("Загаданное слово: ");
        System.out.println(game.declassificationOfTheWord());
    }
}
