/**
 * Helper function to create a div and annimate it.
 * @param className
 * @param element
 * @returns div element
 */

export const createDiv = (
  className: string,
  element: HTMLElement,
): HTMLDivElement => {
  const div = document.createElement('div');
  div.className = className;
  div.style.opacity = '0';
  element.appendChild(div);

  //fade in the div
  let opacity = 0;
  const fadeIn = () => {
    opacity += 0.05;
    div.style.opacity = opacity.toString();
    if (opacity < 1) {
      requestAnimationFrame(fadeIn);
    }
  };
  requestAnimationFrame(fadeIn);

  return div;
};
