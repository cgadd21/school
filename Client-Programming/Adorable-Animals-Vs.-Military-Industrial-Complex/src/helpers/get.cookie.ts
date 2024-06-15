/**
 * Helper function to get a cookie.
 * @param name
 * @returns cookie content
 */
export const getCookie = (name: string): string | null => {
  const arg = name + '=';
  const alen = arg.length;
  const clen = document.cookie.length;
  let i = 0;
  while (i < clen) {
    const j = i + alen;
    if (document.cookie.substring(i, j) == arg) {
      let endstr = document.cookie.indexOf(';', j);
      if (endstr == -1) {
        endstr = document.cookie.length;
      }
      return decodeURIComponent(document.cookie.substring(j, endstr));
    }
    i = document.cookie.indexOf(' ', i) + 1;
    if (i == 0) break;
  }
  return null;
};
