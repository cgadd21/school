import useSWR from 'swr';
import { iSchool } from '../api/iSchool';

/** Represents the structure of the people data. */
type People = {
  title: string;
  subTitle: string;
  faculty: person[];
  staff: person[];
};

/** Represents the structure of a person */
type person = {
  username: string;
  name: string;
  tagline: string;
  imagePath: string;
  title: string;
  interestArea: string;
  office: string;
  website: string;
  phone: string;
  email: string;
  twitter: string;
  facebook: string;
};

/**
 * Hook to fetch people data.
 * @returns An object containing the people data, loading state, and error.
 */
export const usePeople = () => {
  const { data, isLoading, error } = useSWR<People>(
    `${iSchool.iSchoolURL}people`,
  );
  return { data, isLoading, error };
};
