package com.placinta.pizzafactory.builder;

public class Order {

  private final String name;
  private final Pizza pizza;
  private final double price;

  public Order(String name, Pizza pizza, double price) {
    this.name = name;
    this.pizza = pizza;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

}
