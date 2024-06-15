import { Welcome } from './components/Welcome';
import { Welcome2 } from './components/Welcome2';
import './App.css';
import { useState } from 'react';

function App() {
  const [loaded, setloaded] = useState(false);
  const [dataObj, setDataObj] = useState();

  const getData = () => {
    setDataObj({
      title: 'React is FUN!',
      description: 'lots and lots of words.',
    });
    setloaded(true);
  };

  if (!loaded) {
    return (
      <>
        <Welcome name="Jill" />
        <Welcome name="Joe" />
        <p>Loading...</p>
        <button onClick={getData}>Get Data</button>
      </>
    );
  }

  return (
    <>
      <h1>Data!</h1>
      <h2>{dataObj.title}</h2>
      <h3>{dataObj.description}</h3>

      <Welcome name="Jill" />
      <Welcome name="Joe" />
      <Welcome2 name="Dan" job="talk" myStyle="myStyle" />
      <Welcome2 name="Fred" job="boss" myStyle="otherStyle" />
    </>
  );
}

export default App;
