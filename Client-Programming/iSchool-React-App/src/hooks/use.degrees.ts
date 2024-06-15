import useSWR from 'swr';
import { iSchool } from '../api/iSchool';

/** Represents the structure of the degrees data. */
type Degrees = {
  undergraduate: {
    degreeName: string;
    title: string;
    description: string;
    concentrations: string[];
  }[];
  graduate: {
    degreeName: string;
    title?: string;
    description?: string;
    concentrations?: string[];
    availableCertificates?: string[];
  }[];
};

/**
 * Hook to fetch degrees data.
 * @returns An object containing the degrees data, loading state, and error.
 */
export const useDegrees = () => {
  const { data, isLoading, error } = useSWR<Degrees>(
    `${iSchool.iSchoolURL}degrees`,
  );
  return { data, isLoading, error };
};
