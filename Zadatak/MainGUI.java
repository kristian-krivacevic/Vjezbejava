package Zadatak;
import javax.swing.*;
import java.awt.*;
public class MainGUI {
    public static void main(String[] args){SwingUtilities.invokeLater(MainGUI::run);}    
    static void run(){
        JFrame f=new JFrame("Game"); f.setSize(400,400); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField name=new JTextField(); JTextField hp=new JTextField(); JTextField x=new JTextField(); JTextField y=new JTextField();
        JRadioButton r=new JRadioButton("Rect"); JRadioButton c=new JRadioButton("Circle"); ButtonGroup g=new ButtonGroup(); g.add(r); g.add(c);
        JButton b=new JButton("Start"); JTextArea out=new JTextArea();
        JPanel p=new JPanel(new GridLayout(0,1));
        p.add(new JLabel("Name:")); p.add(name);
        p.add(new JLabel("Health:")); p.add(hp);
        p.add(new JLabel("X:")); p.add(x);
        p.add(new JLabel("Y:")); p.add(y);
        p.add(r); p.add(c); p.add(b);}
}
