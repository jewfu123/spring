package org.keycloak.userstorage.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    private static final byte[] LOCK = new byte[0];
    private static PropertiesUtil instance = null;

    private Properties properties = new Properties();

    public static PropertiesUtil getInstance() {
        if(instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new PropertiesUtil();
                }
            }
        }
        return instance;
    }

    private PropertiesUtil() {
        try {
            InputStream fis = PropertiesUtil.class.getClassLoader().getResourceAsStream("system.properties");
            properties.load(fis);
        } catch (IOException e) {
            logger.error("Manage properties field: " ,e);
        }
    }

    public String getStrPropertyValue(String name) {
        String var = System.getProperty(name);
        if(var != null) {
            logger.debug("System variable, key: " + name + ", value: " + var);
            return var;
        }
        var = properties.getProperty(name);
        logger.debug("User variable, key: " + name + ", value: " + var);
        return var;
    }

    public int getIntPropertyValue(String key, int defaultValue) {
        String data = getStrPropertyValue(key);
        try {
            int valor = Integer.parseInt(data);
            return valor;
        } catch (Exception e) {
            logger.error("Get Int Property Value field: ",e);
            return defaultValue;
        }
    }

}
