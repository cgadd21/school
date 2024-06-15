import { Unit } from './unit';

/**
 * Third level of tree structure.
 */
export type Tank = {
  question: string;
  description: string;
  options: {
    lightTank: Unit;
    heavyTank: Unit;
  };
};
