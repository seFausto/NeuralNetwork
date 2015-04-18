import java.util.ArrayList;

public class Net {

	private ArrayList<Layer> _layers;
	public Net(ArrayList<Integer> topology) {
		
		int numberOfLayers = topology.size();
		
		for (int layerCount = 0; layerCount < numberOfLayers; layerCount++) {
			_layers.add(new Layer());
			for (int neuronCount = 0; neuronCount <= topology.get(layerCount); neuronCount++) {
				
				_layers.get(layerCount).Neurons.add(new Neuron());
			}
			
		}
		
	}

	public void FeedForward(ArrayList<Double> inputVals) {
	}

	public void BackPropagation(ArrayList<Double> targetVals) {
	}

	public void GetResults(ArrayList<Double> returnVals) {
	}

}
