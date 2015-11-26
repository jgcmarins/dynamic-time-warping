
/*
*
* date: Qua Nov 25 11:15:48 BRST 2015
* author: Joao Gustavo Cabral de Marins
* e-mail: jgcmarins@gmail.com
* https://github.com/jgcmarins
*
*/

package dtw.core;

import java.util.ArrayList;

public class Move {

	private Integer label;
	private ArrayList<Double> serie;

	public Move() {
		this.label = new Integer(0);
		this.serie = new ArrayList<Double>();
	}

	public Move(Integer label) {
		this.label = label;
		this.serie = new ArrayList<Double>();
	}

	public Move(int label) {
		this.label = new Integer(label);
		this.serie = new ArrayList<Double>();
	}

	public void setLabel(Integer label) { this.label = label; }

	public void setLabel(int label) { this.label = new Integer(label); }

	public void setSerie(Double value) { this.serie.add(value); }

	public void setSerie(double value) { this.serie.add(new Double(value)); }

	public Integer getLabel() { return this.label; }

	public ArrayList<Double> getSerie() { return this.serie; }
}
