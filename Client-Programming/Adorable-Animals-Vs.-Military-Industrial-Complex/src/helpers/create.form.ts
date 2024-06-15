/**
 * Helper function to create a form.
 * @param div
 * @returns form element
 */
export const createForm = (div: HTMLDivElement): HTMLFormElement => {
  const form = document.createElement('form');
  div.appendChild(form);
  return form;
};
