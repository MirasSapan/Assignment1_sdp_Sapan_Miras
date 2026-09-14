package com.pcbuilder;

public class StandardComputerBuilder implements ComputerBuilder {

    private static final String DEFAULT_GPU = "Integrated Graphics";
    private static final String DEFAULT_CASE_TYPE = "Mid Tower ATX";
    private static final String DEFAULT_COOLING_SYSTEM = "Stock Air Cooler";
    private static final int MIN_RAM_GB = 4;
    private static final int MIN_PSU_WATTS = 300;

    private String cpu;
    private String gpu = DEFAULT_GPU;
    private int ramGb;
    private String storage;
    private String motherboard;
    private int psuWatts;
    private String caseType = DEFAULT_CASE_TYPE;
    private String coolingSystem = DEFAULT_COOLING_SYSTEM;
    private boolean rgbLighting;

    @Override
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    @Override
    public ComputerBuilder setRamGb(int ramGb) {
        this.ramGb = ramGb;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder setMotherboard(String motherboard) {
        this.motherboard = motherboard;
        return this;
    }

    @Override
    public ComputerBuilder setPsuWatts(int psuWatts) {
        this.psuWatts = psuWatts;
        return this;
    }

    @Override
    public ComputerBuilder setCaseType(String caseType) {
        this.caseType = caseType;
        return this;
    }

    @Override
    public ComputerBuilder setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
        return this;
    }

    @Override
    public ComputerBuilder setRgbLighting(boolean rgbLighting) {
        this.rgbLighting = rgbLighting;
        return this;
    }

    @Override
    public Computer build() {
        validateRequiredFields();
        return new Computer(cpu, gpu, ramGb, storage, motherboard, psuWatts,
                caseType, coolingSystem, rgbLighting);
    }

    private void validateRequiredFields() {
        if (isBlank(cpu)) {
            throw new IllegalStateException("Cannot build a Computer without a CPU.");
        }
        if (isBlank(storage)) {
            throw new IllegalStateException("Cannot build a Computer without storage.");
        }
        if (isBlank(motherboard)) {
            throw new IllegalStateException("Cannot build a Computer without a motherboard.");
        }
        if (ramGb < MIN_RAM_GB) {
            throw new IllegalStateException(
                    "RAM must be at least " + MIN_RAM_GB + " GB, but was " + ramGb + " GB.");
        }
        if (psuWatts < MIN_PSU_WATTS) {
            throw new IllegalStateException(
                    "PSU must supply at least " + MIN_PSU_WATTS + "W, but was " + psuWatts + "W.");
        }
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
