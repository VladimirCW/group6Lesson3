package test.java.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DPAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        /*if(method.getName().toLowerCase().equals("parametrizedtest")) {
            System.out.println("Will use method: " + method.getName());

        }*/
        if(!System.getProperty("dp").toLowerCase().equals("empty")) {
            iTestAnnotation.setDataProviderClass(DPSource.class);
            iTestAnnotation.setDataProvider(System.getProperty("dp"));
        }
    }
}
