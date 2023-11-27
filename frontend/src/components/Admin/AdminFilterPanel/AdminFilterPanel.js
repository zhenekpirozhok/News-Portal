import React, { useState } from "react";
import { Flex, Button } from "antd";
import { DatePicker, Select, Input } from "antd";
import { PlusCircleFilled } from '@ant-design/icons';
import AddNewsWindow from '../AddNewsWindow/AddNewsWindow';
import "./AdminFilterPanel.css";

const { Option } = Select;

const AdminFilterPanel = ({ onDateFilterChange, onAuthorFilterChange, onAddClick }) => {
  const [isAddNewsModalVisible, setAddNewsModalVisible] = useState(false);

  const handleDateFilterChange = (date, dateString) => {
    onDateFilterChange(dateString);
  };

  const handleAuthorFilterChange = (value) => {
    onAuthorFilterChange(value);
  };

  const handleAddClick = () => {
    setAddNewsModalVisible(true);
  };

  const handleAddNewsCancel = () => {
    setAddNewsModalVisible(false);
  };

  return (
    <Flex className="filter-panel" align="center" gap={50}>
      <h3>Filters</h3>
      <Flex className="filter-section" gap={10} align="center">
        <label>Date:</label>
        <DatePicker onChange={handleDateFilterChange} />
      </Flex>
      <Flex className="filter-section" gap={10} align="center">
        <label>Author:</label>
        <Select
          showSearch
          style={{ width: 200 }}
          placeholder="Select author"
          onChange={handleAuthorFilterChange}
          optionFilterProp="children"
          filterOption={(input, option) =>
            option.children.toLowerCase().indexOf(input.toLowerCase()) >= 0
          }
        >
          <Option value="author1">Author 1</Option>
          <Option value="author2">Author 2</Option>
          {/* Add more authors as needed */}
        </Select>
        <Button className="add-button" icon={<PlusCircleFilled style={{ fontSize: "24px", marginLeft: '10px' }} />} onClick={handleAddClick}></Button>
      </Flex>

      {isAddNewsModalVisible && (
        <AddNewsWindow
          visible={isAddNewsModalVisible}
          onCancel={handleAddNewsCancel}
          onDateFilterChange={onDateFilterChange}
          onAuthorFilterChange={onAuthorFilterChange}
        />
      )}
    </Flex>
  );
};

export default AdminFilterPanel;
