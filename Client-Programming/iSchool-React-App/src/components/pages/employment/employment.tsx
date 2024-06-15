import { useState } from 'react';
import { useEmployment } from '../../../hooks/use.employment';
import { Failed } from '../../shared/failed';
import { Loading } from '../../shared/loading';

/** Employment section component. */
export const Employment = () => {
  const { data, isLoading, error } = useEmployment();

  const [pageCoop, setPageCoop] = useState(1);
  const [pageEmployer, setPageEmployer] = useState(1);

  return error ? (
    <Failed />
  ) : isLoading ? (
    <Loading />
  ) : (
    data && (
      <>
        <div className="collapse collapse-arrow border border-base-300 bg-base-200 text-center">
          <input type="radio" name="my-accordion-1" defaultChecked />
          <div className="collapse-title text-xl font-medium">
            {data.introduction.title}
          </div>
          <div className="collapse-content">
            {data.introduction.content.map((contnet) => (
              <div key={contnet.title}>
                <p>{contnet.title}</p>
                <p>{contnet.description}</p>
                <br />
              </div>
            ))}
          </div>
        </div>
        <div className="collapse collapse-arrow border border-base-300 bg-base-200 text-center">
          <input type="radio" name="my-accordion-1" />
          <div className="collapse-title text-xl font-medium">
            {data.degreeStatistics.title}
          </div>
          <div className="collapse-content">
            <div className="stats shadow">
              {data.degreeStatistics.statistics.map((statistic) => (
                <div className="stat place-items-center" key={statistic.value}>
                  <p className="stat-value">{statistic.value}</p>
                  <p className="">{statistic.description}</p>
                  <br />
                </div>
              ))}
            </div>
          </div>
        </div>
        <div className="collapse collapse-arrow border border-base-300 bg-base-200 text-center">
          <input type="radio" name="my-accordion-1" />
          <div className="collapse-title text-xl font-medium">
            {data.employers.title}
          </div>
          <div className="collapse-content flex justify-around">
            {data.employers.employerNames
              .slice()
              .sort((a, b) => a.localeCompare(b))
              .map((employerName) => (
                <div key={employerName}>
                  <p>{employerName}</p>
                </div>
              ))}
          </div>
        </div>
        <div className="collapse collapse-arrow border border-base-300 bg-base-200 text-center">
          <input type="radio" name="my-accordion-1" />
          <div className="collapse-title text-xl font-medium">
            {data.careers.title}
          </div>
          <div className="collapse-content flex justify-around">
            {data.careers.careerNames
              .slice()
              .sort((a, b) => a.localeCompare(b))
              .map((careerName) => (
                <div key={careerName}>
                  <p>{careerName}</p>
                </div>
              ))}
          </div>
        </div>
        <div className="collapse collapse-arrow border border-base-300 bg-base-200 text-center">
          <input type="radio" name="my-accordion-1" />
          <div className="collapse-title text-xl font-medium">
            {data.coopTable.title}
          </div>
          <div className="collapse-content">
            <div className="overflow-x-auto">
              <table className="table table-zebra">
                <thead>
                  <tr>
                    <th>Employer</th>
                    <th>Degree</th>
                    <th>City</th>
                    <th>Term</th>
                  </tr>
                </thead>
                <tbody>
                  {data.coopTable.coopInformation
                    .slice((pageCoop - 1) * 10, pageCoop * 10) //10 items per page
                    .map((coop, idx) => (
                      <tr className="hover" key={idx}>
                        <td>{coop.employer}</td>
                        <td>{coop.degree}</td>
                        <td>{coop.city}</td>
                        <td>{coop.term}</td>
                      </tr>
                    ))}
                </tbody>
              </table>
              <div className="join">
                <button
                  onClick={() => setPageCoop((prevPage) => prevPage - 1)}
                  disabled={pageCoop === 1}
                  className="join-item btn"
                >
                  {'«'}
                </button>
                <button className="join-item btn">Page {pageCoop}</button>
                <button
                  onClick={() => setPageCoop((prevPage) => prevPage + 1)}
                  //4 total pages
                  disabled={
                    pageCoop ===
                    Math.ceil(data!.coopTable.coopInformation.length / 10)
                  }
                  className="join-item btn"
                >
                  {'»'}
                </button>
              </div>
            </div>
          </div>
        </div>
        <div className="collapse collapse-arrow border border-base-300 bg-base-200 text-center">
          <input type="radio" name="my-accordion-1" />
          <div className="collapse-title text-xl font-medium">
            {data.employmentTable.title}
          </div>
          <div className="collapse-content">
            <div className="overflow-x-auto">
              <table className="table table-zebra">
                <thead>
                  <tr>
                    <th></th>
                    <th>Title</th>
                    <th>Employer</th>
                    <th>Degree</th>
                    <th>City</th>
                    <th>Start Date</th>
                  </tr>
                </thead>
                <tbody>
                  {data.employmentTable.professionalEmploymentInformation
                    .slice((pageEmployer - 1) * 10, pageEmployer * 10) //10 items per page
                    .map((pro, idx) => (
                      <tr className="hover" key={idx}>
                        <th>{idx + 1}</th>
                        <td>{pro.title}</td>
                        <td>{pro.employer}</td>
                        <td>{pro.degree}</td>
                        <td>{pro.city}</td>
                        <td>{pro.startDate.toString()}</td>
                      </tr>
                    ))}
                </tbody>
              </table>
              <div className="join">
                <button
                  onClick={() => setPageEmployer((prevPage) => prevPage - 1)}
                  disabled={pageEmployer === 1}
                  className="join-item btn"
                >
                  {'«'}
                </button>
                <button className="join-item btn">Page {pageEmployer}</button>
                <button
                  onClick={() => setPageEmployer((prevPage) => prevPage + 1)}
                  //4 total pages
                  disabled={
                    pageEmployer ===
                    Math.ceil(
                      data!.employmentTable.professionalEmploymentInformation
                        .length / 10,
                    )
                  }
                  className="join-item btn"
                >
                  {'»'}
                </button>
              </div>
            </div>
          </div>
        </div>
      </>
    )
  );
};
