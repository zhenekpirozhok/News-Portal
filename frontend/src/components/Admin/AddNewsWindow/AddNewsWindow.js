import React, { useState } from "react";
import { Modal, Form, Input, Button, Upload, message } from "antd";
import { PlusOutlined, UploadOutlined } from "@ant-design/icons";

const AddNewsWindow = ({ visible, onCancel, onAddNews }) => {
  const [form] = Form.useForm();
  const [fileList, setFileList] = useState([]);

  const handleFileChange = (info) => {
    if (info.file.status === "done") {
      message.success(`${info.file.name} file uploaded successfully`);
    } else if (info.file.status === "error") {
      message.error(`${info.file.name} file upload failed.`);
    }
    setFileList(info.fileList);
  };

  const onFinish = (values) => {
    // You can perform the logic to post the news with the collected values
    onAddNews(values, fileList);
    form.resetFields();
    setFileList([]);
  };

  return (
    <Modal
      visible={visible}
      title="Add News"
      onCancel={onCancel}
      footer={[
        <Button key="cancel" onClick={onCancel}>
          Cancel
        </Button>,
        <Button style = {{backgroundColor: 'black'}} key="post" type="primary" onClick={form.submit}>
          Post
        </Button>,
      ]}
    >
      <Form form={form} onFinish={onFinish} layout="vertical">
        <Form.Item
          name="authorName"
          label="Author Name"
          rules={[
            { required: true, message: "Please enter the author's name" },
          ]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          name="newsTitle"
          label="News Title"
          rules={[{ required: true, message: "Please enter the news title" }]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          name="tags"
          label="Assign Tags"
          rules={[{ required: true, message: "Please enter the news title" }]}
        >
          <Input />
        </Form.Item>

        <Form.Item
          name="content"
          label="Content"
          rules={[{ required: true, message: "Please enter the news content" }]}
        >
          <Input.TextArea rows={4} />
        </Form.Item>

        <Form.Item
          name="attachments"
          valuePropName="fileList"
          getValueFromEvent={handleFileChange}
        >
          <Upload
            customRequest={() => {}}
            showUploadList={{ showRemoveIcon: false }}
            fileList={fileList}
            beforeUpload={() => false}
          >
            <Button icon={<UploadOutlined />}>Attach Files</Button>
          </Upload>
        </Form.Item>
      </Form>
    </Modal>
  );
};

export default AddNewsWindow;
