import java.io.*;
import java.util.*;

/** This class does all I/O (either to standard input/output or specified
 *  files depending on what is sent the constructor).  It is designed to aid
 *  in the use of command line arguements to specify input/output files.
 *  @author     Cathy Bareiss
 *  @id         cbareiss
 *  @course     CSIS 252:  Programming II
 *  @assignment Demostration
 *  @related    CountingProblem
 */
public class RobotCommandLine implements RobotInterface {
    /** used to specify the output location */
    PrintStream out;
    /** used to specify the input location */
    Scanner in;

    /** creates the input and output locations based on parameter
      * @param args - an array of file names - first is input, second is output
      *             - if no elements, use System.in and System.out
      *             - if only one, use System.out for output
      */
    public RobotCommandLine(String[] args) throws IOException {
        if (args.length == 0) { // using standard in and out
            in = new Scanner(System.in);
            out = System.out;
        } else if (args.length == 1) { // using standard out
            in = new Scanner(new FileReader(args[0]));
            out = System.out;
        } else { // using specified files
            in = new Scanner(new FileReader(args[0]));
            out = new PrintStream(args[1]);
        }
    
    }
    public int getButton() throws Exception{
        int number;
        number = in.nextInt();
        return number;
    }
    public void moveMotor(int motor) throws Exception {
        out.println("Motor "+motor+" is moving");
    }
    public void displayString(String str) throws Exception {
        out.println("Displaying "+str);
    }
}
