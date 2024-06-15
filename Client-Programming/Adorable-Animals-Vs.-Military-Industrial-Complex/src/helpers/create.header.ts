/**
 * Helper function to create a header.
 * @param text
 * @param div
 * @returns header element
 */
export const createHeader = (
  text: string,
  div: HTMLDivElement,
): HTMLHeadElement => {
  const header = document.createElement('h1');
  header.appendChild(document.createTextNode(text));
  div.appendChild(header);
  return header;
};
