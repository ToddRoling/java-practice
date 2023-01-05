package com.github.toddroling.java.interview.preperation.designpatterns.factory;

// My solution to https://www.hackerrank.com/challenges/java-factory/problem
// Note I think these would be better separated into different files, but the problem requires this style
interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {

        // I would put the following formatting lines into a separate method if the problem allowed
        order = order.toLowerCase();
        order = order.substring(0, 1).toUpperCase() + order.substring(1);

        try {
            Class<?> clazz = Class.forName(order);
            return (Food) clazz.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException reflectiveOperationException) {
            return null;
        }
    }
}