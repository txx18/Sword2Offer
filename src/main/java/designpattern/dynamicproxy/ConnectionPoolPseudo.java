package designpattern.dynamicproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author ShaneTang
 * @create 2021-06-01 22:40
 */
public class ConnectionPoolPseudo {

    @Test
    public void connectionProxy() throws SQLException {
        Connection physicalConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "11111111");
        Connection proxy = (Connection) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                physicalConn.getClass().getInterfaces(),
                (proxy1, method, args) -> {
                    if (method.getName().equals("close")) {
                        System.out.println("close");
                        return 1;
                    }else {
                        return method.invoke(physicalConn, args);
                    }
                }
        );
        proxy.close();
    }
}
