package com.itheima;

//import com.itheima.h2mapper.ComponentMapper;
//import com.itheima.mapper.BrandMapper;
//import com.itheima.mapper.TestMapper;
//import com.itheima.h2mapper.ComponentMapper;
//import com.itheima.pojo.Brand;
//import com.itheima.pojo.User;
//import com.yyt.testbigproject.testbigAP.mybatis.DoTestMybatis;
import com.yyt.bp.mapper.ComponentMapper;
import com.yyt.bp.pojo.Component;

import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis 快速入门代码
 */
public class MyBatisDemo {

    public static void main(String[] args) throws IOException {
    	
    	//DoTestMybatis ddt = new DoTestMybatis();
    	//ddt.TestSqlSession();
    	
    	/*
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        TestMapper tt = sqlSession.getMapper(TestMapper.class);
        List<Brand> tts = tt.selectAll();
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        System.out.println(tts);
        //4. 释放资源
        sqlSession.close();
		*/
    	
    	//1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
    	String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        ComponentMapper componentMapper = sqlSession.getMapper(ComponentMapper.class);
        List<Component> tts = componentMapper.selectAll();
        Component fT = componentMapper.selectById("	 ('fc0f15cc-2176-40b5-b04f-8b409151f937'");
        Component nff = new Component();
        nff.setID("ahahhhhhhasdfasdfasdf");
        nff.setNAME("fh");
        nff.setPARENT_ID("adsfafadsf314334");
        nff.setPROVIDER_ID("132413241234");
        nff.setPROVIDER_TYPE("A");
        nff.setREALM_ID("asdfasdfasdfasdf");
        nff.setSUB_TYPE("asfasdf132413241");
        componentMapper.add(nff);
        sqlSession.commit();
        System.out.println(tts);
        System.out.println(fT);
        //4. 释放资源
        sqlSession.close();
        
    }
    
    
}
