package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.Topping;

import java.util.Set;

public class Pizza {

  private Set<Topping> toppings;

  public Pizza(Set<Topping> toppings) {
    this.toppings = toppings;
  }

}
