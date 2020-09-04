package src;

import java.util.List;
import java.util.Vector;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileSerialization {

	public static void saveToFile(List<Candidate> candidates) {

        try {

            FileOutputStream fos = new FileOutputStream("candidates.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Candidate c : candidates) {
                oos.writeObject(c);
            }
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Vector<Candidate> readFile() {
        Vector<Candidate> input = new Vector<>();
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("candidates.txt")))) {
            
            while(true) {
                try {
                    input = (Vector<Candidate>) is.readObject();
                    for (Candidate c : input)
                        System.out.println(c);
                    is.close();
                } catch (EOFException e) {
                    break;
                }
            }    
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

}
