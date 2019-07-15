package cn.bit.edu.exception;

public class NoNumberException extends RuntimeException {

    public NoNumberException(String msg){
        super(msg);
    }

    public NoNumberException(String msg,Throwable throwable) {
        super(msg,throwable);
    }
}
