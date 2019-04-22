package ru.test.project.utils;

import com.github.javafaker.Faker;
import ru.test.project.service.MessageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


/**
 * Generate {@value ROWS_AMOUNT} rows to {@link File} with name {@value FILE_NAME} for testing {@link MessageService}
 *
 */
public class DataGenerator {

    private static final int ROWS_AMOUNT = 5000;

    private static final String FILE_NAME = "generatedData";

    public static void main(String[] args) {
        generateFile();
    }

    private static void generateFile() {
        StringBuilder builder = new StringBuilder();


        for (int i = 0; i < ROWS_AMOUNT; i++) {
            //Random faker library from google
            Faker faker = new Faker();
            String template = "{\"jsonrpc\": \"2.0\"," +
                    " \"method\": \"readMessage\"," +
                    " \"params\": " +
                    "{\"data\":{" +
                    "\"id_sample\":\"" + faker.idNumber().valid() +"\","+
                    "\"num_id\": \"" + faker.idNumber().valid() +"\","+
                    "\"id_location\": \"" + getCity() +"\","+
                    "\"id_signal_par\": \"" + faker.number().randomNumber() +"\","+
                    "\"id_detected\":\"" + (new Random().nextBoolean() ? "None" : "Nan") +"\","+
                    "\"id_class_det\":\"" + faker.number().randomNumber() + "\"}}, " +
                    "\"id\": 1}\n";
            builder.append(template);
        }
        try {
            Files.write(Paths.get(FILE_NAME),builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCity() {
        String[] cities = new String[]{"Spb", "Msc", "Tarkov", "Tikhvin", "Orel", "Sochi", "Krakow", "Berlin", "321.3311", "45.33344", "12.33488"};
        return cities[(int) (Math.random() * cities.length)];
    }


}
