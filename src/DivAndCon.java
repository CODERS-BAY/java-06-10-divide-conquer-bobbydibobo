import java.util.Random;
import java.util.Scanner;

public class DivAndCon {

    public static void main(String[] args) {

        int[] rndArray=fillRandomly();

        System.out.println("Your Array is: ");
        for (int i = 0; i < rndArray.length; i++){
            System.out.print("[" + rndArray[i] + "]");
        }

       findMax(rndArray, rndArray);

    }

    public static int[] fillRandomly (){

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Define the length of your Array.");
        int arrayLength = scan.nextInt();

        int[] emptyArray = new int[arrayLength];

        for (int i = 0; i < emptyArray.length; i++){
            emptyArray[i] = rnd.nextInt(100+1);

        }
        return emptyArray;
    }

    public static int findMax(int[] yourArray, int[] initialArray){
        int[] tempArray = initialArray;
        int max = tempArray[0];

       if (yourArray.length == 1){

           for (int i = 0; i < tempArray.length; i++){
               if (tempArray[i] > max){
                   max = tempArray[i];
               }
           }

           if (yourArray[0] == max){
               System.out.println();
               System.out.println("Max Numb is: " + yourArray[0]);
           }

           return yourArray[0];

       } else {

           int [] leftArray = new int[yourArray.length/2];
           int [] rightArray = new int[yourArray.length - leftArray.length];

           for (int i = 0; i < yourArray.length; i++){
               if (i < (leftArray.length)){
                   leftArray[i] = yourArray[i];
               } else {
                   rightArray[i - leftArray.length] = yourArray[i];
               }

           }
               int maxLeft = findMax(leftArray, tempArray);
               int maxRight = findMax(rightArray, tempArray);

               if (maxLeft > maxRight){
                   return maxLeft;
               } else {
                   return maxRight;
               }
       }
    }


}
