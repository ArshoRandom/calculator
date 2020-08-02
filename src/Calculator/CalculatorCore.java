package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.round;
import static java.lang.Double.parseDouble;

class CalculatorCore extends JPanel {

    private JTextField field = new JTextField(10);
    private CalculatorEventListener calculatorEventListener = new CalculatorEventListener();
    private Color darkBackColor = new Color(50, 50, 80);
    private Color darkKeyColor = new Color(0, 110, 120);
    private Color darkNumColor = new Color(100, 110, 120);
    private Color lightNumColor = new Color(153, 250, 238);
    private Color lightKeyColor = new Color(191, 250, 183);
    private Color lightBackColor = new Color(230, 250, 196);

    private final JButton plus = new JButton("+");
    private final JButton minus = new JButton("-");
    private final JButton divide = new JButton("/");
    private final JButton multiply = new JButton("x");
    private final JButton fact = new JButton("fact");
    private final JButton equal = new JButton("=");
    private final JButton delete = new JButton("C");
    private final JButton clear = new JButton("CE");
    private final JButton b1 = new JButton("1");
    private final JButton b2 = new JButton("2");
    private final JButton b3 = new JButton("3");
    private final JButton b4 = new JButton("4");
    private final JButton b5 = new JButton("5");
    private final JButton b6 = new JButton("6");
    private final JButton b7 = new JButton("7");
    private final JButton b8 = new JButton("8");
    private final JButton b9 = new JButton("9");
    private final JButton b0 = new JButton("0");
    private final JButton point = new JButton(" . ");
    private final JButton plusOrMinus = new JButton("- / +");
    private final JButton percentage = new JButton("%");
    private final JButton sqrt = new JButton("sqrt");
    private final JRadioButton darkMode = new JRadioButton("Dark Mode");
    private final JRadioButton lightMode = new JRadioButton("Light Mode");
    private final ButtonGroup group = new ButtonGroup();

    private double bufferNum;
    private int fieldLength = -5;

    private boolean plusIsPressed = false;
    private boolean minusIsPressed = false;
    private boolean divideIsPressed = false;
    private boolean multiplyIsPressed = false;
    private boolean factIsPressed = false;
    private boolean percentIsPressed = false;
    private boolean sqrtIsPressed = false;


    public static CalculatorCore getInstance() {
        return CalculationCoreInstance.calculatorCore;
    }

    private CalculatorCore(){
        field.setEditable(false);
        addComponents();
    }

    private void addComponents() {

        setLayout(new FlowLayout());
        add(field);
        field.setHorizontalAlignment(0);
        changeMode();
        add(delete);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(point);
        add(b0);
        add(equal);
        add(minus);
        add(multiply);
        add(divide);
        add(plus);
        add(fact);
        add(sqrt);
        add(percentage);
        add(plusOrMinus);
        add(clear);
        delete.setBackground(Color.LIGHT_GRAY);
        clear.setBackground(Color.LIGHT_GRAY);
        modeSelect();
        plus.addActionListener(calculatorEventListener);
        minus.addActionListener(calculatorEventListener);
        multiply.addActionListener(calculatorEventListener);
        equal.addActionListener(calculatorEventListener);
        divide.addActionListener(calculatorEventListener);
        fact.addActionListener(calculatorEventListener);
        clear.addActionListener(calculatorEventListener);
        delete.addActionListener(calculatorEventListener);
        point.addActionListener(calculatorEventListener);
        plusOrMinus.addActionListener(calculatorEventListener);
        percentage.addActionListener(calculatorEventListener);
        sqrt.addActionListener(calculatorEventListener);
        b0.addActionListener(calculatorEventListener);
        b1.addActionListener(calculatorEventListener);
        b2.addActionListener(calculatorEventListener);
        b3.addActionListener(calculatorEventListener);
        b4.addActionListener(calculatorEventListener);
        b5.addActionListener(calculatorEventListener);
        b6.addActionListener(calculatorEventListener);
        b7.addActionListener(calculatorEventListener);
        b8.addActionListener(calculatorEventListener);
        b9.addActionListener(calculatorEventListener);
    }

