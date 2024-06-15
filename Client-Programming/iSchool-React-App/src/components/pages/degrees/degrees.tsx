import { useDegrees } from '../../../hooks/use.degrees';
import { Failed } from '../../shared/failed';
import { Loading } from '../../shared/loading';

/** Degrees section component. */
export const Degrees = () => {
  const { data, isLoading, error } = useDegrees();

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
            <h1>Undergraduate</h1>
          </div>
          <div className="collapse-content">
            {data?.undergraduate
              .slice()
              .sort((a, b) => a.degreeName.localeCompare(b.degreeName))
              .map((ug) => (
                <div key={ug.degreeName}>
                  <div className="collapse collapse-arrow border border-base-300 bg-base-200">
                    <input type="checkbox" />
                    <div className="collapse-title text-xl font-medium">
                      <h1>
                        {ug.title} ({ug.degreeName.toUpperCase()})
                      </h1>
                    </div>
                    <div className="collapse-content space-y-4">
                      <p>{ug.description}</p>
                      <div>
                        <p>Concentrations</p>
                        <div className="join">
                          {ug.concentrations
                            .slice()
                            .sort((a, b) => a.localeCompare(b))
                            .map((concentration) => (
                              <div
                                className="join-item p-2"
                                key={concentration}
                              >
                                {concentration}
                              </div>
                            ))}
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              ))}
          </div>
        </div>
        <br />
        <div className="collapse bg-base-200 text-center collapse-open">
          <input type="checkbox" />
          <div className="collapse-title text-xl font-medium">
            <h1>Graduate</h1>
          </div>
          <div className="collapse-content">
            {data.graduate
              .slice()
              .sort((a, b) => a.degreeName.localeCompare(b.degreeName))
              .map((g) => (
                <div key={g.degreeName}>
                  <div className="collapse collapse-arrow border border-base-300 bg-base-200">
                    <input type="checkbox" />
                    <div className="collapse-title text-xl font-medium">
                      {g.title ? (
                        <h1>
                          {g.title} ({g.degreeName.toUpperCase()})
                        </h1>
                      ) : (
                        <h1>{g.degreeName.toUpperCase()}</h1>
                      )}
                    </div>
                    <div className="collapse-content space-y-4">
                      {g.description && <p>{g.description}</p>}
                      {g.concentrations && (
                        <div>
                          <p>Concentrations</p>
                          <div className="join">
                            {g.concentrations
                              .slice()
                              .sort((a, b) => a.localeCompare(b))
                              .map((concentration) => (
                                <div
                                  className="join-item p-2"
                                  key={concentration}
                                >
                                  {concentration}
                                </div>
                              ))}
                          </div>
                        </div>
                      )}
                      {g.availableCertificates && (
                        <div>
                          <h3>Certificates</h3>
                          <div className="join">
                            {g.availableCertificates
                              .slice()
                              .sort((a, b) => a.localeCompare(b))
                              .map((certificate) => (
                                <div
                                  className="join-item p-2"
                                  key={certificate}
                                >
                                  {certificate}
                                </div>
                              ))}
                          </div>
                        </div>
                      )}
                    </div>
                  </div>
                </div>
              ))}
          </div>
        </div>
      </>
    )
  );
};
