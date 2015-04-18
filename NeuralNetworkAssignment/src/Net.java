import java.util.ArrayList;

public class Net {

	private ArrayList<Layer> _layers;
	private double _error;
	private double _recentAverageError;
	private double _recentAverageSmoothingFactor = 100;

	public Net(ArrayList<Integer> topology) {
		_layers = new ArrayList<Layer>();
		int numberOfLayers = topology.size();

		for (int layerCount = 0; layerCount < numberOfLayers; layerCount++) {
			_layers.add(new Layer());
			int numberOfOutputs = layerCount == topology.size() - 1 ? 0
					: topology.get(layerCount + 1);

			int neuronCount;
			for (neuronCount = 0; neuronCount <= topology.get(layerCount); neuronCount++) {

				_layers.get(layerCount).Neurons.add(new Neuron(numberOfOutputs,
						neuronCount));
			}

			_layers.get(layerCount).Neurons.get(neuronCount-1)
					.SetOutputValue(1.0);

		}

	}

	public void FeedForward(ArrayList<Double> inputVals) {
		// assert
		for (int i = 0; i < inputVals.size(); i++) {

			_layers.get(0).Neurons.get(i).SetOutputValue(inputVals.get(i));
		}

		// forward prop
		for (int layerCount = 1; layerCount < _layers.size(); layerCount++) {
			Layer previousLayer = _layers.get(layerCount - 1);
			for (int neuronCount = 0; neuronCount < _layers.get(layerCount).Neurons
					.size() - 1; neuronCount++) {

				_layers.get(layerCount).Neurons.get(neuronCount).FeedForward(
						previousLayer);
			}
		}

	}

	public void BackPropagation(ArrayList<Double> targetVals) {

		Layer outputLayer = _layers.get(_layers.size() - 1);
		_error = 0.0;

		for (int n = 0; n < outputLayer.Neurons.size() - 1; n++) {
			double delta = targetVals.get(n)
					- outputLayer.Neurons.get(n).GetOuputValue();
			_error += delta * delta;
		}

		_error /= outputLayer.Neurons.size() - 1;
		_error = Math.sqrt(_error);

		_recentAverageError = (_recentAverageError
				* _recentAverageSmoothingFactor + _error)
				/ (_recentAverageSmoothingFactor + 1.0);

		for (int i = 0; i < outputLayer.Neurons.size() - 1; i++) {
			outputLayer.Neurons.get(i).CalcOutputGradients(targetVals.get(i));
		}

		for (int layerNumber = _layers.size() - 2; layerNumber > 0; layerNumber--) {
			Layer hiddenLayer = _layers.get(layerNumber);
			Layer nextLayer = _layers.get(layerNumber + 1);

			for (int i = 0; i < hiddenLayer.Neurons.size(); i++) {
				hiddenLayer.Neurons.get(i).CalcHiddenGradients(nextLayer);
			}
		}

		for (int layerNum = _layers.size() - 1; layerNum > 0; layerNum--) {
			Layer layer = _layers.get(layerNum);
			Layer previousLayer = _layers.get(layerNum - 1);

			for (int i = 0; i < layer.Neurons.size() - 1; i++) {
				layer.Neurons.get(i).UpdateInputWeights(previousLayer);
			}

		}

	}

	public void GetResults(ArrayList<Double> returnVals) {
		returnVals.clear();
		int last = _layers.size() - 1;
		for (int i = 0; i < _layers.get(last).Neurons.size() - 1; i++) {
			returnVals.add(_layers.get(last).Neurons.get(i).GetOuputValue());

		}
	}

}
