package org.example.service;

import org.example.controller.utils.ScannerUtils;
import org.example.domain.Coffee;

public class Menu {
    private final Coffee coffee = new Coffee();

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
        coffee.setWater(coffee.getWater() + ScannerUtils.nextIntAndMoveToNextLine());
        System.out.print("Write how many ml of milk do you want to add: ");
        coffee.setMilk(coffee.getMilk() + ScannerUtils.nextIntAndMoveToNextLine());
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        coffee.setBeans(coffee.getBeans() + ScannerUtils.nextIntAndMoveToNextLine());
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        coffee.setCups(coffee.getCups() + ScannerUtils.nextIntAndMoveToNextLine());
        logic();
    }

    public void takeMoney() {
        System.out.println("I gave you $" + coffee.getMoney());
        coffee.setMoney(0);
        logic();
    }

    public void remaining() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(coffee.getWater() + " of water");
        System.out.println(coffee.getMilk() + " of milk");
        System.out.println(coffee.getBeans() + " of coffee beans");
        System.out.println(coffee.getCups() + " of disposable cups");
        System.out.println("$" + coffee.getMoney() + " of money\n");
        logic();
    }

    public void makeCoffee(int water, int milk, int beans, int cups, int money) {
        if (coffee.getWater() < water) {
            System.out.println("Sorry, not enough water!");
            logic();
        } else if (coffee.getMilk() < milk) {
            System.out.println("Sorry, not enough milk!");
            logic();
        } else if (coffee.getBeans() < beans) {
            System.out.println("Sorry, not enough beans!");
            logic();
        } else if (coffee.getCups() < cups) {
            System.out.println("Sorry, not enough cups!");
            logic();
        } else {
            coffee.setWater(coffee.getWater() - water);
            coffee.setMilk(coffee.getMilk() - milk);
            coffee.setBeans(coffee.getBeans() - beans);
            coffee.setCups(coffee.getCups() - cups);
            coffee.setMoney(coffee.getMoney() + money);
            System.out.println("I have enough resources, making you a coffee!");
            logic();
        }
    }
}
