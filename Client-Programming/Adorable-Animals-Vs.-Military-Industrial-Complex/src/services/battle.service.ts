import { Unit } from '../models/unit';
import { createDiv } from '../helpers/create.div.js';
import { createHeader } from '../helpers/create.header.js';
import { createImage } from '../helpers/create.image.js';

/**
 * Creation method that creates and handles all battle functions.
 * @param unit1
 * @param unit2
 * @param onBattleCompleted
 */
export const createBattle = (
  unit1: Unit,
  unit2: Unit,
  onBattleCompleted: () => void,
): void => {
  const battleResult = battle(unit1, unit2);

  //store winner count in local storage
  if (window.localStorage) {
    const result = localStorage.getItem(battleResult?.description);
    if (result === null) {
      localStorage.setItem(battleResult.description, '1');
    } else {
      localStorage.setItem(
        battleResult.description,
        (parseInt(result) + 1).toString(),
      );
    }
  }

  const battleDiv = createDiv('battle', document.body);

  createHeader(
    `The battle resulted in ${
      battleResult.description
    } victorious! Win Count: ${localStorage.getItem(battleResult.description)}`,
    battleDiv,
  );

  createImage(battleResult.image, battleDiv);

  onBattleCompleted();
};

/**
 * Method that has two units battle.
 * @param unit1
 * @param unit2
 * @returns winning unit
 */
const battle = (unit1: Unit, unit2: Unit): Unit => {
  unit1.health *= unit1.squad;
  unit2.health *= unit2.squad;
  while (unit1.health > 0 && unit2.health > 0) {
    unit2.health -= unit1.damage * unit1.squad;

    if (unit2.health <= 0) {
      return unit1;
    }

    unit1.health -= unit2.damage * unit2.squad;

    if (unit1.health <= 0) {
      return unit2;
    }
  }
  return unit1;
};
