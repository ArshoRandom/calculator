package Calculator;


import javax.swing.*;

import static java.awt.EventQueue.invokeLater;


public class CalculatorStart extends JFrame {


    private CalculatorStart() {
        CalculatorCore core = new CalculatorCore();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(180, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        core.components();
        core.getField().setEditable(false);
        add(core);

    }

    public static void main(String[] args) {
        invokeLater(CalculatorStart::new);

    }
}
