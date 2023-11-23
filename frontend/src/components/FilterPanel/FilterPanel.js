import React from "react";
import { Flex } from "antd";
import { DatePicker, Select } from "antd";
import "./FilterPanel.css";

const FilterPanel = ({ onDateFilterChange, onNewsPerPageChange }) => {
  const handleDateFilterChange = (date, dateString) => {
    onDateFilterChange(dateString);
  };

  const handleNewsPerPageChange = (value) => {
    onNewsPerPageChange(value);
  };

  return (
    <Flex className="filter-panel" align="center" gap={50}>
      <h3>Filters</h3>
      <Flex className="filter-section" gap={10} align="center">
        <label>Date:</label>
        <DatePicker onChange={handleDateFilterChange} />
      </Flex>
      <Flex className="filter-section" gap={10} align="center">
        <label>News per Page:</label>
        <Select
          defaultValue="10"
          onChange={handleNewsPerPageChange}
          options={[
            {
              label: "10",
              value: 10,
            },
            {
              label: "20",
              value: 20,
            },
            {
              label: "30",
              value: 30,
            },
          ]}
        />
      </Flex>
    </Flex>
  );
};

export default FilterPanel;
