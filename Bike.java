class Wheel {
    int d;
    Wheel (int di){
        d = di;
    }

    public Wheel clone() throws CloneNotSupportedException {
        d = clone();
    }
}




public class Bike implements Cloneable {
    String typeWheels;
    int wheelCount;
    Wheel w;
    boolean isBroken = false;

    Bike(int wCount, int wDiameter) {
        typeWheels = new Action(wCount).typeWheels;
        wheelCount = wCount;
        w = new Wheel(wDiameter);
        if (wheelCount == 3) isBroken = true;

    }


    public Bike clone() throws CloneNotSupportedException {
        Bike newBike = (Bike) super.clone();
        int wheelDiameter = newBike.w.d;
        newBike.w = new Wheel(wheelDiameter);
        return newBike;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bike other = (Bike) obj;
        if (wheelCount != other.wheelCount)
            return false;
        return true;
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + wheelCount;
        return result;
    }

    public String toString() {
        String info;
        String isBrokenString = "не сломан";
        if (isBroken) isBrokenString = "сломан";
        info = "Велосипед "+ typeWheels + "колёсный номер " + hashCode() + ", и он " + isBrokenString;
        return info;
    }
    public void use() {
        if (isBroken) System.out.printf("Мы не можем использовать %sколёсный велосипед. Он поломан\n", typeWheels);
        else System.out.printf("Использование %sколёсного\n", typeWheels);
    }
    public void assemble() {
        if (isBroken) System.out.printf("Мы не можем собрать %sколёсный велосипед. Детали поломаны\n", typeWheels);
        else System.out.printf("Сборка %sколёсного\n", typeWheels);
    }
    public static void main(String[] arg) throws CloneNotSupportedException {
        Bike bike1 = new Bike(2, 26);
        Bike bike2 = (Bike) bike1.clone();
        bike1.wheelCount = 2;
        bike1.w.d = 29;
        System.out.println(bike1.w);
        System.out.println(bike2.w);
        System.out.println(bike1.equals(bike2));
        System.out.println(bike1.hashCode());
    }
}


