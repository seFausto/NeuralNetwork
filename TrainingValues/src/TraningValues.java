import java.util.Random;

public class TraningValues {

	public static void main(String[] args) {

		System.out.println("X\tY");
		for (int i = 0; i < 100; i++) {
			double x = GetNextX();
			double y = Equation(x);
			System.out.println(x + "\t" + y);
		}

	}

	private static double GetNextX() {
		double randomX = 0;
		double rangeMax = 1.6;
		double rangeMin = 0;
		do {
			randomX = rangeMin + (rangeMax - rangeMin) * Math.random();
		} while (randomX < (double) .5 && randomX > (double) 3);
		return randomX;
	}

	public static double Equation(double x) {
		double result = 0.0;

		double xTo3 = Math.pow(x, 3);
		double xTo2 = Math.pow(x, 2);

		result = xTo3 - (2 * xTo2) - (2 * x) + 1;

		return result;

	}

}
