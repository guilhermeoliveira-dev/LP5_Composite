package org.example.manufacturing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ManufacturedPartTest {

    @Test
    void givenRawMaterial_whenGetCost_thenReturnsCalculatedCost() {
        ManufacturedPart plastic = new RawMaterial("Polycarbonate", 0.05, 100);

        assertEquals(5.0, plastic.getCost(), 0.001);
    }

    @Test
    void givenSimpleComponent_whenGetCost_thenReturnsFixedCost() {
        ManufacturedPart screen = new SimpleComponent("OLED-6IN", 45.0);

        assertEquals(45.0, screen.getCost(), 0.001);
    }

    @Test
    void givenAssemblyModule_whenGetCost_thenReturnsSumOfPartsPlusAssemblyCost() {
        AssemblyModule motherboard = new AssemblyModule("MB-REV2", 15.0);
        motherboard.addPart(new SimpleComponent("CPU-ARM", 30.0));
        motherboard.addPart(new SimpleComponent("RAM-8GB", 20.0));
        motherboard.addPart(new RawMaterial("Solder", 0.10, 50));

        assertEquals(70.0, motherboard.getCost(), 0.001);
    }

    @Test
    void givenComplexProduct_whenGetCost_thenReturnsTotalHierarchicalCost() {
        AssemblyModule smartphone = new AssemblyModule("SP-FLAGSHIP", 25.0);

        AssemblyModule screenModule = new AssemblyModule("SCR-MOD", 5.0);
        screenModule.addPart(new SimpleComponent("OLED-6IN", 45.0));
        screenModule.addPart(new SimpleComponent("GORILLA-GLASS", 10.0));

        AssemblyModule motherboard = new AssemblyModule("MB-REV2", 15.0);
        motherboard.addPart(new SimpleComponent("CPU-ARM", 30.0));
        motherboard.addPart(new SimpleComponent("RAM-8GB", 20.0));

        smartphone.addPart(screenModule);
        smartphone.addPart(motherboard);
        smartphone.addPart(new SimpleComponent("BATT-4000", 12.0));

        assertEquals(162.0, smartphone.getCost(), 0.001);
    }
}