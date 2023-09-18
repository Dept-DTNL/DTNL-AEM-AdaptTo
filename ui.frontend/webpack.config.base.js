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
const path = require('path')

const CleanWebpackPlugin = require('clean-webpack-plugin')
const webpack = require('webpack')
const nodeExternals = require('webpack-node-externals')
const { createWebpackAliases } = require('./utils/create-webpack-aliases')

module.exports = {
  target: 'node',
  externals: nodeExternals({
    allowlist: [
      '.bin',
      'source-map-support/register',
      /\.(eot|woff|woff2|ttf|otf)$/,
      /\.(svg|png|jpg|jpeg|gif|ico)$/,
      /\.(mp4|mp3|ogg|swf|webp)$/,
      /\.(css|scss|sass|sss|less)$/,
      v =>
        v.indexOf('babel-plugin-universal-import') === 0 ||
        v.indexOf('react-universal-component') === 0,
    ],
  }),
  mode: 'development',
  // Output our app to the dist/ directory
  output: {
    globalObject: `typeof self !== 'undefined' ? self : this`,
    path: path.resolve(__dirname + '/dist'),
    publicPath: '/',
  },
  // Emit source maps so we can debug our code in the browser
  devtool: 'source-map',

  resolve: {
    extensions: ['.js', '.jsx', '.ts', '.tsx', '.scss'],
    // This allows you to set a fallback for where Webpack should look for modules.
    // We placed these paths second because we want `node_modules` to "win"
    // if there are any conflicts. This matches Node resolution mechanism.
    // https://github.com/facebook/create-react-app/issues/253
    modules: ['node_modules'],
    alias: {
      ...createWebpackAliases(),
    },
  },
  // Tell webpack to run our source code through Babel
  module: {
    rules: [
      {
        test: /\.[jt]sx?$/,
        enforce: 'post',
        loader: require.resolve('babel-loader'),
        options: {
          babelrc: false,
          presets: [['@babel/preset-env'], '@babel/react', '@babel/preset-typescript'],
          plugins: [['universal-import']],
        },
      },
      {
        test: /\.scss$/,
        use: [
          {
            loader: 'css-loader', // translates CSS into CommonJS
          },
          {
            loader: 'sass-loader', // compiles Sass to CSS
          },
        ],
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: 'css-loader', // translates CSS into CommonJS
          },
        ],
      },
      {
        test: /\.svg$/,
        type: 'asset/inline',
      },
      {
        test: /\.(woff|woff2|eot|ttf|otf)$/i,
        type: 'asset/resource',
        use: [
          {
            loader: 'file-loader',
            options: {
              name: '[name].[ext]',
              outputPath: 'fonts/', // Specify the output directory
            },
          },
        ],
      },
      {
        test: /\.(png)$/,
        type: 'asset/resource',
        use: [
          {
            loader: 'file-loader',
            options: {
              outputPath: 'assets/media/',
            },
          },
        ],
      },
    ],
  },

  // Use the plugin to specify the resulting filename (and add needed behavior to the compiler)
  plugins: [
    new CleanWebpackPlugin(['dist']),
    new webpack.optimize.LimitChunkCountPlugin({
      maxChunks: 1,
    }),
    new webpack.ProvidePlugin({
      React: 'react',
    }),
  ],
}
