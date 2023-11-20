/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-10-20
 * Time: 20:24
 */
public class QueueEmptyException extends RuntimeException{
    public QueueEmptyException() {
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
