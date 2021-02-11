package br.com.cgmn.domain;

public class DomainException extends Exception {

    private static final long serialVersionUID = 7428271666553271544L;

    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
