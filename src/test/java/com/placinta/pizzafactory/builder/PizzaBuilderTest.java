package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.InvalidToppingCountException;
import com.placinta.pizzafactory.model.Topping;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

@Test
public class PizzaBuilderTest {

  public static final String NOT_THE_EXPECTED_TOPPINGS = "Not the expected toppings";
  private PizzaBuilder pizzaBuilder;

  @BeforeMethod
  protected void setUp() throws Exception {
    pizzaBuilder = new PizzaBuilder();
  }

  public void testBuildBasicPizza() {
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Pizza pizza = pizzaBuilder.build();
    Assert.assertTrue(pizza.getToppings().isEmpty());
  }

  public void testBuildPizzaWithCheese() {
    Set<Topping> cheeses = new HashSet<>();
    cheeses.add(Topping.FETA);
    cheeses.add(Topping.PARMESAN);
    cheeses.add(Topping.MOZZARELLA);

    pizzaBuilder.setToppings(cheeses);

    Assert.assertSame(pizzaBuilder.build().getToppings(), cheeses, NOT_THE_EXPECTED_TOPPINGS);
  }

  @Test(expectedExceptions = InvalidToppingCountException.class, expectedExceptionsMessageRegExp = "Too much cheese")
  public void testPizzaCanOnlyContainThreeCheeses() {
    Set<Topping> cheeses = new HashSet<>();
    cheeses.add(Topping.FETA);
    cheeses.add(Topping.PARMESAN);
    cheeses.add(Topping.MOZZARELLA);
    cheeses.add(Topping.EDAM);

    pizzaBuilder.setToppings(cheeses);
  }

  public void testBuildPizzaWithMeat() {
    Set<Topping> meats = new HashSet<>();
    meats.add(Topping.BACON);
    meats.add(Topping.HAM);

    pizzaBuilder.setToppings(meats);

    Assert.assertSame(pizzaBuilder.build().getToppings(), meats, NOT_THE_EXPECTED_TOPPINGS);
  }

  @Test(expectedExceptions = InvalidToppingCountException.class, expectedExceptionsMessageRegExp = "Too much meat")
  public void testPizzaCanOnlyContainTwoMeats() {
    Set<Topping> meats = new HashSet<>();
    meats.add(Topping.BACON);
    meats.add(Topping.PROSCIUTTO);
    meats.add(Topping.HAM);

    pizzaBuilder.setToppings(meats);
  }

  public void testBuildPizzaWithVegetables() {
    Set<Topping> vegetables = new HashSet<>();
    vegetables.add(Topping.FRESH_MUSHROOMS);
    vegetables.add(Topping.SMOKED_MUSHROOMS);
    vegetables.add(Topping.RED_ONION);
    vegetables.add(Topping.TOMATOES);
    vegetables.add(Topping.GARLIC);

    pizzaBuilder.setToppings(vegetables);

    Assert.assertSame(pizzaBuilder.build().getToppings(), vegetables, NOT_THE_EXPECTED_TOPPINGS);
  }

  @Test(expectedExceptions = InvalidToppingCountException.class,
      expectedExceptionsMessageRegExp = "Too many vegetables")
  public void testPizzaCanOnlyContainFiveVegetables() {
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
