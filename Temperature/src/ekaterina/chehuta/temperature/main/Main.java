package ekaterina.chehuta.temperature.main;

import ekaterina.chehuta.temperature.controller.Controller;
import ekaterina.chehuta.temperature.model.Model;
import ekaterina.chehuta.temperature.view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new Model(), new View());
    }
}