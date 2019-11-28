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

		assertEquals("fizz", numbers.get(2));
	}

	@Test
	public void fifthNumberReturnBuzz() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("buzz", numbers.get(4));
	}

	@Test
	public void fifteenNumberReturnFizzBuzz() {
		FizzBuzz fizzbuzz = new FizzBuzz();

		List<String> numbers = fizzbuzz.getNumbers();

		assertEquals("FizzBuzz", numbers.get(14));
	}

	@Test
	public void checkMultipleOfThree() {
		FizzBuzz fizzBuzz = new FizzBuzz();

		assertTrue(fizzBuzz.isMultipleOfThree(3));
	}

}
