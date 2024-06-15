import useSWR from 'swr';
import { iSchool } from '../api/iSchool';

/** Represents the structure of the minors data. */
type Minors = {
  UgMinors: {
    name: string;
    title: string;
    description: string;
    courses: string[];
    note: string;
  }[];
};

/**
 * Hook to fetch minors data.
 * @returns An object containing the minors data, loading state, and error.
 */
export const useMinors = () => {
  const { data, isLoading, error } = useSWR<Minors>(
    `${iSchool.iSchoolURL}minors`,
  );
  return { data, isLoading, error };
};
