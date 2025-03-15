package hamurabi;
 import java.util.Random;
 import java.util.Scanner;


public class Hamurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new Hamurabi().playGame();
    }


    void playGame() {
        int pricePerBushel = 19;
        int bushels = 2800;
        int acresOwned = 1000;
        int population = 100;
        int bushelsFedToPeople;
        int howManyPeopleStarved;
        int grainsInStorage;

    }

    public int getUserInput(String string){
        System.out.println(string);
       return scanner.nextInt();
    }

    public int askHowManyAcresToBuy(int price, int bushels){

        return 0;
    }

    public  void askHowManyAcresToSell(int acresOwned){

    }

    public  void askHowMuchGrainToFeedPeople(int bushels){

    }

    public  void askHowManyAcresToPlant(int acresOwned, int population, int bushels){

    }
}