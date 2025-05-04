package es.mahoramas.lolpedia.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();
    private static String currentLanguage = "es"; // Idioma por defecto

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setIdioma(String languageCode) {
        currentLanguage = languageCode;
        cargarPropertiesIdioma();
    }

    public static String getIdioma() {
        return currentLanguage;
    }

    private static void cargarPropertiesIdioma() {
        String[] files = {
            "idioma-" + currentLanguage + ".properties",
            "carriles-" + currentLanguage + ".properties"
        };
    
        properties.clear();
    
        for (String filename : files) {
            String path;
            if (filename.startsWith("idioma")) {
                path = "src/main/resources/" + filename;
            } else if (filename.startsWith("carriles")) {
                path = "src/main/resources/textos/carriles/" + filename;
            } else {
                continue;
            }
    
            File file = new File(path);
    
            if (!file.exists()) {
                System.err.println("Archivo de idioma no encontrado: " + path);
                continue;
            }
    
            try (FileInputStream input = new FileInputStream(file);
                 InputStreamReader isr = new InputStreamReader(input, "UTF-8")) {
                properties.load(isr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    

    public static void initialize() {
        cargarPropertiesIdioma();
    }
}
