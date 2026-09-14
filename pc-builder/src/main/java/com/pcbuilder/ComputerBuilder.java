package com.pcbuilder;

/**
 * The Builder contract: a step-by-step, fluent API for assembling a
 * {@link Computer}. Every setter returns the builder itself so calls can be
 * chained (method chaining / fluent API), and {@link #build()} performs the
 * final validation before handing back an immutable product.
 */
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
