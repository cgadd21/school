import { useEffect, useState } from 'react';
import './App.css';
import { PeopleTabs } from './components/PeopleTabs';
import { getData } from './utils/getData';

const App = () => {
  const [loaded, setLoaded] = useState(false);
  const [aboutObj, setAboutObj] = useState();

  useEffect(() => {
    getData('about').then((about) => {
      console.log(about);
      setAboutObj(about);
      setLoaded(true);
    });
  }, []);

  if (!loaded)
    return (
      <>
        <h1>Welcome to the iSchool</h1>
        <div>Loading...</div>
      </>
    );

  return (
    <>
      <div className="Sticky">
        <h1>Welcome to the iSchool</h1>
        <div>Menu...</div>
      </div>

      <div className="App">
        <div className="About">
          <h2>{aboutObj.title}</h2>
          <h3>{aboutObj.description}</h3>
          <div className="AboutQuote">
            <h4 className="Quote">{aboutObj.quote}</h4>
            <h4>--{aboutObj.quoteAuthor}</h4>
          </div>
        </div>
        <hr />
        <PeopleTabs />
        <hr />
      </div>
    </>
  );
};

export default App;
