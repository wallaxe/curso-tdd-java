import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();

        for (int number = 1; number <= 100; number++) {
                numbers.add(transform(number));
        }
        return numbers;
    }

    private String transform(int number) {


        if (isFizzBuzz(number)) {
            return "FizzBuzz";
        }

        if (ContainsNumber(number, "5")) {
            return "Buzz";
        }

        if (ContainsNumber(number, "3")) {
            return "Fizz";
        }


        if (isFizz(number)) {
            return "Fizz";
        }

        if (isBuzz(number)) {
            return "Buzz";
        }


        return String.valueOf(number);
    }

    private boolean isFizzBuzz(int number) {

        if (ContainsNumber(number, "5") && isFizz(number)) {
            return true;
        }

        if (ContainsNumber(number, "3") && isBuzz(number)) {
            return true;
        }
        return isFizz(number) && isBuzz(number);
    }

    private boolean ContainsNumber(int number, String s) {
        return String.valueOf(number).contains(s);
    }

    private boolean isFizz(int number) {
        return isMultipleOf(number, 3);
    }


    private boolean isBuzz(int number) {
        return isMultipleOf(number, 5);
    }

    private boolean isMultipleOf(int number, int divisor) {
        return number % divisor == 0;
    }

}
