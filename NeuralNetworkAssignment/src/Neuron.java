import java.util.ArrayList;
import java.util.Random;

public class Neuron {

	private double _outputValue;
	private int _myIndex;
	private ArrayList<Connection> _outputWeights;
	public double _gradient = 0;
	private double eta = .05; // learning
	private double alpha = 1; // momentum
	private double _inputValue;

	public Neuron(int numberOfOutputs, int myIndex) {
		Random r = new Random();
		_outputWeights = new ArrayList<Connection>();

		for (int i = 0; i < numberOfOutputs; i++) {
			Connection c = new Connection();
			c.weight = r.nextDouble();
			_outputWeights.add(c);
		}

		_myIndex = myIndex;
	}

	public void SetOutputValue(double outputValue) {
		_outputValue = outputValue;
		_inputValue = outputValue;
	}

	public double GetOuputValue() {
				return _outputValue;
	}

	public void FeedForward(Layer previousLayer) {
		double sum = 0.0;

		for (int n = 0; n < previousLayer.Neurons.size(); n++) {
			sum += previousLayer.Neurons.get(n).GetOuputValue()
					* previousLayer.Neurons.get(n)._outputWeights.get(_myIndex).weight;
		}

		//Add the normalized thing here
		double active = Activation(sum);
		_outputValue = active;
	}	

	public double Activation(double x) {
		// convert to sigmoid
		double result = (double) 1 / ((double) 1 + Math.pow(Math.E, -x));
		// double result = this._outputWeights.get(0).weight * x;
		return result;
	}

	private double ActivationDerivative(double x) {
//		double result = (double) 1
//				/ ((double) 1 + Math.pow(Math.E, -x))
//				* ((double) 1 - ((double) 1 / ((double) 1 + Math
//						.pow(Math.E, -x))));
		
		double result = (Math.pow(Math.E, -x)) /Math.pow(1+Math.pow(Math.E, -x), 2);
		return result;

	}

	private double Denormalization(double active, double output) {
		double result = 0;
		double y = output;
		double xMaxxMin = 1.6;
		result = (active - y) / (2 / xMaxxMin);

		return result;
	}
	
	public void CalcOutputGradients(double targetValue) {
		double denorm = Denormalization(_outputValue, _inputValue);
		double delta = targetValue - denorm;
		_gradient = delta * ActivationDerivative(_outputValue);
	}

	public void CalcHiddenGradients(Layer nextLayer) {
		double dow = SumDow(nextLayer);
		_gradient = dow * ActivationDerivative(_outputValue);
	}

	public void UpdateInputWeights(Layer previousLayer) {

		for (int i = 0; i < previousLayer.Neurons.size(); i++) {

			Neuron neuron = previousLayer.Neurons.get(i);

			double oldDeltaWeight = neuron._outputWeights.get(_myIndex).deltaWeight;
			double newDeltaWeight = eta * neuron.GetOuputValue() * _gradient
					+ alpha * oldDeltaWeight;

			neuron._outputWeights.get(_myIndex).deltaWeight = newDeltaWeight;
			neuron._outputWeights.get(_myIndex).weight += newDeltaWeight;

		}

	}

	private double SumDow(Layer nextLayer) {
		double sum = 0.0;

		for (int i = 0; i < nextLayer.Neurons.size() - 1; i++) {
			sum += _outputWeights.get(i).weight
					* nextLayer.Neurons.get(i)._gradient;

		}
		return sum;
	}

}
