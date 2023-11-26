import React from "react";
import { Form, Input, Button, Checkbox } from "antd";
import "./SignInForm.css"; // Import your CSS file

const SignInForm = () => {
  const onFinish = (values) => {
    console.log("Received values:", values);
    // You can add your sign-in logic here
  };

  return (
    <div className="signin-container">
      <h2 className="signin-form-title">Sign in to enjoy all functionality!</h2>
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
          <Button
            type="primary"
            htmlType="submit"
            className="signin-form-button"
          >
            Sign In
          </Button>
          Or <a href="/">register now!</a>
        </Form.Item>
      </Form>
    </div>
  );
};

export default SignInForm;
