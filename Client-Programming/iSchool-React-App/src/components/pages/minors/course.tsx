import { useCourse } from '../../../hooks/use.course';
import { Failed } from '../../shared/failed';
import { Loading } from '../../shared/loading';

/** Represents the course parameters. */
type CourseParameters = {
  id: number;
  courseName: string;
};

/** Course section component. */
export const Course = (courseParameters: CourseParameters) => {
  const { data, isLoading, error } = useCourse(courseParameters.courseName);

  return error ? (
    <Failed />
  ) : isLoading ? (
    <Loading />
  ) : (
    data && (
      <>
        <button
          className="btn"
          onClick={() =>
            (
              document.getElementById(
                `my_modal_${courseParameters.id}`,
              ) as HTMLDialogElement
            ).showModal()
          }
        >
          {courseParameters.courseName}
        </button>
        <dialog id={`my_modal_${courseParameters.id}`} className="modal">
          <div className="modal-box">
            <h3 className="font-bold text-lg">{data.courseID}</h3>
            {data.title && <p className="py-4">{data.title}</p>}
            {data.description && (
              <p className="py-4">Office: {data.description}</p>
            )}
          </div>
          <form method="dialog" className="modal-backdrop">
            <button>close</button>
          </form>
        </dialog>
      </>
    )
  );
};
