package ch.zhaw.domi.vorlesung.vorlesung_03_21_2012;

import java.io.File;
import java.io.IOException;


public class Filewriter {
	
public static void main(String[] args) {

	
	File dir = new File("/Volumes/Stuff/dpe/Desktop/einOrdner");
	
	dir.mkdir();
	
	File file1 = new File(dir, "Datei.txt");
	File file2 = new File(dir, "Datei2.txt");

try {
	
	
	file1.createNewFile();
	file2.createNewFile();
	

	
	
} catch (IOException e){
	e.printStackTrace();
	

}
}
}
