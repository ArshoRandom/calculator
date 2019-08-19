package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.round;
import static java.lang.Double.parseDouble;

class CalculatorCore extends JPanel {

    private JTextField field = new JTextField(10);
    private Function function = new Function();
    private Calculation calculation = new Calculation();
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
    private final JRadioButton selector1 = new JRadioButton("Dark Mode");
    private final JRadioButton selector2 = new JRadioButton("Light Mode");
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

    public JTextField getField() {
        return field;
    }

    void components() {

        setLayout(new FlowLayout());
        add(field);
        field.setHorizontalAlignment(0);
        Mode();
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
        plus.addActionListener(function);
        minus.addActionListener(function);
        multiply.addActionListener(function);
        equal.addActionListener(function);
        divide.addActionListener(function);
        fact.addActionListener(function);
        clear.addActionListener(function);
        delete.addActionListener(function);
        point.addActionListener(function);
        plusOrMinus.addActionListener(function);
        percentage.addActionListener(function);
        sqrt.addActionListener(function);
        b0.addActionListener(function);
        b1.addActionListener(function);
        b2.addActionListener(function);
        b3.addActionListener(function);
        b4.addActionListener(function);
        b5.addActionListener(function);
        b6.addActionListener(function);
        b7.addActionListener(function);
        b8.addActionListener(function);
        b9.addActionListener(function);
    }

