package exp.dp.proxy.staticproxy;

import exp.dp.proxy.IDBQuery;

/**
 * <p>Copyright: Copyright (c) 1997-2016 Sophos Limited or one of its affiliates. All rights reserved.</p>
 * <p>Created: Oct 27, 2016</p>
 * @author CHANGE TO YOUR NAME IN Java->Code Style->Code Templates->Comments->Files
 */

public class DBQuery implements IDBQuery{
    public DBQuery(){
        try{
            Thread.sleep(1000);//假设数据库连接等耗时操作
        }catch(final InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String request() {
        //TODO Auto-generated method stub
        return "request string";
    }

}