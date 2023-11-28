import React from "react";
import { Form, Input, Button, Checkbox } from "antd";
import "./SignInForm.css"; // Import your CSS file
import { useDispatch } from "react-redux";
import { login } from "../../redux/auth/actions";
import { useNavigate } from "react-router-dom";


const SignInForm = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const onSignIn = (values) => {
    const result = values;
    console.log("Received values:", result);
    dispatch(login(result.username));
    navigate("/");
  };

  return (
    <div className="signin-container">
      <h2 className="signin-form-title">Sign in to enjoy all functionality!</h2>
      <Form
      onFinish={onSignIn}
        name="signin-form"
        initialValues={{ remember: true }}
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
          <a style={{ marginTop: "80px" }} href="/register">
            Register now!
          </a>{" "}
          or<a href="/signInAdmin"> Sign in as admin</a>
        </Form.Item>
      </Form>
    </div>
  );
};

export default SignInForm;
