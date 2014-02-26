package com.placinta.pizzafactory.ui;

import com.placinta.pizzafactory.builder.Order;
import com.placinta.pizzafactory.builder.OrderBuilder;
import com.placinta.pizzafactory.builder.Pizza;
import com.placinta.pizzafactory.builder.PizzaBuilder;
import com.placinta.pizzafactory.model.InvalidNameException;
import com.placinta.pizzafactory.model.InvalidToppingCountException;
import com.placinta.pizzafactory.model.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppWindow {

  public static final int FIRST_COLUMN_X = 8;
  public static final int SECOND_COLUMN_X = 164;
  public static final int THIRD_COLUMN_X = 320;

  private JFrame frame;
  private JTextField txtUserName;
  private JLabel lblUserName;
  private JButton btnNext;
  private JButton btnBack;
  private JTextArea txtResult;

  private int currentPage = 1;
  private List<JCheckBox> checkBoxes = new ArrayList<>();

  public AppWindow() {
    createMainFrame();
    createFirstPageComponents();
    createCheckBoxes();
    createButtons();
    createTextArea();
  }

  private void createMainFrame() {
    frame = new JFrame();
    frame.setBounds(100, 100, 490, 400);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
  }

  private void createFirstPageComponents() {
    lblUserName = new JLabel("Please enter your name:");
    lblUserName.setBounds(74, 160, 142, 15);
    frame.getContentPane().add(lblUserName);

    txtUserName = new JTextField();
    txtUserName.setBounds(234, 158, 136, 19);
    frame.getContentPane().add(txtUserName);
    txtUserName.setColumns(10);
  }

  private void createButtons() {
    btnNext = new JButton("Next");
    btnNext.setBounds(253, 337, 117, 25);
    btnNext.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        currentPage++;
        renderCurrentPage();
      }
    });
    frame.getContentPane().add(btnNext);

    btnBack = new JButton("Back");
    btnBack.setEnabled(false);
    btnBack.setBounds(94, 337, 117, 25);
    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        currentPage--;
        renderCurrentPage();
      }
    });

    frame.getContentPane().add(btnBack);
  }

  private void renderCurrentPage() {
    boolean isFirstPage = currentPage == 1;
    boolean isSecondPage = currentPage == 2;
    boolean isThirdPage = currentPage == 3;

    lblUserName.setVisible(isFirstPage);
    txtUserName.setVisible(isFirstPage);
    btnBack.setEnabled(!isFirstPage);
    toggleCheckBoxes(isSecondPage);
    btnNext.setText(isThirdPage ? "Order" : "Next");
    btnNext.setEnabled(!isThirdPage);
    txtResult.setVisible(isThirdPage);

    if (isThirdPage) {
      buildOrder();
    }
  }

  private void buildOrder() {
    try {

      PizzaBuilder pizzaBuilder = applyToppings();
      Order order = createOrder(txtUserName.getText(), pizzaBuilder);
      printReceipt(order, pizzaBuilder);

    } catch (InvalidNameException exception) {
      JOptionPane.showMessageDialog(frame, exception.getMessage());
      currentPage = 1;
      renderCurrentPage();
    } catch (InvalidToppingCountException exception) {
      JOptionPane.showMessageDialog(frame, exception.getMessage());
      currentPage = 2;
      renderCurrentPage();
    }
  }

  private Order createOrder(String name, PizzaBuilder pizzaBuilder) {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.setName(name);
    orderBuilder.setPizzaBuilder(pizzaBuilder);

    return orderBuilder.build();
  }

  private PizzaBuilder applyToppings() {
    Set<Topping> toppings = new HashSet<>();
    for (JCheckBox checkBox : checkBoxes) {
      if (checkBox.isSelected()) {
        String toppingName = checkBox.getText().replace(" ", "_").toUpperCase();
        toppings.add(Topping.valueOf(toppingName));
      }
    }
    PizzaBuilder pizzaBuilder = new PizzaBuilder();
    pizzaBuilder.setToppings(toppings);
    return pizzaBuilder;
  }

  private void printReceipt(Order order, PizzaBuilder pizzaBuilder) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Order id: ");
    stringBuilder.append(order.getId());
    stringBuilder.append("\n");
    stringBuilder.append("Customer name: ");
    stringBuilder.append(order.getName());
    stringBuilder.append("\n");
    stringBuilder.append("Selected extra toppings:\n");

    Pizza pizza = pizzaBuilder.build();
    for (Topping topping : pizza.getToppings()) {
      stringBuilder.append(topping.name().toLowerCase().replace("_", " "));
      stringBuilder.append(", ");
    }

    txtResult.setText(stringBuilder.toString());
  }

  private void toggleCheckBoxes(boolean visible) {
    for (JCheckBox checkBox : checkBoxes) {
      checkBox.setVisible(visible);
    }
  }

  private void createCheckBoxes() {
    createCheckBox("Feta", FIRST_COLUMN_X, 8);
    createCheckBox("Parmesan", FIRST_COLUMN_X, 35);
    createCheckBox("Mozzarella", FIRST_COLUMN_X, 62);
    createCheckBox("Dor Blue", FIRST_COLUMN_X, 89);
    createCheckBox("Edam", FIRST_COLUMN_X, 116);
    createCheckBox("Branza", FIRST_COLUMN_X, 143);

    createCheckBox("Bacon", SECOND_COLUMN_X, 8);
    createCheckBox("Prosciutto", SECOND_COLUMN_X, 35);
    createCheckBox("Salami", SECOND_COLUMN_X, 62);
    createCheckBox("Chicken Breast", SECOND_COLUMN_X, 89);
    createCheckBox("Ham", SECOND_COLUMN_X, 116);

    createCheckBox("Fresh mushrooms", THIRD_COLUMN_X, 8);
    createCheckBox("Smoked mushrooms", THIRD_COLUMN_X, 35);
    createCheckBox("Red onion", THIRD_COLUMN_X, 62);
    createCheckBox("Tomatoes", THIRD_COLUMN_X, 89);
    createCheckBox("Garlic", THIRD_COLUMN_X, 116);
    createCheckBox("Rucola", THIRD_COLUMN_X, 143);
    createCheckBox("Marinated Gogoshars", THIRD_COLUMN_X, 170);
    createCheckBox("Corn", THIRD_COLUMN_X, 197);
    createCheckBox("Parsley", THIRD_COLUMN_X, 224);
    createCheckBox("Chili pepper", THIRD_COLUMN_X, 251);

    toggleCheckBoxes(false);
  }

  private void createCheckBox(String name, int x, int y) {
    JCheckBox checkBox = new JCheckBox(name);
    checkBox.setBounds(x, y, 148, 23);
    frame.getContentPane().add(checkBox);
    checkBoxes.add(checkBox);
  }

  private void createTextArea() {
    txtResult = new JTextArea();
    txtResult.setEditable(false);
    txtResult.setBounds(18, 66, 412, 181);
    frame.getContentPane().add(txtResult);

    txtResult.setVisible(false);
  }

  public JFrame getFrame() {
    return frame;
  }

}