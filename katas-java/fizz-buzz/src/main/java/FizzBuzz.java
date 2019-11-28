import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> getNumbers() {
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            int number = i + 1;

            if(number == 3) {
                numbers.add("fizz");
                continue;
            }
            if(number == 5) {
                numbers.add("buzz");
                continue;
            }
            if(number == 15) {
                numbers.add("FizzBuzz");
                continue;
            }
            numbers.add(String.valueOf(number));

        }


        return numbers;
    }

    public boolean isMultipleOfThree(int i) {
        return false;
    }
}
