import org.apache.commons.text.similarity.LevenshteinDistance;

public class Main {
    public static void main(String[] args) {
        String randomWord =CreateRandomWorlds.pullRandomWord(); // 1
        System.out.println("Random sozler cekildi!");

        CreateRandomWorlds.writeToFile(randomWord); // 2
        System.out.println("Random soz File-a yazildi!");

        String [] randomWordsDinamicArray = CreateRandomWorlds.addToDinamicArr();      // 3
        System.out.println("File-dan randomWords Dinamic arrayine sozler yazildi!");

        // 4

        CreateRandomWorlds.geriSayma();
        long endTime = System.currentTimeMillis() + 60000;
        int rightWord = 0;
        int rightChars =0;

        while (System.currentTimeMillis() < endTime){
            String compWord = CreateRandomWorlds.randomIndex(randomWordsDinamicArray);
            System.out.println(compWord);
            System.out.println("Sozu daxil edin: ");
            String myWord = CreateRandomWorlds.writeWord();
            if (myWord.equals(compWord)){
                rightWord++;
                rightChars= myWord.length() +rightChars;
            }

        }
        System.out.println("Duz sozlerin sayi: " + rightWord);
        double wps = (double) rightWord / 60;
        System.out.println("Saniye basina dusen duz sozlerin sayi: " + wps);
        System.out.println("Duzgun yazilmis charlarin sayi: " + rightChars);









    }
}