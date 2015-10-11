/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.defaultMethods;

public class DefaultMethodTester {

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.print();
    }

    interface Vehicle {
        default void print() {
            System.out.println("I am a vehicle!");
        }
        
        static void blowHorn() {
            System.out.println("Blowing horn!!!");
        }
    }

    interface FourWheeler {
        default void print() {
            System.out.println("I am a four wheeler!");
        }
    }

    static class Car implements Vehicle, FourWheeler {
        public void print() {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("I am a car!");
        }
    }
}
