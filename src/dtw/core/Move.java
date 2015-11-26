
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

	private Integer type;
	private ArrayList<Double> serie;

	public Move() {
		this.type = new Integer(0);
		this.serie = new ArrayList<Double>();
	}

	public Move(Integer type) {
		this.type = type;
		this.serie = new ArrayList<Double>();
	}

	public Move(int type) {
		this.type = new Integer(type);
		this.serie = new ArrayList<Double>();
	}

	public void setType(Integer type) { this.type = type; }

	public void setType(int type) { this.type = new Integer(type); }

	public void setSerie(Double value) { this.serie.add(value); }

	public void setSerie(double value) { this.serie.add(new Double(value)); }

	public Integer getType() { return this.type; }

	public ArrayList<Double> getSerie() { return this.serie; }
}
