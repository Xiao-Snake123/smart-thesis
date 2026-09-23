/**
 * 网站底部版权信息组件
 */

import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import React from 'react';
import { Divider } from 'antd';

const Footer: React.FC = () => {
  const currentYear = new Date().getFullYear();
  return (
    <>
      <Divider />
      <DefaultFooter
        style={{
          background: 'none',
        }}
        links={[
          {
            key: 'github',
            title: <GithubOutlined />,
            href: 'https://github.com/Xiao-Snake123/smart-thesis',
            blankTarget: true,
          },
        ]}
        copyright={`${currentYear} 智选论题`}
      />
    </>
  );
};

export default Footer;
