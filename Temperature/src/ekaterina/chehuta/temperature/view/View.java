package ekaterina.chehuta.temperature.view;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int height = screenSize.height;
    private int width = screenSize.width;

    private JTextField textInput = new JTextField("Введите температуру в градусах Цельсия", height / 30);
    private JButton buttonFahrenheit = new JButton("Перевести в градусы Фаренгейта");
    private JButton buttonKelvin = new JButton("Перевести в градусы Кельвина");
    private JTextField textOut = new JTextField(height/30);

    public View() {
        super("Перевод температур");

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignore) {
            }

            JPanel panelInput = new JPanel();
            JPanel panelButton = new JPanel();
            JPanel panelOut = new JPanel();

            this.setSize(width / 4, height / 4);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panelInput.add(textInput);

            panelButton.add(buttonFahrenheit, Component.CENTER_ALIGNMENT);
            buttonFahrenheit.updateUI();
            panelButton.add(buttonKelvin, Component.CENTER_ALIGNMENT);
            buttonKelvin.updateUI();

            textOut.setEditable(false);
            panelOut.add(textOut);

            this.add(panelInput, BorderLayout.PAGE_START);
            this.add(panelButton, BorderLayout.CENTER);
            this.add(panelOut, BorderLayout.PAGE_END);
        });
    }

    public JTextField getTextInput() {
        return textInput;
    }

    public void setTextOut(String stringOut) {
        textOut.setText(stringOut);
    }

    public JButton getButtonFahrenheit() {
        return buttonFahrenheit;
    }

    public JButton getButtonKelvin() {
        return buttonKelvin;
    }

    public void errorWindow(String error) {
        JOptionPane.showMessageDialog(this, error);
    }
}