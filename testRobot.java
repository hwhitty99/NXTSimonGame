import lejos.nxt.*;

public class testRobot{

    public static void main(String[] args) throws Exception{
        RobotButton robot = new RobotButton();
        int n = robot.getButton();
        robot.displayString(String.valueOf(n));
        robot.pause();
    }
}