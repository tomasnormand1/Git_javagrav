import java.io.*;
import java.util.*;

public class FileReader2 {
	/**
	 * scanner to read the content of the txt file
	 */
	private Scanner scanner;
	
	/**
	 * strings that go into teh arraylist of scores
	 */
	private String a;
	private String b;
	
	/**
	 * arraylist to store the high scores loaded from file
	 */
	private ArrayList<String> Scores;
	
	/**
	 * open the file from the directory 
	 */
	public void loadFile() {
		try {
			scanner = new Scanner(new File("lolol.txt"));
		} catch (Exception e) {
			System.out.println("error loading file");
		}
	}
	
	/**
	 * read the file of its contents and pull out the data as strings
	 */
	public void readFile() {
		Scores = new ArrayList<String>();
		while(scanner.hasNext()) {
			String a = scanner.next();
			this.a = a;
			//System.out.printf("%s \n", a);
			Scores.add(a);
		}
	}
	
	/**
	 * put strings into arraylist
	 */
	public int addToScoreBoard() {
		return Scores.size();
	}

	/**
	 * @return the arraylist of strings of scores
	 */
	public ArrayList<String> getArrayStuff() {
		return Scores;
	}
	
	/**
	 * @return the string from file (first element)
	 */
	public String showString1() {
		return a;
	}
	
	/**
	 * close the file 
	 */
	public void closeFile() {
		scanner.close();
	}
}
