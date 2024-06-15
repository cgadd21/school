/**
 * Helper function that creates a cookie.
 * @param name
 * @param value
 * @param maxAge
 * @param path
 * @param domain
 * @param sameSite
 * @param secure
 */

export const setCookie = (
  name: string,
  value: string,
  maxAge?: number,
  path?: string,
  domain?: string,
  sameSite?: string,
  secure?: string,
): void => {
  document.cookie =
    name +
    '=' +
    encodeURIComponent(value) +
    (maxAge ? ';max-age=' + maxAge : '') +
    (path ? ';path=' + path : '') +
    (domain ? ';domain=' + domain : '') +
    (sameSite ? ';samesite=' + sameSite : ';samesite=strict') +
    (secure ? ';secure;' : ';');
};
