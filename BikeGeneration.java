class Action {
    String typeWheels;

    Action(int wheels) {
        switch (wheels) {
            case 1:
                typeWheels = "одно";
                break;
            case 2:
                typeWheels = "двух";
                break;
            case 3:
                typeWheels = "трёх";
                break;
            default:
                typeWheels = "";
        }
    }

}

class Repairer {
    Repairer() {}
    public void repair(Bike bike) {
        if (bike.isBroken) bike.isBroken = false;
        System.out.printf("Ремонт %sколёсного велосипеда\n", bike.typeWheels);
    }
}

class Shop {
    public static void buy(Bike bike) {
        if (bike.isBroken) System.out.printf("Мы не можем продать %sколёсный велосипед. Он поломан\n", bike.typeWheels);
        else System.out.printf("Покупаем %sколёсный велосипед\n", bike.typeWheels);
    }
}

class Bike1 extends Bike {
    Bike1(int wDiameter) {
        super(1, wDiameter);
    }
}

class Bike2 extends Bike {
    Bike2(int wDiameter) {
        super(2, wDiameter);
    }
}

class Bike3 extends Bike {
    Bike3(int wDiameter) {
        super(3, wDiameter);
    }
}
public class BikeGeneration {
    public static void main(String[] args) {
        Bike bike1 = new Bike1(40);
        Bike bike2 = new Bike2(50);
        Bike bike3 = new Bike3(60);
        Shop shop = new Shop();
        shop.buy(bike2);
        bike3.assemble();
        bike3.use();
        Repairer repairer = new Repairer();
        repairer.repair(bike3);
        shop.buy(bike3);
        System.out.println(bike3.typeWheels);
        System.out.println(bike1.equals(bike1));
        Bike3 newBike3 = bike3.clone();
    }
}
