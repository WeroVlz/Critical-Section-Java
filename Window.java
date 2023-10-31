import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Window extends JFrame {
    private int WIDTH = 600;
    private int HEIGTH = 300;
    private JLabel threadNumberLabel = new JLabel("Number of Threads:");
    private JLabel criticalTimeLabel = new JLabel("Time inside CS (ms):");
    private JTextField threadNumberField = new JTextField();
    private JTextField criticalTimeField = new JTextField();;
    private JButton executeButton = new JButton("Execute");
    private JLabel studentEdgar = new JLabel("0217557 Edgar Velazquez Mercado");
    private JLabel studentAngel = new JLabel("0235347 Angel Martinez Rodriguez");
    private JLabel courseName = new JLabel("Fundamentos de Programacion en Paralelo");
    private JLabel teacherName = new JLabel("Dr. Juan Carlos Lopez Pimentel");

    public Window(String name) {
        super(name);
        setSize(WIDTH, HEIGTH);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void createAndShowGUI() {

        threadNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        criticalTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentEdgar.setHorizontalAlignment(SwingConstants.CENTER);
        studentAngel.setHorizontalAlignment(SwingConstants.CENTER);
        courseName.setHorizontalAlignment(SwingConstants.CENTER);
        teacherName.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(threadNumberLabel);
        inputPanel.add(threadNumberField);
        inputPanel.add(criticalTimeLabel);
        inputPanel.add(criticalTimeField);
        inputPanel.setPreferredSize(new Dimension(600, 100));
        getContentPane().add(inputPanel, BorderLayout.NORTH);

        executeButton.addActionListener(e -> {
            String threadNumber = threadNumberField.getText();
            String criticalTime = criticalTimeField.getText();

            if (threadNumber.isEmpty() || criticalTime.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please don't leave empty fields.");
            } else {
                try {
                    CriticalSectionWindow CSWindow = new CriticalSectionWindow("Data Display Screen");
                    CSWindow.createAndShowGUI(Integer.parseInt(threadNumber), Integer.parseInt(criticalTime));
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(this, "Please only enter numeric values.");
                }
            }

        });

        getContentPane().add(executeButton, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        infoPanel.add(studentEdgar);
        infoPanel.add(studentAngel);
        infoPanel.add(courseName);
        infoPanel.add(teacherName);
        infoPanel.setPreferredSize(new Dimension(600, 100));
        getContentPane().add(infoPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
