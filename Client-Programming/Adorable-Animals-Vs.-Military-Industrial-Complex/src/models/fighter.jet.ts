import { Unit } from './unit';

/**
 * Third level of tree structure.
 */
export type FighterJet = {
  question: string;
  description: string;
  options: {
    f22Raptor: Unit;
    su35Flanker: Unit;
  };
};
