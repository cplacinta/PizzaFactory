package com.placinta.pizzafactory.builder;

public class Order {

  private final String name;
  private Pizza pizza;

  public Order(String name, Pizza pizza) {
    this.name = name;
    this.pizza = pizza;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return pizza.getPrice();
  }

}
