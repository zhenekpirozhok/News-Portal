import React, { useState } from 'react';
import { Input, Button } from 'antd'; 
import './ShareOpinion.css'; 

const ShareOpinion = () => {
  const [opinion, setOpinion] = useState('');

  const handleInputChange = (e) => {
    setOpinion(e.target.value);
  };

  const handleShareOpinion = () => {
    // Add your logic to handle sharing the opinion
    console.log('Sharing opinion:', opinion);
    // Reset the input field after sharing
    setOpinion('');
  };

  const {TextArea} = Input;
  return (
    <div className="share-opinion-container">
      <h2 className="opinion-title">Wanna share your opinion?</h2>
      <TextArea
      rows={6}
        className="opinion-input"
        placeholder="Leave a comment..."
        value={opinion}
        onChange={handleInputChange}
        style={{ verticalAlign: 'top' }} 
      />
      <Button className="share-button" type="primary" onClick={handleShareOpinion}>
        Send
      </Button>
    </div>
  );
};

export default ShareOpinion;
