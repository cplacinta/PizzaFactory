package com.placinta.pizzafactory.builder;

import com.placinta.pizzafactory.model.InvalidNameException;
import com.placinta.pizzafactory.model.Topping;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


@Test
public class OrderBuilderTest {

  private static final String NAME_DIFFERENT_THAN_EXPECTED = "Name is different than expected";

  private PizzaBuilder pizzaBuilder;
  private OrderBuilder orderBuilder;

  @BeforeMethod
  protected void setUp() throws Exception {
    pizzaBuilder = new PizzaBuilder();
    orderBuilder = new OrderBuilder("Ion", pizzaBuilder);
  }

  public void testBasicOrderForGeorge() {
    orderBuilder = new OrderBuilder("George", pizzaBuilder);
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "George", NAME_DIFFERENT_THAN_EXPECTED);
  }

  public void testBasicOrderForIon() {
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
  }

  @Test(expectedExceptions = InvalidNameException.class, expectedExceptionsMessageRegExp = "Invalid name provided")
  public void testBasicOrderWithNoName() {
    orderBuilder = new OrderBuilder("", pizzaBuilder);
    orderBuilder.build();
  }

  public void testOrderWithNameAndPizza() {
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
    Assert.assertEquals(order.getPrice(), 10D, "Price is different than expected");
  }

  public void testOrderWithNameAndPizzaWithOneTopping() {
    Set<Topping> toppings = new HashSet<>();
    toppings.add(Topping.FETA);
    pizzaBuilder.setToppings(toppings);

    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
    Assert.assertEquals(order.getPrice(), 60D, "Price is different than expected");
  }

  public void testOrderWithNameAndPizzaWithMultipleToppings() {
    Set<Topping> toppings = new HashSet<>();
    toppings.add(Topping.FETA);
    toppings.add(Topping.PROSCIUTTO);
    toppings.add(Topping.BACON);
    pizzaBuilder.setToppings(toppings);

    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
    Assert.assertEquals(order.getPrice(), 310D, "Price is different than expected");
  }

  public void testOrderIdIsRandomAndInTheExpectedRange() throws InterruptedException {
    Order order1 = orderBuilder.build();
    Order order2 = orderBuilder.build();

    Assert.assertTrue(order1.getId() > 99 && order1.getId() < 1000);
    Assert.assertTrue(order2.getId() > 99 && order2.getId() < 1000);
    Assert.assertNotEquals(order1.getId(), order2.getId(), "Order ids are the same");
  }

}

