import React from 'react';
import { Flex } from 'antd';
import { DatePicker, Space } from 'antd';

const FilterPanel = ({ onDateFilterChange, onNewsPerPageChange }) => {
  const handleDateFilterChange = (e) => {
    const selectedDate = e.target.value;
    onDateFilterChange(selectedDate);
  };

  const handleNewsPerPageChange = (e) => {
    const selectedNewsPerPage = e.target.value;
    onNewsPerPageChange(selectedNewsPerPage);
  };

  return (
    <Flex className="filter-panel">
      <h3>Filters</h3>
      <div className="filter-section">
        <label>Date:</label>
        <DatePicker onChange={handleDateFilterChange} />
      </div>
      <div className="filter-section">
        <label>News per Page:</label>
        <select onChange={handleNewsPerPageChange}>
          {/* Options for news per page */}
          <option value="24">24</option>
          <option value="48">48</option>
          <option value="96">96</option>
        </select>
      </div>
    </Flex>
  );
};

export default FilterPanel;
