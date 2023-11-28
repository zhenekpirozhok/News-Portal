import React, { useState } from "react";
import { Row, Col, Card, Button, Space, Typography, Modal, Switch } from "antd";

const { Text } = Typography;

const AdminsLine = ({ user, onEdit, onDelete }) => {
  const { username, userId } = user;
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [isAdminEnabled, setAdminEnabled] = useState(true);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    onDelete(userId);
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  const handleToggle = (checked) => {
    setAdminEnabled(checked);
  };

  return (
    <Card>
      <Row gutter={[16, 16]} justify="space-between" align="middle">
        <Col xs={24} sm={24} md={18} lg={20}>
          <Space direction="vertical" size="small">
            <Text strong>{username}</Text>
          </Space>
        </Col>
        <Col xs={24} sm={24} md={6} lg={4}>
          <Space>
            <p style={{marginLeft: '-90px'}}>Enable</p>
            <Switch checked={isAdminEnabled} onChange={handleToggle} style={{marginLeft: '-160px'}}/>
            <Button type="primary" onClick={() => onEdit(userId)}>
              Change role
            </Button>
            <Button danger onClick={showModal}>
              Delete
            </Button>
          </Space>
        </Col>
        <Modal
          title="Delete User"
          visible={isModalVisible}
          onOk={handleOk}
          onCancel={handleCancel}
          okText="Delete"
          cancelText="Cancel"
        >
          <p>Are you sure you want to delete the admin "{username}"?</p>
        </Modal>
      </Row>
    </Card>
  );
};

export default AdminsLine;
