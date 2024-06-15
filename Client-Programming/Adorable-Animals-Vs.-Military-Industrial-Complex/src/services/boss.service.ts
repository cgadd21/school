import { Unit } from '../models/unit.js';
import { createDiv } from '../helpers/create.div.js';
import { createForm } from '../helpers/create.form.js';
import { createLabel } from '../helpers/create.label.js';
import { createSelect } from '../helpers/create.select.js';
import { createOption } from '../helpers/create.option.js';
import { deleteElement } from '../helpers/delete.element.js';

/**
 * Creation method that creates and handles all boss functions.
 * @param bosses
 * @param onBossSelected
 */
export const createBoss = (
  bosses: Unit[],
  onBossSelected: (unit: Unit) => void,
): void => {
  const div = createDiv('boss', document.body);
  const form = createForm(div);
  createLabel('Select boss.', form);
  const select = createSelect(form);
  createOption('', '', select);

  for (let boss of bosses) {
    createOption(JSON.stringify(boss), boss.description, select);
  }

  select.addEventListener('change', function () {
    deleteElement(this);
    onBossSelected(JSON.parse(select.value));
  });
};
