/**
 * Helper function to create a span.
 * @param id
 * @param className
 * @param value
 * @param text
 * @param div
 * @returns span element
 */
export const createSpan = (
  id: string,
  className: string,
  value: string,
  text: string,
  div: HTMLDivElement,
): HTMLSpanElement => {
  const span = document.createElement('span');
  span.id = id;
  span.className = className;
  span.setAttribute('data-value', value);
  span.appendChild(document.createTextNode(text));
  div.appendChild(span);
  return span;
};
