// NewsLine.js
import React, { useState } from "react";
import { Row, Col, Card, Button, Space, Typography, Modal } from "antd";
import AddNewsWindow from "../AddNewsWindow/AddNewsWindow";

const { Text } = Typography;

const NewsLine = ({ news, onEdit, onDelete }) => {
  const { title, date } = news;
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [isAddNewsModalVisible, setAddNewsModalVisible] = useState(false);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    onDelete(news.id);
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  const handleAddClick = () => {
    setAddNewsModalVisible(true);
  };

  const handleAddNewsCancel = () => {
    setAddNewsModalVisible(false);
  };

  return (
    <Card>
      <Row gutter={[16, 16]} justify="space-between" align="middle">
        <Col xs={24} sm={24} md={18} lg={20}>
          <Space direction="vertical" size="small">
            <Text strong>{title}</Text>
            <Text type="secondary">Date: {date}</Text>
          </Space>
        </Col>
        <Col xs={24} sm={24} md={6} lg={4}>
          <Space>
            <Button type="primary" onClick={handleAddClick}>
              Edit
            </Button>
            <Button danger onClick={showModal}>
              Delete
            </Button>
          </Space>
        </Col>
        <Modal
          title="Delete News"
          visible={isModalVisible}
          onOk={handleOk}
          onCancel={handleCancel}
          okText="Delete"
          cancelText="Cancel"
        >
          <p>Are you sure you want to delete the news "{news.title}"?</p>
        </Modal>

        <AddNewsWindow
          visible={isAddNewsModalVisible}
          onCancel={handleAddNewsCancel}
        />
      </Row>
    </Card>
  );
};

export default NewsLine;
