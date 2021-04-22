package pl.sdk.converter;

import pl.sdk.skills.EconomySkill;
import pl.sdk.skills.SkillStatistic;

import java.util.HashMap;

public class SkillMasteries {
    private HashMap<EconomySkill, SkillStatistic.SkillLevel> skillMap;

    public SkillMasteries(HashMap<EconomySkill, SkillStatistic.SkillLevel> aSkillMap) {
        aSkillMap.forEach((key,val) ->{ skillMap.put(key, val); });
    }

    public SkillMasteries(EconomySkill aKey,SkillStatistic.SkillLevel aVal) {
        skillMap.put(aKey, aVal);
    }
    public SkillStatistic.SkillLevel get(SkillStatistic akey){
        return skillMap.get(akey);
    }

    public void put(EconomySkill aKey, SkillStatistic.SkillLevel aVal){
        skillMap.put(aKey,aVal);
    }
}
