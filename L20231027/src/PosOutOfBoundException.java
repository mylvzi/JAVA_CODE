/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-27
 * Time: 15:59
 */
public class PosOutOfBoundException extends RuntimeException{
    public PosOutOfBoundException() {
    }

    public PosOutOfBoundException(String message) {
        super(message);
    }
}
