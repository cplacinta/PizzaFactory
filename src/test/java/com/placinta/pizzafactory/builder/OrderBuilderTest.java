package com.placinta.pizzafactory.builder;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class OrderBuilderTest {

  public static final String NAME_DIFFERENT_THAN_EXPECTED = "Name is different than expected";

  public void testBasicOrderForGeorge() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("George");
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "George", NAME_DIFFERENT_THAN_EXPECTED);
  }

  public void testBasicOrderForIon() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("Ion");
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
  }

  @Test
  public void testOrderWithNameAndPizza() {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName("Ion");
    Order order = orderBuilder.build();

    Assert.assertEquals(order.getName(), "Ion", NAME_DIFFERENT_THAN_EXPECTED);
    Assert.assertEquals(order.getPrice(), 10D, "Price is different than expected");
  }

}
