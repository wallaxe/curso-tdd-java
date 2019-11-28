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

        if (isFizz(number)) {
            return "Fizz";
        }

        if (isBuzz(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private boolean isFizzBuzz(int number) {
        return (ContainsNumber(number, "5") && isFizz(number)) ||
                (ContainsNumber(number, "3") && isBuzz(number)) ||
                (ContainsNumber(number, "3") && ContainsNumber(number, "5")) ||
                (isFizz(number) && isBuzz(number));
    }

    private boolean isFizz(int number) {
        return (ContainsNumber(number, "3")) ||
                isMultipleOf(number, 3);
    }

    private boolean isBuzz(int number) {
        return (ContainsNumber(number, "5")) ||
                isMultipleOf(number, 5);
    }

    private boolean isMultipleOf(int number, int divisor) {
        return number % divisor == 0;
    }

    private boolean ContainsNumber(int number, String s) {
        return String.valueOf(number).contains(s);
    }
}
