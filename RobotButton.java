import lejos.nxt.*;
import lejos.nxt.Sound;

public class RobotButton implements RobotInterface {
    TouchSensor a, b, c, d;
    
    public RobotButton() {
        a = new TouchSensor(SensorPort.S1);
        b = new TouchSensor(SensorPort.S2);
        c = new TouchSensor(SensorPort.S3);
        d = new TouchSensor(SensorPort.S4);
    }
    
    public String getButton() throws Exception{
        while(!a.isPressed() && !b.isPressed() && !c.isPressed() && !d.isPressed()){
        }
            if (a.isPressed()) {
                return "1";
                }
            if (b.isPressed()) {
                return "2";
                }
            if (c.isPressed()) {
                return "3";
                }
            if (d.isPressed()) {
                return "4";
                }
            return "0";
    }
    
    public void moveMotor(int motor) throws Exception {
        switch (motor) {
            case 1 : Motor.A.setSpeed(100);
                     Motor.A.forward();
                     Thread.sleep(1000);
                     Motor.A.stop();
                     break;
            case 2 : Motor.B.setSpeed(100);
                     Motor.B.forward();
                     Thread.sleep(1000);
                     Motor.B.stop();
                     break;
            case 3 : Motor.C.setSpeed(100);
                     Motor.C.forward();
                     Thread.sleep(1000);
                     Motor.C.stop();
                     break;
        }
    }

    public void playSound(String str) {
        if(str.equals("1"))
            Sound.playTone(200, 500);
        if(str.equals("2"))
            Sound.playTone(250, 500);
        if(str.equals("3"))
            Sound.playTone(300, 500);
        if(str.equals("4"))
            Sound.playTone(350, 500);
        else{}
    }

    public void displayString(String str) throws InterruptedException {
        LCD.clear();
        playSound(str);
        LCD.drawString(str, 8, 3);
        Thread.sleep(500);
    }
    
    public void displayLongString(String str) throws InterruptedException {
        LCD.clear();
        LCD.drawString(str, 0, 0);
        Thread.sleep(2000);
    }
    
    public void pause() {
        while(!a.isPressed() && !b.isPressed() && !c.isPressed() && !d.isPressed()){
        }
    }
}
