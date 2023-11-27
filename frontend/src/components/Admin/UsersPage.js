// Parent component rendering a list of users
import React from "react";
import UsersLine from "./OneLine/UsersLine";
import { Typography, Divider } from 'antd';

const { Title } = Typography;

const UserList = ({ users, onEdit, onDelete }) => {
  return (
    <div>
      <Title level={2}>Users</Title>
      <Divider />
      {users.map((user) => (
        <UsersLine
          key={user.id}
          user={user}
          onEdit={onEdit}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
};

export default UserList;
