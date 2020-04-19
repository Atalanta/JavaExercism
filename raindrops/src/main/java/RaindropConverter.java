class RaindropConverter {

    boolean isFactorOfThree(int number) {
        if (number % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFactorOfFive(int number) {
        if (number % 5 == 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFactorOfSeven(int number) {
        if (number % 7 == 0) {
            return true;
        } else {
            return false;
        }
    }

    String convert(int number) {

        String output = "";

        if (isFactorOfThree(number)) {
            output = output + "Pling";
        }

        if (isFactorOfFive(number)) {
            output = output + "Plang";
        }

        if (isFactorOfSeven(number)) {
            output = output + "Plong";
        }

        if (output == "") {
            output = String.valueOf(number);
        }

        return output;

    }
}
