import { Strategy } from '../models/strategy.js';
import { Unit } from '../models/unit.js';

/**
 * Method that fetches the strategy data from JSON.
 * @returns strategy
 */
export const getStrategyData = async (): Promise<Strategy> => {
  try {
    const result = await fetch('../public/assets/data/strategy.data.json');
    const data = await result.json();
    return data;
  } catch (error) {
    throw error;
  }
};

/**
 * Method that fetches the boss data from JSON.
 * @returns unit
 */
export const getBossData = async (): Promise<Unit[]> => {
  try {
    const result = await fetch('../public/assets/data/boss.data.json');
    const data = await result.json();
    return data;
  } catch (error) {
    throw error;
  }
};
