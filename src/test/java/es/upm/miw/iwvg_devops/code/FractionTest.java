package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void testFractionIntInt() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    void testFraction() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(0.5, fraction.decimal(), 10e-5);
    }

    @Test
    void testDecimalWithInvalidFraction() {
        Fraction fraction = new Fraction(1, 0);
        assertTrue(Double.isNaN(fraction.decimal()));
    }

    @Test
    void testIsValidWithValidFraction() {
        Fraction fraction = new Fraction(1, 2);
        assertTrue(fraction.isValid());
    }

    @Test
    void testIsValidWithInvalidFraction() {
        Fraction fraction = new Fraction(1, 0);
        assertFalse(fraction.isValid());
    }

    @Test
    void testIsProperWithInvalidFraction() {
        Fraction fraction = new Fraction(1, 0);
        assertFalse(fraction.isProper());
    }

    @Test
    void testIsProperFractionZero() {
        Fraction fraction = new Fraction(0, 1);
        assertFalse(fraction.isProper());
    }

    @Test
    void testIsProperAPositiveProperFraction() {
        Fraction fraction = new Fraction(1, 2);
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsProperANegativeProperFraction() {
        Fraction fraction = new Fraction(-1, 2);
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsProperANonProperFraction() {
        Fraction fraction = new Fraction(-3, 2);
        assertFalse(fraction.isProper());
    }

    @Test
    void testIsImproperWithInvalidFraction() {
        Fraction fraction = new Fraction(1, 0);
        assertFalse(fraction.isImproper());
    }

    @Test
    void testIsImproperZero() {
        Fraction fraction = new Fraction(0, 1);
        assertTrue(fraction.isImproper());
    }

    @Test
    void testIsImproperAPositiveImproperFraction() {
        Fraction fraction = new Fraction(3, 2);
        assertTrue(fraction.isImproper());
    }

    @Test
    void testIsImproperANegativeImproperFraction() {
        Fraction fraction = new Fraction(-3, 2);
        assertTrue(fraction.isImproper());
    }

    @Test
    void testIsImproperANonImproperFraction() {
        Fraction fraction = new Fraction(1, -2);
        assertFalse(fraction.isImproper());
    }

    @Test
    void testIsEquivalentWithTwoEquivalentFractions() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(4, 8);
        assertTrue(f1.isEquivalent(f2));
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testIsEquivalentParametersFromMethod(Fraction f1, Fraction f2) {
        assertFalse(f1.isEquivalent(f2));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new Fraction(3, 2), new Fraction(4, 8)),
                Arguments.of(new Fraction(3, 0), new Fraction(4, 8)),
                Arguments.of(new Fraction(3, 5), new Fraction(4, 0))
        );
    }

    @Test
    void testIsEquivalentWithNullFraction() {
        Fraction f1 = new Fraction(3, 5);
        assertFalse(f1.isEquivalent(null));
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(10, 35);
        Fraction expected = new Fraction(31, 35);
        assertEquals(expected, f1.add(f2));
    }

    @Test
    void testAddWithInvalidFraction() {
        Fraction f1 = new Fraction(1, 0);
        Fraction f2 = new Fraction(10, 12);
        assertSame(Fraction.NaN, f1.add(f2));
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(10, 12);
        Fraction expected = new Fraction(1, 2);
        assertEquals(expected, f1.multiply(f2));
    }

    @Test
    void testMultiplyWithInvalidFraction() {
        Fraction f1 = new Fraction(1, 0);
        Fraction f2 = new Fraction(10, 12);
        assertSame(Fraction.NaN, f1.multiply(f2));
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(10, 12);
        Fraction expected = new Fraction(18, 25);
        assertEquals(expected, f1.divide(f2));
    }

    @Test
    void testDivideWithInvalidFraction() {
        Fraction f1 = new Fraction(1, 0);
        Fraction f2 = new Fraction(10, 12);
        assertSame(Fraction.NaN, f1.divide(f2));
    }

    @Test
    void testDivideWithNegativeFraction() {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(-10, 12);
        Fraction expected = new Fraction(-18, 25);
        assertEquals(expected, f1.divide(f2));
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(3, 5);
        String expected = "Fraction{numerator=3, denominator=5}";
        assertEquals(expected, fraction.toString());
    }

    @Test
    void testSetNumerator() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        Fraction fraction = new Fraction();
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }
}