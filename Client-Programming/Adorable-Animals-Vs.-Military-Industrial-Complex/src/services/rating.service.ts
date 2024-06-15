import { createDiv } from '../helpers/create.div.js';
import { createHeader } from '../helpers/create.header.js';
import { createForm } from '../helpers/create.form.js';
import { createLabel } from '../helpers/create.label.js';
import { createInput } from '../helpers/create.input.js';
import { createSpan } from '../helpers/create.span.js';
import { createButton } from '../helpers/create.button.js';
import { setCookie } from '../helpers/create.cookie.js';

//variable to store star rating
let starRating: string | null;

/**
 * Creation method that creates and handles all rating functions.
 */
export const createRating = (): void => {
  const div = createDiv('rating', document.body);

  createHeader('Please leave a review!', div);

  let starDiv = createDiv('stars', div);
  for (let i = 1; i <= 5; i++) {
    const span = createSpan(
      `star${i.toString()}`,
      'star',
      i.toString(),
      '\u2605', //unicode for star
      starDiv,
    );

    span.addEventListener('click', function () {
      starRating = this.getAttribute('data-value');

      for (let i = 1; i <= 5; i++) {
        const star = document.getElementById(`star${i.toString()}`);
        const starValue = star?.getAttribute('data-value');
        if (star) star.className = 'star';

        if (starValue && starRating && starValue <= starRating) {
          if (star) star.className = 'star active';
        }
      }
    });
  }

  const form = createForm(div);
  createLabel('Name', form);
  createInput('name', 'text', form);

  createButton(
    'Save',
    function () {
      if (saveRating()) {
        createHeader(`Thanks for leaving a rating!`, div);
        createButton(
          'Start Over',
          function () {
            location.reload(); //page reload
            return true;
          },
          div,
        );
        return true;
      }
      return false;
    },
    createDiv('save', div),
  );
};

/**
 * Method to save rating.
 * @returns save status
 */
const saveRating = (): boolean => {
  if (navigator.cookieEnabled) {
    const name: HTMLInputElement | null = document.getElementById(
      'name',
    ) as HTMLInputElement;
    const nameValue = name.value;

    name.className = nameValue ? 'name' : 'name invalid';
    starRating ? normalStars() : redStars();

    //store rating in cookie
    if (nameValue && starRating) {
      setCookie('name', nameValue);
      setCookie('stars', starRating);
      return true;
    }
  }
  return false;
};

/**
 * Method to turn all stars red.
 */
const redStars = () => {
  for (let i = 1; i <= 5; i++) {
    const star = document.getElementById(`star${i.toString()}`);
    if (star) star.className = 'star invalid';
  }
};

/**
 * Method to turn stars normal.
 */
const normalStars = () => {
  for (let i = 1; i <= 5; i++) {
    const star = document.getElementById(`star${i.toString()}`);
    const starValue = star?.getAttribute('data-value');
    if (star) star.className = 'star';

    //if user selected a star rating we must return it to the state it was
    if (starValue && starRating && starValue <= starRating) {
      if (star) star.className = 'star active';
    }
  }
};
