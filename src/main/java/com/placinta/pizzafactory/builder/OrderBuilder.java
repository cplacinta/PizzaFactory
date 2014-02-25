package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.InvalidNameException;

public class OrderBuilder {
  private String name;
  private PizzaBuilder pizzaBuilder;

  public Order build() throws InvalidNameException {
    if (name == null || name.isEmpty()) {
      throw new InvalidNameException("Invalid name provided");
    }
    return new Order(name, pizzaBuilder.build(), pizzaBuilder.getPrice());
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
    this.pizzaBuilder = pizzaBuilder;
  }

}
