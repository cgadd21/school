/**
 * Helper function to create a label.
 * @param text
 * @param form
 * @returns label element
 */
export const createLabel = (
  text: string,
  form: HTMLFormElement,
): HTMLLabelElement => {
  const label = document.createElement('label');
  label.appendChild(document.createTextNode(text));
  form.appendChild(label);
  return label;
};
