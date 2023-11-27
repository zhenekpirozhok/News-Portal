// SiderPanel.js
import React from 'react';
import { Layout, Menu } from 'antd';
import { UserOutlined, FileOutlined, ClockCircleOutlined, FireOutlined } from '@ant-design/icons';
import './SiderPanel.css'; // Add your CSS file if needed
import { useDispatch } from 'react-redux';
import { setSelectedMenuItem } from '../../../redux/adminMenu/actions';

const { Sider } = Layout;

const SiderPanel = () => {
    const dispatch = useDispatch();

    const handleMenuClick = (menuItem) => {
      dispatch(setSelectedMenuItem(menuItem.key));
    };

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
      className='demo-sider'
    >
      <div className="demo-logo-vertical" />
      <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
        <Menu.Item key="1" icon={<FileOutlined />}
        onClick={() => handleMenuClick({ key: '1' })}>
          News
        </Menu.Item>
        <Menu.Item key="2" icon={<UserOutlined />}
        onClick={() => handleMenuClick({ key: '2' })}>
          Users
        </Menu.Item>
        <Menu.Item key="3" icon={<ClockCircleOutlined />}
        onClick={() => handleMenuClick({ key: '3' })}>
          Wait List
        </Menu.Item>
        <Menu.Item key="4" icon={<FireOutlined />}
        onClick={() => handleMenuClick({ key: '4' })}>
          Admins
        </Menu.Item>
      </Menu>
    </Sider>
  );
};

export default SiderPanel;
