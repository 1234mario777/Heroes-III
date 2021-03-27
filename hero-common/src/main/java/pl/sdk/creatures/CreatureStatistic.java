package pl.sdk.creatures;

import com.google.common.collect.Range;

public enum CreatureStatistic implements CreatureStatisticIf{

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

    // TOWER FRACTION
    GREMLIN("Gremlin",3,3,4,4,Range.closed(1,2),1,"Gremlins are only better than imps... cheap and plentiful too, but slow and weak in all aspects.",false,16),
    STONE_GARGOYLE("Stone Gargoyle",6,6,16,6,Range.closed(2,3),2,"Not a very good fighter, but quite useful for preventing enemy shooters from using their range attacks.",false,9),
    STONE_GOLEM("Stone Golem",7,10,30,3,Range.closed(4,5),3,"Great town defenders because spells just don't take them that easy! Too slow for heroes though, that's what upgrade is for.",false,6),
    MAGE("Mage",11,8,25,5,Range.closed(7,9),4,"Good offensive shooters, but even though they suffer no hand-to-hand penalty, keep them defended because their hit points and defence are low.\nSpell bonus is great! Magic arrows cost 2 mana! Note that when all magi on the battlefield are dead, spell bonus disappears.",false,4),
    GENIE("Genie",12,12,40,7,Range.closed(13,16),5,"Offensive unit with big lack of hit points, do not attack unless it will destroy the target.\n I would prefer 1 naga instead of 2 genies.",false,3),
    NAGA("Naga",16,13,110,5,Range.closed(20,20),6,"Nagas and naga queens are necromancer's black and dread knights' toughest competitors for the first place amongst the level 6 units.\nNothing to comment really, this unit is great all around, just don't bother blessing or cursing that great constant damage.",false,2),
    GIANT("Giant",19,16,150,7,Range.closed(40,60),7,"Their damage is great, especially if blessed. Their dwelling is really cheap compared to other level 7 dwellings. The only drawback is the gem cost.\nAnyway, a good unit to recruit and upgrade later in the game. Nagas and giants make a hardly beatable ground attack force.",false,1),
    MASTER_GREMLIN("Master Gremlin",4,4,4,5,Range.closed(1,2),1,"Master gremlins are the only level one shooters (except for halflings in AB) and provide a great advantage in early stages of the game, thank god the gremlin rush desn't work anymore, it was unstoppable.\n Otherways, awesome upgrade, but keep the ammo cart handy, these guys have only 8 shots. They do have a hand-to-hand penalty, so try to block them.",true,16),
    OBSIDIAN_GARGOYLE("Obsidian Gargoyle",7,7,16,9,Range.closed(2,3),2,"30 Gold for 3 extra speed and 1 attack and defence... not a good upgrade, but makes them better shooter-blockers. I would prefer to save money for golems who will last a whole lot longer.\n Recruit gargoyles only when you are quite desperate for army.",true,9),
    IRON_GOLEM("Iron Golem",9,10,35,5,Range.closed(4,5),3,"Great upgrade! Speed is usable for hero armies while extra hit points and magic resistance make them even tougher. Only a foolish player will cast offensive spells on iron golems, only a quarter damage will get through.\n Iron golems are great to defend shooters.",true,6),
    ARCH_MAGE("Arch Mage",12,9,30,7,Range.closed(7,9),4,"Reasonable upgrade adds speed, improves defensive ratings and wall penetration will decrease the range penalty in seige attacks.",true,4),
    MASTER_GENIE("Master Genie",12,12,40,11,Range.closed(13,16),5,"Master genies are a totally different story with their spellcasting abbilities. If you have room in your army, split master genies in many stacks to be able to cast more beneficial spells on your units per turn.\n Remember that most of their spells last for 6 turns and that a single unit stack can have a maximum of 3 spells affecting it. Great upgrade for 50 extra gold.",true,3),
    NAGA_QUEEN("Naga Queen",16,13,110,7,Range.closed(30,30),6,"Extra speed and extra 50% of that constant damage are worth the extra 500 gold that make naga queen the most expensive in level 6.",true,2),
    TITAN("Titan",24,24,300,11,Range.closed(40,60),7,"The best shooter in the game and the most expensive level 7 unit. Shooting abbility is great, as well as twice the hit points and major increases in speed/attack/defence, but the price is more than doubled...\nThis is really an endgame creature because the dwelling costs 25000 gold and 30 gems to upgrade and the titans are so expensive too.",true,1),

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
    CHAOS_HYDRA("Chaos Hydra",18,20,250,7,Range.closed(25,45),7,"Extra 75 hit points, 2 attack and defence, but most importantly extra speed.\nWell, speed still remains the slowest among level 7 upgrades, but the strategic use is at it's best.\n",true, 1),

