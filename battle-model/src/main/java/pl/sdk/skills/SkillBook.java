package pl.sdk.skills;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SkillBook {
    private final List<AbstractSkill> skills;

    public SkillBook(List<AbstractSkill> aSkills){
        skills = aSkills;
    }

    public List<AbstractSkill> getSkills() {
        return skills;
    }

}
