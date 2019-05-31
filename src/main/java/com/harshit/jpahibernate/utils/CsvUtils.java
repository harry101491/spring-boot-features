package com.harshit.jpahibernate.utils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;


public class CsvUtils {
    private static final CsvMapper mapper = new CsvMapper();
    private static Logger logger = LoggerFactory.getLogger(CsvUtils.class);

    /**
     * Method to Load the CSV to Database.
     * @param <T>
     * @param clazz
     * @param fileName
     * @return
     */
    public static <T> List<T> read(Class<T> clazz, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues = 
                mapper.reader(clazz).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch(IOException e) {
            logger.error("Error while parsing the data");
            return Collections.emptyList();
        }
    }

    /**
     * Method to load many to many relationship for the given file name.
     * @param fileName
     * @return
     */
    public static List<String[]> loadManyToManyRelationship(String fileName) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<String[]> readValues = 
              mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            logger.error(
              "Error occurred while loading many to many relationship from file = " + fileName, e);
            return Collections.emptyList();
        }
    }
}