// NewsLine.js
import React from 'react';
import { Row, Col, Card, Button, Space, Typography } from 'antd';

const { Text } = Typography;

const NewsLine = ({ news, onEdit, onDelete }) => {
  const { title, date } = news;

  return (
    <Row gutter={[16, 16]} justify="start">
      <Col xs={24} sm={24} md={18} lg={20}>
        <Card>
          <Space direction="vertical" size="small">
            <Text strong>{title}</Text>
            <Text type="secondary">Date: {date}</Text>
          </Space>
        </Card>
      </Col>
      <Col xs={24} sm={24} md={6} lg={4}>
        <Space>
          <Button type="primary" onClick={() => onEdit(news.id)}>
            Edit
          </Button>
          <Button type="danger" onClick={() => onDelete(news.id)}>
            Delete
          </Button>
        </Space>
      </Col>
    </Row>
  );
};

export default NewsLine;
