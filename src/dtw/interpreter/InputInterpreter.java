
/*
*
* date: Qua Nov 25 11:29:20 BRST 2015
* author: Joao Gustavo Cabral de Marins
* e-mail: jgcmarins@gmail.com
* https://github.com/jgcmarins
*
*/

package dtw.interpreter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

import dtw.core.Move;

public class InputInterpreter {

	public InputInterpreter() {}

	private static ArrayList<String> readInput(String fileName) {
		ArrayList<String> input = new ArrayList<String>();

		try {

			Scanner s = new Scanner(new File(fileName));
			while(s.hasNext()) input.add(new String(s.nextLine()));
			s.close();

		} catch(IOException ioe) { ioe.printStackTrace(); }

		return input;
	}

	private static ArrayList<Move> organizeInput(ArrayList<String> input) {
		ArrayList<Move> moves = new ArrayList<Move>();
		for(String move : input) {
			String[] elements = move.split(" ");
			Move m = new Move(Integer.parseInt(elements[0].toString()));
			for(int i = 1 ; i < elements.length ; i++) m.setSerie(Double.parseDouble(elements[i].toString()));
			moves.add(m);
		}

		return moves;
	}

	public static ArrayList<Move> interpret(String fileName) {
		return InputInterpreter.organizeInput(InputInterpreter.readInput(fileName));
	}
}
