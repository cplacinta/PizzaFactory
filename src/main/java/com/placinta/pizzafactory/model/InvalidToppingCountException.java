package com.placinta.pizzafactory.model;

public class InvalidToppingCountException extends RuntimeException {

  public InvalidToppingCountException(String message) {
    super(message);
  }

}
