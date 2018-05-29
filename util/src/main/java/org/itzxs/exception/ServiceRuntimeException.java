package org.itzxs.exception;

/**
 * Created by Itzxs on 2018/5/29.
 * 在Spring 事务中处理业务异常的
 */
public class ServiceRuntimeException extends RuntimeException {
    static final long serialVersionUID = -7034898790745766939L;

    private int errorCode;

    /**
     * Constructs a new runtime exception with <code>null</code> as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ServiceRuntimeException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ServiceRuntimeException(String message) {
        super(message);
    }

    public ServiceRuntimeException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
