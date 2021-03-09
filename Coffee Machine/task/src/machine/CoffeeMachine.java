package machine;

import java.util.*;

public class CoffeeMachine {
    public static int water = 400;
    public static int milk = 540;
    public static int beans = 120;
    public static int cups = 9;
    public static int money = 550;
    public static String action = "";
    public static boolean makable = false;

    public static void main(String[] args) {

        // create an instance of a coffee machine
        machineAction();
    } // end of main method

    public void machineStatus() {
        System.out.println("The coffee machine has: ");
        System.out.printf("%d of water\n%d of milk\n%d of beans\n%d of disposable cups\n%d of money\n\n", water, milk, beans, cups, money);
    }

    public void makeCoffee() {
        System.out.println("Starting to make a coffee...");
        System.out.println("Grinding coffee beans...");
        System.out.println("Boiling water...");
        System.out.println("Mixing boiled water with crushed coffee beans...");
        System.out.println("Pouring coffee into the cup...");
        System.out.println("Pouring some milk into the cup...");
        System.out.println("Coffee is ready!");
    }

    public void countMakeableCups(int waterNeeded, int milkNeeded, int beansNeeded, int cupsNeeded) {

        if (water / waterNeeded < 1 || beans / beansNeeded < 1 || cups / cupsNeeded < 1) {
            makable = false;
        }
        if (water / waterNeeded < 1) {
            System.out.print("Sorry, not enough water!" + "\n");
        } else if (milkNeeded != 0 && milk / milkNeeded < 1) {
            System.out.print("Sorry, not enough milk! " + "\n");
            makable = false;
        } else if (beans / beansNeeded < 1) {
            System.out.print("Sorry, not enough beans! " + "\n");
        } else if (cups / cupsNeeded < 1) {
            System.out.print("Sorry, not enough cups!" + "\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!" + "\n");
            makable = true;
        }
    }

    public static void machineAction() {

        CoffeeMachine myCoffeeMachine = new CoffeeMachine();
        Scanner userInput = new Scanner(System.in);

        do {

            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            action = userInput.next();


            switch (action) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String coffee = userInput.next();
                    switch (coffee) {
                        case "1":
                            System.out.println();
                            myCoffeeMachine.countMakeableCups(250, 0, 16, 1);
                            if (makable) {
                                water -= 250;
                                beans -= 16;
                                cups -= 1;
                                money += 4;
                            }
                            myCoffeeMachine.makeCoffee();
                            break;

                        case "2":
                            System.out.println();
                            myCoffeeMachine.countMakeableCups(350, 75, 20, 1);
                            if (makable) {
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups -= 1;
                                money += 7;
                            }
                            myCoffeeMachine.makeCoffee();
                            break;

                        case "3":
                            System.out.println();
                            myCoffeeMachine.countMakeableCups(200, 100, 12, 1);
                            if (makable) {
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups -= 1;
                                money += 6;
                            }
                            myCoffeeMachine.makeCoffee();
                            break;

                        case "back":
                            break;

                        default:
                            System.out.println("Wrong choice!" + "\n");
                            break;
                    }
                    break;

                case "fill":
                    System.out.print("\nWrite how many ml of water do you want to add: " + "\n");
                    water += userInput.nextInt();
                    System.out.print("\nWrite how many ml of milk do you want to add: " + "\n");
                    milk += userInput.nextInt();
                    System.out.print("\nWrite how many g of beans do you want to add: " + "\n");
                    beans += userInput.nextInt();
                    System.out.print("\nWrite how many disposable coffee cups do you want to add: " + "\n");
                    cups += userInput.nextInt();
                    System.out.println();

                    break;

                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    System.out.println();

                    break;

                case "remaining":
                    myCoffeeMachine.machineStatus();

                    break;

                case "exit":
                    userInput.close();
                    action = "exit";
                    break;

                default:
                    System.out.println("Wrong action!" + "\n");
                    break;
            }
        } while (!"exit".equals(action));


    }   //end of machineAction();   


    public void calcIngredientsTotal(int cups) {

        // constants
        // ml
        int waterOneCup = 200;
        int water = waterOneCup * cups;
        // ml
        int milkOneCup = 50;
        int milk = milkOneCup * cups;
        // g
        int beansOneCup = 15;
        int beans = beansOneCup * cups;

        System.out.printf("For %d cups of coffee you will need:\n%7d ml of water\n%7d ml of milk\n%7d  g of coffee beans\n", cups, water, milk, beans);

    }
}  // end of class
    