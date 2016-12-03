package annotation;

import java.util.Date;

public class SuppressWarningTest {

    @SuppressWarnings( "deprecation" )
    public static void doSomething(){
        final Date date = new Date(113, 8, 26);
        System.out.println(date);
    }

    public static void main(final String[] args) {
        doSomething();
    }
}