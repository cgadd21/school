import { useMinors } from '../../../hooks/use.minors';
import { Course } from './course';
import { Failed } from '../../shared/failed';
import { Loading } from '../../shared/loading';

/** Minors section component. */
export const Minors = () => {
  const { data, isLoading, error } = useMinors();

  return error ? (
    <Failed />
  ) : isLoading ? (
    <Loading />
  ) : (
    data && (
      <>
        <div className="collapse collapse-open bg-base-200 text-center">
          <input type="checkbox" />
          <div className="collapse-title text-xl font-medium">
            Undergraduate
          </div>
          <div className="collapse-content">
            {data.UgMinors.slice()
              .sort((a, b) => a.title.localeCompare(b.title))
              .map((ugMinor, idx) => (
                <div
                  className="collapse collapse-arrow border border-base-300 bg-base-200"
                  key={idx}
                >
                  <input type="checkbox" />
                  <div className="collapse-title text-xl font-medium">
                    {ugMinor.title}
                  </div>
                  <div className="collapse-content space-y-4">
                    <p>{ugMinor.description}</p>
                    <div>
                      <p>{ugMinor.name} Courses</p>
                      <div className="join">
                        <div className="join-item">
                          {ugMinor.courses
                            .slice()
                            .sort((a, b) => a.localeCompare(b))
                            .map((course, idx) => (
                              <Course key={idx} id={idx} courseName={course} />
                            ))}
                        </div>
                      </div>
                    </div>
                    {ugMinor.note && <p>{ugMinor.note}</p>}
                  </div>
                </div>
              ))}
          </div>
        </div>
      </>
    )
  );
};
