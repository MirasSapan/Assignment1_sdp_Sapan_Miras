package com.pcbuilder;

public final class Computer {

    private final String cpu;
    private final String gpu;
    private final int ramGb;
    private final String storage;
    private final String motherboard;
    private final int psuWatts;
    private final String caseType;
    private final String coolingSystem;
    private final boolean rgbLighting;

    Computer(String cpu,
             String gpu,
             int ramGb,
             String storage,
             String motherboard,
             int psuWatts,
             String caseType,
             String coolingSystem,
             boolean rgbLighting) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ramGb = ramGb;
        this.storage = storage;
        this.motherboard = motherboard;
        this.psuWatts = psuWatts;
        this.caseType = caseType;
        this.coolingSystem = coolingSystem;
        this.rgbLighting = rgbLighting;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public int getRamGb() {
        return ramGb;
    }

    public String getStorage() {
        return storage;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public int getPsuWatts() {
        return psuWatts;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    public boolean hasRgbLighting() {
        return rgbLighting;
    }

    @Override
    public String toString() {
        return "Computer{"
                + "cpu='" + cpu + '\''
                + ", gpu='" + gpu + '\''
                + ", ramGb=" + ramGb
                + ", storage='" + storage + '\''
                + ", motherboard='" + motherboard + '\''
                + ", psuWatts=" + psuWatts
                + ", caseType='" + caseType + '\''
                + ", coolingSystem='" + coolingSystem + '\''
                + ", rgbLighting=" + rgbLighting
                + '}';
    }
}
