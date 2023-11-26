import React, { useState } from "react";
import { Layout, Menu, Flex } from "antd";
import { UserOutlined, DiffOutlined } from "@ant-design/icons";
import SidePanel from "../components/Admin/SidePanel/SidePanel";

const { Header, Content, Footer, Sider } = Layout;

const AdminPage = ({ children }) => {
  const [selectedTab, setSelectedTab] = useState("users");

  const handleMenuClick = (tab) => {
    setSelectedTab(tab);
  };

  return (
    <Layout style={{ minHeight: "100vh" }}>
      <SidePanel />
      <Layout>
        <Header style={{ padding: 0, background: "#001529" }} />
        <Content style={{ margin: "24px 16px 0" }}>
          <div style={{ padding: 24, minHeight: 360, background: "#fff" }}>
            <Menu
              mode="horizontal"
              selectedKeys={[selectedTab]}
              onClick={({ key }) => handleMenuClick(key)}
            >
              <Menu.Item key="users" icon={<UserOutlined />}>
                Users
              </Menu.Item>
              <Menu.Item key="news" icon={<DiffOutlined />}>
                News
              </Menu.Item>
            </Menu>

            {selectedTab === "users" && (
              <div>
                {/* Render content for the "Users" tab */}
                <h2>Users Tab Content</h2>
                {children}
              </div>
            )}

            {selectedTab === "news" && (
              <div>
                {/* Render content for the "News" tab */}
                <h2>News Tab Content</h2>
                {children}
              </div>
            )}
          </div>
        </Content>
        <Footer style={{ textAlign: "center" }}>
          ©2023 EPAM ESDE News Portal
        </Footer>
      </Layout>
    </Layout>
  );
};

export default AdminPage;
