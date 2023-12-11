package FinalExam;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Crayon implements Comparable{
    private String color;
    private double percentRemaining;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPercentRemaining() {
        return percentRemaining;
    }

    public void setPercentRemaining(double percentRemaining) {
        if(percentRemaining > 1 || percentRemaining < 0){
            IllegalArgumentException e = new IllegalArgumentException();
            throw   e;
        }
        else {
            this.percentRemaining = percentRemaining;
        }
    }

    @Override
    public String toString() {
        return "Crayon{" +
                "color='" + color + '\'' +
                ", percentRemaining=" + percentRemaining +
                '}';
    }

    public Crayon() {
        color = "black";
        percentRemaining = 1;
    }

    public Crayon(String color, double percentRemaining) {
        setColor(color);
        setPercentRemaining(percentRemaining);
    }



    public static void main(String[] args){
        List<Crayon> crayons = new ArrayList<>();
        Crayon crayon1 = new Crayon();
        Crayon crayon2 = new Crayon("yellow", .75);
        Crayon crayon3 = new Crayon("blue", 1);
        Crayon crayon4 = new Crayon("red", .25);
        Crayon crayon5 = new Crayon("green", .80);
        crayons.add(crayon1);
        crayons.add(crayon2);
        crayons.add(crayon3);
        crayons.add(crayon4);
        crayons.add(crayon5);

        crayons.sort(Crayon::compareTo);
        crayons.forEach(System.out::println);
        System.out.println();
        System.out.println();

        List<Crayon> copy = new ArrayList<>(crayons);
        copy.removeIf((Crayon) -> Crayon.getPercentRemaining() < .50);
        copy.forEach(System.out::println);


    }

    @Override
    public int compareTo(@NotNull Object o) {
        //if(this.getColor() <
        return 0;
    }
}
