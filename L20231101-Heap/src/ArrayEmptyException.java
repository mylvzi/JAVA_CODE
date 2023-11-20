/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-02
 * Time: 20:57
 */
public class ArrayEmptyException extends RuntimeException{
    public ArrayEmptyException() {
    }

    public ArrayEmptyException(String message) {
        super(message);
    }
}
