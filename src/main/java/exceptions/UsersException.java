package exceptions;

public class UsersException extends Exception {

    public final static String MESSAGE = "You entered a non-existent user";

    public UsersException() {

        super(MESSAGE);

    }

}
