package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.InvalidToppingCountException;
import com.placinta.pizzafactory.model.Topping;
import com.placinta.pizzafactory.model.ToppingType;

import java.util.HashSet;
import java.util.Set;

public class PizzaBuilder {
  private Set<Topping> toppings = new HashSet<Topping>();
  private int cheeseCounter;
  private int meatCounter;
  private int vegetablesCounter;


  public Pizza build() {
    return new Pizza(toppings);
  }

  public void setToppings(Set<Topping> toppings) {
    for (Topping topping : toppings) {
      if (topping.getToppingType() == ToppingType.CHEESE) {
        cheeseCounter++;
      } else if (topping.getToppingType() == ToppingType.MEAT) {
        meatCounter++;
      } else {
        vegetablesCounter++;
      }

      checkCounter(cheeseCounter, 3, "Too much cheese");
      checkCounter(meatCounter, 2, "Too much meat");
      checkCounter(vegetablesCounter, 5, "Too many vegetables");

      this.toppings = toppings;
    }
  }

  private void checkCounter(int counter, int maxCount, String message) {
    if (counter > maxCount) {
      throw new InvalidToppingCountException(message);
    }
  }

}