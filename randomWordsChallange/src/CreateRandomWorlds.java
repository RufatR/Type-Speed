import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class CreateRandomWorlds {

    public static String pullRandomWord(){
        String urlPath = "https://random-word-api.herokuapp.com/word";
        try {
            URL url = new URL(urlPath);
            Scanner scanner = new Scanner(url.openStream());
            String randomWord = scanner.useDelimiter("\\A").nextLine();
            String s = randomWord.replace("[\"","");
            String s1 = s.replace("\"]","");
            return s1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void writeToFile(String randomWord){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("randomWords.txt",true));
            bufferedWriter.write(randomWord);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String[] addToDinamicArr(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("randomWords.txt"));
            int arraySize = 0 ;
            while (bufferedReader.readLine() != null){
                arraySize++;
            }
            bufferedReader.close();

            bufferedReader = new BufferedReader(new FileReader("randomWords.txt"));
            String line;
            String[] randomWordsDinamicArr = new String[arraySize];
            int index =0;
            while ((line = bufferedReader.readLine())!= null){
                randomWordsDinamicArr[index] = line;
                index++;
            }
            return randomWordsDinamicArr;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static String randomIndex(String[] arr){
        Random random = new Random();
        int index = random.nextInt(arr.length);

        return arr[index];
    }


    public static void geriSayma()  {
        for (int i = 3; i > 0 ; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 1){
                System.out.println("Start!");
            }
        }
    }


    public static String writeWord(){
        Scanner rr = new Scanner(System.in);
        return rr.nextLine();
    }
}
