import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CriticalSectionWindow{
    private int WIDTH = 700;
    private int HEIGTH = 600;
    private JFrame csWindowFrame;
    

    public CriticalSectionWindow(String name){
        csWindowFrame = new JFrame(name);
        csWindowFrame.setSize(WIDTH, HEIGTH);
        csWindowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void createAndShowGUI(int threadNumber, int criticalTime){
        
        String[] columnNames = {"Name", "Accesses", "Waiting", "Critical Section", "Dying", "Dead"};
        Object[][] threadData = new Object[threadNumber][];

        for (int i = 0; i < threadNumber; i++) {
            threadData[i] = new Object[]{"Thread "+ i,0};
        }

        JTable table = new JTable(new DefaultTableModel(threadData, columnNames));


        JScrollPane scrollPane = new JScrollPane(table);
        csWindowFrame.add(scrollPane);
        csWindowFrame.setVisible(true);
    }
}
