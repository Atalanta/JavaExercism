import java.util.Objects;

public class Hamming {

    private final String left;
    private final String right;

    public Hamming(String leftStrand, String rightStrand) {
        this.left = leftStrand;
        this.right = rightStrand;

        if (left.isEmpty() && !right.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");

        if (right.isEmpty() && !left.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");

        if (!(right.length() == left.length()))
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    public int getHammingDistance() {
        int distance = 0;
        if (Objects.equals(left, right)) return 0;
        int i = 0;
        while (i < left.length()) {
            if ((right.charAt(i) != left.charAt(i))) distance++;
            i++;
        }

        return distance;

    }
}
