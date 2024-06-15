import { Unit } from '../models/unit.js';
import { createDiv } from '../helpers/create.div.js';
import { createForm } from '../helpers/create.form.js';
import { createLabel } from '../helpers/create.label.js';
import { createSelect } from '../helpers/create.select.js';
import { createOption } from '../helpers/create.option.js';
import { deleteElement } from '../helpers/delete.element.js';

/**
 * Creation method that creates and handles all strategy functions.
 * @param question
 * @param options
 * @param onUnitSelected
 */
export const createStrategy = (
  question: string,
  options: any,
  onUnitSelected: (unit: Unit) => void,
): void => {
  const div = createDiv('strategy', document.body);
  const form = createForm(div);
  createLabel(question, form);
  const select = createSelect(form);
  createOption('', '', select);

  for (let option in options) {
    createOption(option, options[option].description, select);
  }

  select.addEventListener('change', function () {
    deleteElement(this);
    if (options[select.value].options) {
      createStrategy(
        options[select.value].question,
        options[select.value].options,
        onUnitSelected,
      );
    } else {
      onUnitSelected(options[select.value] as Unit);
    }
  });
};
