import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private int WIDTH = 400;
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
    }

    public void createAndShowGUI(){
        threadNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        criticalTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().add(threadNumberLabel);
        getContentPane().add(threadNumberField);
        getContentPane().add(criticalTimeLabel);
        getContentPane().add(criticalTimeField);

        executeButton.addActionListener(e -> {
            new CriticalSectionWindow("Data Display Screen");
        });
        
        getContentPane().add(executeButton);
        setVisible(true);
    }
}
