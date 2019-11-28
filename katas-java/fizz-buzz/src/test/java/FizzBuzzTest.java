import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {

	@Test
	public void firstNumberNoChange() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("1", numbers.get(0));
	}

	@Test
	public void secondNumberNoChange() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("2", numbers.get(1));
	}

	@Test
	public void thirdNumberReturnFizz() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("Fizz", numbers.get(2));
	}

	@Test
	public void fifthNumberReturnBuzz() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("Buzz", numbers.get(4));
	}

	@Test
	public void fifteenNumberReturnFizzBuzz() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("FizzBuzz", numbers.get(14));
	}


	@Test
	public void haveHundredNumbers() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals(100, numbers.size());
	}

	@Test
	public void numberContainsFiveAndMultipleOf3isFizzBuzz() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("FizzBuzz", numbers.get(50));
	}

	@Test
	public void numberContainsThreeAndMultipleOf5isFizzBuzz() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("FizzBuzz", numbers.get(34));
	}

	@Test
	public void numberContainsFive() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("Buzz", numbers.get(51));
	}

	@Test
	public void numberContainsThree() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("Fizz", numbers.get(33));
	}

	@Test
	public void numberContainsThreeAndFive() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("FizzBuzz", numbers.get(34));
	}
}
