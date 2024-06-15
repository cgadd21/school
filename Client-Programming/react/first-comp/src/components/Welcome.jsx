//can pass in (props) which is a catch all object
export function Welcome({ name }) {
  return (
    <div>
      {/** probs.name */}
      <h1>Hello, {name}</h1>
    </div>
  );
}
