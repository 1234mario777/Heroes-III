package pl.sdk.converter;

public class SpellMasteries {

    enum SpellMasterLevel{
        BASIC, ADVANCED, MASTER
    }

    private final SpellMasterLevel air;
    private final SpellMasterLevel fire;
    private final SpellMasterLevel earth;
    private final SpellMasterLevel water;

    SpellMasteries(SpellMasterLevel aAir, SpellMasterLevel aFire, SpellMasterLevel aEarth, SpellMasterLevel aWater) {
        air = aAir;
        fire = aFire;
        earth = aEarth;
        water = aWater;
    }

    SpellMasterLevel getAir() {
        return air;
    }

    SpellMasterLevel getFire() {
        return fire;
    }

    SpellMasterLevel getEarth() {
        return earth;
    }

    SpellMasterLevel getWater() {
        return water;
    }
}
