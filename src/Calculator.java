import java.io.*;

public class Calculator {
    public static void main(String[] args) {
        File file = new File("dzialania.txt");
        File fileWrite = new File("wyniki.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(fileWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(" ");
                System.out.println((array[0]) + " " + array[1] + " " + (array[2]) + " = " + (count(array)));
                bufferedWriter.write((array[0]) + " " + array[1] + " " + (array[2]) + " = " + (count(array)));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Błąd pliku");
        }
    }

    private static double count(String[] array) {
        char sign = array[1].charAt(0);
        double result = 0;

        switch (sign) {
            case '+':
                result = Double.parseDouble(array[0]) + Double.parseDouble(array[2]);
                break;
            case '-':
                result = Double.parseDouble(array[0]) - Double.parseDouble(array[2]);
                break;
            case '*':
                result = Double.parseDouble(array[0]) * Double.parseDouble(array[2]);
                break;
            case '/':
                result = Double.parseDouble(array[0]) / Double.parseDouble(array[2]);
                break;
        }
        return result;
    }
}