    private void Mode() {
        if (!selector2.isSelected()) {
            setBackground(darkBackColor);
            selector1.setBackground(darkBackColor);
            selector2.setBackground(darkBackColor);
            selector1.setForeground(Color.white);
            selector2.setForeground(Color.white);
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
            selector1.setBackground(lightBackColor);
            selector2.setBackground(lightBackColor);
            selector1.setForeground(Color.BLUE);
            selector2.setForeground(Color.BLUE);
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
        group.add(selector1);
        group.add(selector2);
        add(selector1);
        add(selector2);
        selector1.setSelected(true);
        selector1.addActionListener(e -> {
            if (selector1.isSelected()) {
                Mode();
            }
        });
        selector2.addActionListener(e -> {
            if (!selector1.isSelected()) {
                Mode();
            }
        });
    }

    private void deleteLastNumber() {
        if (field.getText().length() != 0) {
            String num = field.getText().substring(0, field.getText().length() - 1);
            field.setText(num);
        }
    }

    private void resultCalculation() {
        if (plusIsPressed) {
            bufferNum = calculation.plus(bufferNum, parseDouble(field.getText()));
            if (bufferNum % 1 != 0) {
                field.setText("" + bufferNum);
            } else {
                field.setText("" + round(bufferNum));
            }
            plusIsPressed = false;
        }
        if (minusIsPressed) {
            bufferNum = calculation.minus(bufferNum, parseDouble(field.getText()));
            if (bufferNum % 1 != 0) {
                field.setText("" + bufferNum);
            } else {
                field.setText("" + round(bufferNum));
            }
            minusIsPressed = false;
        }
        if (divideIsPressed) {
            bufferNum = calculation.divide(bufferNum, parseDouble(field.getText()));
            if (bufferNum != -1) {
                if (bufferNum % 1 != 0) {
                    field.setText("" + bufferNum);
                } else {
                    field.setText("" + round(bufferNum));
                }
            } else {
                field.setText("ERROR");
                bufferNum = 0;
                fieldLength = 0;
            }
            divideIsPressed = false;
        }
        if (multiplyIsPressed) {
            bufferNum = calculation.multiply(bufferNum, parseDouble(field.getText()));
            if (bufferNum % 1 != 0) {
                field.setText("" + bufferNum);
            } else {
                field.setText("" + round(bufferNum));
            }
            multiplyIsPressed = false;
        }
        if (percentIsPressed) {
            bufferNum = calculation.percentage(bufferNum, parseDouble(field.getText()));
            if (bufferNum != -1) {
                if (bufferNum % 1 != 0) {
                    field.setText("" + bufferNum);
                } else {
                    field.setText("" + round(bufferNum));
                }
            }
            percentIsPressed = false;
        }
        if (factIsPressed) {
            if (calculation.factorial(Long.parseLong(field.getText())) == -1) {
                field.setText("ERROR");
            } else {
                field.setText("" + calculation.factorial(Long.parseLong(field.getText())));
            }
            factIsPressed = false;
        }
        if (sqrtIsPressed) {
            bufferNum = Math.sqrt(parseDouble(field.getText()));
            if (bufferNum % 1 != 0) {
                field.setText(("" + bufferNum).substring(0, 10));
            } else {
                field.setText("" + round(bufferNum));
            }

        }
        sqrtIsPressed = false;


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
        if (selector1.isSelected()) {
            field.setBackground(Color.GRAY);
        } else {
            field.setBackground(Color.WHITE);
        }

        field.setText("");
    }


    private class Function implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == plus) {
                    if (field.getText() != null) {
                        if (minusIsPressed || plusIsPressed || divideIsPressed || multiplyIsPressed) {
                            resultCalculation();
                        }
                        plusIsPressed = true;
                        bufferNum = parseDouble(field.getText());
                        field.setText("");
                    } else {
                        resultCalculation();
                        field.setText("");
                    }
                }
                if (e.getSource() == minus) {
                    if (field.getText() != null) {
                        if (minusIsPressed || plusIsPressed || divideIsPressed || multiplyIsPressed) {
                            resultCalculation();
                        }
                        minusIsPressed = true;
                        bufferNum = parseDouble(field.getText());
                        field.setText("");
                    } else {
                        resultCalculation();
                        field.setText("");
                    }
                }
                if (e.getSource() == multiply) {
                    if (field.getText() != null) {
                        if (minusIsPressed || plusIsPressed || divideIsPressed || multiplyIsPressed) {
                            resultCalculation();
                        }
                        multiplyIsPressed = true;
                        bufferNum = parseDouble(field.getText());
                        field.setText("");
                    } else {
                        resultCalculation();
                        field.setText("");
                    }
                }
                if (e.getSource() == divide) {
                    if (field.getText() != null) {
                        if (minusIsPressed || plusIsPressed || divideIsPressed || multiplyIsPressed) {
                            resultCalculation();
                        }
                        divideIsPressed = true;
                        bufferNum = parseDouble(field.getText());
                        field.setText("");
                    } else {
                        resultCalculation();
                        field.setText("");
                    }
                }
                if (e.getSource() == percentage) {
                    if (field.getText() != null) {
                        percentIsPressed = true;
                        bufferNum = parseDouble(field.getText());
                        field.setText("");
                    } else {
                        resultCalculation();
                        field.setText("");
                    }
                }
                if (e.getSource() == equal) {
                    equality();
                }
                if (e.getSource() == fact) {
                    if (field.getText() != null) {
                        factIsPressed = true;
                        resultCalculation();
                    }
                }
                if (e.getSource() == sqrt) {
                    if (field.getText() != null) {
                        sqrtIsPressed = true;
                        resultCalculation();
                    }
                }
                if (e.getSource() == clear) {
                    cleanField();
                }
                if (e.getSource() == delete) {
                    deleteLastNumber();
                }
                if (e.getSource() == point && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + ".");
                    fieldLength++;
                }
                if (e.getSource() == b1 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "1");
                    fieldLength++;
                }
                if (e.getSource() == b2 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "2");
                    fieldLength++;
                }
                if (e.getSource() == b3 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "3");
                    fieldLength++;
                }
                if (e.getSource() == b4 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "4");
                    fieldLength++;
                }
                if (e.getSource() == b5 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "5");
                    fieldLength++;
                }
                if (e.getSource() == b6 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "6");
                    fieldLength++;
                }
                if (e.getSource() == b7 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "7");
                    fieldLength++;
                }
                if (e.getSource() == b8 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "8");
                    fieldLength++;
                }
                if (e.getSource() == b9 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "9");
                    fieldLength++;
                }
                if (e.getSource() == b0 && fieldLength <= field.getColumns()) {
                    field.setText(field.getText() + "0");
                    fieldLength++;
                }
                if (e.getSource() == plusOrMinus && parseDouble(field.getText()) > 0) {
                    if (parseDouble(field.getText()) % 1 == 0) {
                        field.setText(Integer.toString(Math.negateExact(Integer.parseInt(field.getText()))));
                    } else {
                        field.setText(Double.toString(calculation.negateExact(parseDouble(field.getText()))));
                    }
                }

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Please enter number");
            }
        }
    }
}
