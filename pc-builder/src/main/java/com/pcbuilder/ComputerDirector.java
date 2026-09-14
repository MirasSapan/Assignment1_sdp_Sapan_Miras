package com.pcbuilder;

public class ComputerDirector {

    public Computer buildGamingPc(ComputerBuilder builder) {
        return builder
                .setCpu("AMD Ryzen 7 7800X3D")
                .setGpu("NVIDIA GeForce RTX 4070 Ti")
                .setRamGb(32)
                .setStorage("2TB NVMe SSD")
                .setMotherboard("B650 ATX")
                .setPsuWatts(750)
                .setCaseType("Mid Tower ATX")
                .setCoolingSystem("240mm AIO Liquid Cooler")
                .setRgbLighting(true)
                .build();
    }

    public Computer buildOfficePc(ComputerBuilder builder) {
        return builder
                .setCpu("Intel Core i5-13400")
                .setRamGb(16)
                .setStorage("512GB NVMe SSD")
                .setMotherboard("B760 Micro-ATX")
                .setPsuWatts(400)
                .setCaseType("Compact Mini Tower")
                .build();
    }

    public Computer buildWorkstationPc(ComputerBuilder builder) {
        return builder
                .setCpu("AMD Ryzen 9 7950X")
                .setGpu("NVIDIA RTX 4000 Ada")
                .setRamGb(128)
                .setStorage("4TB NVMe SSD")
                .setMotherboard("X670E ATX")
                .setPsuWatts(1000)
                .setCaseType("Full Tower ATX")
                .setCoolingSystem("360mm AIO Liquid Cooler")
                .build();
    }
}