    //CASTLE FRACTION
    PIKEMAN("Pikeman",4,5,10,4,Range.closed(1,3),1,"Toughest lvl1 unit, but a bit slow.",false,14),
    ARCHER("Archer",6,3,10,4,Range.closed(2,3),2,"Archer's upgrade is literally 2 times better. Upgrade them quickly.",false,9),
    GRIFFIN("Griffin",8,8,25,6,Range.closed(3,6),3,"High in population, griffins become castle's main unit for the midgame.",false,7),
    SWORDSMAN("Swordsman",10,12,35,5,Range.closed(6,9),4,"Not too good unit the upgrade and also too slow.",false, 4),
    MONK("Monk",12,7,30,5,Range.closed(10,12),5,"Good shooter, nice damage.",false,3),
    CAVALIER("Cavalier",15,15,100,7,Range.closed(15,25),6,"Make sure that the path is as long as possible - they need some speed!",false,2),
    ANGEL("Angel",20,20,100,7,Range.closed(50,50),7,"Nice combat ratings and great constant damage - no need to bless them.\nNote that before the update patches Angels and Archangels didn't cost any gems, just gold.",false,1),
    HALBERDIER("Halberdier",6,5,10,5,Range.closed(2,3),1,"Now they are faster and do more damage. Will make a good defence for shooters.",true,14),
    MARKSMAN("Marksman",6,3,10,6,Range.closed(2,3),2,"Awesome upgrade, but they still lack defence...",true,9),
    ROYAL_GRIFFIN("Royal Griffin",9,9,25,9,Range.closed(3,6),3,"Send them right in the middle of the battlefield. Everyone who comes will get some ;)",true,7),
    CRUSADER("Crusader",7,10,35,6,Range.closed(7,10),4,"Good upgrade, but still lacks speed. Seem undefeatable in large numbers.",true,4),
    ZEALOT("Zealot",12,10,30,7,Range.closed(10,12),5,"Zealots are skilled enough to use the same magic powers at very close range. Better defence too.",true,3),
    CHAMPION("Champion",16,16,100,9,Range.closed(20,25),6,"That's up to 45% extra damage possible! Champions also have better aiming skills.",true,2),
    ARCHANGEL("Archangel",30,30,250,18,Range.closed(50,50),7,"Best attack, defence and speed in a whole game! Resurrection is a very convenient abbility.\nThose fast wings take up a whole extra hex! :]",true,1),

    //    STRONGHOLD FRACTION
    GOBLIN("Goblin",4,2,5,5, Range.closed(1,2),1,"Slightly weaker than average for level 1, but better than imp for a smaller price. Highly populated, goblin is a good offensive unit to start with. Nice speed for level 1, especially after the upgrade. Defence is lower than attack, so be sure to attack before attacked.",false,12),
    WOLF_RIDER("Wolf Rider",7,5,10,6, Range.closed(2,4),2,"Basically you're getting the same goblin, slightly better stats and larger size. Weak for level 2, wolf rider is only slightly better than level 1 centaur captain. Wolves should attack before attacked, applies to wolf raiders especially.",false,8),
    ORC("Orc",8,4,15,4, Range.closed(2,5),3,"Weaker than beholders and elves, orcs are the weakest level 3 shooters, but that is also reflected in their low price. Reasonable stats, wide damage easily affected by bless and curse, slow speed which will be reflected on your hero movement, but if you plan using ogres in your army, they are just as slow, so feel free to take some orcs. Cyclops will replace orcs later on.",false,7),
    OGRE("Ogre",13,7,40,4, Range.closed(6,12),4,"A great level 4 unit if it wasn't for the superlow speed. Nice damage, great attack, low price, while the low defence is backed up by plenty hit points. Orcs and ogres are a speed pair, so either have both or none for your main hero. Ogres make great defenders, bashing the enemy from close range as they approach your juicy shooters. For all ogres - watch out for curse and apply bless as required.",false,4),
    ROC("Roc",13,11,60,7, Range.closed(11,15),5,"Let's roc! A nice level 5 unit with higher hit points than most. Roc is also very balanced, having no weak sides such as damage range or low defence. Use them for whatever purpose, but being the only stronghold flyers they often die alone in the enemy crowd.",false,3),
    CYCLOPS("Cyclops",15,12,70,6, Range.closed(16,20),6,"Now we're shooting! Only titan's lightning can hit stronger than cyclops' rocks, and that abbility to attack seige walls is completely exlusive to cyclops. Want 3 extra catapults? Split cyclops into multiple stacks, seige walls take same damage from 1 cyclops as from 100. Cyclops is also a well-balanced unit with no weakneses except for the hand-to-hand penalty. Keep that ammo cart handy for long ones.",false,2),
    BEHEMOTH("Behemoth",17,17,160,6, Range.closed(30,50),7,"That smile scares the hell out of whoever behemoth is attacking, reducing their abbility to defend themselves. Slow and quite vunerable, behemoth is also a cheap level 7 unit, definitely attack-oriented and able to deal huge damage by reducing enemy defence during the attack. Try to use charge tactics whenever possible, do not leave behemoth exposed to enemy attacks, too easy to lose them.",false,1),

