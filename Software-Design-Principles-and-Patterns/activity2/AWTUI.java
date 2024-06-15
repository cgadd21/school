import java.awt.* ;
import java.awt.event.* ;

public class AWTUI extends Frame {
    public Label celsiusField;
    public Label kelvinField;

    private static Font labelFont = new Font(Font.SERIF, Font.PLAIN, 72);

    public AWTUI() {
        super("Weather Station");
        setLayout(new GridLayout(1,0));

        Panel panel = new Panel(new GridLayout(2,1));
        add(panel);
        setLabel(" Kelvin ", panel);
        kelvinField = setLabel("", panel);

        panel = new Panel(new GridLayout(2,1));
        add(panel);
        setLabel(" Celsius ", panel);
        celsiusField = setLabel("", panel);

        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }        
            }
        );

        pack();
        setVisible(false);
    }

    private Label setLabel(String title, Panel panel) {
        Label label = new Label(title);

        label.setAlignment(Label.CENTER);
        label.setFont(labelFont);
        panel.add(label);

        return label;
    }

    public void setKelvinJLabel(double temperature) {
        kelvinField.setText(String.format("%6.2f", temperature));
    }

    public void setCelsiusJLabel(double temperature) {
        celsiusField.setText(String.format("%6.2f", temperature));
    }
}
