package org.keycloak.userstorage.util;


import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import org.keycloak.userstorage.domain.Constants;
import org.keycloak.userstorage.domain.UserEntity;
import org.keycloak.userstorage.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MybatisUtil {
    private final Logger logger = LoggerFactory.getLogger(MybatisUtil.class);

    private static final byte[] LOCKER = new byte[0];

    private static HikariDataSource dataSource;
    private static PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();

    private static SqlSessionFactory sqlSessionFactory;


    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            synchronized (LOCKER) {
                if (sqlSessionFactory == null) {
                    try {
                        sqlSessionFactory = buildSqlSessionFactory(initDataSource());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }


    public static SqlSessionFactory buildSqlSessionFactory(DataSource dataSource) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);

        Configuration configuration = factory.getConfiguration();
        Environment environment = new Environment("1", new JdbcTransactionFactory(), dataSource);
        configuration.setEnvironment(environment);

        //构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(configuration);

        return sqlSessionFactory;
    }

    /**
     * 初始化数据源
     *
     * @return
     */
    private static DataSource initDataSource() {
        dataSource = new HikariDataSource();
        dataSource.setDriverClassName(propertiesUtil.getStrPropertyValue(Constants.DB_DRIVER_CLASS));
        dataSource.setJdbcUrl(propertiesUtil.getStrPropertyValue(Constants.DB_URL));
        dataSource.setUsername(propertiesUtil.getStrPropertyValue(Constants.DB_USERNAME));
        dataSource.setPassword(propertiesUtil.getStrPropertyValue(Constants.DB_PASSWORD));

        dataSource.setMinimumIdle(propertiesUtil.getIntPropertyValue(Constants.DB_MIN_POOL_SIZE, 1));
        dataSource.setMaximumPoolSize(propertiesUtil.getIntPropertyValue(Constants.DB_MAX_POOL_SIZE, 20));
        dataSource.setIdleTimeout(propertiesUtil.getIntPropertyValue(Constants.DB_MAX_IDLE_TIME, 60000));
        dataSource.setMaxLifetime(propertiesUtil.getIntPropertyValue(Constants.DB_MAX_LIFE_TIME, 60000 * 10));

        dataSource.setConnectionTestQuery("SELECT 1");
        dataSource.setAutoCommit(true);
        return dataSource;
    }


    /**
     * 解析mapper.xml文件
     *
     * @param configuration
     * @param classPath
     * @throws IOException
     */
    private void registryMapperXml(Configuration configuration, String classPath) throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> mapper = this.getClass().getClassLoader().getResources(classPath);
        while (mapper.hasMoreElements()) {
            URL url = mapper.nextElement();
            if (url.getProtocol().equals("file")) {
                String path = url.getPath();
                File file = new File(path);
                File[] files = file.listFiles();
                for (File f : files) {
                    FileInputStream in = new FileInputStream(f);
                    XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(in, configuration, f.getPath(), configuration.getSqlFragments());
                    xmlMapperBuilder.parse();
                    in.close();
                }
            } else {
                // TODO org.jboss.vfs.protocol.VirtualFileURLConnection cannot be cast to java.net.JarURLConnection
                JarURLConnection urlConnection = (JarURLConnection) url.openConnection();
                JarFile jarFile = urlConnection.getJarFile();
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if (jarEntry.getName().endsWith(".xml")) {
                        InputStream in = jarFile.getInputStream(jarEntry);
                        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(in, configuration, jarEntry.getName(), configuration.getSqlFragments());
                        xmlMapperBuilder.parse();
                        in.close();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 20) {
            try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
                UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                List<UserEntity> all = mapper.selectList("1");
                System.out.println(all);
                System.out.println(dataSource.getHikariPoolMXBean().getActiveConnections());
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


}
