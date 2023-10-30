import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridLayout;


public class Window extends JFrame{
    private int WIDTH = 500;
    private int HEIGTH = 150;
    private JLabel threadNumberLabel = new JLabel("Number of Threads:");
    private JLabel criticalTimeLabel = new JLabel("Time inside CS (ms):");
    private JTextField threadNumberField = new JTextField();
    private JTextField criticalTimeField = new JTextField();;
    private JButton executeButton = new JButton("Execute");

    public Window(String name){
        super(name);
        setSize(WIDTH, HEIGTH);
        setLayout(new GridLayout(3,2));
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(40,40,40));
    }

    public void createAndShowGUI(){
        threadNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        criticalTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        threadNumberLabel.setForeground(new Color(255,255,255));
        criticalTimeLabel.setForeground(new Color(255,255,255));

        getContentPane().add(threadNumberLabel);
        getContentPane().add(threadNumberField);
        getContentPane().add(criticalTimeLabel);
        getContentPane().add(criticalTimeField);

        executeButton.addActionListener(e -> {
            CriticalSectionWindow CSWindow = new CriticalSectionWindow("Data Display Screen");
            CSWindow.createAndShowGUI(Integer.parseInt(threadNumberField.getText()),10);
        });
        
        getContentPane().add(executeButton);
        setVisible(true);
    }

    
}
