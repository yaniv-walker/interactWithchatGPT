package com.yan.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * .
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/4 0004
 * @since JDK 1.8.0
 */
public final class PropertiesFileUtil {
    /**
     * cache.
     */
    private static final Map<String, String> PROPERTIES_CACHE = new ConcurrentHashMap<>();

    /**
     * the file name has been read.
     */
    private static final Set<String> READ_FILE_NAME_SET = new HashSet<>();

    /**
     * get property with default properties file name.
     * @param propertyName property name
     * @return property
     */
    public static String getProperty(final String propertyName) {
        return getProperty(propertyName, "application.properties");
    }

    /**
     * get property.
     * @param propertyName property name
     * @return property
     */
    public static String getProperty(final String propertyName, final String propertiesFileName) {
        if (!READ_FILE_NAME_SET.contains(propertiesFileName)) {
            final Properties properties = readPropertiesFile(propertiesFileName);
            properties.forEach((key, value) -> PROPERTIES_CACHE.put((String) key, (String) value));
            READ_FILE_NAME_SET.add(propertiesFileName);
        }
        return PROPERTIES_CACHE.get(propertyName);
    }

    /**
     * read properties file.
     * @param fileName file name
     * @return properties
     */
    private static Properties readPropertiesFile(final String fileName) {
        Properties prop = null;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop = new Properties();
            prop.load(fis);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
