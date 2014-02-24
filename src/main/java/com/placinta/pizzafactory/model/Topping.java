package com.placinta.pizzafactory.model;

@SuppressWarnings("unused")
public enum Topping {
  FETA(ToppingType.CHEESE, 50),
  PARMESAN(ToppingType.CHEESE, 40),
  MOZZARELLA(ToppingType.CHEESE, 60),
  DOR_BLUE(ToppingType.CHEESE, 30),
  EDAM(ToppingType.CHEESE, 20),
  BRANZA(ToppingType.CHEESE, 1),
  BACON(ToppingType.MEAT, 150),
  PROSCIUTTO(ToppingType.MEAT, 100),
  SALAMI(ToppingType.MEAT, 95),
  CHICKEN_BREAST(ToppingType.MEAT, 25),
  HAM(ToppingType.MEAT, 65),
  FRESH_MUSHROOMS(ToppingType.VEGETABLE, 15),
  SMOKED_MUSHROOMS(ToppingType.VEGETABLE, 10),
  RED_ONION(ToppingType.VEGETABLE, 5),
  TOMATOES(ToppingType.VEGETABLE, 12),
  GARLIC(ToppingType.VEGETABLE, 8),
  RUCOLA(ToppingType.VEGETABLE, 7),
  MARINATED_GOGOSHARS(ToppingType.VEGETABLE, 20),
  CORN(ToppingType.VEGETABLE, 2),
  PARSLEY(ToppingType.VEGETABLE, 2.5),
  CHILI_PEPPER(ToppingType.VEGETABLE, 25);

  private ToppingType toppingType;
  private double price;

  Topping(ToppingType toppingType, double price) {
    this.toppingType = toppingType;
    this.price = price;
  }

  public ToppingType getToppingType() {
    return toppingType;
  }

  public void setToppingType(ToppingType toppingType) {
    this.toppingType = toppingType;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
