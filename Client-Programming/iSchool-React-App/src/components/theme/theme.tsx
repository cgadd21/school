import { useEffect, useState } from 'react';
import * as Cookie from 'js-cookie';

/** Represents the themes. */
const themes = [
  'Light',
  'Dark',
  'Cupcake',
  'Bumblebee',
  'Emerald',
  'Corporate',
  'Synthwave',
  'Retro',
  'Cyberpunk',
  'Valentine',
  'Halloween',
  'Garden',
  'Forest',
  'Aqua',
  'Lofi',
  'Pastel',
  'Fantasy',
  'Wireframe',
  'Black',
  'Luxury',
  'Dracula',
  'Cmyk',
  'Autumn',
  'Business',
  'Acid',
  'Lemonade',
  'Night',
  'Coffee',
  'Winter',
  'Dim',
  'Nord',
  'Sunset',
].sort((a, b) => a.localeCompare(b));

/** Set the theme of the application and store it in a cookie. */
const setTheme = (newTheme: string) => {
  document.documentElement.setAttribute('data-theme', newTheme);
  Cookie.default.set('theme', newTheme);
};

/** Get the cookie theme. If none, luxury is set by default. */
const getTheme = () => {
  const currentTheme = Cookie.default.get('theme');
  return currentTheme || 'luxury';
};

/** Theme drop down component. */
export const Theme = () => {
  const [page, setPage] = useState(1);
  const [currentTheme, setCurrentTheme] = useState(getTheme());

  useEffect(() => {
    setTheme(currentTheme);
  }, [currentTheme]);

  return (
    <div className="dropdown">
      <div tabIndex={0} role="button" className="btn m-1">
        Theme
        <svg
          width="12px"
          height="12px"
          className="h-2 w-2 fill-current opacity-60 inline-block"
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 2048 2048"
        >
          <path d="M1799 349l242 241-1017 1017L7 590l242-241 775 775 775-775z"></path>
        </svg>
      </div>
      <ul
        tabIndex={0}
        className="dropdown-content z-[10] p-2 shadow-2xl bg-base-300 rounded-box"
      >
        {themes
          .slice((page - 1) * 8, page * 8) //8 items per page
          .map((theme) => (
            <li key={theme}>
              <input
                onClick={() => setCurrentTheme(theme.toLowerCase())}
                type="radio"
                name="theme-dropdown"
                className="theme-controller btn btn-sm btn-block btn-ghost justify-start"
                aria-label={theme}
                defaultChecked={currentTheme === theme.toLowerCase()}
              />
            </li>
          ))}
        <div className="pagination flex justify-around">
          <button
            onClick={() => setPage((prevPage) => prevPage + -1)}
            disabled={page === 1}
            className="btn m-1"
          >
            {'«'}
          </button>
          <button
            onClick={() => setPage((prevPage) => prevPage + 1)}
            disabled={page === Math.ceil(themes.length / 8)}
            className="btn m-1"
          >
            {'»'}
          </button>
        </div>
      </ul>
    </div>
  );
};
