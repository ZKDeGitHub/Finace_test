package com.javasm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author:
 * @className: SqlSessionUtils
 * @description: 操作SqlSession对象
 * @date: 2023/6/8 16:30
 * @since: 11
 */
public class SqlSessionUtils {
    static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 单例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 获取SqlSession对象
     *
     * @return SqlSession对象
     */
    public static SqlSession getSqlSession() {
        // 设置参数为true，执行增删改操作时自动进行事务的提交操作
        return sqlSessionFactory.openSession(true);
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        sqlSession.close();
    }
}