package es.upm.miw.iwvg_devops.code;

import java.util.Objects;

public class Fraction {

    private int numerator;

    private int denominator;

    public static final Fraction NaN = new Fraction(0, 0);

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public boolean isValid() {
        return this.denominator != 0;
    }

    public double decimal() {
        if (isValid()) {
            return (double) numerator / denominator;
        } else {
            return Double.NaN;
        }
    }

    public boolean isProper() {
        return this.isValid() && this.numerator != 0 && Math.abs(this.numerator) < Math.abs(this.denominator);
    }

    public boolean isImproper() {
        return this.isValid() && !this.isProper();
    }

    public boolean isEquivalent(Fraction other) {
        if (this.isValid() && other != null && other.isValid()) {
            return this.numerator * other.denominator == this.denominator * other.numerator;
        } else {
            return false;
        }
    }

    public Fraction add(Fraction other) {
        if (this.isValid() && other != null && other.isValid()) {
            return new Fraction(this.getNumerator() * other.getDenominator() + this.getDenominator() * other.getNumerator(), this.getDenominator() * other.getDenominator()).reduce();
        } else {
            return NaN;
        }
    }

    public Fraction multiply(Fraction other) {
        if (this.isValid() && other != null && other.isValid()) {
            return new Fraction(this.getNumerator() * other.getNumerator(), this.getDenominator() * other.getDenominator()).reduce();
        } else {
            return NaN;
        }
    }

    public Fraction divide(Fraction other) {
        if (this.isValid() && other != null && other.isValid()) {
            return new Fraction(this.getNumerator() * other.getDenominator(), this.getDenominator() * other.getNumerator()).reduce();
        } else {
            return NaN;
        }
    }

    private Fraction reduce() {
        assert this.isValid();
        int gcd = greatestCommonDivisor(this.numerator, this.denominator);
        int newNumerator = this.numerator / gcd;
        int newDenominator = this.denominator / gcd;
        if (newDenominator < 0) {
            newNumerator = -newNumerator;
            newDenominator = -newDenominator;
        }
        return new Fraction(newNumerator, newDenominator);
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return greatestCommonDivisor(b, a % b);
    }

    @Override
    public String toString() {
        return "Fraction{" + "numerator=" + numerator + ", denominator=" + denominator + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
