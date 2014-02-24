package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.Topping;

import java.util.Set;

public class Pizza {

  private double price = 10;
  private Set<Topping> toppings;

  public Pizza(Set<Topping> toppings) {
    this.toppings = toppings;
  }

  public double getPrice() {
    for (Topping topping : toppings) {
      price += topping.getPrice();
    }
    return price;
  }

}
