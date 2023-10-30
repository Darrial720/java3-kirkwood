package com.shirley.demo.day16;

import java.math.BigInteger;


public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public void setNumerator (int numerator){
        this.numerator=numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public void setDenominator (int denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can not be zero");
        }
        this.denominator = denominator;

    }

    public static int greatestCommonDivisor(int num1, int num2){
        BigInteger i = BigInteger.valueOf(num1).gcd(BigInteger.valueOf(num2));
        int gcd = Integer.parseInt(i.toString());
        return gcd;
    }

    public Fraction Symplify(){
        int gcd = greatestCommonDivisor(this.numerator, this.denominator);
        Fraction simplifiedFraction = new Fraction(this.numerator / gcd, this.denominator / gcd);
        if(simplifiedFraction.numerator >= 0 && simplifiedFraction.denominator < 0
                || simplifiedFraction.numerator < 0 && simplifiedFraction.denominator < 0) {
            simplifiedFraction.numerator *= -1;
            simplifiedFraction.denominator *= -1;
        }
        return simplifiedFraction;
    }

    public String mixedNumber(){
        Integer num = 0;
        Integer num2 = 0;
        String string = "";
        Fraction fraction = new Fraction(this.numerator, this.denominator);
        if(fraction.Symplify().getDenominator() == 1){
            num = fraction.Symplify().getNumerator();
            string = num.toString();
        } else if (fraction.Symplify().getNumerator() == 0 ) {
            num = 0;
            string =num.toString();
        } else if (fraction.Symplify().getNumerator() > fraction.Symplify().getDenominator()) {
            if(fraction.Symplify().getNumerator() % fraction.Symplify().getDenominator() == 0){
                num = (fraction.Symplify().getNumerator()/fraction.Symplify().getDenominator());
                string = num.toString();
            }
            else {
                num = fraction.Symplify().getNumerator() / fraction.Symplify().getDenominator();
                num2 = fraction.Symplify().getNumerator() % fraction.Symplify().getDenominator();
                Integer num3 = fraction.Symplify().getDenominator();
                string = num.toString() + " " +  num2.toString() + "/" + num3.toString();
            }

        }else if (fraction.Symplify().getNumerator() < fraction.Symplify().getDenominator() && Math.abs(fraction.Symplify().getNumerator()) < fraction.Symplify().getDenominator()){
            num = fraction.Symplify().getNumerator() % fraction.Symplify().getDenominator();
            num2 = fraction.Symplify().getDenominator();
            string = num.toString() + "/" + num2.toString();
        }else if((fraction.Symplify().getNumerator() < 0) && (Math.abs(fraction.Symplify().getNumerator()) > fraction.Symplify().getDenominator())){
            num = fraction.Symplify().getNumerator() / fraction.Symplify().getDenominator();
            num2 = Math.abs(fraction.Symplify().getNumerator() % fraction.Symplify().getDenominator());
            Integer num3 = fraction.Symplify().getDenominator();
            string = num.toString() + " " +  num2.toString() + "/" + num3.toString();
        }

        return string;
    }
}
