package ch.zhaw.domi.vorlesung.vorlesung_03_14_2012;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class AutosSerialisieren {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
//		Auto a = new Auto("rot", new Motor(1200));
//		
//		FileOutputStream fos = new FileOutputStream("/Volumes/Stuff/dpe/Desktop/auto.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		
//		oos.writeObject(a);
//		oos.close();
		
		FileInputStream fis = new FileInputStream("/Volumes/Stuff/dpe/Desktop/auto.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		
		Auto auto = (Auto) ois.readObject();
		ois.close();
		System.out.println(" Farbe: " + auto.getFarbe());
		
		
	}
}
