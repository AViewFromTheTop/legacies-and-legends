execute as @a if items entity @s weapon.mainhand legacies_and_legends:tablet_of_channeling run function legacies_and_legends:use_effect/tablet_of_channeling
execute as @a if items entity @s weapon.offhand legacies_and_legends:tablet_of_channeling run function legacies_and_legends:use_effect/tablet_of_channeling

execute as @a if items entity @s weapon.mainhand legacies_and_legends:tablet_of_deafening run function legacies_and_legends:use_effect/tablet_of_deafening
execute as @a if items entity @s weapon.offhand legacies_and_legends:tablet_of_deafening run function legacies_and_legends:use_effect/tablet_of_deafening

advancement revoke @s only legacies_and_legends:function/item_use_mainhand
advancement revoke @s only legacies_and_legends:function/item_use_offhand