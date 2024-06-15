import { environment } from '../environment/environment';
import { proxy } from './proxy';

/** Provides iSchool API information. */
export const iSchool = {
  /** URL to access iSchool API. */
  iSchoolURL: `${environment.production ? proxy.peopleURL : proxy.solaceURL}https://ischool.gccis.rit.edu/api/`,
};
