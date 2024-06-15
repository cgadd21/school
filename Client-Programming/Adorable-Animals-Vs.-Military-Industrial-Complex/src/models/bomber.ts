import { Unit } from './unit';

/**
 * Third level of tree structure.
 */
export type Bomber = {
  question: string;
  description: string;
  options: {
    strategicBombers: Unit;
    stealthBombers: Unit;
  };
};
