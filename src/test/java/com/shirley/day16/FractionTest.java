package com.shirley.day16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    @Test
    public void defaultConstructor(){
        String expected ="1/1";
        String actual= new Fraction().toString();
        assertEquals(expected, actual);

        /*assertEquals("100/100", actual);*/
    }

    @Test
    public void parameterizedConstructor(){
        Fraction fraction = new Fraction(27, 6);
        String expected = "27/6";
        String actual = fraction.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void getNumerator(){
        int expected = 1;
        int actual = new Fraction().getNumerator();

        assertEquals(expected, actual);
        assertEquals(27, new Fraction(27, 6).getNumerator());
    }

    @Test
    public void getDenominator(){
        assertEquals(1, new Fraction().getDenominator());
        assertEquals(6, new Fraction(27, 6).getDenominator());
    }

    @Test
    public void setDenominator(){
        int expected = 30;
        Fraction fraction = new Fraction();
        fraction.setDenominator(30);
        int actual = fraction.getDenominator();
        assertEquals(expected, actual);
        assertThrows(Exception.class, () -> fraction.setDenominator(0));
    }

    @Test
    public void setNumerator(){
        int expected = 30;
        Fraction fraction = new Fraction();
        fraction.setNumerator(30);
        int actual = fraction.getNumerator();
        assertEquals(expected, actual);
    }

    @Test
    public void greatestCommonFactor(){
        int actual =  Fraction.greatestCommonDivisor(75, 45);
        int expected = 15;
        assertTrue(expected == actual);
        assertEquals(2, Fraction.greatestCommonDivisor(2, 4));
        assertTrue(1 == Fraction.greatestCommonDivisor(5, 7));
    }

    @Test
    public void testDoubles(){
        double expected = 3.3;
        double actual = 1.1 + 2.2;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void Symplify(){
        //1
        Fraction fraction = new Fraction(75, 45);
        assertEquals(fraction.Symplify().toString(), "5/3");
        //2
        fraction = new Fraction(5, 7);
        assertTrue(fraction.Symplify().toString().equals("5/7"));
        //3
        fraction = new Fraction(2, -4);
        assertEquals(fraction.Symplify().getNumerator(), -1);
        assertEquals(fraction.Symplify().getDenominator(), 2);

        Fraction fraction1 = new Fraction(2,4);
        assertEquals(fraction1.Symplify().toString(), "1/2");

        Fraction fraction2 = new Fraction(-2,4);
        assertTrue(fraction2.Symplify().toString().equals("-1/2"));

        Fraction fraction3 = new Fraction(-2,-4);
        assertEquals(fraction3.Symplify().getNumerator(), 1);
        assertEquals(fraction3.Symplify().getDenominator(), 2);
    }
}