package com.pcbuilder;

public final class Main {

    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        Computer gamingPc = director.buildGamingPc(new StandardComputerBuilder());
        System.out.println("Gaming PC:\n" + gamingPc);

        Computer officePc = director.buildOfficePc(new StandardComputerBuilder());
        System.out.println("\nOffice PC:\n" + officePc);

        Computer workstationPc = director.buildWorkstationPc(new StandardComputerBuilder());
        System.out.println("\nWorkstation PC:\n" + workstationPc);

        Computer customPc = new StandardComputerBuilder()
                .setCpu("Intel Core i5-13400F")
                .setRamGb(16)
                .setStorage("1TB NVMe SSD")
                .setMotherboard("B760 Micro-ATX")
                .setPsuWatts(550)
                .setCaseType("Compact Mini Tower")
                .setCoolingSystem("Stock Air Cooler")
                .build();
        System.out.println("\nCustom Budget PC (built without the Director):\n" + customPc);

        try {
            new StandardComputerBuilder()
                    .setCpu("Intel Core i9-14900K")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("\nValidation works as expected: " + e.getMessage());
        }
    }
}
