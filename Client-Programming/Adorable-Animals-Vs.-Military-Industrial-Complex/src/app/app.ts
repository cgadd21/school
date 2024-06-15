import { Unit } from '../models/unit.js';
import { getBossData, getStrategyData } from '../services/data.service.js';
import { createWelcome } from '../services/welcome.service.js';
import { createBoss } from '../services/boss.service.js';
import { createStrategy } from '../services/strategy.service.js';
import { createBattle } from '../services/battle.service.js';
import { createRating } from '../services/rating.service.js';

/**
 * App is the central location that pulls all services together to run this web application.
 * It uses callback functions to control the flow of the app.
 *
 * Onit calls all the creation and data methods.
 */
const onInit = async (): Promise<void> => {
  createWelcome();

  const StrategyData = await getStrategyData();
  const BossData = await getBossData();

  createBoss(BossData, (selectedBoss: Unit) => {
    createStrategy(
      StrategyData.question,
      StrategyData.options,
      (selectedUnit: Unit) => {
        createBattle(selectedUnit, selectedBoss, () => {
          createRating();
        });
      },
    );
  });
};

onInit();
