package com.company;

public class Dog {
    private final int  MAX = 10;
    private int health;
    private int food;
    private int energy;
    private int sanity;
    private String name;

    public Dog(int health, int food, int energy, int sanity, String name) {
        this.health = health;
        this.food = food;
        this.energy = energy;
        this.sanity = sanity;
        this.name = name;
    }
    public Dog(){
        this.health = 6;
        this.food = 2;
        this.energy = 9;
        this.sanity = 7;
        this.name = "Mura";
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getFood() {
        return food;
    }

    public int getEnergy() {
        return energy;
    }

    public int getSanity() {
        return sanity;
    }
}
