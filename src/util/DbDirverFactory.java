package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class DbDirverFactory {

    private static SqlSessionFactory factory;

    public static void driver(){

        String myBatisFile = "xml/mybatis-config.xml";
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(myBatisFile);
        }catch (Exception e){
            e.printStackTrace();
        }

        factory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println("SessionFactory is create");
    }

    public static SqlSessionFactory getFactory(){
        return factory;
    }



}
