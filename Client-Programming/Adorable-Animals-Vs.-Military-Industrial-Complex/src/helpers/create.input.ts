/**
 * Helper function to create an input.
 * @param id
 * @param type
 * @param form
 * @returns input element
 */
export const createInput = (
  id: string,
  type: string,
  form: HTMLFormElement,
): HTMLInputElement => {
  const input = document.createElement('input');
  input.id = id;
  input.type = type;
  form.appendChild(input);
  return input;
};
