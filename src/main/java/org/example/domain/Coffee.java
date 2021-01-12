package org.example.domain;

public class Coffee {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public Coffee(int water, int milk, int beans, int cup, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cup;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
