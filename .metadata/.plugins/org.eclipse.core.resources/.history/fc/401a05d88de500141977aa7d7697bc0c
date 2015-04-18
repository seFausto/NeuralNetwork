import java.util.Random;

public class Neuron {

	private double[] _weights;
	
	public Neuron(int numberOfInputs)
	{	
		_weights = new double[numberOfInputs];
		Random r = new Random();
		for (int i = 0; i < numberOfInputs; i++) {
			_weights[i] = r.nextDouble();
		}
		
	}
	
	public Neuron()
	{	
	
	}
	
	public double FeedForward(double[] inputs)
	{
		double sum = 0;
		
		for (int i = 0; i < _weights.length; i++) {
			sum += inputs[i] * _weights[i];
		}
			
		return sum;
		
	}
	
	private double learningRate = .01;
	
	public void Train(double[] inputs, double desired)
	{
		double guess = FeedForward(inputs);
		
		double error = desired - guess;
		
		for (int i = 0; i < inputs.length; i++) {
			_weights[i] +=learningRate * error * inputs[i];
		}
		
	}
	
	

	
		
		

}
