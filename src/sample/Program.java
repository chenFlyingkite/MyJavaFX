package sample;

import java.awt.*;

public class Program extends Frame {
    public static void main(String[] args) {
        new Program();
    }

    public Program() {
        System.out.println("program");
        setLayout(new GridLayout(1, 1));
        Panel p = new Panel();
        Button b = new Button("Press");
        p.add(b);
        add(p);
        setTitle("public program");
        setSize(500, 300);
        setVisible(true);
    }
}
