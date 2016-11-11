package exp.dp.proxy.dinamic;

/**
 * <p>Copyright: Copyright (c) 1997-2016 Sophos Limited or one of its affiliates. All rights reserved.</p>
 * <p>Created: Oct 27, 2016</p>
 * @author CHANGE TO YOUR NAME IN Java->Code Style->Code Templates->Comments->Files
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import exp.dp.proxy.IDBQuery;
import exp.dp.proxy.staticproxy.DBQuery;


public class DBQueryHandler implements InvocationHandler{
    IDBQuery realQuery = null;//定义主题接口

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        //如果第一次调用，生成真实主题
        if(realQuery == null){
            realQuery = new DBQuery();
        }
        //返回真实主题完成实际的操作
//        return realQuery.request();
        return method.invoke( realQuery, args );
    }

    public static IDBQuery createProxy()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException{
        final IDBQuery proxy = (IDBQuery)Proxy.newProxyInstance(
            ClassLoader.getSystemClassLoader(),
            new Class[]{IDBQuery.class},
            new DBQueryHandler()
        );

//        final Class<IDBQuery> proxyClass =  (Class< IDBQuery >) Proxy.getProxyClass(
//            ClassLoader.getSystemClassLoader(),
//            new Class[]{IDBQuery.class}
//            );
//        final IDBQuery proxy = proxyClass.getConstructor(new Class[] { InvocationHandler.class })
//                .newInstance(new Object[] { new DBQueryHandler() });

        return proxy;
    }

}