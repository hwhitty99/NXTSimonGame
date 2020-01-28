/** Queue class for SimonLab is in control of enqueing a random
  * color/number, creates user's queue, and compares the queues.
  *
  * @author		Hudson Whittaker
  * @id			hjwhittaker
  * @course		CSIS 252 - 02
  * @assignment		Lab03
  * @related		ArrayQueue1
  */
import lejos.nxt.*;
import java.util.Random;

public class QueueRobot {
	private ArrayQueue1 randQ1, randQ2, userQ;
    private RobotButton robot = new RobotButton();
	private int holder = 2;
    private int randInt;
    private String returnString;
	private String currInt;
    private Random rand;
    
    /** Constructor instantiates queues with 100 elements
      * @param NONE
      * @return NONE 
      */
    public QueueRobot(){
        randQ1 = new ArrayQueue1(100);
        randQ2 = new ArrayQueue1(100);
        userQ = new ArrayQueue1(100);
    }
    
    /** Returns string form of currently filled randQ queue for user to copy
      * @param NONE
      * @return String of whichever queue is filled 
      */
    public void screenPrint() throws InterruptedException{
        returnString = "";
        if (holder%2==0){
            while(!randQ1.isEmpty()){
                robot.displayString("");
                currInt = (String)randQ1.dequeue();
                robot.displayString(currInt);
                randQ2.enqueue(currInt);
            }
        }
        else {
            while(!randQ2.isEmpty()){
                robot.displayString("");
                currInt = (String)randQ2.dequeue();
                robot.displayString(currInt);
                randQ1.enqueue(currInt);
            }
        }
        holder++;
    }
    
    /** Compares userQ to randQ1 or randQ2 
      * @param NONE
      * @return bool true if they are equal; else bool false
      */
    public boolean compare() {
        if (holder%2==0){
            while(!randQ1.isEmpty()){
                currInt = (String)randQ1.dequeue();
                if(currInt.equals(userQ.dequeue()))
                    randQ2.enqueue(currInt);
                else return false;
            }
        }
        else {
            while(!randQ2.isEmpty()) {
                currInt = (String)randQ2.dequeue();
                if(currInt.equals(userQ.dequeue()))
                    randQ1.enqueue(currInt);
                else return false;
            }
        }
        holder++;
        return true;
    }
    
    /** Enqueues random integer between 1 and 4 to either 
      * randQ1 or randQ2
      * @param NONE
      * @return NONE
      */
    public void randQ() {
        rand = new Random();
        randInt = rand.nextInt(4)+1;
        if(holder%2==0)
            randQ1.enqueue(String.valueOf(randInt));
        else
            randQ2.enqueue(String.valueOf(randInt));
    }
    
    /** Enqueues given string to userQ divided by spaces 
      * @param String of ints separated by spaces 
      * @return NONE
      */
    public void queueButton(String q) {
        userQ.enqueue(q);
    }
}
