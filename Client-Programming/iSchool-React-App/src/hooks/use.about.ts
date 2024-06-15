import useSWR from 'swr';
import { iSchool } from '../api/iSchool';

/** Represents the structure of the about data. */
type About = {
  title: string;
  description: string;
  quote: string;
  quoteAuthor: string;
};

/**
 * Hook to fetch about data.
 * @returns An object containing the about data, loading state, and error.
 */
export const useAbout = () => {
  const { data, isLoading, error } = useSWR<About>(
    `${iSchool.iSchoolURL}about`,
  );
  return { data, isLoading, error };
};
