execute as @a if items entity @s weapon.mainhand legacies_and_legends:amulet_of_evasion run function legacies_and_legends:item_effect/amulet_of_evasion
execute as @a if items entity @s weapon.offhand legacies_and_legends:amulet_of_evasion run function legacies_and_legends:item_effect/amulet_of_evasion

advancement revoke @s only legacies_and_legends:function/item_check_mainhand
advancement revoke @s only legacies_and_legends:function/item_check_offhand