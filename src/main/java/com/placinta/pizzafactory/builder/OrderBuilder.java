package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.InvalidNameException;
import com.placinta.pizzafactory.model.Topping;

import java.util.Random;

public class OrderBuilder {
  private String name;
  private PizzaBuilder pizzaBuilder;
  private Random random = new Random();
  private double price = 10;

  public Order build() throws InvalidNameException {
    if (name == null || name.isEmpty()) {
      throw new InvalidNameException("Invalid name provided");
    }
    return new Order(generateRandomId(), name, pizzaBuilder.build(), getPrice());
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
    this.pizzaBuilder = pizzaBuilder;
  }

  public double getPrice() {
    for (Topping topping : pizzaBuilder.getToppings()) {
      price += topping.getPrice();
    }
    return price;
  }

  private int generateRandomId() {
    int randomNumber = random.nextInt(999);
    if (randomNumber < 100) {
      randomNumber += 100;
    }
    return randomNumber;
  }

}
