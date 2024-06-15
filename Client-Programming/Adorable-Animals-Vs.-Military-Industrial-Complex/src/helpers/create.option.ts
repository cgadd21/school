/**
 * Helper function to create an option.
 * @param value
 * @param text
 * @param select
 * @returns option element
 */
export const createOption = (
  value: string,
  text: string,
  select: HTMLSelectElement,
): HTMLOptionElement => {
  const option = document.createElement('option');
  option.value = value;
  option.appendChild(document.createTextNode(text));
  select.appendChild(option);
  return option;
};
