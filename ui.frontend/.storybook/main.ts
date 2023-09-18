import type { StorybookConfig } from '@storybook/react-webpack5'
//import path from 'path'; // Import path from Node.js
const path = require("path");

const config: StorybookConfig = {
  //stories: ['../src/**/*.mdx', '../src/**/*.stories.@(js|jsx|mjs|ts|tsx)'],
  stories: ['../src/components/**/*.stories.@(js|jsx|mjs|ts|tsx)'],
  addons: [
    '@storybook/addon-links',
    '@storybook/addon-essentials',
    '@storybook/preset-create-react-app',
    '@storybook/addon-onboarding',
    '@storybook/addon-interactions',
  ],

  webpackFinal: async (config) => {
    // Ensure that config.resolve is defined
    config.resolve = config.resolve || {};
    // Add webpack alias for custom paths
    config.resolve.alias = config.resolve.alias || {};
    config.resolve.alias['@assets'] = path.resolve(__dirname, '../src/assets')
    config.resolve.alias['@constants'] = path.resolve(__dirname, '../src/constants')
    config.resolve.alias['@partials'] = path.resolve(__dirname, '../src/partials')
    config.resolve.alias['fonts'] = path.resolve(__dirname, '../src/assets/fonts')
    return config
  },
  framework: {
    name: '@storybook/react-webpack5',
    options: {},
  },
  docs: {
    autodocs: 'tag',
  },
  staticDirs: ['../public'],
}
export default config
