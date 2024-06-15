import { Bomber } from './bomber';
import { FighterJet } from './fighter.jet';

/**
 * Second level of tree structure.
 */
export type AerialAssult = {
  question: string;
  description: string;
  options: {
    fighterJet: FighterJet;
    bomber: Bomber;
  };
};
