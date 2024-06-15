import { createDiv } from '../helpers/create.div.js';
import { createHeader } from '../helpers/create.header.js';
import { getCookie } from '../helpers/get.cookie.js';

/**
 * Creation method that creates and handles all welcome functions.
 */
export const createWelcome = (): void => {
  const div = createDiv('welcome', document.body);

  const name = getCookie('name');
  createHeader(
    name === null
      ? 'Welcome To Adorable Animals Vs. Military Industrial Complex'
      : `Welcome Back ${name}!`,
    div,
  );

  const stars = getCookie('stars');
  createHeader(
    stars
      ? stars == '1' || stars == '2' || stars == '3'
        ? `I'm suprised you're back after that review...`
        : `Thanks for the amazing review!`
      : `Don't forget to leave a review!`,
    div,
  );
};
