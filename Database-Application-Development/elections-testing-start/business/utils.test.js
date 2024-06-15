import * as utils from "./utils.js";

// Candidate

// Password
/*
Short1!
NoNumber!
NoSpecialCh4r
noc4pitals!
NOL0WER!
goodP4ssw0rd!
*/

test(`Password must have at least 8 characters`, () => {
  expect(utils.isValidPassword(`Short!`)).toBe(false);
});

test(`Password must contain a number`, () => {
  expect(utils.isValidPassword(`NoNumber!`)).toBe(false);
});

test(`Password must contain a special char`, () => {
  expect(utils.isValidPassword(`NoSpecialCh4r`)).toBe(false);
});

test(`Password must contain a capital letter`, () => {
  expect(utils.isValidPassword(`noc4pitals!`)).toBe(false);
});

test(`Password must contain a lowercase letter`, () => {
  expect(utils.isValidPassword(`NOL0WER!`)).toBe(false);
});

test(`Password must be complex`, () => {
  expect(utils.isValidPassword(`goodP4ssw0rd!`)).toBe(true);
});
