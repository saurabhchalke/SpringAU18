import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@interface MyAnnotation{  
int rollno() default 0;
String name() default "John Doe";
}  

class Student{  
@MyAnnotation(rollno=5, name="Saurabh Chalke") 
public void testPrint(){System.out.println("Hello!");}  
}  

public class AuCustomAnnotation {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		Student t = new Student();  
		Method m = t.getClass().getMethod("testPrint");  
		  
		MyAnnotation student = m.getAnnotation(MyAnnotation.class);  
		System.out.println("Roll number: " + student.rollno());
		System.out.println("Name: " + student.name());

	}

}
