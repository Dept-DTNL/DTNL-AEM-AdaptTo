/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2018 Adobe Systems Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

// webpack.config.adobeio.js
const { default: merge } = require('webpack-merge')
const WebpackShellPluginNext = require('webpack-shell-plugin-next')

const baseConfig = require('./webpack.config.base')
const isTestEnvironment = process.env.NODE_ENV === 'test'

module.exports = merge(baseConfig, {
  entry: ['babel-polyfill', './src/server/aem-processor.ts'],
  output: {
    filename: isTestEnvironment ? '[name].js' : 'app.js',
    library: 'ssr',
  },
  plugins: [
    new WebpackShellPluginNext({
      onBuildEnd: { scripts: ['node ./aem-scripts/postWebhook.js'] },
    }),
  ],
})
