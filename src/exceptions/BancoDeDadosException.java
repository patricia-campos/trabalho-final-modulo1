package exceptions;

public class BancoDeDadosException extends Throwable {

    public BancoDeDadosException(Throwable cause) {
        System.out.println(cause);
    }

}
