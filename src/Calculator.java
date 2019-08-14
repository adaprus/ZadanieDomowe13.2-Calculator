import java.io.*;

public class Calculator {
    public static void main(String[] args) {
        File file = new File("dzialania.txt");
        File fileWrite = new File("wyniki.txt");

        if (!fileWrite.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(fileWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(" ");
                System.out.println((array[0]) + " + " + (array[2]) + " = " + (Integer.parseInt(array[0]) + Integer.parseInt(array[2])));
                bufferedWriter.write((array[0]) + " + " + (array[2]) + " = "
                        + (Integer.parseInt(array[0]) + Integer.parseInt(array[2])));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Błąd pliku");
        }
    }
}
