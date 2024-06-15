import useSWR from 'swr';
import { iSchool } from '../api/iSchool';

/** Represents the structure of the course data. */
type Course = {
  courseID: string;
  title: string;
  description: string;
};

/**
 * Hook to fetch course data.
 * @returns An object containing the course data, loading state, and error.
 */
export const useCourse = (courseName: string) => {
  const { data, isLoading, error } = useSWR<Course>(
    `${iSchool.iSchoolURL}course/courseID=${courseName}`,
  );
  return { data, isLoading, error };
};
