package pl.sdk.creatures;

import com.google.common.collect.Range;

enum CreatureStatistic implements CreatureStatisticIf{

    // TEST CREATURES
    TEST("name",2,1,10,1,Range.closed(2,2),0,"for unit testing",false, 1),
    TEST_TIER_1_NOT_UPGRADED("Skeleton",5,4,6,4,Range.closed(1,3),1,"Average lvl1 foot soldier, but always in huge numbers thanks to necromancy skill and skeleton transformer.",false, 12),
    TEST_TIER_2_NOT_UPGRADED("Walking Dead",5,5,15,3,Range.closed(2,3),2,"Basically its the same skeleton with more hit points. I prefer buying 2 skeletons instead.",false, 8 ),
    TEST_TIER_3_NOT_UPGRADED("Wight",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round",false, 7),
    TEST_TIER_4_NOT_UPGRADED("Vampire",10,9,30,6,Range.closed(5,8),4,"NOTHING compared to their upgraded brothers. Keep the population growing and recruit after the upgrade.\nSpecial: no enemy retaliation.",false, 4),
    TEST_TIER_5_NOT_UPGRADED("Lich",13,10,30,6,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",false, 3),
    TEST_TIER_6_NOT_UPGRADED("Black Knight",16,16,120,7,Range.closed(15,30),6,"Awesome ground unit. As any undead it cannot be blinded, so your enemies will have to look out.\nSpecial: 20% chance to curse enemy.\n", false, 2),
    TEST_TIER_7_NOT_UPGRADED("Bone Dragon",17,15,150,9,Range.closed(25,50),7,"They are truly fearsome for enemies with low morale. Simply keeping them on battlefield scares enemies.\nSpecial: -1 to enemy morale.\n",false, 1),
    TEST_TIER_1_UPGRADED("Skeleton Warrior",6,6,6,5,Range.closed(1,3),1,"Numerous skeletons become even better, but running back to town and upgrading is a problem... If there is no room in your army for ordinary skeletons, necromancy skill will resurrect skeleton warriors, but there will be less of them than normal skeletons, so it might be a good idea not to upgrade cursed temple at all.",true, 12),
    TEST_TIER_2_UPGRADED("Zombie",5,5,20,4,Range.closed(2,3),2,"Attack ratings are way too low... In my opinion, necropolis has the worst lvl2 creature.\nSpecial: 20% chance to disease enemies (-2Att -2Def for 3 rounds)\n",true, 8),
    TEST_TIER_3_UPGRADED("Wraith",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round\n",true, 7),
    TEST_TIER_4_UPGRADED("Vampire Lord",10,10,40,9,Range.closed(5,8),4,"My favorite necropolis unit. Use them as main striking unit and you might end up with no losses!\nSpecial: no enemy retaliation ; resurrects members of their own stack by restoring health equal to the amount of damage they do to living enemies.\n",true, 4),
    TEST_TIER_5_UPGRADED("Power Lich",13,10,40,7,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",true, 3),
    TEST_TIER_6_UPGRADED("Dread Knight",18,18,120,9,Range.closed(15,30),6,"I think it's the best lvl6 unit in the game! Double damage ability puts Dread Knights above Naga Queens.\nSpecial: 20% chance to curse enemy ; 20% chance to do double damage.\n",true, 2),
    TEST_TIER_7_UPGRADED("Ghost Dragon",19,17,200,14,Range.closed(25,50),7,"When situation seems hopeless, take a chance on the best enemy stack! If you'll get lucky, half their hit points will be gone instantly!! Ageing ability makes ghost dragons as dangerous as other lvl7 creatures.\nSpecial: -1 to enemy morale ; 20% chance to age enemy (halve hit points of all stack members).\n",true, 1),

    // NECROPILIS FRACTION
    SKELETON("Skeleton",5,4,6,4,Range.closed(1,3),1,"Average lvl1 foot soldier, but always in huge numbers thanks to necromancy skill and skeleton transformer.",false, 12),
    WALKING_DEAD("Walking Dead",5,5,15,3,Range.closed(2,3),2,"Basically its the same skeleton with more hit points. I prefer buying 2 skeletons instead.",false, 8 ),
    WIGHT("Wight",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round",false, 7),
    VAMPIRE("Vampire",10,9,30,6,Range.closed(5,8),4,"NOTHING compared to their upgraded brothers. Keep the population growing and recruit after the upgrade.\nSpecial: no enemy retaliation.",false, 4),
    LICH("Lich",13,10,30,6,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",false, 3),
    BLACK_KNIGHT("Black Knight",16,16,120,7,Range.closed(15,30),6,"Awesome ground unit. As any undead it cannot be blinded, so your enemies will have to look out.\nSpecial: 20% chance to curse enemy.\n", false, 2),
    BONE_DRAGON("Bone Dragon",17,15,150,9,Range.closed(25,50),7,"They are truly fearsome for enemies with low morale. Simply keeping them on battlefield scares enemies.\nSpecial: -1 to enemy morale.\n",false, 1),
    SKELETON_WARRIOR("Skeleton Warrior",6,6,6,5,Range.closed(1,3),1,"Numerous skeletons become even better, but running back to town and upgrading is a problem... If there is no room in your army for ordinary skeletons, necromancy skill will resurrect skeleton warriors, but there will be less of them than normal skeletons, so it might be a good idea not to upgrade cursed temple at all.",true, 12),
    ZOMBIE("Zombie",5,5,20,4,Range.closed(2,3),2,"Attack ratings are way too low... In my opinion, necropolis has the worst lvl2 creature.\nSpecial: 20% chance to disease enemies (-2Att -2Def for 3 rounds)\n",true, 8),
    WRAITH("Wraith",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round\n",true, 7),
    VAMPIRE_LORD("Vampire Lord",10,10,40,9,Range.closed(5,8),4,"My favorite necropolis unit. Use them as main striking unit and you might end up with no losses!\nSpecial: no enemy retaliation ; resurrects members of their own stack by restoring health equal to the amount of damage they do to living enemies.\n",true, 4),
    POWER_LICH("Power Lich",13,10,40,7,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",true, 3),
    DREAD_KNIGHT("Dread Knight",18,18,120,9,Range.closed(15,30),6,"I think it's the best lvl6 unit in the game! Double damage ability puts Dread Knights above Naga Queens.\nSpecial: 20% chance to curse enemy ; 20% chance to do double damage.\n",true, 2),
    GHOST_DRAGON("Ghost Dragon",19,17,200,14,Range.closed(25,50),7,"When situation seems hopeless, take a chance on the best enemy stack! If you'll get lucky, half their hit points will be gone instantly!! Ageing ability makes ghost dragons as dangerous as other lvl7 creatures.\nSpecial: -1 to enemy morale ; 20% chance to age enemy (halve hit points of all stack members).\n",true, 1),

    // INFERNO FRACTION
    IMP("Imp",2,3,4,5,Range.closed(1,2),1,"Weakest level 1 unit in Heroes 3 which is also quite expensive. Useless all around :)",false, 15),
    GOG("Gog",6,4,13,4,Range.closed(2,4),2,"Very good shooter, nice damage range and hit points are a meaningful number to them. Speed is too slow before upgraded though.",false, 8 ),
    HELL_HOUND("Hell hound",10,6,25,7,Range.closed(2,7),3,"Good offensive unit, low on defence. Strongly affected by bless and curse spells.",false, 5),
    DEMON("Demon",10,10,35,5,Range.closed(7,9),4,"Average unit for level 4, but the price is very reasonable.",false, 4),
    PIT_FIEND("Pit Fiend",13,13,45,6,Range.closed(13,17),5,"Not a very good level 5 creature, but costly. Demons and pit fiends kinda balance each outher out. Note how often number 13 is used :)",false, 3),
    EFREETI("Efreeti",16,12,90,9,Range.closed(16,24),6,"Reasonable creature, can be purchased early due to inferno's specific building plan. Good troop for armageddon spellcaster.", false, 2),
    DEVIL("Devil",19,21,160,11,Range.closed(30,40),7,"Makes a tough opponent because of speed and no enemy retaliation. Devil can beat an angel in one on one combat.",false, 1),
    FAMILIAR("Familiar",4,4,4,7,Range.closed(1,2),1,"Upgrade is well worth doing: attack and defence become closer to medium for level 1, good speed and the mana chanelling abbility which makes it somewhat worthy having familiars present at the long battles.",true, 15),
    MAGOG("Magog",7,4,13,6,Range.closed(2,4),2,"Magog cannot beat marksman's two shots, but if enemies are standing close together, the advantage can be even grater.\nNote that fireproof units do not suffer magog's adjacent damage.\n",true, 8),
    CERBERUS("Cerberus",10,8,25,8,Range.closed(2,7),3,"Great upgrade. This is the only case in the game where stats get downgraded, damage in this case because this damage can be done to 3 enemies at once.\nBetter defence and with no retaliation it's a good idea to charge and attack the crowd.\n",true, 5),
    HORNED_DEMON("Horned Demon",10,10,40,6,Range.closed(7,9),4,"One of the smallest upgrades in the game: 5 hit points and 1 speed for 20 gold... reasonable,\n but horned demons are now below-average among level 4 upgrades, but their price still remains low.\n",true, 4),
    PIT_LORD("Pit Lord",13,13,45,7,Range.closed(13,17),5,"1 speed and demon resurrection abbility for 200 gold! Sounds darn expensive.\nThink this way: if you have lost 90 imps on a battle, 10 pit lords can resurrect them into about 10 demons... or if you lost 14 hell hounds, 10 pit lords can also turn them into about 10 demons.\n",true, 3),
    EFREET_SULTAN("Efreet Sultan",16,14,90,13,Range.closed(16,24),6,"Excellent upgrade. Their speed is only matched by some level 7 upgrades and... dragon flies.\nEnemy will think well before attacking efreet sultans: portion of the damage returns back to the attacker plus the retaliation.\n",true, 2),
    ARCH_DEVIL("Arch Devil",26,28,200,17,Range.closed(30,40),7,"Arch devil is no match for an arch angel. Otherways, a really powerful creature for non-retaliated attacks with outwaiting the opponent.\n",true, 1),

    // FORTRESS FRACTION
    GNOLL("Gnoll",3,5,6,4,Range.closed(2,3),1,"Above-average level 1 creature with good defence ratings and damage.",false, 12),
    LIZARDMAN("Lizardman",5,6,14,4,Range.closed(2,3),2,"This table shows lizardman stats with the latest game patch applied.\nOriginally they've had 12 hit points, 1-3 damage and population of 8. A much-needed balancing for Fortress.",false, 9 ),
    SERPENT_FLY("Serpent Fly",7,9,20,9,Range.closed(2,5),3,"Costly and weakish. Also good to give to scouts for lots of movement.\nBefore the patch their attack and defence was lower by 1 point each.",false, 8),
    BASILISK("Basilisk",11,11,35,5,Range.closed(6,10),4,"Finally a better creature, normal for level 4. Useful for both offence and defence.\nStoning abbility can be especially nice to block the holes in your seige walls for a while with... stoned enemies!",false, 4),
    GORGON("Gorgon",10,14,70,5,Range.closed(12,16),5,"To compensate for the previous creatures, fortress rules in level 5.\nGorgons are very tough, but try to save them until the upgrade, that's where they become extremely valuable.\n",false, 3),
    WYVERN("Wyvern",14,14,70,7,Range.closed(14,18),6,"Below-average level 6 creature. Damage is ok, but wyverns die quickly because they are the only strong flies in fortress...\n", false, 2),
    HYDRA("Hydra",16,18,175,5,Range.closed(25,45),7,"Costs no special resources and the special abbility is one of the greatest: hydras attack all 8 hexes around them without fear of retaliation!\n",false, 1),
    GNOLL_MARADEUR("Gnoll Maradeur",4,6,6,5,Range.closed(2,3),1,"1 speed, 1 attack and 1 defence for 20 gold extra? Bad upgrade looking at the value, also costs 10 wood to upgrade the dwelling, so it's not worth doing unless you're really wealthy.",true, 12),
    LIZARD_WARRIOR("Lizard Warrior",6,8,15,5,Range.closed(2,5),2,"Bless/curse will make a lot of difference to lizard warriors.\n",true, 9),
    DRAGON_FLY("Dragon Fly",8,10,20,13,Range.closed(2,5),3,"Flies are very annoying to spellcasters.\nIf you have spare slots in your army, split the flies so that you can dispel and weaken more enemies.\n",true, 8),
    GREATER_BASILISK("Greater Basilisk",12,12,40,7,Range.closed(6,10),4,"Good upgrade, improves basilisks all-around.\n",true, 4),
    MIGHTY_GORGON("Mighty Gorgon",11,16,70,6,Range.closed(12,16),5,"One of the best upgrades in the game, we can forget the minor stats upgrades, the special abbility is awesome!\nYes, even if it's an archangel commanded by a hero with 30 defence, he can die instantly from mighty gorgon's gaze.\n",true, 3),
    WYVERN_MONARCH("Wyvern Monarch",14,14,70,11,Range.closed(18,22),6,"Costly upgrade raises the damage by 4 and adds a poison abbility which can be very useful to weaken a strong stack.\n",true, 2),
    CHAOS_HYDRA("Chaos Hydra",18,20,250,7,Range.closed(25,45),7,"Extra 75 hit points, 2 attack and defence, but most importantly extra speed.\nWell, speed still remains the slowest among level 7 upgrades, but the strategic use is at it's best.\n",true, 1);


    private final String name;
    private final int attack;
    private final int armor;
    private final int maxHp;
    private final int moveRange;
    private final Range<Integer> damage;
    private final int tier;
    private final String description;
    private final boolean isUpgraded;
    private final int growth;

    CreatureStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage, int aTier, String aDescription, boolean aIsUpgraded, int aGrowth) {
        name = aName;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
        tier = aTier;
        description = aDescription;
        isUpgraded = aIsUpgraded;
        growth = aGrowth;
    }

    public String getTranslatedName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public Range<Integer> getDamage(){
        return damage;
    }

    public int getTier() {
        return tier;
    }

    public String getDescription() {
        return description;
    }

    boolean isUpgraded() {
        return isUpgraded;
    }

    int getGrowth()
    {
        return growth;
    }
}
