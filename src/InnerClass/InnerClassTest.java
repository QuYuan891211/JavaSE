package InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest {


    private int interval;
    private boolean beep;

    public InnerClassTest(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isBeep() {
        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }

    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("time is" + now);
            if(beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
    public static void main(String[] a){
        InnerClassTest innerClassTest = new InnerClassTest(1000,true);
        innerClassTest.start();
        JOptionPane.showMessageDialog(null,"quit?");
        System.exit(0);
    }
}
