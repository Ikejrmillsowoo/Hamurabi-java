package hammurabi;
 import java.util.Random;
 import java.util.Scanner;


public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new Hammurabi().playGame();
    }


    void playGame() {
        int pricePerBushel = 19;
        int bushels = 2800;
        int acresOwned = 1000;
        int population = 100;
        int bushelsFedToPeople;
        int howManyPeopleStarved;
        int grainsInStorage;
        int currentYear = 1;
        int numberDied = 0;
        int immigrants = 5;
        int bushelsHarvested = 3000;
        int harvestRate = bushelsHarvested/acresOwned;

        System.out.print("\n " +
                "O great Hammurabi!\n" +
                "You are in year "  + currentYear + " of your ten year rule.\n" +
                "In the previous year " + numberDied+ " people starved to death.\n" +
                "In the previous year " + immigrants  + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested "+ bushelsHarvested + " bushels at " +harvestRate +" bushels per acre.\n" +
                "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                "The city owns 1000 acres of land.\n" +
                "Land is currently worth 19 bushels per acre.");

        int acresToBuy = askHowManyAcresToBuy(pricePerBushel, bushels);
        acresOwned += acresToBuy;
        if (acresToBuy == 0){
            acresOwned = acresToBuy - askHowManyAcresToSell(acresOwned);
        } else {
            bushelsFedToPeople = askHowMuchGrainToFeedPeople(bushels);
        }
        askHowManyAcresToPlant(acresOwned,population,bushels);
    }

    public int getUserInput(String string){
        System.out.println(string);
       return scanner.nextInt();
    }

    public int askHowManyAcresToBuy(int price, int bushels){
        int numberOfAcresToBuy = getUserInput("How many acres do you want to buy?");
        if ((numberOfAcresToBuy * price)  <  bushels ){
            return numberOfAcresToBuy;
        } else {
            //getUserInput("How many acres do you want to buy?");
            throw new IllegalArgumentException("You cant afford that many acres");
        }

    }

    public  int askHowManyAcresToSell(int acresOwned){
        int acresToSell = getUserInput("How many acres do you want to sell?");
        if (acresToSell > acresOwned){
            throw new IllegalArgumentException("Cant sell more than you have");
        } else {
            return acresToSell;
        }

    }

    public int askHowMuchGrainToFeedPeople(int bushels){
        int grainToFeedPeople = getUserInput("How much grain do you want to feed the people");
        if (grainToFeedPeople < bushels){
            return grainToFeedPeople;
        } else {
            throw new IllegalArgumentException("You can only fee from what you have");
        }
    }

    public  int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        int numberOfAcresToPlant = getUserInput("How many acres do you want to plant?");
        if (numberOfAcresToPlant < acresOwned && numberOfAcresToPlant/10 < population && numberOfAcresToPlant/2 < bushels){
            return numberOfAcresToPlant;
        } else {
            throw new IllegalArgumentException("You can plant that much");
        }

    }


    public int plagueDeaths(int population) {

        return (rand.nextInt(0,15)/100) * population;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        return population%(bushelsFedToPeople/20);
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        return ((.45)*population)<howManyPeopleStarved;
    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
       return (20 * acresOwned + grainInStorage)/(100*population) + 1;
//        return 0;
    }

    public int harvest(int acres) {
//        if (acres < ) {
//
//        }
        System.out.println(acres * rand.nextInt(1,6));
        return acres * rand.nextInt(1,7);
    }

    public int grainEatenByRats(int i) {
            return 0;
    }

    public int newCostOfLand() {
        return 0;
    }
}