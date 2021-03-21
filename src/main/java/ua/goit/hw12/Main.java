package ua.goit.hw12;

import java.util.concurrent.Phaser;

public class Main {
    Phaser phaser = new Phaser(3);
    static String INPUUT = "HHHHHHHHHHHHOOOOOOHHHHHHOO";

    public static void main(String[] args) {
        new Main().makeWater();

    }

    public void makeWater(){
        int i = 1;
        while (i <= INPUUT.length()/3){
            new Oxygen(phaser);
            new Hydrogen(phaser);
            new Hydrogen(phaser);
            i++;
        }
    }

    static class Oxygen extends Thread{
        Phaser phaser;

        public Oxygen(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run(){
            System.out.print("O");
            phaser.arriveAndAwaitAdvance();
        }
    }

    static class Hydrogen extends Thread{
        Phaser phaser;

        public Hydrogen(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run(){
            System.out.print("H");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
