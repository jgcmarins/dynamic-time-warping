
/*
*
* date: Qua Nov 25 22:46:20 BRST 2015
* author: Joao Gustavo Cabral de Marins
* e-mail: jgcmarins@gmail.com
* https://github.com/jgcmarins
*
*/

package dtw.core;

import java.util.ArrayList;

public class DTW {

	public DTW() {}

	private static double minThree(double x, double y, double z) {
		if(x*y < x*z) {
			if(x < y) return x;
			return y;
		} else if(x < z) return x;
		return z;
	}

	private static double distance(Double a, Double b) {
		double x = a.doubleValue();
		double y = b.doubleValue();

		return ((x - y)*(x - y));
	}

	public static double DTWdistance(Move trainingMove, Move testMove) {
		int n = trainingMove.getSerie().size();
		int m = testMove.getSerie().size();

		double[][] dtw = new double[n][m];

		for(int i = 1 ; i < n ; i++) dtw[i][0] = Double.POSITIVE_INFINITY;
		for(int j = 1 ; j < m ; j++) dtw[0][j] = Double.POSITIVE_INFINITY;
		dtw[0][0] = 0.0;

		for(int i = 1 ; i < n ; i++) {
			for(int j = 1 ; j < m ; j++) {
				double d = DTW.distance(trainingMove.getSerie().get(i), testMove.getSerie().get(j));
				dtw[i][j] = d + DTW.minThree(dtw[i - 1][j],
											dtw[i][j - 1],
											dtw[i - 1][j - 1]);
			}
		}

		return dtw[n - 1][m - 1];
	}
}
