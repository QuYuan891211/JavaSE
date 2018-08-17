package InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousInnerClassTest {

    private int interval;
    private boolean beep;

    public AnonymousInnerClassTest(int interval, boolean beep) {
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
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                System.out.println("time :" + date);
                /*if(beep){
                    Toolkit.getDefaultToolkit().beep();}*/
            }

        };
        Timer timer = new Timer(interval,listener);
        timer.start();
    }

    public static void main(String[] a){
        AnonymousInnerClassTest anonymousInnerClassTest = new AnonymousInnerClassTest(2000,true);
        anonymousInnerClassTest.start();
        JOptionPane.showMessageDialog(null,"quit?");
        System.exit(0);
    }

}
