package pl.sdk.creatures;

import com.google.common.collect.Range;

public enum CreatureStatistic implements CreatureStatisticIf{

    // TEST CREATURES
    TEST("name",2,1,10,1,Range.closed(2,2),0,"for unit testing",false, 1, MovementType.GROUND),
    TEST_TIER_1_NOT_UPGRADED("Skeleton",5,4,6,4,Range.closed(1,3),1,"Average lvl1 foot soldier, but always in huge numbers thanks to necromancy skill and skeleton transformer.",false, 12, MovementType.GROUND),
    TEST_TIER_2_NOT_UPGRADED("Walking Dead",5,5,15,3,Range.closed(2,3),2,"Basically its the same skeleton with more hit points. I prefer buying 2 skeletons instead.",false, 8, MovementType.GROUND ),
    TEST_TIER_3_NOT_UPGRADED("Wight",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round",false, 7, MovementType.GROUND),
    TEST_TIER_4_NOT_UPGRADED("Vampire",10,9,30,6,Range.closed(5,8),4,"NOTHING compared to their upgraded brothers. Keep the population growing and recruit after the upgrade.\nSpecial: no enemy retaliation.",false, 4, MovementType.GROUND),
    TEST_TIER_5_NOT_UPGRADED("Lich",13,10,30,6,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",false, 3, MovementType.GROUND),
    TEST_TIER_6_NOT_UPGRADED("Black Knight",16,16,120,7,Range.closed(15,30),6,"Awesome ground unit. As any undead it cannot be blinded, so your enemies will have to look out.\nSpecial: 20% chance to curse enemy.\n", false, 2, MovementType.GROUND),
    TEST_TIER_7_NOT_UPGRADED("Bone Dragon",17,15,150,9,Range.closed(25,50),7,"They are truly fearsome for enemies with low morale. Simply keeping them on battlefield scares enemies.\nSpecial: -1 to enemy morale.\n",false, 1, MovementType.FLYING),
    TEST_TIER_1_UPGRADED("Skeleton Warrior",6,6,6,5,Range.closed(1,3),1,"Numerous skeletons become even better, but running back to town and upgrading is a problem... If there is no room in your army for ordinary skeletons, necromancy skill will resurrect skeleton warriors, but there will be less of them than normal skeletons, so it might be a good idea not to upgrade cursed temple at all.",true, 12, MovementType.GROUND),
    TEST_TIER_2_UPGRADED("Zombie",5,5,20,4,Range.closed(2,3),2,"Attack ratings are way too low... In my opinion, necropolis has the worst lvl2 creature.\nSpecial: 20% chance to disease enemies (-2Att -2Def for 3 rounds)\n",true, 8, MovementType.GROUND),
    TEST_TIER_3_UPGRADED("Wraith",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round\n",true, 7, MovementType.GROUND),
    TEST_TIER_4_UPGRADED("Vampire Lord",10,10,40,9,Range.closed(5,8),4,"My favorite necropolis unit. Use them as main striking unit and you might end up with no losses!\nSpecial: no enemy retaliation ; resurrects members of their own stack by restoring health equal to the amount of damage they do to living enemies.\n",true, 4, MovementType.GROUND),
    TEST_TIER_5_UPGRADED("Power Lich",13,10,40,7,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",true, 3, MovementType.GROUND),
    TEST_TIER_6_UPGRADED("Dread Knight",18,18,120,9,Range.closed(15,30),6,"I think it's the best lvl6 unit in the game! Double damage ability puts Dread Knights above Naga Queens.\nSpecial: 20% chance to curse enemy ; 20% chance to do double damage.\n",true, 2, MovementType.GROUND),
    TEST_TIER_7_UPGRADED("Ghost Dragon",19,17,200,14,Range.closed(25,50),7,"When situation seems hopeless, take a chance on the best enemy stack! If you'll get lucky, half their hit points will be gone instantly!! Ageing ability makes ghost dragons as dangerous as other lvl7 creatures.\nSpecial: -1 to enemy morale ; 20% chance to age enemy (halve hit points of all stack members).\n",true, 1, MovementType.FLYING),

    // NECROPILIS FRACTION
    SKELETON("Skeleton",5,4,6,4,Range.closed(1,3),1,"Average lvl1 foot soldier, but always in huge numbers thanks to necromancy skill and skeleton transformer.",false, 12, MovementType.GROUND),
    WALKING_DEAD("Walking Dead",5,5,15,3,Range.closed(2,3),2,"Basically its the same skeleton with more hit points. I prefer buying 2 skeletons instead.",false, 8, MovementType.GROUND),
    WIGHT("Wight",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round",false, 7, MovementType.GROUND),
    VAMPIRE("Vampire",10,9,30,6,Range.closed(5,8),4,"NOTHING compared to their upgraded brothers. Keep the population growing and recruit after the upgrade.\nSpecial: no enemy retaliation.",false, 4, MovementType.GROUND),
    LICH("Lich",13,10,30,6,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",false, 3, MovementType.GROUND),
    BLACK_KNIGHT("Black Knight",16,16,120,7,Range.closed(15,30),6,"Awesome ground unit. As any undead it cannot be blinded, so your enemies will have to look out.\nSpecial: 20% chance to curse enemy.\n", false, 2, MovementType.GROUND),
    BONE_DRAGON("Bone Dragon",17,15,150,9,Range.closed(25,50),7,"They are truly fearsome for enemies with low morale. Simply keeping them on battlefield scares enemies.\nSpecial: -1 to enemy morale.\n",false, 1, MovementType.FLYING),
    SKELETON_WARRIOR("Skeleton Warrior",6,6,6,5,Range.closed(1,3),1,"Numerous skeletons become even better, but running back to town and upgrading is a problem... If there is no room in your army for ordinary skeletons, necromancy skill will resurrect skeleton warriors, but there will be less of them than normal skeletons, so it might be a good idea not to upgrade cursed temple at all.",true, 12, MovementType.GROUND),
    ZOMBIE("Zombie",5,5,20,4,Range.closed(2,3),2,"Attack ratings are way too low... In my opinion, necropolis has the worst lvl2 creature.\nSpecial: 20% chance to disease enemies (-2Att -2Def for 3 rounds)\n",true, 8, MovementType.GROUND),
    WRAITH("Wraith",7,7,18,5,Range.closed(3,5),3,"Regenerating ability is really good when fighting weak enemies, especially shooters.\nSpecial: top wight of the stack regenerates all lost damage in the beginning of each round\n",true, 7, MovementType.GROUND),
    VAMPIRE_LORD("Vampire Lord",10,10,40,9,Range.closed(5,8),4,"My favorite necropolis unit. Use them as main striking unit and you might end up with no losses!\nSpecial: no enemy retaliation ; resurrects members of their own stack by restoring health equal to the amount of damage they do to living enemies.\n",true, 4, MovementType.GROUND),
    POWER_LICH("Power Lich",13,10,40,7,Range.closed(11,15),5,"Now they last longer and are able to do more damage! A must for good necropolis army.\nSpecial: death cloud range attack - damages living creatures on adjacent hexes to target.\n",true, 3, MovementType.GROUND),
    DREAD_KNIGHT("Dread Knight",18,18,120,9,Range.closed(15,30),6,"I think it's the best lvl6 unit in the game! Double damage ability puts Dread Knights above Naga Queens.\nSpecial: 20% chance to curse enemy ; 20% chance to do double damage.\n",true, 2, MovementType.GROUND),
    GHOST_DRAGON("Ghost Dragon",19,17,200,14,Range.closed(25,50),7,"When situation seems hopeless, take a chance on the best enemy stack! If you'll get lucky, half their hit points will be gone instantly!! Ageing ability makes ghost dragons as dangerous as other lvl7 creatures.\nSpecial: -1 to enemy morale ; 20% chance to age enemy (halve hit points of all stack members).\n",true, 1, MovementType.FLYING),

    // INFERNO FRACTION
    IMP("Imp",2,3,4,5,Range.closed(1,2),1,"Weakest level 1 unit in Heroes 3 which is also quite expensive. Useless all around :)",false, 15, MovementType.GROUND),
    GOG("Gog",6,4,13,4,Range.closed(2,4),2,"Very good shooter, nice damage range and hit points are a meaningful number to them. Speed is too slow before upgraded though.",false, 8, MovementType.GROUND ),
    HELL_HOUND("Hell hound",10,6,25,7,Range.closed(2,7),3,"Good offensive unit, low on defence. Strongly affected by bless and curse spells.",false, 5, MovementType.GROUND),
    DEMON("Demon",10,10,35,5,Range.closed(7,9),4,"Average unit for level 4, but the price is very reasonable.",false, 4, MovementType.GROUND),
    PIT_FIEND("Pit Fiend",13,13,45,6,Range.closed(13,17),5,"Not a very good level 5 creature, but costly. Demons and pit fiends kinda balance each outher out. Note how often number 13 is used :)",false, 3, MovementType.GROUND),
    EFREETI("Efreeti",16,12,90,9,Range.closed(16,24),6,"Reasonable creature, can be purchased early due to inferno's specific building plan. Good troop for armageddon spellcaster.", false, 2, MovementType.FLYING),
    DEVIL("Devil",19,21,160,11,Range.closed(30,40),7,"Makes a tough opponent because of speed and no enemy retaliation. Devil can beat an angel in one on one combat.",false, 1, MovementType.TELEPORT),
    FAMILIAR("Familiar",4,4,4,7,Range.closed(1,2),1,"Upgrade is well worth doing: attack and defence become closer to medium for level 1, good speed and the mana chanelling abbility which makes it somewhat worthy having familiars present at the long battles.",true, 15, MovementType.GROUND),
    MAGOG("Magog",7,4,13,6,Range.closed(2,4),2,"Magog cannot beat marksman's two shots, but if enemies are standing close together, the advantage can be even grater.\nNote that fireproof units do not suffer magog's adjacent damage.\n",true, 8, MovementType.GROUND),
    CERBERUS("Cerberus",10,8,25,8,Range.closed(2,7),3,"Great upgrade. This is the only case in the game where stats get downgraded, damage in this case because this damage can be done to 3 enemies at once.\nBetter defence and with no retaliation it's a good idea to charge and attack the crowd.\n",true, 5, MovementType.GROUND),
    HORNED_DEMON("Horned Demon",10,10,40,6,Range.closed(7,9),4,"One of the smallest upgrades in the game: 5 hit points and 1 speed for 20 gold... reasonable,\n but horned demons are now below-average among level 4 upgrades, but their price still remains low.\n",true, 4, MovementType.GROUND),
    PIT_LORD("Pit Lord",13,13,45,7,Range.closed(13,17),5,"1 speed and demon resurrection abbility for 200 gold! Sounds darn expensive.\nThink this way: if you have lost 90 imps on a battle, 10 pit lords can resurrect them into about 10 demons... or if you lost 14 hell hounds, 10 pit lords can also turn them into about 10 demons.\n",true, 3, MovementType.GROUND),
    EFREET_SULTAN("Efreet Sultan",16,14,90,13,Range.closed(16,24),6,"Excellent upgrade. Their speed is only matched by some level 7 upgrades and... dragon flies.\nEnemy will think well before attacking efreet sultans: portion of the damage returns back to the attacker plus the retaliation.\n",true, 2, MovementType.FLYING),
    ARCH_DEVIL("Arch Devil",26,28,200,17,Range.closed(30,40),7,"Arch devil is no match for an arch angel. Otherways, a really powerful creature for non-retaliated attacks with outwaiting the opponent.\n",true, 1, MovementType.TELEPORT),

    // TOWER FRACTION
    GREMLIN("Gremlin",3,3,4,4,Range.closed(1,2),1,"Gremlins are only better than imps... cheap and plentiful too, but slow and weak in all aspects.",false,16, MovementType.GROUND),
    STONE_GARGOYLE("Stone Gargoyle",6,6,16,6,Range.closed(2,3),2,"Not a very good fighter, but quite useful for preventing enemy shooters from using their range attacks.",false,9, MovementType.FLYING),
    STONE_GOLEM("Stone Golem",7,10,30,3,Range.closed(4,5),3,"Great town defenders because spells just don't take them that easy! Too slow for heroes though, that's what upgrade is for.",false,6, MovementType.GROUND),
    MAGE("Mage",11,8,25,5,Range.closed(7,9),4,"Good offensive shooters, but even though they suffer no hand-to-hand penalty, keep them defended because their hit points and defence are low.\nSpell bonus is great! Magic arrows cost 2 mana! Note that when all magi on the battlefield are dead, spell bonus disappears.",false,4, MovementType.GROUND),
    GENIE("Genie",12,12,40,7,Range.closed(13,16),5,"Offensive unit with big lack of hit points, do not attack unless it will destroy the target.\n I would prefer 1 naga instead of 2 genies.",false,3, MovementType.FLYING),
    NAGA("Naga",16,13,110,5,Range.closed(20,20),6,"Nagas and naga queens are necromancer's black and dread knights' toughest competitors for the first place amongst the level 6 units.\nNothing to comment really, this unit is great all around, just don't bother blessing or cursing that great constant damage.",false,2, MovementType.GROUND),
    GIANT("Giant",19,16,150,7,Range.closed(40,60),7,"Their damage is great, especially if blessed. Their dwelling is really cheap compared to other level 7 dwellings. The only drawback is the gem cost.\nAnyway, a good unit to recruit and upgrade later in the game. Nagas and giants make a hardly beatable ground attack force.",false,1, MovementType.GROUND),
    MASTER_GREMLIN("Master Gremlin",4,4,4,5,Range.closed(1,2),1,"Master gremlins are the only level one shooters (except for halflings in AB) and provide a great advantage in early stages of the game, thank god the gremlin rush desn't work anymore, it was unstoppable.\n Otherways, awesome upgrade, but keep the ammo cart handy, these guys have only 8 shots. They do have a hand-to-hand penalty, so try to block them.",true,16, MovementType.GROUND),
    OBSIDIAN_GARGOYLE("Obsidian Gargoyle",7,7,16,9,Range.closed(2,3),2,"30 Gold for 3 extra speed and 1 attack and defence... not a good upgrade, but makes them better shooter-blockers. I would prefer to save money for golems who will last a whole lot longer.\n Recruit gargoyles only when you are quite desperate for army.",true,9, MovementType.FLYING),
    IRON_GOLEM("Iron Golem",9,10,35,5,Range.closed(4,5),3,"Great upgrade! Speed is usable for hero armies while extra hit points and magic resistance make them even tougher. Only a foolish player will cast offensive spells on iron golems, only a quarter damage will get through.\n Iron golems are great to defend shooters.",true,6, MovementType.GROUND),
    ARCH_MAGE("Arch Mage",12,9,30,7,Range.closed(7,9),4,"Reasonable upgrade adds speed, improves defensive ratings and wall penetration will decrease the range penalty in seige attacks.",true,4, MovementType.GROUND),
    MASTER_GENIE("Master Genie",12,12,40,11,Range.closed(13,16),5,"Master genies are a totally different story with their spellcasting abbilities. If you have room in your army, split master genies in many stacks to be able to cast more beneficial spells on your units per turn.\n Remember that most of their spells last for 6 turns and that a single unit stack can have a maximum of 3 spells affecting it. Great upgrade for 50 extra gold.",true,3, MovementType.FLYING),
    NAGA_QUEEN("Naga Queen",16,13,110,7,Range.closed(30,30),6,"Extra speed and extra 50% of that constant damage are worth the extra 500 gold that make naga queen the most expensive in level 6.",true,2, MovementType.GROUND),
    TITAN("Titan",24,24,300,11,Range.closed(40,60),7,"The best shooter in the game and the most expensive level 7 unit. Shooting abbility is great, as well as twice the hit points and major increases in speed/attack/defence, but the price is more than doubled...\nThis is really an endgame creature because the dwelling costs 25000 gold and 30 gems to upgrade and the titans are so expensive too.",true,1, MovementType.GROUND),

    // FORTRESS FRACTION
    GNOLL("Gnoll",3,5,6,4,Range.closed(2,3),1,"Above-average level 1 creature with good defence ratings and damage.",false, 12, MovementType.GROUND),
    LIZARDMAN("Lizardman",5,6,14,4,Range.closed(2,3),2,"This table shows lizardman stats with the latest game patch applied.\nOriginally they've had 12 hit points, 1-3 damage and population of 8. A much-needed balancing for Fortress.",false, 9, MovementType.GROUND ),
    SERPENT_FLY("Serpent Fly",7,9,20,9,Range.closed(2,5),3,"Costly and weakish. Also good to give to scouts for lots of movement.\nBefore the patch their attack and defence was lower by 1 point each.",false, 8, MovementType.FLYING),
    BASILISK("Basilisk",11,11,35,5,Range.closed(6,10),4,"Finally a better creature, normal for level 4. Useful for both offence and defence.\nStoning abbility can be especially nice to block the holes in your seige walls for a while with... stoned enemies!",false, 4, MovementType.GROUND),
    GORGON("Gorgon",10,14,70,5,Range.closed(12,16),5,"To compensate for the previous creatures, fortress rules in level 5.\nGorgons are very tough, but try to save them until the upgrade, that's where they become extremely valuable.\n",false, 3, MovementType.GROUND),
    WYVERN("Wyvern",14,14,70,7,Range.closed(14,18),6,"Below-average level 6 creature. Damage is ok, but wyverns die quickly because they are the only strong flies in fortress...\n", false, 2, MovementType.GROUND),
    HYDRA("Hydra",16,18,175,5,Range.closed(25,45),7,"Costs no special resources and the special abbility is one of the greatest: hydras attack all 8 hexes around them without fear of retaliation!\n",false, 1, MovementType.FLYING),
    GNOLL_MARADEUR("Gnoll Maradeur",4,6,6,5,Range.closed(2,3),1,"1 speed, 1 attack and 1 defence for 20 gold extra? Bad upgrade looking at the value, also costs 10 wood to upgrade the dwelling, so it's not worth doing unless you're really wealthy.",true, 12, MovementType.GROUND),
    LIZARD_WARRIOR("Lizard Warrior",6,8,15,5,Range.closed(2,5),2,"Bless/curse will make a lot of difference to lizard warriors.\n",true, 9, MovementType.GROUND),
    DRAGON_FLY("Dragon Fly",8,10,20,13,Range.closed(2,5),3,"Flies are very annoying to spellcasters.\nIf you have spare slots in your army, split the flies so that you can dispel and weaken more enemies.\n",true, 8, MovementType.FLYING),
    GREATER_BASILISK("Greater Basilisk",12,12,40,7,Range.closed(6,10),4,"Good upgrade, improves basilisks all-around.\n",true, 4, MovementType.GROUND),
    MIGHTY_GORGON("Mighty Gorgon",11,16,70,6,Range.closed(12,16),5,"One of the best upgrades in the game, we can forget the minor stats upgrades, the special abbility is awesome!\nYes, even if it's an archangel commanded by a hero with 30 defence, he can die instantly from mighty gorgon's gaze.\n",true, 3, MovementType.GROUND),
    WYVERN_MONARCH("Wyvern Monarch",14,14,70,11,Range.closed(18,22),6,"Costly upgrade raises the damage by 4 and adds a poison abbility which can be very useful to weaken a strong stack.\n",true, 2, MovementType.GROUND),
    CHAOS_HYDRA("Chaos Hydra",18,20,250,7,Range.closed(25,45),7,"Extra 75 hit points, 2 attack and defence, but most importantly extra speed.\nWell, speed still remains the slowest among level 7 upgrades, but the strategic use is at it's best.\n",true, 1, MovementType.FLYING),

    //CASTLE FRACTION
    PIKEMAN("Pikeman",4,5,10,4,Range.closed(1,3),1,"Toughest lvl1 unit, but a bit slow.",false,14, MovementType.GROUND),
    ARCHER("Archer",6,3,10,4,Range.closed(2,3),2,"Archer's upgrade is literally 2 times better. Upgrade them quickly.",false,9, MovementType.GROUND),
    GRIFFIN("Griffin",8,8,25,6,Range.closed(3,6),3,"High in population, griffins become castle's main unit for the midgame.",false,7, MovementType.FLYING),
    SWORDSMAN("Swordsman",10,12,35,5,Range.closed(6,9),4,"Not too good unit the upgrade and also too slow.",false, 4, MovementType.GROUND),
    MONK("Monk",12,7,30,5,Range.closed(10,12),5,"Good shooter, nice damage.",false,3, MovementType.GROUND),
    CAVALIER("Cavalier",15,15,100,7,Range.closed(15,25),6,"Make sure that the path is as long as possible - they need some speed!",false,2, MovementType.GROUND),
    ANGEL("Angel",20,20,100,7,Range.closed(50,50),7,"Nice combat ratings and great constant damage - no need to bless them.\nNote that before the update patches Angels and Archangels didn't cost any gems, just gold.",false,1, MovementType.FLYING),
    HALBERDIER("Halberdier",6,5,10,5,Range.closed(2,3),1,"Now they are faster and do more damage. Will make a good defence for shooters.",true,14, MovementType.GROUND),
    MARKSMAN("Marksman",6,3,10,6,Range.closed(2,3),2,"Awesome upgrade, but they still lack defence...",true,9, MovementType.GROUND),
    ROYAL_GRIFFIN("Royal Griffin",9,9,25,9,Range.closed(3,6),3,"Send them right in the middle of the battlefield. Everyone who comes will get some ;)",true,7, MovementType.FLYING),
    CRUSADER("Crusader",7,10,35,6,Range.closed(7,10),4,"Good upgrade, but still lacks speed. Seem undefeatable in large numbers.",true,4, MovementType.GROUND),
    ZEALOT("Zealot",12,10,30,7,Range.closed(10,12),5,"Zealots are skilled enough to use the same magic powers at very close range. Better defence too.",true,3, MovementType.GROUND),
    CHAMPION("Champion",16,16,100,9,Range.closed(20,25),6,"That's up to 45% extra damage possible! Champions also have better aiming skills.",true,2, MovementType.GROUND),
    ARCHANGEL("Archangel",30,30,250,18,Range.closed(50,50),7,"Best attack, defence and speed in a whole game! Resurrection is a very convenient abbility.\nThose fast wings take up a whole extra hex! :]",true,1, MovementType.FLYING),

    //    STRONGHOLD FRACTION
    GOBLIN("Goblin",4,2,5,5, Range.closed(1,2),1,"Slightly weaker than average for level 1, but better than imp for a smaller price. Highly populated, goblin is a good offensive unit to start with. Nice speed for level 1, especially after the upgrade. Defence is lower than attack, so be sure to attack before attacked.",false,12, MovementType.GROUND),
    WOLF_RIDER("Wolf Rider",7,5,10,6, Range.closed(2,4),2,"Basically you're getting the same goblin, slightly better stats and larger size. Weak for level 2, wolf rider is only slightly better than level 1 centaur captain. Wolves should attack before attacked, applies to wolf raiders especially.",false,8, MovementType.GROUND),
    ORC("Orc",8,4,15,4, Range.closed(2,5),3,"Weaker than beholders and elves, orcs are the weakest level 3 shooters, but that is also reflected in their low price. Reasonable stats, wide damage easily affected by bless and curse, slow speed which will be reflected on your hero movement, but if you plan using ogres in your army, they are just as slow, so feel free to take some orcs. Cyclops will replace orcs later on.",false,7, MovementType.GROUND),
    OGRE("Ogre",13,7,40,4, Range.closed(6,12),4,"A great level 4 unit if it wasn't for the superlow speed. Nice damage, great attack, low price, while the low defence is backed up by plenty hit points. Orcs and ogres are a speed pair, so either have both or none for your main hero. Ogres make great defenders, bashing the enemy from close range as they approach your juicy shooters. For all ogres - watch out for curse and apply bless as required.",false,4, MovementType.GROUND),
    ROC("Roc",13,11,60,7, Range.closed(11,15),5,"Let's roc! A nice level 5 unit with higher hit points than most. Roc is also very balanced, having no weak sides such as damage range or low defence. Use them for whatever purpose, but being the only stronghold flyers they often die alone in the enemy crowd.",false,3, MovementType.FLYING),
    CYCLOPS("Cyclops",15,12,70,6, Range.closed(16,20),6,"Now we're shooting! Only titan's lightning can hit stronger than cyclops' rocks, and that abbility to attack seige walls is completely exlusive to cyclops. Want 3 extra catapults? Split cyclops into multiple stacks, seige walls take same damage from 1 cyclops as from 100. Cyclops is also a well-balanced unit with no weakneses except for the hand-to-hand penalty. Keep that ammo cart handy for long ones.",false,2, MovementType.GROUND),
    BEHEMOTH("Behemoth",17,17,160,6, Range.closed(30,50),7,"That smile scares the hell out of whoever behemoth is attacking, reducing their abbility to defend themselves. Slow and quite vunerable, behemoth is also a cheap level 7 unit, definitely attack-oriented and able to deal huge damage by reducing enemy defence during the attack. Try to use charge tactics whenever possible, do not leave behemoth exposed to enemy attacks, too easy to lose them.",false,1, MovementType.GROUND),
    HOBGOBLIN("Hobgoblin",5,3,5,7, Range.closed(1,2),1,"The speed is worth 10 gold, combined attack and defence increase. Hobgoblins are more able to attack before failing to defend themselves. However, the damage is lacking: 1-2 is lower than 1-3 or 2-3 that many other units of this level have. Since this upgrade is required for wolf raiders, you will probably end up doing it, but 5 wood and 5 ore are better saved for a castle.",true,12, MovementType.GROUND),
    WOLF_RAIDER("Wolf Raider",8,5,10,8, Range.closed(3,4),2,"Awesome upgrade that makes wolves do about 2.5 times more damage. Defence and hit points remain the same, so use the sudden charge tactics. Try to get your target to waste their retaliation before raiders make their double move. Ahhh, HOMM1 memories... same two attacks, but those wolves were white and self-sufficient :) As for getting the upgrade - it is very expensive in terms of wood and ore because you are required to upgrade goblins first. If you're poor, you might even forget about using goblins and wolves in your main army, just let them stock up for a bad day",true,8, MovementType.GROUND),
    ORC_CHIEFTAIN("Orc Chieftain",8,4,20,5, Range.closed(2,5),3,"A small and cheap upgrade that makes orcs slightly faster (same as ogre magi) and tougher. Do it if you want orcs to last longer or if all your ogres are upgraded already, so that the lowest army speed will be 5 instead of 4. Comparing the pictures, orc chieftain has one extra axe - this is to be interpreted as double amount of shots :)",true,7, MovementType.GROUND),
    OGRE_MAGI("Ogre Magi",13,7,60,5, Range.closed(6,12),4,"Great upgrade, 50% tougher for 33% extra price plus the spell bonus. Ogre magi are the toughest among their level, their supperiority undermined perhaps only by vampires' life drain. Stock up on these guys because they can dellay your enemy's victory by few thousand hit points. Ogre magi are still slow, but they don't just stand there anymore - bloodlust spell will assist the advancing armies while magi defend the shooters. Bloodlust increases attack skill for the time of 6 round",true,4, MovementType.GROUND),
    THUNDERBIRD("Thunderbird",13,11,60,11, Range.closed(11,15),5,"Thunderbolt strike is a useful damage since it is not affected by defence. The only flying unit for stronghold, they are still not good enough to fly over the castle walls alone. This upgrade is good to get the earlier spellcasting turn: speed 11 is the highest in stronghold, followed by 9 of ancient behemoth. And hey, the looks are good, they actually look more powerful to your human opponent.",true,3, MovementType.FLYING),
    CYCLOPS_KING("Cyclops King",17,13,70,8, Range.closed(16,20),6,"They aren't kings for nothing, packing two seige shots in one turn and leveling walls to the ground in no time. You'll notice that the lack of flyers is compensated by the cyclops' special abbilities. Kings however are quite pricey - look at that golden skirt armor that you are buying them for 350 gold! Attack, defence and speed improvements are too small to be worth 350 gold, so upgrade only if you are filthy rich and are heading for a long seige. Think about it, 2 kings cost almost as much as 3 normal cyclops!",true,2, MovementType.GROUND),
    ANCIENT_BEHEMOTH("Ancient Behemoth",19,19,300,9, Range.closed(30,50),7,"Quite low on attack, defence and speed for the best creature, but hit points are at the top and the special abbility is amazing: the target is virtually defenceless however high it's skill is, even if it is commanded by a good hero, nothing helps, only 1/5th of defence will be useful to the scared enemy. Ancient behemoth is able to deal the highest damage amongst all level 7 units, but it's use is more strategic than that: always attack the unit with the highest defence skill since only behemoths can bypass it. If you are ever to face the ancient behemoth, command all your units to attack at once - its attack is great, but its defence is nothing special, making it a strategic target.",true,1, MovementType.GROUND),

    // DUNGEON FRACTION
    TROGLODYTE("Troglodyte",4,3,5,4,Range.closed(1,3),1,"Average level 1 creature. Strongly affected by bless and curse.\nSpecial: immune to blind spell.\n",false, 14, MovementType.GROUND),
    INFERNAL_TROGLODYTE("Infernal Troglodyte",5,4,6,5,Range.closed(1,3),1,"Upgrade is expensive but quite reasonable. Damage range is still huge.\nSpecial: immune to blind spell.\n",true, 14, MovementType.GROUND ),
    HARPY("Harpy",6,5,14,6,Range.closed(1,4),2,"Quite a weak creature with huge damage range (bless and curse do well), but the abbility is very unique, not very useful before the upgrade though. Once enemy stack has used up their retaliation, it's harpy time!\nSpecial: return to the hex they started from after an attack.\n",false, 8, MovementType.FLYING),
    HARPY_HAG("Harpy Hag",6,6,14,9,Range.closed(1,4),2,"Great upgrade. Now you can annoy your enemies from 9 hexes away, like from the other side of castle walls without loosing any harpy hags. Take note that both harpies and harpy hags retreat back when attacking shooters, so sometimes it's better to move close without attacking to prevent the more powerful range attacks.\nSpecial: return to the hex they started from after an attack, no enemy retaliation.\n",true, 8,MovementType.FLYING),
    BEHOLDER("Beholder",9,7,22,5,Range.closed(3,5),3,"Good shooter, plenty of hit points and no fear of close combat.\nSpecial: no hand-to-hand penalty.\n",false, 7, MovementType.GROUND),
    EVIL_EYE("Evil Eye",10,8,22,7,Range.closed(3,5),3,"Little all-around upgrade. Evil eyes make a good shooter unit and they don't die as quick as most low level shooters.\nSpecial: no hand-to-hand penalty.\n", true, 7, MovementType.GROUND),
    MEDUSA("Medusa",9,9,25,5,Range.closed(6,8),4,"Very good creature, would be a better deal than beholder if had more than 4 shots... Keep an ammo cart handy and if your enemy has medusas, make sure it's the first machine you destroy. But when their shots run out, they still make great fighters with the stoning abbility, no match for basilisks though.\nSpecial: no hand-to-hand penalty, hand-to-hand attacks have 20% chance to turn enemies to stone: 3 rounds, take 50% damage, unstoned when attacked.\n",false, 5, MovementType.GROUND),
    MEDUSA_QUEEN("Medusa Queen",10,10,30,6,Range.closed(6,8),4,"Definitely worth upgrading: double shots, extra health and other minor upgrades for only 30 gold. Medusa queens and evil eyes make a good shooting combo together, especially at such early levels.\nSpecial: no hand-to-hand penalty, hand-to-hand attacks have 20% chance to turn enemies to stone: 3 rounds, take 50% damage, unstoned when attacked.\n",true, 5, MovementType.GROUND),
    MINOTAUR("Minotaur",14,12,50,6,Range.closed(12,20),5,"Good level 5 fighter with a reasonable price. Minotaur's strategy is pretty simple: just go and smash, although a little blessing would be very useful. With the moral bonus, there's always a hope for a second turn.\nSpecial: minotaur's morale is never below 1.\n",false, 3, MovementType.GROUND),
    MINOTAUR_KING("Minotaur King",15,15,50,8,Range.closed(12,20),5,"Good upgrade: 2 extra speed and much better defence rating. Smash strategy remains.\nSpecial: minotaur's morale is never below 1.\n",true, 3, MovementType.GROUND),
    MANTICORE("Manticore",15,13,80,7,Range.closed(14,20),6,"The only dungeon creature without a special abbility, manticores are below-average for level 6 and lack hit points.\n",false, 2, MovementType.GROUND),
    SCORPICORE("Scorpicore",16,14,80,11,Range.closed(14,20),6,"Is there any actual difference between stoning and paralyzing? Hmmm... 200 gold for paralyzing, speed and 2 combat points... Scorpicores are a bit too expensive and 80 hit points is not enough - that's what happens when you breed a lion-bat-scorpion.\nSpecial: 20% chance to paralyze: take 50% damage, unparalyzed after 3 rounds or when attacked.\n",true, 2, MovementType.GROUND),
    RED_DRAGON("Red Dragon",19,19,180,11,Range.closed(40,50),7,"Stronger than green dragon, but otherways a dragon like any other.\nSpecial: immune to spells level 1-3.\n",false, 1, MovementType.FLYING),
    BLACK_DRAGON("Black Dragon",25,25,300,15,Range.closed(40,50),7,"Little trick: titans do 150% damage to black dragons, but giants don't, so if you attack some giants, there's a definite bonus! Stronger than gold dragon, but not than archangel. Great for armageddon casters. Black dragons are terror of those heroes who have chosen magic over might, although there is one artifact that can break black dragon's spell immunity.\nSpecial: immune to all spells, 150% damage to giants and titans.\n",true, 1, MovementType.FLYING),

    // RAMPART FRACTION
    CENTAUR("Centaur",5,3,8,6,Range.closed(2,3),1,"Centaurs and Centaur Captains are the best and the most expensive lvl 1 units.\n",false, 14, MovementType.GROUND),
    CENTAUR_CAPTAIN("Centaur Captain",6,3,10,8,Range.closed(2,3),1,"Haliberdier kills Centaur Captain in 1 on 1 combat, but speed makes Centaur Captains better. Centaur Captains are better attackers than defenders, so attack before attacked. Good upgrade.\n",true, 14, MovementType.GROUND ),
    DWARF("Dwarf",6,7,20,3,Range.closed(2,4),2,"Real slowdown for your hero. Good defenders. Good for garrison shooter defence. Toughest lvl 2 units.Special: 20% magic resistance.\n",false, 8, MovementType.GROUND),
    BATTLE_DWARF("Battle Dwarf",7,7,20,5,Range.closed(2,4),2,"Now your hero can take them, speed will do until the endgame. Resists about 2 out of 5 spells!\nSpecial: 40% magic resistance.\n",true, 8, MovementType.GROUND),
    WOOD_ELF("Wood Elf",9,5,15,6,Range.closed(3,5),3,"The only shooter for Rampart. Elves are offensive units and need a good defence.",false, 7, MovementType.GROUND),
    GRAND_ELF("Grand Elf",9,5,15,7,Range.closed(3,5),3,"Awesome upgrade - doubles the attack and costs only 25 gold extra!\nSpecial: fires two shots per attack.\n", true, 7, MovementType.GROUND),
    PEGASUS("Pegasus",9,8,30,8,Range.closed(25,50),4,"If you're short on money, 1 Pegasus is better than 3 Centaurs and more useful than 2 Dwarves.\nSpecial: enemy spellcasters must pay 2 extra spell points per spell when Pegasi are present.\n",false, 5, MovementType.FLYING),
    SILVER_PEGASUS("Silver Pegasus",9,10,30,12,Range.closed(5,9),4,"Weakest non-shooting lvl 4 unit, but really fast and annoying to enemy spellcasters. Highest pop among lvl 4.\nSpecial: enemy spellcasters must pay 2 extra spell points per spell when Silver Pegasi are present.\n",true, 5, MovementType.FLYING),
    DENDROID_GUARD("Dendroid Guard",9,12,55,3,Range.closed(10,14),5,"Way too slow for hero's army, but excellent for garrison - Dendroid's roots will hold flies in place while Elves do their job from a very nice close-up. Worst lvl 5 unit but maximum population is the highest among lvl 5.\nSpecial: creatures attacked by Dendroids are held in place by their roots until Dendroids move or are killed.\n",false, 3, MovementType.GROUND),
    DENDROID_SOLDIER("Dendroid Soldier",9,12,65,4,Range.closed(10,14),5,"Really hard to identify the upgrade by picture, but if you look closer, Dendroid Soldiers have a few extra branches and bigger feet :) Bad upgrade: 1sp and 10hp for 75 gold! Too slow for hero, excellent for garrison.\nSpecial: creatures attacked by Dendroids are held in place by their roots until Dendroids move or are killed.\n",true, 3, MovementType.GROUND),
    UNICORN("Unicorn",15,14,90,7,Range.closed(18,22),6,"Note that Unicorn's aura does not affect the Unicorn itself. Unit surrounded by few stacks of Unicorns cold be almost invinsible to magic! Unicorns are good for any combat situations.\nSpecial: 20% chance to blind enemy. Aura increases magic resistace of all adjacent creatures by 20%.\n",false, 2, MovementType.GROUND),
    WAR_UNICORN("War Unicorn",15,14,110,9,Range.closed(18,22),6,"Good upgrade makes unicorn an excellent lvl 6 unit with a very small price!\nSpecial: 20% chance to blind enemy. Aura increases magic resistace of all adjacent creatures by 20%.\n",true, 2, MovementType.GROUND),
    GREEN_DRAGON("Green Dragon",18,18,180,10,Range.closed(40,50),7,"A little weaker, cheaper and slower than Red Dragon, otherways indentical.\nSpecial: attack affects 2 hexes. Immune to spells levels 1-3.\n",false, 1, MovementType.FLYING),
    GOLD_DRAGON("Gold Dragon",27,27,250,16,Range.closed(40,50),7,"While equal in price to Black Dragon, Gold Dragon has less immunity and hit points, but has more attack, defence and speed. Has a little weak spot for powerful enemy earth spellcasters - lvl 5 implosion.\nSpecial: attack affects 2 hexes. Immune to spells levels 1-4.\n",true, 1, MovementType.FLYING);

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
    private final MovementType movementType;

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
        movementType = aMovementType;
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

    public MovementType getMovementType() { return movementType; }
}
