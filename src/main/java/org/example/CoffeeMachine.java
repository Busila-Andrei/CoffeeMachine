package org.example;

import java.util.Scanner;

public class CoffeeMachine {
    int water;
    int milk;
    int beans;
    int cups;
    int money;
    Scanner scanner;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        scanner = new Scanner(System.in);
        action();
    }

    public void action() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();

        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
            case "exit":
                break;
        }
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String a = scanner.next();
        switch (a) {
            case "1":
                coffee(250,0,16,1,4);
                break;
            case "2":
                coffee(350,75,20,1,7);
                break;
            case "3":
                coffee(200,100,12,1,6);
                break;
            case "back":
                action();
                break;
        }
    }

    public void coffee(int water, int milk, int beans, int cups, int money) {
        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
            action();
        }
        else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
            action();
        }
        else if (this.beans < beans) {
            System.out.println("Sorry, not enough beans!");
            action();
        }
        if (this.cups < cups) {
            System.out.println("Sorry, not enough cups!");
            action();
        } else {
            this.water = this.water - water;
            this.milk = this.milk - milk;
            this.beans = this.beans - beans;
            this.cups = this.cups - cups;
            this.money = this.money + money;
            System.out.println("I have enough resources, making you a coffee!");
            action();
        }
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        this.water = this.water + scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk = this.milk + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.beans = this.beans + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups = this.cups + scanner.nextInt();
        action();
    }

    public void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
        action();
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println("$" + this.money + " of money");
        action();
    }
}
