package juniorTechTask;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class JavaReflectionTest {

    @Test
    public void createTxtWithMethods()  {
        Set<Class> setOfClasses = findAllClasses("juniorTechTask");
        System.out.println(setOfClasses.size());
        String listOfMethods = getListOfMethods(setOfClasses);
        createTxtFromString(listOfMethods);
    }
    public Set<Class> findAllClasses(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return new HashSet<>(reflections.getSubTypesOf(Object.class));
    }
    public String getListOfMethods(Set<Class> setOfClasses) {
        StringBuilder listOfMethods = new StringBuilder();
        for (Class clazz : setOfClasses) {
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    listOfMethods.append(method.getName()).append(", ");
                }
            }
        }
        listOfMethods.delete(listOfMethods.lastIndexOf(","), listOfMethods.lastIndexOf(",")+2).append(".");
        return listOfMethods.toString();
    }
    public void createTxtFromString(String stringToWrite) {
        File output = new File("listOfMethods.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(output);
            writer.write(stringToWrite);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
