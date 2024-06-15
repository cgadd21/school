export function isValidCandidate(candidate) {
  const errors = [];
}

export function isValidPassword(pw) {
  /* 
    require password to have (using positive look-ahead):
    • number       /d
    • lower case   [a-z]
    • upper case   [A-Z]
    • special char [ !"#$%&'()*+,\-.\/:;<=>?@[\\\]^_`{|}~]
    • at least 8 characters
  */
  return /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[ !"#$%&'()*+,\-.\/:;<=>?@[\\\]^_`{|}~]).{8,}$/.test(
    pw
  );
}
