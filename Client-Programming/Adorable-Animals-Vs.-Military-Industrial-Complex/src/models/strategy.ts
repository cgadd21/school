import { AerialAssult } from './aerial.assult';
import { LandInvasion } from './land.invasion';

/**
 * First level of tree structure.
 */
export type Strategy = {
  question: string;
  options: {
    aerialAssult: AerialAssult;
    landInvasion: LandInvasion;
  };
};
