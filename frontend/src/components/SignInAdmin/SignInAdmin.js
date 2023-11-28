import React from "react";
import { Form, Input, Button, Checkbox } from "antd";
import "../SignInForm/SignInForm"; // Import your CSS file

const SignInAdmin = () => {
  const onFinish = (values) => {
    console.log("Received values:", values);
    // You can add your sign-in logic here
  };

  const style = {
    width: "300px",
    textAlign: "center",
    fontSize: "12px",
    marginTop: "0",
  };

  return (
    <div className="signin-container">
      <h2 className="signin-form-title">Sign in as Admin</h2>
      <p style={style}>
        (Your request will be send to wait list for other admin to approve if
        you're new)
      </p>
      <Form
        name="signin-form"
        initialValues={{ remember: true }}
        onFinish={onFinish}
        className="signin-form"
      >
        <Form.Item
          label="Username"
          name="username"
          rules={[{ required: true, message: "Please input your username!" }]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          label="Password"
          name="password"
          rules={[{ required: true, message: "Please input your password!" }]}
        >
          <Input.Password />
        </Form.Item>

        <Form.Item>
          <Form.Item name="remember" valuePropName="checked" noStyle>
            <Checkbox>Remember me</Checkbox>
          </Form.Item>
        </Form.Item>

        <Form.Item>
          <a href="/confirmationPage">
            <Button
              type="primary"
              htmlType="submit"
              className="signin-form-button"
            >
              Sign In
            </Button>
          </a>
        </Form.Item>
      </Form>
    </div>
  );
};

export default SignInAdmin;
