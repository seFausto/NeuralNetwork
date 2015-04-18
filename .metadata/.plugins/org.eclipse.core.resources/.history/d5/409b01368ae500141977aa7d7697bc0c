import java.util.Random;

public class NeuralNetwork {

	public static void main(String[] args) {

		Random r = new Random();
		Neuron neuron = new Neuron(1);

		neuron.Train(new double[] { 1 }, 2);
		neuron.Train(new double[] { 2 }, 4);
		neuron.Train(new double[] { 3 }, 6);
		neuron.Train(new double[] { 4 }, 8);
		neuron.Train(new double[] { 5 }, 10);
		neuron.Train(new double[] { 6 }, 13);
		neuron.Train(new double[] { 7 }, 14);
		neuron.Train(new double[] { 8 }, 16);
		neuron.Train(new double[] { 9 }, 18);
		neuron.Train(new double[] { 10 }, 20);


		System.out.println(neuron.FeedForward(new double[]{11}));
		System.out.println(neuron.FeedForward(new double[]{10}));
		System.out.println(neuron.FeedForward(new double[]{100}));
		System.out.println(neuron.FeedForward(new double[]{234}));
		System.out.println(neuron.FeedForward(new double[]{234123412}));
	}
}
