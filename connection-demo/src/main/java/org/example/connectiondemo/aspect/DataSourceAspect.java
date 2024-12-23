package org.example.connectiondemo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.connectiondemo.connection.ConnectionInvocationHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;

@Aspect
@Component
public class DataSourceAspect {

    //DataSource is all method in sql like (create, update ..)
    @Around("target(javax.sql.DataSource)")
    public Object aroundDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Data Source Trace : " + joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();

        //if connection contain that will call createConnectionProxy method if not that will call normal
        if(proceed instanceof Connection){
            return createConnectionProxy((Connection) proceed);
        }
        return proceed;
    }

    public Connection createConnectionProxy(Connection connection) {
        //1 create new Proxy
        //2 ဒီ class is used
        //3 class array is filled with Connection
        //4 and Handler will be work when you call connection

        return (Connection) Proxy.newProxyInstance(
                DataSourceAspect.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionInvocationHandler(connection)
        );
    }

}
