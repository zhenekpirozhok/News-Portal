import React from "react";
import { Form, Input, Button } from "antd";
import "./RegisterForm.css"; // Import your CSS file

const RegisterForm = () => {
  const onFinish = (values) => {
    console.log("Received values:", values);
    // You can add your registration logic here
  };

  const validatePassword = (_, value) => {
    if (value && value.length < 8) {
      return Promise.reject("Password must be at least 8 characters");
    }
    return Promise.resolve();
  };

  return (
    <div className="register-container">
      <h2 className="register-form-title">Register for an account</h2>
      <Form
        name="register-form"
        onFinish={onFinish}
        className="register-form"
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
          rules={[
            { required: true, message: "Please input your password!" },
            { validator: validatePassword },
          ]}
        >
          <Input.Password />
        </Form.Item>

        <Form.Item
          label="Confirm Password"
          name="confirmPassword"
          dependencies={['password']}
          rules={[
            { required: true, message: "Please confirm your password!" },
            ({ getFieldValue }) => ({
              validator(_, value) {
                if (!value || getFieldValue('password') === value) {
                  return Promise.resolve();
                }
                return Promise.reject("Passwords do not match");
              },
            }),
          ]}
        >
          <Input.Password />
        </Form.Item>

        <Form.Item>
          <Button
            type="primary"
            htmlType="submit"
            className="register-form-button"
          >
            <a href="/">Register</a>
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default RegisterForm;
