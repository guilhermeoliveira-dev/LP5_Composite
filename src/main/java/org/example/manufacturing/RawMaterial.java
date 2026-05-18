package org.example.manufacturing;

public class RawMaterial implements ManufacturedPart{

    private final String name;
    private final double unitCost;
    private final double quantity;

    public RawMaterial(String name, double unitCost, double quantity) {
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    @Override
    public double getCost() {
        return unitCost * quantity;
    }

}
