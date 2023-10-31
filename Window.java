import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridLayout;


public class Window extends JFrame{
    private int WIDTH = 600;
    private int HEIGTH = 200;
    private JLabel threadNumberLabel = new JLabel("Number of Threads:");
    private JLabel criticalTimeLabel = new JLabel("Time inside CS (ms):");
    private JTextField threadNumberField = new JTextField();
    private JTextField criticalTimeField = new JTextField();;
    private JButton executeButton = new JButton("Execute");
    private JButton killButton = new JButton("Kill Threads");
    private JLabel studentEdgar = new JLabel("0217557 Edgar Velazquez Mercado");
    private JLabel studentAngel = new JLabel("0217557 Ángel Martínez Rodríguez");
    private JLabel courseName = new JLabel("Fundamentos de Programación en Paralelo");
    private JLabel teacherName = new JLabel("Dr. Juan Carlos López Pimentel");

    public Window(String name){
        super(name);
        setSize(WIDTH, HEIGTH);
        setLayout(new GridLayout(5,2));
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(40,40,40));
    }

    public void createAndShowGUI(){
        threadNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        criticalTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentEdgar.setHorizontalAlignment(SwingConstants.CENTER);
        studentAngel.setHorizontalAlignment(SwingConstants.CENTER);
        courseName.setHorizontalAlignment(SwingConstants.CENTER);
        teacherName.setHorizontalAlignment(SwingConstants.CENTER);
        threadNumberLabel.setForeground(Color.WHITE);
        criticalTimeLabel.setForeground(Color.WHITE);
        studentEdgar.setForeground(Color.WHITE);
        studentAngel.setForeground(Color.WHITE);
        courseName.setForeground(Color.WHITE);
        teacherName.setForeground(Color.WHITE);

        getContentPane().add(threadNumberLabel);
        getContentPane().add(threadNumberField);
        getContentPane().add(criticalTimeLabel);
        getContentPane().add(criticalTimeField);

        executeButton.addActionListener(e -> {
            CriticalSectionWindow CSWindow = new CriticalSectionWindow("Data Display Screen");
            CSWindow.createAndShowGUI(Integer.parseInt(threadNumberField.getText()),10);
        });
        
        getContentPane().add(executeButton);
        getContentPane().add(killButton);
        getContentPane().add(studentEdgar);
        getContentPane().add(studentAngel);
        getContentPane().add(courseName);
        getContentPane().add(teacherName);

        setVisible(true);
    }

    
}
