// Parent component rendering a list of users
import React from "react";
import WaitListLine from "./OneLine/WaitListLine";
import { Typography, Divider } from "antd";

const { Title } = Typography;

const WaitListPage = ({ users, onEdit, onDelete }) => {
  return (
    <div>
      <Title level={2}>Waiting Users</Title>
      <Divider />
      {users.map((user) => (
        <WaitListLine
          key={user.id}
          user={user}
          onEdit={onEdit}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
};

export default WaitListPage;
