/**
 * Helper function to remove an element.
 * Removes elements if user went backwards.
 * @param dom
 */
export const deleteElement = (dom: any): void => {
  while (
    dom.parentNode?.parentNode &&
    dom.parentNode.parentNode !== dom.parentNode.parentNode.parentNode.lastChild
  ) {
    document.body.removeChild(dom.parentNode.parentNode.parentNode.lastChild);
  }
};
