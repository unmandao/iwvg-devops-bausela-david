package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindDecimalFractionByUserName() {
        assertEquals(List.of(1.0, 1.0, Double.NaN, Double.NaN, 1.0),
                new Searches().findDecimalFractionByUserName("Paula").collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameBySomeImproperFraction() {
        assertEquals(List.of("Blanco", "López"),
                new Searches().findUserFamilyNameBySomeImproperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(List.of("Blanco", "López"),
                new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct().collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        assertEquals(List.of(-0.2, -0.5),
                new Searches().findDecimalFractionByNegativeSignFraction().collect(Collectors.toList()));
    }
}