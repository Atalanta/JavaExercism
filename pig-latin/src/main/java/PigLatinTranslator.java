import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class PigLatinTranslator {

    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    Set<Character> consonants = Set.of(
            'b', 'c', 'd', 'f', 'g', 'h', 'j',
            'k', 'l', 'm', 'n', 'p', 'q', 'r',
            's', 't', 'v', 'w', 'x', 'y', 'z');
    String consonantEdgeCasePattern = "^(ch|qu|rh|squ|thr|th|sch)(.+)";
    String vowelEdgeCasePattern = "^(yt|xr)(.+)";

    String translate(String plaintext) {

        var tokenisedPlainText = Arrays.asList(plaintext.split(" "));
        return tokenisedPlainText.stream()
                .map(word -> encipherWord(word))
                .collect(Collectors.joining(" "));
    }

    boolean beginsWithVowel(String word) {
        return vowels.contains(word.charAt(0));
    }

    boolean beginsWithConsonant(String word) {
        return consonants.contains(word.charAt(0));
    }

    String encipherWord(String word) {

        if (beginsWithVowel(word) || word.matches(vowelEdgeCasePattern)) {
            return word + "ay";
        } else if (beginsWithConsonant(word)) {
            if (word.matches(consonantEdgeCasePattern)) {
                return word.replaceAll(consonantEdgeCasePattern, "$2$1ay");
            }
            return word.substring(1) + word.substring(0, 1) + "ay";
        } else {
            return word;
        }
    }
}
