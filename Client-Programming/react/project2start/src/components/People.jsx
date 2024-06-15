import { useEffect, useState } from 'react';
import './People.css';
import { getData } from '../utils/getData';

export const People = () => {
  const [loaded, setLoaded] = useState(false);
  const [peopleObj, setPeopleObj] = useState();

  useEffect(() => {
    getData('people').then((people) => {
      console.log(people);
      setPeopleObj(people);
      setLoaded(true);
    });
  }, []);

  if (!loaded) {
    return <h1>Loading People...</h1>;
  }

  return (
    <>
      <h1>{peopleObj.title}</h1>
      <h3>{peopleObj.subTitle}</h3>
      <h3>Faculty</h3>
      <div className="peopleList">
        {peopleObj.faculty.map((p) => [
          <div className="peopleListItem" key={p.email}>
            <h3>{p.name}</h3>
            <img src={p.imagePath} alt="person" />
          </div>,
        ])}
      </div>
      <h3>Staff</h3>
      <div className="peopleList">
        {peopleObj.staff.map((p) => {
          return (
            <div className="peopleListItem" key={p.email}>
              <h3>{p.name}</h3>
              <img src={p.imagePath} alt="person" />
            </div>
          );
        })}
      </div>
    </>
  );
};
