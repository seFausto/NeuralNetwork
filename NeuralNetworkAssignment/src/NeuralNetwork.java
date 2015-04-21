import java.util.ArrayList;
import java.util.Random;

public class NeuralNetwork {
	
	private static double Denormalization(double active, double output) {
		double result = 0;
		double y = output;
		double xMaxxMin = 1.6;
		result = (active - y) / (2 / xMaxxMin);

		return result;
	}
	static double[][] _values;
	public static void main(String[] args) {

		ArrayList<Integer> topology = new ArrayList<Integer>();
		// 3 inputs, 1 output
		topology.add(2);
		topology.add(2);
		topology.add(1);
		GetValues();
		Net myNet = new Net(topology);
		ArrayList<Double> inputVals = new ArrayList<Double>();
		ArrayList<Double> targetVals = new ArrayList<Double>();
		
		for (int i = 0; i < 100; i++) {
		
			inputVals.clear();
			targetVals.clear();
			
			inputVals.add(_values[i][0]);
			targetVals.add(_values[i][1]);
			
			
			myNet.FeedForward(inputVals);
			myNet.BackPropagation(targetVals);

			ArrayList<Double> returnVals = myNet.GetResults();

			for (int j = 0; j < inputVals.size(); j++) {
				System.out.println("input: " + inputVals.get(j) + " | output: "
						+  Denormalization(returnVals.get(j), inputVals.get(j)));
			}

		}

	
		inputVals.add((double) .528);
	
		myNet.FeedForward(inputVals);

		ArrayList<Double> returnVals = new ArrayList<>();
		returnVals = myNet.GetResults();

		for (Double double1 : returnVals) {
			System.out.println(Denormalization(double1, .528));
		}

	}

