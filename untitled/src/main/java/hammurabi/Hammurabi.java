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
        int bushelsFedToPeople = 0;
        int howManyPeopleStarved = 0;
        int plaguesDeath = 0;
        int grainsInStorage = 0;
        int currentYear = 1;
        int immigrants = 5;
        int bushelsHarvested = 3000;
        int harvestRate = bushelsHarvested / acresOwned;
        int numberOfDestroyedGrain = 0;

        while (currentYear <= 10){
        System.out.print("\n " +
                "O great Hammurabi!\n" +
                "You are in year " + currentYear + " of your ten year rule.\n" +
                "In the previous year " + howManyPeopleStarved + " people starved to death.\n" +
                "In the previous year " + immigrants + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushelsHarvested + " bushels at " + harvestRate + " bushels per acre.\n" +
                "Rats destroyed " + numberOfDestroyedGrain + " bushels, leaving " + grainsInStorage + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + pricePerBushel + " bushels per acre.");

        int acresToBuy = askHowManyAcresToBuy(pricePerBushel, bushels);
        acresOwned += acresToBuy;
        if (acresToBuy == 0) {
            acresOwned = acresToBuy - askHowManyAcresToSell(acresOwned);
        } else {
            bushelsFedToPeople = askHowMuchGrainToFeedPeople(bushels);
        }
        askHowManyAcresToPlant(acresOwned, population, bushels);

        population = population - plagueDeaths(population);
        howManyPeopleStarved = starvationDeaths(population, bushelsFedToPeople);
        uprising(population, howManyPeopleStarved);
        immigrants = immigrants(population, acresOwned, grainsInStorage);
        bushelsHarvested = harvest(acresOwned);

        currentYear++;
    }
    }

    public int getUserInput(String string){
        System.out.println(string);
       return scanner.nextInt();
    }

    public int askHowManyAcresToBuy(int price, int bushels){
        int numberOfAcresToBuy = getUserInput("\n How many acres do you want to buy?");;
        if ((numberOfAcresToBuy * price)  <  bushels ){
            return numberOfAcresToBuy;
        } else {
            System.out.println("You cant afford that many acres");
            return askHowManyAcresToBuy(price, bushels);
        }

    }

    public  int askHowManyAcresToSell(int acresOwned){
        int numberToCheck = getUserInput("\n How many acres do you want to sell?");
        int acresToSell = (numberToCheck < acresOwned)? numberToCheck : getUserInput("\n How many acres do you want to sell? you only have " + acresOwned + " to sell.");
//        if (acresToSell > acresOwned){
//            throw new IllegalArgumentException("Cant sell more than you have");
//        } else {
            return acresToSell;
//        }

    }

    public int askHowMuchGrainToFeedPeople(int bushels){
        int numberToCheck = getUserInput("\n How much grain do you want to feed the people?");
        int grainToFeedPeople = numberToCheck < bushels? numberToCheck : getUserInput("How much grain do you want to feed the people. you only have " + bushels + " to feed.");
       // if (grainToFeedPeople < bushels){
            return grainToFeedPeople;
//        } else {
//            throw new IllegalArgumentException("You can only fee from what you have");
//        }
    }

    public  int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        int numberToCheck = getUserInput("\n How much grain do you want to feed the people?");
        int numberOfAcresToPlant = getUserInput("How many acres do you want to plant?");
        if (numberOfAcresToPlant < acresOwned && numberOfAcresToPlant/10 < population && numberOfAcresToPlant/2 < bushels){
            return numberOfAcresToPlant;
        } else {
            throw new IllegalArgumentException("You can plant that much");
        }

    }


    public int plagueDeaths(int population) {
        int r = rand.nextInt(1,100);
        int plagueDeaths = 0;
        if (r <= 15){
            plagueDeaths =  population/2;
        }
        return plagueDeaths;
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
       // System.out.println(acres * rand.nextInt(1,6));
        return acres * rand.nextInt(1,7);
    }

    public int grainEatenByRats(int i) {
            return 0;
    }

    public int newCostOfLand() {
        return 0;
    }


}