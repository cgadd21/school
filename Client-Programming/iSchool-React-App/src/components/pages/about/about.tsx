import { useAbout } from '../../../hooks/use.about';
import { Failed } from '../../shared/failed';
import { Loading } from '../../shared/loading';

/** About section component. */
export const About = () => {
  const { data, isLoading, error } = useAbout();

  return error ? (
    <Failed />
  ) : isLoading ? (
    <Loading />
  ) : (
    data && (
      <>
        <div className="hero min-h-screen bg-base-200">
          <div className="hero-content text-center">
            <div className="max-w-md">
              <h1 className="text-5xl font-bold">{data.title}</h1>
              <p className="py-6">{data.description}</p>
              <p className="py-6">"{data.quote}"</p>
              <p className="py-6">--{data.quoteAuthor}</p>
            </div>
          </div>
        </div>
      </>
    )
  );
};
