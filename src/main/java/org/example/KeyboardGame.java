package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardGame {
    private List<Character> letters;
    private List<Character> listLettersKeyboard;

    public KeyboardGame(){
        this.letters = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
        );
        this.listLettersKeyboard = new ArrayList<>(this.letters);
    }

    public void delLetter(Character letter){
        this.listLettersKeyboard.remove(letter);
    }

    public void getAllLetter(){
        this.listLettersKeyboard.stream().forEach(s -> {System.out.print(s + " ");});
    }
}
