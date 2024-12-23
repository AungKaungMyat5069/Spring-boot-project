package org.example.connectiondemo.connection;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

@RequiredArgsConstructor
public class ConnectionInvocationHandler implements InvocationHandler {
    private final Connection connection;

    // invoke is proxy and method enter and argument will fill
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Connection trace : " + method.toGenericString());
        return method.invoke(connection, args);
    }
}
