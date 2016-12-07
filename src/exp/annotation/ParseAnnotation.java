package exp.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ParseAnnotation {

    public static void parseTypeAnnotation() throws ClassNotFoundException {
        final Class clazz = Class.forName("annotation.UserAnnotation");

        final Annotation[] annotations = clazz.getAnnotations();
        for (final Annotation annotation : annotations) {
            final TestA testA = (TestA)annotation;
            System.out.println("id= " + testA.id() + "; name= " + testA.name() + "; gid = " + testA.gid());
        }
    }

    public static void parseMethodAnnotation(){
        final Method[] methods = UserAnnotation.class.getDeclaredMethods();
        for (final Method method : methods) {

            final boolean hasAnnotation = method.isAnnotationPresent(TestA.class);
            if (hasAnnotation) {

                final TestA annotation = method.getAnnotation(TestA.class);
                System.out.println("method = " + method.getName()
                + " ; id = " + annotation.id() + " ; description = "
                + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    public static void parseConstructAnnotation(){
        final Constructor[] constructors = UserAnnotation.class.getConstructors();
        for (final Constructor constructor : constructors) {

            final boolean hasAnnotation = constructor.isAnnotationPresent(TestA.class);
            if (hasAnnotation) {

                final TestA annotation =(TestA) constructor.getAnnotation(TestA.class);
                System.out.println("constructor = " + constructor.getName()
                + " ; id = " + annotation.id() + " ; description = "
                + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    public static void parseFieldAnnotation(){
        final Field[] fields = UserAnnotation.class.getDeclaredFields( );
        for (final Field fidld : fields) {

            final boolean hasAnnotation = fidld.isAnnotationPresent(TestA.class);
            if (hasAnnotation) {

                final TestA annotation =fidld.getAnnotation(TestA.class);
                System.out.println("field = " + fidld.getName()
                + " ; id = " + annotation.id() + " ; description = "
                + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    public static void main(final String[] args) throws ClassNotFoundException {
        parseTypeAnnotation();
        parseMethodAnnotation();
        parseConstructAnnotation();
        parseFieldAnnotation();
    }
}