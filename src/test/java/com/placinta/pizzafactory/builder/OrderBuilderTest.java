package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.InvalidNameException;
import com.placinta.pizzafactory.model.Topping;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


@Test
public class OrderBuilderTest {

  public static final String NAME_DIFFERENT_THAN_EXPECTED = "Name is different than expected";

  public void testBasicOrderForGeorge() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("George");
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    orderBuilder.setPizzaBuilder(pizzaBuilder);
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "George", NAME_DIFFERENT_THAN_EXPECTED);
  }

  public void testBasicOrderForIon() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("Ion");
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    orderBuilder.setPizzaBuilder(pizzaBuilder);
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
  }

  @Test(expectedExceptions = InvalidNameException.class, expectedExceptionsMessageRegExp = "Invalid name provided")
  public void testBasicOrderWithNoName() {
    OrderBuilder orderBuilder = new OrderBuilder();
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    orderBuilder.setPizzaBuilder(pizzaBuilder);
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
  }

  public void testOrderWithNameAndPizza() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("Ion");
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    orderBuilder.setPizzaBuilder(pizzaBuilder);
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
    Assert.assertEquals(order.getPrice(), 10D, "Price is different than expected");
  }

  public void testOrderWithNameAndPizzaWithOneTopping() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("Ion");

    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> toppings = new HashSet<>();
    toppings.add(Topping.FETA);
    pizzaBuilder.setToppings(toppings);

    orderBuilder.setPizzaBuilder(pizzaBuilder);
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
    Assert.assertEquals(order.getPrice(), 60D, "Price is different than expected");
  }

  public void testOrderWithNameAndPizzaWithMultipleToppings() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("Ion");

    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> toppings = new HashSet<>();
    toppings.add(Topping.FETA);
    toppings.add(Topping.PROSCIUTTO);
    toppings.add(Topping.BACON);
    pizzaBuilder.setToppings(toppings);

    orderBuilder.setPizzaBuilder(pizzaBuilder);
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
    Assert.assertEquals(order.getPrice(), 310D, "Price is different than expected");
  }

  public void testOrderIdIsRandomAndInTheExpectedRange() throws InterruptedException {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("Ion");

    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    Set<Topping> toppings = new HashSet<>();
    toppings.add(Topping.FETA);
    toppings.add(Topping.PROSCIUTTO);
    toppings.add(Topping.BACON);
    pizzaBuilder.setToppings(toppings);

    orderBuilder.setPizzaBuilder(pizzaBuilder);
    Order order1 = orderBuilder.build();
    //Thread.sleep(1000);
    Order order2 = orderBuilder.build();

    Assert.assertTrue(order1.getId() > 99 && order1.getId() < 1000);
    Assert.assertTrue(order2.getId() > 99 && order2.getId() < 1000);
    Assert.assertNotEquals(order1.getId(), order2.getId(), "Order ids are the same");
  }

}

