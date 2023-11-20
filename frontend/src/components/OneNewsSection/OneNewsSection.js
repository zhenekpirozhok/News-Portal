import React from 'react';

const OneNewsSection = ({ children }) => {
  const sectionStyle = {
    padding: '60px 60px',
  };

  return <section style={sectionStyle}>{children}</section>;
};

export default OneNewsSection;