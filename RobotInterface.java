public interface RobotInterface {
    public String getButton() throws Exception;
    public void moveMotor(int motor) throws Exception ;
    public void displayString(String str) throws Exception ;
}