// MyComponent.js

import React, { useEffect } from 'react';

const MyComponent = () => {
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('https://d0a8-78-62-142-17.ngrok-free.app/api/data');
        const data = await response.json();
        console.log(data);
      } catch (error) {
        console.error('Error:', error);
      }
    };

    fetchData();
  }, []); // Empty dependency array means this effect runs once after the initial render

  return (
    <div>
      {/* Your component's UI goes here */}
    </div>
  );
};

export default MyComponent;
