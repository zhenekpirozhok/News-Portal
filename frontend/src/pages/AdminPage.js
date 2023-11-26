import React, { useState } from "react";
import { Layout, Menu, Flex } from "antd";
import { UserOutlined, DiffOutlined } from "@ant-design/icons";
import SidePanel from "../components/Admin/SiderPanel/SiderPanel";
import AdminFilterPanel from "../components/Admin/AdminFilterPanel/AdminFilterPanel";

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
            {selectedTab === "users" && (
              <div>
                {/* Render content for the "Users" tab */}
                <AdminFilterPanel />
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
        </Content>
        <Footer style={{ textAlign: "center" }}>
          ©2023 EPAM ESDE News Portal
        </Footer>
      </Layout>
    </Layout>
  );
};

export default AdminPage;
