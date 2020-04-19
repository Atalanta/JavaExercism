package com.atalanta.sns;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

class IsogramChecker {

    boolean hasDuplicate(String phrase, Character character) {
        if (phrase.chars().filter(ch -> ch == character).count() > 1) {
            return true;
        } else {
            return false;
        }
    }

    boolean isIsogram(String phrase) {

        CharacterIterator duplicateChecker = new StringCharacterIterator(phrase);

        while (duplicateChecker.current() != CharacterIterator.DONE) {
            if (hasDuplicate(phrase
                    .replaceAll("-| ", "")
                    .toLowerCase(), duplicateChecker.current())) {
                return false;
            } else {
                duplicateChecker.next();
            }
        }

        return true;
    }

}

