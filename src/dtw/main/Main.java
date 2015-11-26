
/*
*
* date: Qua Nov 25 11:08:47 BRST 2015
* author: Joao Gustavo Cabral de Marins
* e-mail: jgcmarins@gmail.com
* https://github.com/jgcmarins
*
*/

package dtw.main;

import java.util.ArrayList;

import dtw.core.Move;
import dtw.interpreter.InputInterpreter;
import dtw.core.DTW;

public class Main {

	private static void task(ArrayList<Move> trainingMoves, ArrayList<Move> testMoves) {
		int counter = 0;

		for(Move trainingm : trainingMoves) {
			double minimumDistance = Double.POSITIVE_INFINITY;
			int label = 0;

			for(Move testm : testMoves) {
				double distance = DTW.DTWdistance(trainingm, testm);
				if(distance < minimumDistance) {
					minimumDistance = distance;
					label = testm.getLabel().intValue();
				}
			}

			if(minimumDistance != Double.POSITIVE_INFINITY) {
				if(trainingm.getLabel().intValue() == label) counter++;
			}
		}

		double result = (double)counter/(double)trainingMoves.size();

		System.out.println(result*100+"%");
	}

	public static void main(String args[]) {

		if(args.length != 2) {
			System.out.println("Usage: java -jar dtw.jar training_file.txt test_file.txt");
			System.exit(0);
		} else {
			ArrayList<Move> trainingMoves = InputInterpreter.interpret(args[0].toString());
			ArrayList<Move> testMoves = InputInterpreter.interpret(args[1].toString());

			Main.task(trainingMoves, testMoves);
		}
	}
}
