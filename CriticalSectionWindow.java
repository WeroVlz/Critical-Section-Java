import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CriticalSectionWindow {
    private int WIDTH = 700;
    private int HEIGTH = 600;
    private JFrame csWindowFrame;
    private ArrayList<MyThread> threads;

    public CriticalSectionWindow(String name) {
        csWindowFrame = new JFrame(name);
        csWindowFrame.setLayout(new BorderLayout());
        csWindowFrame.setSize(WIDTH, HEIGTH);
        csWindowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        threads = new ArrayList<>();
    }

    public void createAndShowGUI(int threadNumber, int criticalTime) {

        DataCenter dataCenter = new DataCenter();
        String[] columnNames = { "Name", "Accesses", "Waiting", "Critical Section", "Dying", "Dead" };

        MyTableModel tableModel = new MyTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        tableModel.setRowCount(0);

        for (int i = 0; i < threadNumber; i++) {
            MyThread t = new MyThread(dataCenter, criticalTime, i, tableModel);
            tableModel.addRow(new Object[] { t.getName(), t.getAccesses(), t.getIsWaiting(),
                    !t.getIsWaiting(), Boolean.FALSE, Boolean.FALSE });
            threads.add(t);
            t.start();
        }

        JPanel killPanel = new JPanel();
        JButton killButton = new JButton("Kill Threads");

        killButton.addActionListener(e -> {
            for(MyThread thread : threads){
                thread.kill();
            }
        });
        killPanel.add(killButton);
        csWindowFrame.add(killPanel, BorderLayout.SOUTH);

        csWindowFrame.add(new JScrollPane(table), BorderLayout.CENTER);
        csWindowFrame.setVisible(true);

    }
}
