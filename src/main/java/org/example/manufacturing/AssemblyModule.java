package org.example.manufacturing;

import java.util.ArrayList;
import java.util.List;

public class AssemblyModule implements ManufacturedPart {

    private final String moduleCode;
    private final double assemblyLaborCost;
    private final List<ManufacturedPart> parts = new ArrayList<>();

    public AssemblyModule(String moduleCode, double assemblyLaborCost) {
        this.moduleCode = moduleCode;
        this.assemblyLaborCost = assemblyLaborCost;
    }

    public void addPart(ManufacturedPart part) {
        parts.add(part);
    }

    public void removePart(ManufacturedPart part) {
        parts.remove(part);
    }

    @Override
    public double getCost() {
        return assemblyLaborCost + parts.stream()
                .mapToDouble(ManufacturedPart::getCost)
                .sum();
    }
}