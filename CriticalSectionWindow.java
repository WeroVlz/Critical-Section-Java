import javax.swing.JFrame;

public class CriticalSectionWindow{
    private int WIDTH = 800;
    private int HEIGTH = 600;
    private JFrame csWindowFrame;

    public CriticalSectionWindow(String name){
        csWindowFrame = new JFrame(name);
        csWindowFrame.setSize(WIDTH, HEIGTH);
        csWindowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        csWindowFrame.setVisible(true);
    }
}