    private void changeMode() {
        if (!lightMode.isSelected()) {
            setBackground(darkBackColor);
            darkMode.setBackground(darkBackColor);
            lightMode.setBackground(darkBackColor);
            darkMode.setForeground(Color.white);
            lightMode.setForeground(Color.white);
            field.setBackground(Color.GRAY);
            field.setForeground(Color.ORANGE);
            plus.setBackground(darkKeyColor);
            multiply.setBackground(darkKeyColor);
            minus.setBackground(darkKeyColor);
            sqrt.setBackground(darkKeyColor);
            divide.setBackground(darkKeyColor);
            fact.setBackground(darkKeyColor);
            plusOrMinus.setBackground(darkKeyColor);
            percentage.setBackground(darkKeyColor);
            equal.setBackground(darkNumColor);
            point.setBackground(darkNumColor);
            b1.setBackground(darkNumColor);
            b2.setBackground(darkNumColor);
            b3.setBackground(darkNumColor);
            b4.setBackground(darkNumColor);
            b5.setBackground(darkNumColor);
            b6.setBackground(darkNumColor);
            b7.setBackground(darkNumColor);
            b8.setBackground(darkNumColor);
            b9.setBackground(darkNumColor);
            b0.setBackground(darkNumColor);
        } else {
            setBackground(lightBackColor);
            darkMode.setBackground(lightBackColor);
            lightMode.setBackground(lightBackColor);
            darkMode.setForeground(Color.BLUE);
            lightMode.setForeground(Color.BLUE);
            field.setBackground(Color.WHITE);
            field.setForeground(Color.BLACK);
            plus.setBackground(lightKeyColor);
            multiply.setBackground(lightKeyColor);
            sqrt.setBackground(lightKeyColor);
            minus.setBackground(lightKeyColor);
            divide.setBackground(lightKeyColor);
            fact.setBackground(lightKeyColor);
            plusOrMinus.setBackground(lightKeyColor);
            percentage.setBackground(lightKeyColor);
            equal.setBackground(darkNumColor);
            point.setBackground(darkNumColor);
            b1.setBackground(lightNumColor);
            b2.setBackground(lightNumColor);
            b3.setBackground(lightNumColor);
            b4.setBackground(lightNumColor);
            b5.setBackground(lightNumColor);
            b6.setBackground(lightNumColor);
            b7.setBackground(lightNumColor);
            b8.setBackground(lightNumColor);
            b9.setBackground(lightNumColor);
            b0.setBackground(lightNumColor);
            equal.setBackground(lightNumColor);
            point.setBackground(lightNumColor);
        }
    }

    private void modeSelect() {
        group.add(darkMode);
        group.add(lightMode);
        add(darkMode);
        add(lightMode);
        darkMode.setSelected(true);
        darkMode.addActionListener(e -> {
            if (darkMode.isSelected()) {
                changeMode();
            }
        });
        lightMode.addActionListener(e -> {
            if (!darkMode.isSelected()) {
                changeMode();
            }
        });
    }

    private void deleteLastNumber() {
        if (field.getText().length() != 0) {
            String result = field.getText().substring(0, field.getText().length() - 1);
            field.setText(result);
        }
    }

    private void resultCalculation() {
        if (plusIsPressed) {
            bufferNum = Calculation.plus(bufferNum, parseDouble(field.getText()));
            setRelevantNumber();
            plusIsPressed = false;
        }
        if (minusIsPressed) {
            bufferNum = Calculation.minus(bufferNum, parseDouble(field.getText()));
            setRelevantNumber();
            minusIsPressed = false;
        }
        if (divideIsPressed) {
            bufferNum = Calculation.divide(bufferNum, parseDouble(field.getText()));
            if (bufferNum != -1) {
                setRelevantNumber();
            } else {
                field.setText("ERROR");
                bufferNum = 0;
                fieldLength = 0;
            }
            divideIsPressed = false;
        }
        if (multiplyIsPressed) {
            bufferNum = Calculation.multiply(bufferNum, parseDouble(field.getText()));
            setRelevantNumber();
            multiplyIsPressed = false;
        }
        if (percentIsPressed) {
            bufferNum = Calculation.percentage(bufferNum, parseDouble(field.getText()));
            if (bufferNum != -1) {
                setRelevantNumber();
            }
            percentIsPressed = false;
        }
        if (factIsPressed) {
            if (Calculation.factorial(Long.parseLong(field.getText())) == -1) {
                field.setText("ERROR");
            } else {
                field.setText(Double.toString(Calculation.factorial(Long.parseLong(field.getText()))));
            }
            factIsPressed = false;
        }
        if (sqrtIsPressed) {
            bufferNum = Math.sqrt(parseDouble(field.getText()));
            if (bufferNum % 1 != 0) {
                field.setText(Double.toString(bufferNum).substring(0, 10));
            } else {
                field.setText(Double.toString(round(bufferNum)));
            }

        }
        sqrtIsPressed = false;
    }

    private void setRelevantNumber(){
        if (bufferNum % 1 != 0) {
            field.setText(Double.toString(bufferNum));
        } else {
            field.setText(Double.toString(round(bufferNum)));
        }
    }

