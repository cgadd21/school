import { Unit } from './unit';

/**
 * Third level of tree structure.
 */
export type Infantry = {
  question: string;
  description: string;
  options: {
    rifleTeam: Unit;
    sniperTeam: Unit;
  };
};
