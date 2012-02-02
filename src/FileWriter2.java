import java.io.*;
import java.util.*;
import java.lang.*;

public class FileWriter2 {

	// private Formatter formatter;

	public void save(float xp, int level) throws IOException {

		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("lolol.txt", true));
			writer.write(xp + " " + level + "\n");			
			// writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}
}
