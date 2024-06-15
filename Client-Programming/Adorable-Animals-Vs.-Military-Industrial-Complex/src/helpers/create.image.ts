/**
 * Helper functoin to create an image.
 * @param src
 * @param div
 * @returns image element
 */
export const createImage = (
  src: string,
  div: HTMLDivElement,
): HTMLImageElement => {
  const image = document.createElement('img');
  image.src = src;
  div.appendChild(image);
  return image;
};
