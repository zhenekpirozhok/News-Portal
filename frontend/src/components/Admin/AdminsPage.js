// Parent component rendering a list of users
import React from "react";
import AdminsLine from "./OneLine/AdminsLine";
import { Typography, Divider } from 'antd';

const { Title } = Typography;

const AdminsPage = ({ users, onEdit, onDelete }) => {
  return (
    <div>
      <Title level={2}>Admins</Title>
      <Divider />
      {users.map((user) => (
        <AdminsLine
          key={user.id}
          user={user}
          onEdit={onEdit}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
};

export default AdminsPage;
