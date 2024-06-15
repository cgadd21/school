/**
 * Helper function to create a select.
 * @param form
 * @returns select element
 */
export const createSelect = (form: HTMLFormElement): HTMLSelectElement => {
  const select = document.createElement('select');
  form.appendChild(select);
  return select;
};
