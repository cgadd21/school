import useSWR from 'swr';
import { iSchool } from '../api/iSchool';

/** Represents the structure of the employment data. */
type Employment = {
  introduction: {
    title: string;
    content: {
      title: string;
      description: string;
    }[];
  };
  degreeStatistics: {
    title: string;
    statistics: {
      value: string;
      description: string;
    }[];
  };
  employers: {
    title: string;
    employerNames: string[];
  };
  careers: {
    title: string;
    careerNames: string[];
  };
  coopTable: {
    title: string;
    coopInformation: {
      employer: string;
      degree: string;
      city: string;
      term: string;
    }[];
  };
  employmentTable: {
    title: string;
    professionalEmploymentInformation: {
      employer: string;
      degree: string;
      city: string;
      title: string;
      startDate: Date;
    }[];
  };
};

/**
 * Hook to fetch employment data.
 * @returns An object containing the employment data, loading state, and error.
 */
export const useEmployment = () => {
  const { data, isLoading, error } = useSWR<Employment>(
    `${iSchool.iSchoolURL}employment`,
  );
  return { data, isLoading, error };
};
