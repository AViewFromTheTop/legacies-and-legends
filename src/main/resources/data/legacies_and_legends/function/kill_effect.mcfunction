execute as @a if items entity @s weapon.mainhand legacies_and_legends:amulet_of_synthesis run function legacies_and_legends:kill_effect/amulet_of_synthesis
execute as @a if items entity @s weapon.offhand legacies_and_legends:amulet_of_synthesis run function legacies_and_legends:kill_effect/amulet_of_synthesis

advancement revoke @s only legacies_and_legends:function/entity_kill_mainhand
advancement revoke @s only legacies_and_legends:function/entity_kill_offhand