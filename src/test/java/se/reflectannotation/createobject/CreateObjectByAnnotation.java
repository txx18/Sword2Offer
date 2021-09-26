package se.reflectannotation.createobject;

import java.lang.reflect.Method;

/**
 * @author ShaneTang
 * @create 2021-04-11 14:51
 */
@Pro(className = "se.reflectannotation.createobject.Student.java", methodName = "sleep")
public class CreateObjectByAnnotation {
    public static void main(String[] args) throws Exception {

        /*
            前提：不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
         */


        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<CreateObjectByAnnotation> reflectTestClass = CreateObjectByAnnotation.class;

        //2.获取上边的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        /*

            public class ProImpl implements Pro{
                public String className(){
                    return "language.reflect.loadproperties.Student";
                }
                public String methodName(){
                    return "sleep";
                }

            }
 */

        Pro annoObj = reflectTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = annoObj.className();
        String methodName = annoObj.methodName();
        System.out.println(className);
        System.out.println(methodName);


        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }
}
