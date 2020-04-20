import java.util.stream.Stream;

class ReverseString {

    String reverse(String inputString) {
        return Stream.of(inputString.split(""))
                .reduce("", (reversalSoFar, nextLetter) -> nextLetter + reversalSoFar);
    }
  
}