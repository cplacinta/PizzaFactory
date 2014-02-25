package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.InvalidToppingCountException;
import com.placinta.pizzafactory.model.Topping;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

@Test
public class PizzaBuilderTest {

  public static final String PRICE_DIFFERENT_THAN_EXPECTED = "The price is different than expected";

  public void testBuildBasicPizza() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Pizza pizza = pizzaBuilder.build();

    Assert.assertEquals(pizza.getPrice(), 10.0D, PRICE_DIFFERENT_THAN_EXPECTED);
  }

  public void testBuildPizzaWithCheese() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> cheeses = new HashSet<>();
    cheeses.add(Topping.FETA);
    cheeses.add(Topping.PARMESAN);
    cheeses.add(Topping.MOZZARELLA);

    pizzaBuilder.setToppings(cheeses);
    Pizza pizza = pizzaBuilder.build();

    Assert.assertEquals(pizza.getPrice(), 160.0D, PRICE_DIFFERENT_THAN_EXPECTED);
  }

  @Test(expectedExceptions = InvalidToppingCountException.class, expectedExceptionsMessageRegExp = "Too much cheese")
  public void testPizzaCanOnlyContainThreeCheeses() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> cheeses = new HashSet<>();
    cheeses.add(Topping.FETA);
    cheeses.add(Topping.PARMESAN);
    cheeses.add(Topping.MOZZARELLA);
    cheeses.add(Topping.EDAM);

    pizzaBuilder.setToppings(cheeses);
  }

  public void testBuildPizzaWithMeat() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> meats = new HashSet<>();
    meats.add(Topping.BACON);
    meats.add(Topping.HAM);

    pizzaBuilder.setToppings(meats);
    Pizza pizza = pizzaBuilder.build();

    Assert.assertEquals(pizza.getPrice(), 225.0D, PRICE_DIFFERENT_THAN_EXPECTED);
  }

  @Test(expectedExceptions = InvalidToppingCountException.class, expectedExceptionsMessageRegExp = "Too much meat")
  public void testPizzaCanOnlyContainTwoMeats() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> meats = new HashSet<>();
    meats.add(Topping.BACON);
    meats.add(Topping.PROSCIUTTO);
    meats.add(Topping.HAM);

    pizzaBuilder.setToppings(meats);
  }

  public void testBuildPizzaWithVegetables() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> vegetables = new HashSet<>();
    vegetables.add(Topping.FRESH_MUSHROOMS);
    vegetables.add(Topping.SMOKED_MUSHROOMS);
    vegetables.add(Topping.RED_ONION);
    vegetables.add(Topping.TOMATOES);
    vegetables.add(Topping.GARLIC);

    pizzaBuilder.setToppings(vegetables);
    Pizza pizza = pizzaBuilder.build();

    Assert.assertEquals(pizza.getPrice(), 60.0, PRICE_DIFFERENT_THAN_EXPECTED);
  }

  @Test(expectedExceptions = InvalidToppingCountException.class,
      expectedExceptionsMessageRegExp = "Too many vegetables")
  public void testPizzaCanOnlyContainFiveVegetables() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> vegetables = new HashSet<>();
    vegetables.add(Topping.FRESH_MUSHROOMS);
    vegetables.add(Topping.SMOKED_MUSHROOMS);
    vegetables.add(Topping.RED_ONION);
    vegetables.add(Topping.TOMATOES);
    vegetables.add(Topping.GARLIC);
    vegetables.add(Topping.PARSLEY);

    pizzaBuilder.setToppings(vegetables);
  }

}
