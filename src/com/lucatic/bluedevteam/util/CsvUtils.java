package com.lucatic.bluedevteam.util;

import com.lucatic.bluedevteam.excepciones.CsvException;
import com.lucatic.bluedevteam.model.Juego;
import com.lucatic.bluedevteam.model.TipoGenero;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades para operar con archivos de tipo "CSV".
 * @since 22/02/2024
 * @author BlueDevTeam
 * @version 1.0.0
 */

public class CsvUtils {

	private static final Logger LOGGER = LogManager.getLogger(CsvUtils.class);
	
	/**
	 * Convierte datos de un archivo CSV en una lista de objetos "Juego".
	 * 
	 * @param fichero Ruta del archivo CSV.
	 * @return lista de objetos "Juego".
	 * @throws CsvException lanza error si ocurre un error obteniendo los datos del fichero o si ocurre un error procesando los datos del fichero.
	 */


    public static List<Juego> deCsvAList(String fichero) throws CsvException {

        List<Juego> lista = new ArrayList<>();

        try (Reader reader = new FileReader(fichero); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            int i = 0;

            for (CSVRecord csvRecord : csvParser) {

                if (i == 0) {
                    i++;
                    continue;
                }

                String genero = csvRecord.get(4);

                if (genero.equalsIgnoreCase("Role-Playing"))
                    genero = "ROLEPLAYING";

                String anio = csvRecord.get(3);

                if (anio.equalsIgnoreCase("N/A"))
                    anio = "0";

                lista.add(new Juego(Integer.parseInt(csvRecord.get(0)), // ranking
                        csvRecord.get(1), // nombre
                        csvRecord.get(2), // plataforma
                        Integer.parseInt(anio), // Año
                        TipoGenero.valueOf(genero.toUpperCase()), // tipo genero
                        csvRecord.get(5) // editor
                ));
            }

            return lista;

        } catch (IOException e) {
            LOGGER.error("Error obteniendo datos del fichero csv", e);
            throw new CsvException("Error obteniendo datos del fichero csv", e);

        } catch (NumberFormatException e) {
            LOGGER.error("Error parseando datos en las columnas del csv a atributos de Juego", e);
            throw new CsvException("Error parseando datos en las columnas del csv a atributos", e);
        }
    }
}
