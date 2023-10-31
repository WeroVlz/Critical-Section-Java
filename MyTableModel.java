import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

    public MyTableModel(String[] columnNames, int rows) {
        super(columnNames, rows);
    }

    public void updateRow(int rowIndex, String threadName, int accesses, boolean waiting, boolean inCriticalSection,
            boolean dyingSoon, boolean isDead) {
        Object[] rowData = { threadName, accesses, waiting, inCriticalSection, dyingSoon, isDead };
        for (int i = 0; i < getColumnCount(); i++) {
            setValueAt(rowData[i], rowIndex, i);
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
  
}