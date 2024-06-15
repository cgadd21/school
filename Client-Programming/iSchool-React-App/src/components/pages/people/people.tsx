import { usePeople } from '../../../hooks/use.people';
import { Person } from './person';
import { Failed } from '../../shared/failed';
import { Loading } from '../../shared/loading';

/** People section component. */
export const People = () => {
  const { data, isLoading, error } = usePeople();

  return error ? (
    <Failed />
  ) : isLoading ? (
    <Loading />
  ) : (
    data && (
      <>
        <div className="collapse bg-base-200 text-center collapse-open">
          <input type="checkbox" />
          <div className="collapse-title text-xl font-medium">
            <h1>{data.title}</h1>
            <p>{data.subTitle}</p>
          </div>
          <div className="collapse-content">
            <div className="flex justify-center">
              <div className="mx-auto">
                <div className="collapse bg-base-200 text-center collapse-open">
                  <input type="checkbox" />
                  <div className="collapse-title text-xl font-medium">
                    Faculty
                  </div>
                  <div className="collapse-content">
                    {data.faculty
                      .slice()
                      .sort((a, b) => a.name.localeCompare(b.name))
                      .map((faculty) => (
                        <div key={faculty.username}>
                          <div className="card w-96 bg-base-100 shadow-xl">
                            <figure className="px-10 pt-10">
                              <img
                                src={faculty.imagePath}
                                alt="person"
                                className="w-48 h-48 object-cover"
                              />
                            </figure>
                            <div className="card-body items-center text-center">
                              <h2 className="card-title">{faculty.name}</h2>
                              {faculty.title && <p>{faculty.title}</p>}
                              <div className="card-actions">
                                <Person person={faculty} />
                              </div>
                            </div>
                          </div>
                          <br />
                        </div>
                      ))}
                  </div>
                </div>
              </div>
              <div className="mx-auto">
                <div className="collapse bg-base-200 text-center collapse-open">
                  <input type="checkbox" />
                  <div className="collapse-title text-xl font-medium">
                    Staff
                  </div>
                  <div className="collapse-content">
                    {data.staff
                      .slice()
                      .sort((a, b) => a.name.localeCompare(b.name))
                      .map((staff) => (
                        <div key={staff.username}>
                          <div className="card w-96 bg-base-100 shadow-xl">
                            <figure className="px-10 pt-10">
                              <img
                                src={staff.imagePath}
                                alt="person"
                                className="w-48 h-48 object-cover"
                              />
                            </figure>
                            <div className="card-body items-center text-center">
                              <h2 className="card-title">{staff.name}</h2>
                              {staff.title && <p>{staff.title}</p>}
                              <div className="card-actions">
                                <Person person={staff} />
                              </div>
                            </div>
                          </div>
                          <br />
                        </div>
                      ))}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    )
  );
};
