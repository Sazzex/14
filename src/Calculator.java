import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame implements ActionListener {
    TextField a, b, c;
    Button buttom1, buttom2;
    Frame frame = new Frame();
    public Calculator() {
        setLayout(null);
        a = new TextField();
        a.setLocation(100, 60);
        a.setSize(80, 30);
        b = new TextField();
        b.setLocation(100, 90);
        b.setSize(80, 30);
        c = new TextField();
        c.setLocation(100, 120);
        c.setSize(80, 30);
        buttom1 = new Button("Вычислить");
        buttom1.setSize(100, 20);
        buttom1.setLocation(90, 160);
        buttom1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        try {
                                            int a = Integer.parseInt(Calculator.this.a.getText());
                                            int b = Integer.parseInt(Calculator.this.b.getText());
                                            int c = a + b;
                                            Calculator.this.c.setText(String.valueOf(c));
                                        } catch (NumberFormatException nf) {
                                            a.setText("");
                                            b.setText("");
                                            c.setText("Ошибка");
                                        }
                                    }
                                });
        buttom2 = new Button("Очистка");
        buttom2.setSize(100, 20);
        buttom2.setLocation(90, 185);
        buttom2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                a.setText("");
                b.setText("");
                c.setText("");
            }
        });
        add(buttom1);
        add(buttom2);
        add(a);
        add(b);
        add(c);
        setSize(300, 250);
        setTitle("Калькулятор");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("Вычислить")) {
            try {
                int a = Integer.parseInt(this.a.getText());
                int b = Integer.parseInt(this.b.getText());
                int c = a + b;
                this.c.setText(String.valueOf(c));
            }
            catch (NumberFormatException nf) {
                a.setText("");
                b.setText("");
                c.setText("Ошибка");
            }
        }
        else {
            a.setText("");
            b.setText("");
            c.setText("");
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
