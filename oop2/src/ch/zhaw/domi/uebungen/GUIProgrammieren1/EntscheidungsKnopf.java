package ch.zhaw.domi.uebungen.GUIProgrammieren1;
import java.util.ArrayList;
import java.util.Random;


public class EntscheidungsKnopf {
	
	private ArrayList<String> textList;
	private Random generator;
	
	public EntscheidungsKnopf(){
		textList = new ArrayList<String>();
		generator = new Random();
	}
	
	public String RandomString(){
		
		String randomText = textList.get(generator.nextInt(textList.size()));
		
		return randomText;
	}
	
	public void addTexttoList(String newText){
		textList.add(newText);
		
	}

}
