/**
 * Helper function to create a button.
 * @param text
 * @param buttonFunction
 * @param div
 * @returns button element
 */

export const createButton = (
  text: string,
  buttonFunction: () => boolean,
  div: HTMLDivElement,
): HTMLButtonElement => {
  const button = document.createElement('button');
  button.type = 'button';
  button.appendChild(document.createTextNode(text));
  button.onclick = () => {
    //if function was successful, disable the button
    button.disabled = buttonFunction() ? true : false;
  };
  div.appendChild(button);
  return button;
};
