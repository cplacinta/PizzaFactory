package com.placinta.pizzafactory.builder;

public class OrderBuilder {
  private String name;
  private PizzaBuilder pizzaBuilder = new PizzaBuilder();

  public Order build() {
    return new Order(name, pizzaBuilder.build());
  }

  public void setName(String name) {
    this.name = name;
  }

}
