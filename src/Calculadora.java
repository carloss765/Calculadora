
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.w3c.dom.css.RGBColor;

public class Calculadora {
    private JTextField display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
        cal.Interfaz();

    }

    public void Interfaz() {

        // ----< Ventana >----

        JFrame frame = new JFrame("Calculadora");
        ImageIcon Icon = new ImageIcon(getClass().getResource("/icons/calculadora.png"));
        frame.setIconImage(Icon.getImage());
        frame.setSize(255, 429);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        // ----< Display >----

        display = new JTextField();
        display.setBounds(0, 0, 240, 90);
        display.setFont(new Font("Cascadia Code", Font.PLAIN, 45));
        Color customColor = new Color(22, 22, 22);
        display.setCaretColor(customColor);
        display.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        frame.add(display);

        // ----< Color de Fondo y Texto >----

        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);

        // ----< Numeros Botones >----

        JButton button9 = new JButton("9");
        JButton button8 = new JButton("8");
        JButton button7 = new JButton("7");
        JButton button6 = new JButton("6");
        JButton button5 = new JButton("5");
        JButton button4 = new JButton("4");
        JButton button3 = new JButton("3");
        JButton button2 = new JButton("2");
        JButton button1 = new JButton("1");
        JButton button0 = new JButton("0");

        // ----< Font, Size y Border >----

        button9.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button9.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button9.setFocusPainted(false);
        button8.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button8.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button8.setFocusPainted(false);
        button7.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button7.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button7.setFocusPainted(false);
        button6.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button6.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button6.setFocusPainted(false);
        button5.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button5.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button5.setFocusPainted(false);
        button4.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button4.setFocusPainted(false);
        button3.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button3.setFocusPainted(false);
        button2.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button2.setFocusPainted(false);
        button1.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button1.setFocusPainted(false);
        button0.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button0.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        button0.setFocusPainted(false);

        // ----< Color de Fondo y Texto >----

        button9.setBackground(Color.BLACK);
        button9.setForeground(Color.WHITE);
        button8.setBackground(Color.BLACK);
        button8.setForeground(Color.WHITE);
        button7.setBackground(Color.BLACK);
        button7.setForeground(Color.WHITE);
        button6.setBackground(Color.BLACK);
        button6.setForeground(Color.WHITE);
        button5.setBackground(Color.BLACK);
        button5.setForeground(Color.WHITE);
        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button0.setBackground(Color.BLACK);
        button0.setForeground(Color.WHITE);

        // ----< Pocision y Tamaño Botones >----

        button9.setBounds(120, 150, 60, 60);
        button8.setBounds(60, 150, 60, 60);
        button7.setBounds(0, 150, 60, 60);
        button6.setBounds(120, 210, 60, 60);
        button5.setBounds(60, 210, 60, 60);
        button4.setBounds(0, 210, 60, 60);
        button3.setBounds(120, 270, 60, 60);
        button2.setBounds(60, 270, 60, 60);
        button1.setBounds(0, 270, 60, 60);
        button0.setBounds(60, 330, 60, 60);

        // ----< Add in Frame >----

        frame.add(button9);
        frame.add(button8);
        frame.add(button7);
        frame.add(button6);
        frame.add(button5);
        frame.add(button4);
        frame.add(button3);
        frame.add(button2);
        frame.add(button1);
        frame.add(button0);

        // ----< Funcion Botones Numeros >----

        FuncionNumerosyOperadores(button9, "9");
        FuncionNumerosyOperadores(button8, "8");
        FuncionNumerosyOperadores(button7, "7");
        FuncionNumerosyOperadores(button6, "6");
        FuncionNumerosyOperadores(button5, "5");
        FuncionNumerosyOperadores(button4, "4");
        FuncionNumerosyOperadores(button3, "3");
        FuncionNumerosyOperadores(button2, "2");
        FuncionNumerosyOperadores(button1, "1");
        FuncionNumerosyOperadores(button0, "0");

        // ----< Operadores Botones >----

        JButton buttonPlus = new JButton("+");
        JButton buttonLess = new JButton("-");
        JButton buttonMultiplication = new JButton("x");
        JButton buttonDivision = new JButton("/");
        JButton buttonPercentage = new JButton("%");
        JButton buttonPoint = new JButton(",");

        // ----< Font, Size y Border >----

        buttonPlus.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonPlus.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonPlus.setFocusPainted(false);
        buttonLess.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonLess.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonLess.setFocusPainted(false);
        buttonMultiplication.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonMultiplication.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonMultiplication.setFocusPainted(false);
        buttonDivision.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonDivision.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonDivision.setFocusPainted(false);
        buttonPercentage.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonPercentage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonPercentage.setFocusPainted(false);
        buttonPoint.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonPoint.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonPoint.setFocusPainted(false);

        // ----< Color de Fondo y Texto >----

        buttonPlus.setBackground(new Color(22, 22, 22));
        buttonPlus.setForeground(new Color(65, 137, 206));
        buttonLess.setBackground(new Color(22, 22, 22));
        buttonLess.setForeground(new Color(65, 137, 206));
        buttonMultiplication.setBackground(new Color(22, 22, 22));
        buttonMultiplication.setForeground(new Color(65, 137, 206));
        buttonDivision.setBackground(new Color(22, 22, 22));
        buttonDivision.setForeground(new Color(65, 137, 206));
        buttonPercentage.setBackground(Color.BLACK);
        buttonPercentage.setForeground(Color.WHITE);
        buttonPoint.setBackground(Color.BLACK);
        buttonPoint.setForeground(Color.WHITE);

        // ----< Pocision y Tamaño Botones >----

        buttonPlus.setBounds(180, 210, 60, 60);
        buttonLess.setBounds(180, 150, 60, 60);
        buttonMultiplication.setBounds(120, 90, 60, 60);
        buttonDivision.setBounds(60, 90, 60, 60);
        buttonPercentage.setBounds(0, 330, 60, 60);
        buttonPoint.setBounds(120, 330, 60, 60);

        // ----< Add in Frame >----

        frame.add(buttonPlus);
        frame.add(buttonLess);
        frame.add(buttonMultiplication);
        frame.add(buttonDivision);
        frame.add(buttonPercentage);
        frame.add(buttonPoint);

        // ----< Funcion Botones Operadores >----

        FuncionNumerosyOperadores(buttonPlus, "+");
        FuncionNumerosyOperadores(buttonLess, "-");
        FuncionNumerosyOperadores(buttonMultiplication, "*");
        FuncionNumerosyOperadores(buttonDivision, "/");
        FuncionNumerosyOperadores(buttonPercentage, "%");
        FuncionNumerosyOperadores(buttonPoint, ".");

        // ----< Acciones >----
        JButton buttonDelete = new JButton("←");
        JButton buttonEquals = new JButton("=");
        JButton buttonC = new JButton("C");

        // ----< Font, Size y Border >----

        buttonDelete.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonDelete.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonDelete.setFocusPainted(false);
        buttonEquals.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonEquals.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonEquals.setFocusPainted(false);
        buttonC.setFont(new Font("Cascadia Code", Font.PLAIN, 25));
        buttonC.setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
        buttonC.setFocusPainted(false);

        // ----< Color de Fondo y Texto >----

        buttonDelete.setBackground(new Color(22, 22, 22));
        buttonDelete.setForeground(new Color(65, 137, 206));
        buttonEquals.setBackground(new Color(65, 137, 206));
        buttonEquals.setForeground(Color.WHITE);
        buttonC.setBackground(new Color(22, 22, 22));
        buttonC.setForeground(new Color(65, 137, 206));

        // ----< Pocision y Tamaño Botones >----

        buttonDelete.setBounds(180, 90, 60, 60);
        buttonEquals.setBounds(180, 270, 60, 120);
        buttonC.setBounds(0, 90, 60, 60);

        // ----< Add in Frame >----

        frame.add(buttonDelete);
        frame.add(buttonEquals);
        frame.add(buttonC);

        // ----< Funcion Botones Acciones >----

        FuncionAccionesDelete(buttonDelete, "");
        FuncionAccionesC(buttonC, "");
        FuncionAccionesEquals(buttonEquals, "");

        // ----< SetVisible >----

        frame.setVisible(true);
    }

    // ----< Funcion Numeros Botones y Operadores >----

    public void FuncionNumerosyOperadores(JButton button, String NumerouOperador) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (NumerouOperador.matches("[0-9]")) {
                    if (isOperatorPressed) {
                        display.setText(""); // Limpiar el display para el siguiente número
                        isOperatorPressed = false;
                    }
                    display.setText(display.getText() + NumerouOperador);

                } else if (NumerouOperador.equals(".")) {
                    if (!display.getText().contains(".")) {
                        display.setText(display.getText() + ".");
                    }
                } else if (!isOperatorPressed) {
                    firstNumber = Double.parseDouble(display.getText());
                    operator = NumerouOperador;
                    display.setText(display.getText() + "" + operator + "");
                    isOperatorPressed = true;

                }

            }
        });
    }

    // ----< Funcion Acciones Boton Delete >----

    public void FuncionAccionesDelete(JButton button, String Accion) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoActual = display.getText();
                if (!textoActual.isEmpty()) {
                    String textoModificado = textoActual.substring(0, textoActual.length() - 1); // Eliminar el último
                                                                                                 // carácter
                    display.setText(textoModificado); // Establecer el texto sin el último carácter
                }
            }
        });
    }

    // ----< Funcion Acciones Boton Equals >----

    public void FuncionAccionesEquals(JButton button, String Accion) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double secondNumber = Double.parseDouble(display.getText());
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        } else {
                            display.setText("Error"); // Evitar división entre 0
                            return;
                        }
                        break;
                    case "%":
                        result = firstNumber * (secondNumber / 100);
                    default:
                        break;
                }

                display.setText(Double.toString(result));
                firstNumber = result;
                isOperatorPressed = true;
            }

        });
    }

    // ----< Funcion Acciones Boton C >----

    public void FuncionAccionesC(JButton button, String Accion) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
            }
        });
    }

}