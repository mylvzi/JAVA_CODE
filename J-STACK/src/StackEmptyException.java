/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-19
 * Time: 20:56
 */
public class StackEmptyException extends RuntimeException{
    public StackEmptyException() {
    }

    public StackEmptyException(String message) {
        super(message);
    }
}
