package ch.zhaw.domi.vorlesung.vorlesung_03_14_2012;

import java.io.Serializable;


public class Motor implements Serializable {
	
	
	private int hubraum;
	
	
	public Motor (int Hubraum){
		this.hubraum = Hubraum;
	}

	public int getHubraum() {
		return hubraum;
	}

	public void setHubraum(int hubraum) {
		this.hubraum = hubraum;
	}

}
