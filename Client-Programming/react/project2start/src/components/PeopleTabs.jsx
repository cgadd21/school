import React, { useEffect, useState } from 'react';
import { PeopleGroup } from './PeopleGroup';
import { TabPane, Tab } from 'semantic-ui-react';
import { getData } from '../utils/getData';

export const PeopleTabs = () => {
  const [loaded, setLoaded] = useState(false);
  const [peopleObj, setPeopleObj] = useState();
  const panes = [
    {
      menuItem: 'Faculty',
      render: () => (
        <TabPane>
          <PeopleGroup title="Faculty" whichGroup={peopleObj.faculty} />
        </TabPane>
      ),
    },
    {
      menuItem: 'Staff',
      render: () => (
        <TabPane>
          <PeopleGroup title="Staff" whichGroup={peopleObj.staff} />
        </TabPane>
      ),
    },
  ];

  useEffect(() => {
    getData('people').then((people) => {
      console.log(people);
      setPeopleObj(people);
      setLoaded(true);
    });
  }, []);

  return loaded ? (
    <>
      <h1>{peopleObj.title}</h1>
      <h3>{peopleObj.subTitle}</h3>
      <Tab panes={panes} />
    </>
  ) : (
    <>
      <h1>People loading...</h1>
    </>
  );
};
