execute as @a if items entity @s weapon.mainhand legacies_and_legends:amulet_of_allure run function legacies_and_legends:breed_effect/amulet_of_allure
execute as @a if items entity @s weapon.offhand legacies_and_legends:amulet_of_allure run function legacies_and_legends:breed_effect/amulet_of_allure

advancement revoke @s only legacies_and_legends:function/animal_breed_mainhand
advancement revoke @s only legacies_and_legends:function/animal_breed_offhand