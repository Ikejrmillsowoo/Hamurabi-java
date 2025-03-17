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
                    "------------------------------------------------------------------\n " +
                    "O great Hammurabi!\n" +
                    "You are in year " + currentYear + " of your ten year rule.\n" +
                    "In the previous year " + howManyPeopleStarved + " people starved to death.\n" +
                    "In the previous year " + immigrants + " people entered the kingdom.\n" +
                    "The population is now " + population + ".\n" +
                    "We harvested " + bushelsHarvested + " bushels at " + harvestRate + " bushels per acre.\n" +
                    "Rats destroyed " + numberOfDestroyedGrain + " bushels, leaving " + grainsInStorage + " bushels in storage.\n" +
                    "The city owns " + acresOwned + " acres of land.\n" +
                    "Land is currently worth " + pricePerBushel + " bushels per acre. \n" +
                    "----------------------------------------------------------------------");

            int acresToBuy = askHowManyAcresToBuy(pricePerBushel, bushels);
            acresOwned += acresToBuy;
            if (acresToBuy == 0) {
                acresOwned = acresOwned - askHowManyAcresToSell(acresOwned);
            }
            bushelsFedToPeople = askHowMuchGrainToFeedPeople(bushels);
            grainsInStorage += askHowManyAcresToPlant(acresOwned, population, bushels);
            bushels -= grainsInStorage;
            population = population - plagueDeaths(population);
            howManyPeopleStarved = starvationDeaths(population, bushelsFedToPeople);
            population -= howManyPeopleStarved;
            if (uprising(population, howManyPeopleStarved)){
                currentYear = 11;
                System.out.println("Game Over: There was an uprising, You have been thrown out of power!");
            };
            if (howManyPeopleStarved == 0){
                immigrants = immigrants(population, acresOwned, grainsInStorage);
                population += immigrants;
            }
            bushelsHarvested = harvest(acresOwned);
            bushels += bushelsHarvested;

            currentYear++;
        }
        System.exit(0);
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
        int acresToSell = getUserInput("\n How many acres do you want to sell?");
        if (acresToSell < acresOwned){
            return acresToSell;
        } else {
            System.out.println("You do not own that many acres. You only have "+ acresOwned + " to sell");
            return askHowManyAcresToSell(acresOwned);
        }
    }

    public int askHowMuchGrainToFeedPeople(int bushels) {
        int grainToFeedPeople = getUserInput("\n How much grain do you want to feed the people?");
        if (grainToFeedPeople < bushels) {
            return grainToFeedPeople;
        } else {
            System.out.println("You can only feed from what you have");
            return askHowMuchGrainToFeedPeople(bushels);
        }
    }

    public  int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        int numberOfAcresToPlant = getUserInput("How many acres do you want to plant?");
        if (numberOfAcresToPlant < acresOwned && numberOfAcresToPlant/10 < population && numberOfAcresToPlant/2 < bushels){
            return numberOfAcresToPlant;
        } else {
            System.out.println("You can plant that much");
            return askHowManyAcresToPlant(acresOwned, population, bushels);
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

    public int grainEatenByRats(int bushels) {
        return 0;
    }

    public int newCostOfLand() {
        return 0;
    }


}