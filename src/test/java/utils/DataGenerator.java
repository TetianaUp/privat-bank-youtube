package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {
    private static final Faker faker = new Faker();

    public static int getRandomNumber() {
        Random random = new Random();
        return 100 + random.nextInt(9900);
    }

    public static String getRandomFras() {
        return faker.book().title().toLowerCase();
    }

}
