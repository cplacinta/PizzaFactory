package com.placinta.pizzafactory;

import com.placinta.pizzafactory.ui.AppWindow;
import com.placinta.pizzafactory.ui.Theme;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import java.awt.*;

public class Main {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AppWindow window = new AppWindow();
          window.getFrame().setVisible(true);
          update(Theme.AQUA, window.getFrame());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  static void update(MetalTheme aTheme, JFrame frame){
    MetalLookAndFeel.setCurrentTheme(aTheme);
    try {
      UIManager.setLookAndFeel(new MetalLookAndFeel());
      SwingUtilities.updateComponentTreeUI(frame);
    }
    catch ( UnsupportedLookAndFeelException ex ){
      System.out.println("Cannot set new Theme for Java Look and Feel.");
    }
  }

}