    HOBGOBLIN("Hobgoblin",5,3,5,7, Range.closed(1,2),1,"The speed is worth 10 gold, combined attack and defence increase. Hobgoblins are more able to attack before failing to defend themselves. However, the damage is lacking: 1-2 is lower than 1-3 or 2-3 that many other units of this level have. Since this upgrade is required for wolf raiders, you will probably end up doing it, but 5 wood and 5 ore are better saved for a castle.",true,12),
    WOLF_RAIDER("Wolf Raider",8,5,10,8, Range.closed(3,4),2,"Awesome upgrade that makes wolves do about 2.5 times more damage. Defence and hit points remain the same, so use the sudden charge tactics. Try to get your target to waste their retaliation before raiders make their double move. Ahhh, HOMM1 memories... same two attacks, but those wolves were white and self-sufficient :) As for getting the upgrade - it is very expensive in terms of wood and ore because you are required to upgrade goblins first. If you're poor, you might even forget about using goblins and wolves in your main army, just let them stock up for a bad day",true,8),
    ORC_CHIEFTAIN("Orc Chieftain",8,4,20,5, Range.closed(2,5),3,"A small and cheap upgrade that makes orcs slightly faster (same as ogre magi) and tougher. Do it if you want orcs to last longer or if all your ogres are upgraded already, so that the lowest army speed will be 5 instead of 4. Comparing the pictures, orc chieftain has one extra axe - this is to be interpreted as double amount of shots :)",true,7),
    OGRE_MAGI("Ogre Magi",13,7,60,5, Range.closed(6,12),4,"Great upgrade, 50% tougher for 33% extra price plus the spell bonus. Ogre magi are the toughest among their level, their supperiority undermined perhaps only by vampires' life drain. Stock up on these guys because they can dellay your enemy's victory by few thousand hit points. Ogre magi are still slow, but they don't just stand there anymore - bloodlust spell will assist the advancing armies while magi defend the shooters. Bloodlust increases attack skill for the time of 6 round",true,4),
    THUNDERBIRD("Thunderbird",13,11,60,11, Range.closed(11,15),5,"Thunderbolt strike is a useful damage since it is not affected by defence. The only flying unit for stronghold, they are still not good enough to fly over the castle walls alone. This upgrade is good to get the earlier spellcasting turn: speed 11 is the highest in stronghold, followed by 9 of ancient behemoth. And hey, the looks are good, they actually look more powerful to your human opponent.",true,3),
    CYCLOPS_KING("Cyclops King",17,13,70,8, Range.closed(16,20),6,"They aren't kings for nothing, packing two seige shots in one turn and leveling walls to the ground in no time. You'll notice that the lack of flyers is compensated by the cyclops' special abbilities. Kings however are quite pricey - look at that golden skirt armor that you are buying them for 350 gold! Attack, defence and speed improvements are too small to be worth 350 gold, so upgrade only if you are filthy rich and are heading for a long seige. Think about it, 2 kings cost almost as much as 3 normal cyclops!",true,2),
    ANCIENT_BEHEMOTH("Ancient Behemoth",19,19,300,9, Range.closed(30,50),7,"Quite low on attack, defence and speed for the best creature, but hit points are at the top and the special abbility is amazing: the target is virtually defenceless however high it's skill is, even if it is commanded by a good hero, nothing helps, only 1/5th of defence will be useful to the scared enemy. Ancient behemoth is able to deal the highest damage amongst all level 7 units, but it's use is more strategic than that: always attack the unit with the highest defence skill since only behemoths can bypass it. If you are ever to face the ancient behemoth, command all your units to attack at once - its attack is great, but its defence is nothing special, making it a strategic target.",true,1);

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
