import { useEffect, useState } from 'react';

/** Represents the words being cycled through. */
const items = ['iSchool', '@', 'RIT'];

/** Index section component. */
export const Index = () => {
  const [selectedItem, setSelectedItem] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      const nextIndex =
        selectedItem + 1 > items.length - 1 ? 0 : selectedItem + 1;
      setSelectedItem(nextIndex);
    }, 2000); //2 seconds

    return () => {
      clearInterval(interval);
    };
  }, [selectedItem]);

  return (
    <div className="diff aspect-[16/9]">
      <div className="diff-item-1">
        <div className="bg-primary text-primary-content text-9xl font-black grid place-content-center">
          <p className="animate-pulse">{items[selectedItem]}</p>
        </div>
      </div>
      <div className="diff-item-2">
        <div className="bg-base-200 text-9xl font-black grid place-content-center">
          <p className="animate-pulse">{items[selectedItem]}</p>
        </div>
      </div>
      <div className="diff-resizer"></div>
    </div>
  );
};
