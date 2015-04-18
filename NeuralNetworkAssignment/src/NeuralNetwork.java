import java.util.ArrayList;
import java.util.Random;

public class NeuralNetwork {

	public static void main(String[] args) {

		ArrayList<Integer> topology = new ArrayList<Integer>();
		//3 inputs, 1 output
		topology.add(2);
		topology.add(1);
		//topology.add(1);
		
		Net myNet = new Net(topology);		
		
//		
//		for (int i = 0; i < 100; i++) {
//			
//			ArrayList<Double> inputVals = new ArrayList<>();
//			inputVals.add((double)i);
//			myNet.FeedForward(inputVals);		
//			
//			ArrayList<Double> returnVals = new ArrayList<>();
//			myNet.GetResults(returnVals);
//			 
//			for (int j = 0; j < inputVals.size() ; j++) {
//				System.out.println("input: " + inputVals.get(j) 
//						+ " | output: " + returnVals.get(j));
//			}
//			
//			ArrayList<Double> targetVals = new ArrayList<>();
//			targetVals.add((double)i*2);
//			myNet.BackPropagation(targetVals);			
//		
//				
//		}
//		
		
		for (int i = 0; i < 10; i++) {
			ArrayList<Double> inputVals = new ArrayList<>();
			inputVals.add((double)0);
			inputVals.add((double)1);
			myNet.FeedForward(inputVals);	
			
			ArrayList<Double> targetVals = new ArrayList<>();
			targetVals.add((double)1);
			myNet.BackPropagation(targetVals);			

			inputVals.clear();
			targetVals.clear();
			
			inputVals.add((double)1);
			inputVals.add((double)0);
			myNet.FeedForward(inputVals);		
			
			targetVals.add((double)1);
			myNet.BackPropagation(targetVals);	
			 
			inputVals.clear();
			targetVals.clear();
			
			inputVals.add((double)1);
			inputVals.add((double)1);
			myNet.FeedForward(inputVals);		
			
			targetVals.add((double)0);
			myNet.BackPropagation(targetVals);	
			
			inputVals.clear();
			targetVals.clear();
			
			inputVals.add((double)0);
			inputVals.add((double)0);
			myNet.FeedForward(inputVals);		
			
			targetVals.add((double)0);
			myNet.BackPropagation(targetVals);	
			
		}
	
		
		
	
		
		
		ArrayList<Double> inputVals = new ArrayList<>();
		inputVals.add((double)1);
		inputVals.add((double)0);
		myNet.FeedForward(inputVals);
		
		ArrayList<Double> returnVals = new ArrayList<>();
		myNet.GetResults(returnVals);
		
		for (Double double1 : returnVals) {
			System.out.println(double1);
		}
		
		
	}
}