	private static void GetValues() {
		_values = new double[100][2];
		_values[0][0] = -2.522717378;
		_values[0][1] = 1.188280453;
		_values[1][0] = -2.15124242;
		_values[1][1] = 1.051337763;
		_values[2][0] = 0.557437806;
		_values[2][1] = 0.188951473;
		_values[3][0] = 0.781087745;
		_values[3][1] = 0.099962976;
		_values[4][0] = -0.861683808;
		_values[4][1] = 0.647391883;
		_values[5][0] = -3.043417032;
		_values[5][1] = 1.441433082;
		_values[6][0] = -3.103647049;
		_values[6][1] = 1.483461091;
		_values[7][0] = 0.860512503;
		_values[7][1] = 0.065583586;
		_values[8][0] = -1.282162689;
		_values[8][1] = 0.773907698;
		_values[9][0] = -3.11803578;
		_values[9][1] = 1.494489228;
		_values[10][0] = -3.087577853;
		_values[10][1] = 1.471651349;
		_values[11][0] = -0.962468788;
		_values[11][1] = 0.677629921;
		_values[12][0] = -2.02053993;
		_values[12][1] = 1.006862449;
		_values[13][0] = -0.147913785;
		_values[13][1] = 0.429248218;
		_values[14][0] = -2.939795751;
		_values[14][1] = 1.379484348;
		_values[15][0] = -2.801991992;
		_values[15][1] = 1.308988844;
		_values[16][0] = 0.664262678;
		_values[16][1] = 0.147671829;
		_values[17][0] = 0.851180563;
		_values[17][1] = 0.06971849;
		_values[18][0] = -1.044235518;
		_values[18][1] = 0.702172973;
		_values[19][0] = -2.77254489;
		_values[19][1] = 1.295112749;
		_values[20][0] = 0.475159185;
		_values[20][1] = 0.219520443;
		_values[21][0] = 0.973202038;
		_values[21][1] = 0.013225231;
		_values[22][0] = 0.071778968;
		_values[22][1] = 0.358582584;
		_values[23][0] = -2.329948967;
		_values[23][1] = 1.11488824;
		_values[24][0] = 0.575459955;
		_values[24][1] = 0.182121961;
		_values[25][0] = -0.593016424;
		_values[25][1] = 0.566492244;
		_values[26][0] = -0.21092833;
		_values[26][1] = 0.449076829;
		_values[27][0] = -1.846144834;
		_values[27][1] = 0.949521432;
		_values[28][0] = -0.24870155;
		_values[28][1] = 0.460885144;
		_values[29][0] = -0.288411025;
		_values[29][1] = 0.473241184;
		_values[30][0] = -0.730146215;
		_values[30][1] = 0.60787178;
		_values[31][0] = 0.987508579;
		_values[31][1] = 0.006207299;
		_values[32][0] = -1.453258018;
		_values[32][1] = 0.826081665;
		_values[33][0] = -0.043089172;
		_values[33][1] = 0.395857491;
		_values[34][0] = -0.514034582;
		_values[34][1] = 0.542525318;
		_values[35][0] = 0.639515361;
		_values[35][1] = 0.157413567;
		_values[36][0] = 0.570061179;
		_values[36][1] = 0.184173199;
		_values[37][0] = -3.128398937;
		_values[37][1] = 1.502734117;
		_values[38][0] = -0.070842024;
		_values[38][1] = 0.404751305;
		_values[39][0] = 0.871518503;
		_values[39][1] = 0.060671396;
		_values[40][0] = -2.824871651;
		_values[40][1] = 1.320019316;
		_values[41][0] = -2.888417478;
		_values[41][1] = 1.351966579;
		_values[42][0] = -1.16437069;
		_values[42][1] = 0.738310416;
		_values[43][0] = -2.954739983;
		_values[43][1] = 1.387827981;
		_values[44][0] = -1.86383355;
		_values[44][1] = 0.955248864;
		_values[45][0] = -2.886818493;
		_values[45][1] = 1.351136425;
		_values[46][0] = -3.126611316;
		_values[46][1] = 1.501292395;
		_values[47][0] = -2.307717559;
		_values[47][1] = 1.106778921;
		_values[48][0] = 0.862631879;
		_values[48][1] = 0.064640689;
		_values[49][0] = 0.495691636;
		_values[49][1] = 0.211981015;
		_values[50][0] = -0.909257162;
		_values[50][1] = 0.661666;
		_values[51][0] = 0.726190032;
		_values[51][1] = 0.122759971;
		_values[52][0] = -2.598346947;
		_values[52][1] = 1.218922012;
		_values[53][0] = 0.984254826;
		_values[53][1] = 0.007811801;
		_values[54][0] = -3.144983184;
		_values[54][1] = 1.516537118;
		_values[55][0] = -2.976586385;
		_values[55][1] = 1.40034107;
		_values[56][0] = -1.364571066;
		_values[56][1] = 0.798954726;
		_values[57][0] = -0.312159167;
		_values[57][1] = 0.480604238;
		_values[58][0] = -2.953476017;
		_values[58][1] = 1.387115748;
		_values[59][0] = -3.182438191;
		_values[59][1] = 1.551327825;
		_values[60][0] = -3.060600133;
		_values[60][1] = 1.452843657;
		_values[61][0] = -3.16429729;
		_values[61][1] = 1.533746187;
		_values[62][0] = -3.116073251;
		_values[62][1] = 1.492957515;
		_values[63][0] = -2.521602503;
		_values[63][1] = 1.187837653;
		_values[64][0] = 0.673359621;
		_values[64][1] = 0.144061404;
		_values[65][0] = -0.655882779;
		_values[65][1] = 0.585493264;
		_values[66][0] = -0.739232835;
		_values[66][1] = 0.610605883;
		_values[67][0] = -1.04992185;
		_values[67][1] = 0.703880905;
		_values[68][0] = -1.253575994;
		_values[68][1] = 0.765249109;
		_values[69][0] = -3.052241963;
		_values[69][1] = 1.447242752;
		_values[70][0] = -3.202820354;
		_values[70][1] = 1.573324688;
		_values[71][0] = -3.193429354;
		_values[71][1] = 1.562839638;
		_values[72][0] = -1.265677141;
		_values[72][1] = 0.768912703;
		_values[73][0] = -0.803085411;
		_values[73][1] = 0.629799479;
		_values[74][0] = -1.909656722;
		_values[74][1] = 0.970173274;
		_values[75][0] = 0.440012313;
		_values[75][1] = 0.232298836;
		_values[76][0] = -0.680103341;
		_values[76][1] = 0.592798975;
		_values[77][0] = -3.085096179;
		_values[77][1] = 1.469870621;
		_values[78][0] = -2.892778415;
		_values[78][1] = 1.354238196;
		_values[79][0] = -2.064760487;
		_values[79][1] = 1.021747915;
		_values[80][0] = -0.163904422;
		_values[80][1] = 0.434296085;
		_values[81][0] = -2.989766592;
		_values[81][1] = 1.408087807;
		_values[82][0] = 0.32987862;
		_values[82][1] = 0.271398684;
		_values[83][0] = -2.6549767;
		_values[83][1] = 1.242732431;
		_values[84][0] = -2.436642734;
		_values[84][1] = 1.154767636;
		_values[85][0] = -3.169801673;
		_values[85][1] = 1.538917663;
		_values[86][0] = -2.212048672;
		_values[86][1] = 1.072565512;
		_values[87][0] = -0.456869694;
		_values[87][1] = 0.525098626;
		_values[88][0] = 0.032890634;
		_values[88][1] = 0.371290485;
		_values[89][0] = 0.549654358;
		_values[89][1] = 0.191885419;
		_values[90][0] = -3.203313957;
		_values[90][1] = 1.573894868;
		_values[91][0] = -0.660994922;
		_values[91][1] = 0.587035882;
		_values[92][0] = -1.102984881;
		_values[92][1] = 0.719829429;
		_values[93][0] = -1.977736457;
		_values[93][1] = 0.992596952;
		_values[94][0] = 0.578297837;
		_values[94][1] = 0.181041856;
		_values[95][0] = -2.206704642;
		_values[95][1] = 1.070684711;
		_values[96][0] = 0.894148673;
		_values[96][1] = 0.050445136;
		_values[97][0] = -1.973248147;
		_values[97][1] = 0.991108832;
		_values[98][0] = -3.11879017;
		_values[98][1] = 1.495080445;
		_values[99][0] = -2.598874667;
		_values[99][1] = 1.219140257;

	}
}
