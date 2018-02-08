package analyzer;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

/**
 * Helper class that allows  to work with org.reflections library.
 */
public final class ReflectionUtils {
    private static Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forPackage(""))
            .setScanners(new SubTypesScanner(), new MethodAnnotationsScanner()));

    /**
     * Returns all non-abstract subclasses of parent class.
     *
     * @param parent Parent class.
     * @param <E>    Type of parent class.
     * @return Set of subclasses of parent class.
     */
    static <E> Set<Class<? extends E>> getNonAbstractSubtypes(Class<E> parent) {
        return removeAbstractClasses(reflections.getSubTypesOf(parent));
    }

    /**
     * Returns all method annotated with some annotation.
     *
     * @param annotation Annotation for search all methods annotated with it.
     * @return Set of methods annotated with some annotation.
     */
    static Set<Method> getMethodsAnnotatedWith(Class<? extends Annotation> annotation) {

        return reflections.getMethodsAnnotatedWith(annotation);
    }

    // remove all abstract classes from set of classes
    private static <E> Set<Class<? extends E>> removeAbstractClasses(Set<Class<? extends E>> classes) {
        for (Iterator<Class<? extends E>> iterator = classes.iterator(); iterator.hasNext(); ) {
            Class<? extends E> aClass = iterator.next();
            if (Modifier.isAbstract(aClass.getModifiers())) {
                iterator.remove();
            }
        }
        return classes;
    }
}
