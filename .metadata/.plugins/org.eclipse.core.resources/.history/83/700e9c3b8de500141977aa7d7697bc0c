import java.util.ArrayList;
import java.util.Random;

public class NeuralNetwork {

	public static void main(String[] args) {

		ArrayList<Integer> topology = new ArrayList<Integer>();
		
		Net myNet = new Net(topology);		
		
		ArrayList<Double> inputVals = new ArrayList<>();
		myNet.FeedForward(inputVals);
		
		ArrayList<Double> targetVals = new ArrayList<>();
		myNet.BackPropagation(targetVals);
		
		ArrayList<Double> returnVals = new ArrayList<>();
		myNet.GetResults(returnVals);
		
		
	}
}
