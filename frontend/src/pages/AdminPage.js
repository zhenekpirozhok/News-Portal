import React, { useState } from "react";
import { Layout, Menu, Flex } from "antd";
import { UserOutlined, DiffOutlined } from "@ant-design/icons";
import SidePanel from "../components/Admin/SiderPanel/SiderPanel";
import AdminFilterPanel from "../components/Admin/AdminFilterPanel/AdminFilterPanel";
import { useSelector } from "react-redux";
import store from "../redux/store";
import AddNewsWindow from "../components/Admin/AddNewsWindow/AddNewsWindow";
import NewsPage from "../components/Admin/NewsPage";
import news from "../mockData/news.json";

const { Header, Content, Footer, Sider } = Layout;

const AdminPage = () => {

  const selectedTab = useSelector((state) => state.adminMenu.selectedMenuItem);

  return (
    <Layout style={{ minHeight: "100vh" }}>
      <SidePanel />
      <Layout>
        <Header style={{ padding: 0, background: "#001529" }} />
        <Content style={{ margin: "24px 16px 0" }}>
            {selectedTab === '1' && (
              <div>
                <AddNewsWindow />
                <NewsPage newsList={news}/>
              </div>
            )}

            {selectedTab === '2' && (
              <div>
                <h2>Users Tab Content</h2>
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
