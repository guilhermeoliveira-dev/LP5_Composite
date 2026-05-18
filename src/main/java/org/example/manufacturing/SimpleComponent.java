package org.example.manufacturing;

public class SimpleComponent implements ManufacturedPart {

    private final String partNumber;
    private final double cost;

    public SimpleComponent(String partNumber, double cost) {
        this.partNumber = partNumber;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}