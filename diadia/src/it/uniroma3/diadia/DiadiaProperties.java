package it.uniroma3.diadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DiadiaProperties {
    private static final String PROPERTIES_FILE = "diadia.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = DiadiaProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("File di configurazione '" + PROPERTIES_FILE + "' non trovato nel classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il caricamento del file di configurazione", e);
        }
    }

    public static int getNumeroCfuIniziali() {
        return Integer.parseInt(properties.getProperty("numero_cfu_iniziali"));
    }

    public static int getPesoMaxBorsa() {
        return Integer.parseInt(properties.getProperty("peso_max_borsa"));
    }
}
