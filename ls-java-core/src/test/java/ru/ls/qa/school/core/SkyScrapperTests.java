package ru.ls.qa.school.core;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkyScrapperTests {

    public static int testCalculateGain(SkyScrapper s) {
        int x = s.getFirstFloorFlatSale();
        int m = s.getFreqIncrease();
        int n = s.getFloorsCount();
        int k = n / m;
        int sum = x * n + 1000 * (m * (k - 1) * k / 2 + (n % m) * k);
        return sum;
    }

    @Test
    public void totalGainTest() {
        for (int i = 0; i < 100000; i++) {
            int x = (int) (Math.random() * 10000) + 1;
            int m = (int) (Math.random() * 10000) + 1;
            int n = (int) (Math.random() * 10000) + 1;

            SkyScrapper s = new SkyScrapper(x, n, m);

            int actualResult = s.totalGain();

            int expectedResult = testCalculateGain(s);

            assertEquals(expectedResult, actualResult, "Найдена ошибка!");

        }
    }
}
