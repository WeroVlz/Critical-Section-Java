public class MyThread extends Thread {
    private final DataCenter dataCenter;
    private final int sleepTime;
    private final int threadIndex;
    private final MyTableModel tableModel;
    private Integer accesses = 0;
    private Boolean isWaiting = true;
    private Boolean isDying = false;

    public Integer getAccesses() {
        return accesses;
    }

    public Boolean getIsWaiting() {
        return isWaiting;
    }

    public MyThread(DataCenter dataCenter, int sleepTime, int threadIndex, MyTableModel tableModel) {
        this.sleepTime = sleepTime;
        this.dataCenter = dataCenter;
        this.threadIndex = threadIndex;
        this.tableModel = tableModel;

    }

    @Override
    public void run() {
        while (!isDying) {
            try {
                synchronized (dataCenter) {
                    accesses++;
                    isWaiting = false;
                    dataCenter.increment();
                    tableModel.updateRow(threadIndex, getName(), getAccesses(), getIsWaiting(), !getIsWaiting(), false, false);
                    Thread.sleep(sleepTime);
                }
                isWaiting = true;
                tableModel.updateRow(threadIndex, getName(), getAccesses(), getIsWaiting(), !getIsWaiting(), false, false);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        tableModel.updateRow(threadIndex, getName(), getAccesses(), false, false, false, true);
    }

    public void kill(){
        isDying = true;
        tableModel.updateRow(threadIndex, getName(), getAccesses(), false, false, isDying, !isDying);
    }
}
