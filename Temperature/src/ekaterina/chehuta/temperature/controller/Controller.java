package ekaterina.chehuta.temperature.controller;

import ekaterina.chehuta.temperature.model.Model;
import ekaterina.chehuta.temperature.view.View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        view.getTextInput().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ((JTextField)e.getSource()).selectAll();
            }
        });

        view.getButtonFahrenheit().addActionListener(e -> convertTemperatureToFahrenheit());
        view.getButtonKelvin().addActionListener(e -> convertTemperatureToKelvin());
    }

    private void convertTemperatureToFahrenheit() {
        String stringInput;

        try {
            stringInput = view.getTextInput().getText();

            model.convertTemperatureToFahrenheit(stringInput);

            view.setTextOut(model.getStringOut());
        } catch (NumberFormatException ex) {
            view.errorWindow("Ошибка ввода");
        }
    }

    private void convertTemperatureToKelvin() {
        String stringInput;

        try {
            stringInput = view.getTextInput().getText();

            model.convertTemperatureToKelvin(stringInput);

            view.setTextOut(model.getStringOut());
        } catch (NumberFormatException ex) {
            view.errorWindow("Ошибка ввода");
        }
    }
}