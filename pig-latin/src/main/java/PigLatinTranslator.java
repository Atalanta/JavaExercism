import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

    private static final Set<Character> vowels;
    private static final Set<Character> consonants;
    private static final String consonantEdgeCasePattern;
    private static final String vowelEdgeCasePattern;


    static {
        vowels = Set.of('a', 'e', 'i', 'o', 'u');
        consonants = Set.of(
                'b', 'c', 'd', 'f', 'g', 'h', 'j',
                'k', 'l', 'm', 'n', 'p', 'q', 'r',
                's', 't', 'v', 'w', 'x', 'y', 'z');
        consonantEdgeCasePattern = "^(ch|qu|rh|squ|thr|th|sch)(.+)";
        vowelEdgeCasePattern = "^(yt|xr)(.+)";
    }

    public String translate(String plaintext) {

        return Stream.of(plaintext.split(" "))
                .map(this::encipherWord)
                .collect(Collectors.joining(" "));

    }

    private boolean beginsWithVowel(String word) {
        return vowels.contains(word.charAt(0));
    }

    private boolean beginsWithConsonant(String word) {
        return consonants.contains(word.charAt(0));
    }

    private String encipherWord(String word) {

        if (beginsWithVowel(word) || word.matches(vowelEdgeCasePattern)) return word + "ay";
        if (beginsWithConsonant(word)) {
            if (word.matches(consonantEdgeCasePattern)) return word.replaceAll(consonantEdgeCasePattern, "$2$1ay");
            return word.substring(1) + word.substring(0, 1) + "ay";
        }
        return word;
    }
}
