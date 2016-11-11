package exp.dp.proxy.staticproxy;

import exp.dp.proxy.IDBQuery;

/**
 * <p>Copyright: Copyright (c) 1997-2016 Sophos Limited or one of its affiliates. All rights reserved.</p>
 * <p>Created: Oct 27, 2016</p>
 * @author CHANGE TO YOUR NAME IN Java->Code Style->Code Templates->Comments->Files
 */

public class ClientStatic
{
    public static void main(final String[] args){
        // 静态代理
        final IDBQuery q = new DBQueryProxy(); //使用代里
        System.out.println(q.request()); //在真正使用时才创建真实对象

//        // 动态代理
//        final IDBQuery dq = DBQueryHandler.createProxy( );
//        System.out.println(dq.request());
    }
}
