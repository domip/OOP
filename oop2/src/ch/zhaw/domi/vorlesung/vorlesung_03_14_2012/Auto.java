package ch.zhaw.domi.vorlesung.vorlesung_03_14_2012;

import java.io.Serializable;


public class Auto implements Serializable {

	private String farbe;
	private Motor motor;
	
	public Auto(String farbe, Motor motor){
		
		this.farbe = farbe;
		this.motor = motor;
	}

	public String getFarbe() {
		return farbe;
	}


	public Motor getMotor() {
		return motor;
	}

}

