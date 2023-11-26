// SiderPanel.js
import React from 'react';
import { Layout, Menu } from 'antd';
import { UserOutlined, FileOutlined } from '@ant-design/icons';
import './SiderPanel.css';

const { Sider } = Layout;

const SiderPanel = () => {
  return (
    <Sider
      breakpoint="lg"
      collapsedWidth="0"
      onBreakpoint={(broken) => {
        console.log(broken);
      }}
      onCollapse={(collapsed, type) => {
        console.log(collapsed, type);
      }}
    >
      <div className="demo-logo-vertical" />
      <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
        <Menu.Item key="1" icon={<FileOutlined />}>
          News
        </Menu.Item>
        <Menu.Item key="2" icon={<UserOutlined />}>
          Users
        </Menu.Item>
      </Menu>
    </Sider>
  );
};

export default SiderPanel;
