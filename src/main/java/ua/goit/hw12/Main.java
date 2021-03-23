package ua.goit.hw12;

import java.util.concurrent.Phaser;

public class Main {
    Phaser PHASER = new Phaser(4);
    static String INPUUT = "HHHHHHHHHHHHOOOOOOHHHHHHOO";

    public static void main(String[] args) {
        new Main().makeWater();

    }

    public void makeWater() {
        int i = 1;

        for (; i < INPUUT.length() / 3; i++) {
            new Hydrogen(PHASER);
            new Hydrogen(PHASER);
            new Oxygen(PHASER);
            PHASER.arriveAndAwaitAdvance();
        }
    }

    static class Oxygen extends Thread {
        Phaser phaser;

        public Oxygen(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            System.out.print("O");
            phaser.arriveAndAwaitAdvance();
        }
    }

    static class Hydrogen extends Thread {
        Phaser phaser;

        public Hydrogen(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            System.out.print("H");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
