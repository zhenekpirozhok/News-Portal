import React from "react";
import { Form, Input, Button, Checkbox } from "antd";
import "./SignInForm.css"; // Import your CSS file
import { useDispatch } from "react-redux";
import { signIn } from "../../redux/auth/actions";
import { useState } from "react";

const SignInForm = () => {

  const onSignIn = (value) => {
    alert("Received values:", value);
    // You can add your sign-in logic here
  };
  

  return (
    <div className="signin-container">
      <h2 className="signin-form-title">Sign in to enjoy all functionality!</h2>
      <Form
        name="signin-form"
        initialValues={{ remember: true }}
        onFinish={(value) => onSignIn(value)}
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
           <a style={{marginTop: '80px'}} href="/register">Register now!</a> or<a href="/signInAdmin"> Sign in as admin</a>
        </Form.Item>
      </Form>
    </div>
  );
};

export default SignInForm;
