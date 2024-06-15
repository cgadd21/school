import { EmailIcon } from '../../icons/email';
import { FacebookIcon } from '../../icons/facebook';
import { PhoneIcon } from '../../icons/phone';
import { TwitterIcon } from '../../icons/twitter';
import { WebsiteIcon } from '../../icons/website';

/** Represents the structure of a person */
type person = {
  username: string;
  name: string;
  tagline: string;
  imagePath: string;
  title: string;
  interestArea: string;
  office: string;
  website: string;
  phone: string;
  email: string;
  twitter: string;
  facebook: string;
};

/** Person section component. */
export const Person = ({ person }: { person: person }) => {
  return (
    person && (
      <>
        <button
          className="btn"
          onClick={() =>
            (
              document.getElementById(
                `my_modal_${person.username}`,
              ) as HTMLDialogElement
            ).showModal()
          }
        >
          More Info
        </button>
        <dialog id={`my_modal_${person.username}`} className="modal">
          <div className="modal-box">
            <h3 className="font-bold text-lg">{person.name}</h3>
            {person.tagline && <p className="py-4">{person.tagline}</p>}
            {person.office && <p className="py-4">Office: {person.office}</p>}
            {person.interestArea && (
              <p className="py-4">
                Interest Area: {person.interestArea.toUpperCase()}
              </p>
            )}
            <div className="join">
              {person.email && (
                <a
                  className="py-4 join-item mr-4"
                  href={`mailto:${person.email}`}
                >
                  <EmailIcon />
                </a>
              )}
              {person.phone && (
                <a className="py-4 join-item mr-4" href={`tel:${person.phone}`}>
                  <PhoneIcon />
                </a>
              )}
              {person.website && (
                <a
                  target="_blank"
                  className="py-4 join-item mr-4"
                  href={person.website}
                >
                  <WebsiteIcon />
                </a>
              )}
              {person.twitter && (
                <a
                  target="_blank"
                  className="py-4 join-item mr-4"
                  href={`https://twitter.com/${person.twitter}`}
                >
                  <TwitterIcon />
                </a>
              )}
              {person.facebook && (
                <a
                  target="_blank"
                  className="py-4 join-item mr-4"
                  href={`https://facebook.com/${person.facebook}`}
                >
                  <FacebookIcon />
                </a>
              )}
            </div>
          </div>
          <form method="dialog" className="modal-backdrop">
            <button>close</button>
          </form>
        </dialog>
      </>
    )
  );
};
