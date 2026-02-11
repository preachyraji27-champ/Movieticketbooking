package team4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import booking.City;

public class CityTest {

    private Scanner makeScanner(String input) {
        return new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

    @Test
    void testValidCitySelection() {
        City city = new City();
        assertTrue(city.selectCity(makeScanner("1\n")));
        assertEquals("Chennai", city.cityName);

        city = new City();
        assertTrue(city.selectCity(makeScanner("2\n")));
        assertEquals("Bangalore", city.cityName);

        city = new City();
        assertTrue(city.selectCity(makeScanner("3\n")));
        assertEquals("Hyderabad", city.cityName);
    }

    @Test
    void testInvalidCitySelectionNonInt() {
        City city = new City();
        assertFalse(city.selectCity(makeScanner("abc\n")));
    }

    @Test
    void testInvalidCitySelectionOutOfRange() {
        City city = new City();
        assertFalse(city.selectCity(makeScanner("9\n")));
    }
}
