package com.pcbuilder;

public interface ComputerBuilder {

    ComputerBuilder setCpu(String cpu);

    ComputerBuilder setGpu(String gpu);

    ComputerBuilder setRamGb(int ramGb);

    ComputerBuilder setStorage(String storage);

    ComputerBuilder setMotherboard(String motherboard);

    ComputerBuilder setPsuWatts(int psuWatts);

    ComputerBuilder setCaseType(String caseType);

    ComputerBuilder setCoolingSystem(String coolingSystem);

    ComputerBuilder setRgbLighting(boolean rgbLighting);

    Computer build();
}
