import { Infantry } from './infantry';
import { Tank } from './tank';

/**
 * Second level of tree structure.
 */
export type LandInvasion = {
  question: string;
  description: string;
  options: {
    infantry: Infantry;
    tank: Tank;
  };
};
