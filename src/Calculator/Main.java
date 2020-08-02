package Calculator;


import javax.swing.*;

import static java.awt.EventQueue.invokeLater;


public class Main extends JFrame {


    private Main() {
        CalculatorCore core = CalculatorCore.getInstance();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(180, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        add(core);

    }

    public static void main(String[] args) {
        invokeLater(Main::new);

    }
}
