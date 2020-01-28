/** Lab3 class for SimonLab runs until user enters incorrect string of integers.
  * Asks for and gets users input.
  *
  * @author		Hudson Whittaker
  * @id			hjwhittaker
  * @course		CSIS 252 - 02
  * @assignment		Lab03
  * @related		Queue
  */
import lejos.nxt.*;
public class Lab3Robot {
    
    public static void main(String[] args) throws Exception{
        RobotButton robot = new RobotButton();
        String userInput;
        QueueRobot queue;
        queue = new QueueRobot();
        int i;
        int j = 2;
        
        robot.displayLongString("\n\n\n      PRESS");
        queue.randQ();
        queue.screenPrint();
        userInput = robot.getButton();
        robot.displayString(userInput);
        queue.queueButton(userInput);
        
        while(queue.compare()) {
            robot.displayLongString("\n\n\n   Next Level!");
            robot.displayLongString("\n\n\n      PRESS");
            queue.randQ();
            queue.screenPrint();
            for(i = 0; i < j; i++) {
                userInput = robot.getButton();
                robot.displayString(userInput);
                queue.queueButton(userInput);
            }
            j++;
            i = 0;
        }
        robot.displayLongString("////////////////\n////////////////\n////////////////\n   You lost at  \n    LEVEL: " + (j-1) + "\n////////////////\n////////////////\n////////////////");
        robot.pause();
    }
    
}