    private void equality() {
        resultCalculation();
        percentIsPressed = false;
        plusIsPressed = false;
        minusIsPressed = false;
        divideIsPressed = false;
        multiplyIsPressed = false;
        factIsPressed = false;
    }

    private void cleanField() {
        percentIsPressed = false;
        plusIsPressed = false;
        minusIsPressed = false;
        divideIsPressed = false;
        multiplyIsPressed = false;
        factIsPressed = false;
        bufferNum = 0;
        fieldLength = 0;
        if (darkMode.isSelected()) {
            field.setBackground(Color.GRAY);
        } else {
            field.setBackground(Color.WHITE);
        }
        field.setText("");
    }


    private class CalculatorEventListener implements ActionListener {


        private final int columns = field.getColumns();


        private void calculate(String command){

            if (field.getText() != null) {
                if (minusIsPressed || plusIsPressed || divideIsPressed || multiplyIsPressed) {
                    resultCalculation();
                }
                plusIsPressed = command.equalsIgnoreCase("plus");
                minusIsPressed = command.equalsIgnoreCase("minus");
                divideIsPressed = command.equalsIgnoreCase("divide");
                multiplyIsPressed = command.equalsIgnoreCase("multiply");
                bufferNum = parseDouble(field.getText());
                field.setText("");
            } else {
                resultCalculation();
                field.setText("");
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == plus) {
                    calculate("plus");
                }
                else if (e.getSource() == minus) {
                    calculate("minus");
                }
                else if (e.getSource() == multiply) {
                    calculate("multiply");
                }
                else if (e.getSource() == divide) {
                    calculate("divide");
                }
                else if (e.getSource() == percentage) {
                    if (field.getText() != null) {
                        percentIsPressed = true;
                        bufferNum = parseDouble(field.getText());
                        field.setText("");
                    } else {
                        resultCalculation();
                        field.setText("");
                    }
                }

                else if (e.getSource() == equal) {
                    equality();
                }

                else if (e.getSource() == fact) {
                    if (field.getText() != null) {
                        factIsPressed = true;
                        resultCalculation();
                    }
                }

                else if (e.getSource() == sqrt) {
                    if (field.getText() != null) {
                        sqrtIsPressed = true;
                        resultCalculation();
                    }
                }

                else if (e.getSource() == clear) {
                    cleanField();
                }

                else if (e.getSource() == delete) {
                    deleteLastNumber();
                }
                else if (e.getSource() == point && fieldLength <= columns) {
                    field.setText(field.getText() + ".");
                    fieldLength++;
                }
                else if (e.getSource() == b1 && fieldLength <= columns) {
                    field.setText(field.getText() + "1");
                    fieldLength++;
                }

                else if (e.getSource() == b2 && fieldLength <= columns) {
                    field.setText(field.getText() + "2");
                    fieldLength++;
                }

                else if (e.getSource() == b3 && fieldLength <= columns) {
                    field.setText(field.getText() + "3");
                    fieldLength++;
                }

                else if (e.getSource() == b4 && fieldLength <= columns) {
                    field.setText(field.getText() + "4");
                    fieldLength++;
                }
                else if (e.getSource() == b5 && fieldLength <= columns) {
                    field.setText(field.getText() + "5");
                    fieldLength++;
                }

                else if (e.getSource() == b6 && fieldLength <= columns) {
                    field.setText(field.getText() + "6");
                    fieldLength++;
                }

                else if (e.getSource() == b7 && fieldLength <= columns) {
                    field.setText(field.getText() + "7");
                    fieldLength++;
                }

                else if (e.getSource() == b8 && fieldLength <= columns) {
                    field.setText(field.getText() + "8");
                    fieldLength++;
                }

                else if (e.getSource() == b9 && fieldLength <= columns) {
                    field.setText(field.getText() + "9");
                    fieldLength++;
                }

                else if (e.getSource() == b0 && fieldLength <= columns) {
                    field.setText(field.getText() + "0");
                    fieldLength++;
                }

                else if (e.getSource() == plusOrMinus && parseDouble(field.getText()) > 0) {
                    if (parseDouble(field.getText()) % 1 == 0) {
                        field.setText(Integer.toString(Math.negateExact(Integer.parseInt(field.getText()))));
                    } else {
                        field.setText(Double.toString(Calculation.negateExact(parseDouble(field.getText()))));
                    }
                }

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Please enter number");
            }
        }
    }

    private static class CalculationCoreInstance{
        static CalculatorCore calculatorCore = new CalculatorCore();
    }
}
