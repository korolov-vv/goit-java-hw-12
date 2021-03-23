package ua.goit.hw12;

import java.util.concurrent.Phaser;

public class Main {
    Phaser PHASER = new Phaser(4);
    static String INPUUT = "HHHHHHHHHHHHOOOOOOHHHHHHOO";

    public static void main(String[] args) {
        new Main().makeWater();

    }

    public void makeWater() {
        int phase = 0;

        for (; phase < INPUUT.length() / 3; phase++) {
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
