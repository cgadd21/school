import { PeopleModal } from './PeopleModal';

export const PeopleGroup = ({ title, whichGroup }) => {
  return (
    <>
      <h2>{title}</h2>
      <div className="peopleList">
        {whichGroup.map((person) => (
          <div className="peopleListItem" key={person.username}>
            <img src={person.imagePath} alt="person" />
            <PeopleModal {...person} />
          </div>
        ))}
      </div>
    </>
  );
};
