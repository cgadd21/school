//const proxyServer =
'https://people.rit.edu/~dsbics/proxy/https://ischool.gccis.rit.edu/api/';
const proxyServer =
  'http://solace.ist.rit.edu/~dsbics/proxy/https://ischool.gccis.rit.edu/api/';

export const getData = async (endPoint) => {
  return (await fetch(`${proxyServer}${endPoint}/`)).json();
};
