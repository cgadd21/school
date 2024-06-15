/** @type {import('tailwindcss').Config} */
export default {
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx}',
    './components/**/*.{js,ts,jsx,tsx,mdx}',
  ],
  daisyui: {
    themes: true,
  },
  // eslint-disable-next-line no-undef
  plugins: [require('daisyui')],
};
