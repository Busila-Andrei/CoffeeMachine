package org.example;

import org.example.utils.ScannerUtils;

public class Start {
    private final CoffeeMachine coffeeMachine = new CoffeeMachine();
    public void start(){
        logic();
    }


    public void logic() {
        System.out.print("Write action (buy, fill, take, remaining, exit): ");
        String action = ScannerUtils.nextLine();

        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                remaining();
            case "exit":
                break;
        }
    }

    public void buy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String a = ScannerUtils.nextLine();
        switch (a) {
            case "1":
                makeCoffee(250, 0, 16, 1, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 1, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 1, 6);
                break;
            case "back":
                logic();
                break;
        }
    }

    public void fill() {
        System.out.print("Write how many ml of water do you want to add: ");
        coffeeMachine.setWater(coffeeMachine.getWater() + ScannerUtils.nextIntAndMoveToNextLine());
        System.out.print("Write how many ml of milk do you want to add: ");
        coffeeMachine.setMilk(coffeeMachine.getMilk() + ScannerUtils.nextIntAndMoveToNextLine());
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        coffeeMachine.setBeans(coffeeMachine.getBeans() + ScannerUtils.nextIntAndMoveToNextLine());
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        coffeeMachine.setCups(coffeeMachine.getCups() + ScannerUtils.nextIntAndMoveToNextLine());
        logic();
    }

    public void takeMoney() {
        System.out.println("I gave you $" + coffeeMachine.getMoney());
        coffeeMachine.setMoney(0);
        logic();
    }

    public void remaining() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(coffeeMachine.getWater() + " of water");
        System.out.println(coffeeMachine.getMilk() + " of milk");
        System.out.println(coffeeMachine.getBeans() + " of coffee beans");
        System.out.println(coffeeMachine.getCups() + " of disposable cups");
        System.out.println("$" + coffeeMachine.getMoney() + " of money\n");
        logic();
    }

    public void makeCoffee(int water, int milk, int beans, int cups, int money) {
        if (coffeeMachine.getWater() < water) {
            System.out.println("Sorry, not enough water!");
            logic();
        } else if (coffeeMachine.getMilk() < milk) {
            System.out.println("Sorry, not enough milk!");
            logic();
        } else if (coffeeMachine.getBeans() < beans) {
            System.out.println("Sorry, not enough beans!");
            logic();
        } else if (coffeeMachine.getCups() < cups) {
            System.out.println("Sorry, not enough cups!");
            logic();
        } else {
            coffeeMachine.setWater(coffeeMachine.getWater() - water);
            coffeeMachine.setMilk(coffeeMachine.getMilk() - milk);
            coffeeMachine.setBeans(coffeeMachine.getBeans() - beans);
            coffeeMachine.setCups(coffeeMachine.getCups() - cups);
            coffeeMachine.setMoney(coffeeMachine.getMoney() + money);
            System.out.println("I have enough resources, making you a coffee!");
            logic();
        }
    }

}
