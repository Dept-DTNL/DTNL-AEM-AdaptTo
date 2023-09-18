const { createWebpackAliases } = require('./utils/create-webpack-aliases')
const { pathsToModuleNameMapper } = require('ts-jest/utils')
const { compilerOptions } = require('./tsconfig.base.json')
const CracoSwcPlugin = require('craco-swc')

module.exports = {
  reactScriptsVersion: 'react-scripts',
  webpack: {
    configure: (webpackConfig, { env }) => {
      if (env === 'development') {
        webpackConfig.mode = 'development'
        webpackConfig.target = 'web'
        webpackConfig.optimization.minimize = false
        webpackConfig.optimization.minimizer = []
        webpackConfig.cache = {
          type: 'memory',
        }
      }

      if (env === 'production') {
        webpackConfig.cache = {
          type: 'filesystem',
        }
      }

      webpackConfig.performance = {
        hints: 'warning',
      }

      webpackConfig.resolve.alias = {
        ...webpackConfig.resolve.alias,
        ...createWebpackAliases(),
      }

      // Remove ModuleScopePlugin
      webpackConfig.resolve.plugins = webpackConfig.resolve.plugins.filter(
        ({ constructor }) => constructor && constructor.name !== 'ModuleScopePlugin',
      )

      webpackConfig.module.rules.push({
        test: /\.(woff|woff2|eot|ttf|otf)$/i,
        type: 'asset/resource',
      })

      return webpackConfig
    },
  },
  plugins: [
    {
      plugin: {
        ...CracoSwcPlugin,
        overrideCracoConfig: ({ cracoConfig }) => {
          if (typeof cracoConfig.eslint.enable !== 'undefined') {
            cracoConfig.disableEslint = !cracoConfig.eslint.enable
          }
          delete cracoConfig.eslint
          return cracoConfig
        },
        overrideWebpackConfig: ({ webpackConfig, cracoConfig }) => {
          if (
            typeof cracoConfig.disableEslint !== 'undefined' &&
            cracoConfig.disableEslint === true
          ) {
            webpackConfig.plugins = webpackConfig.plugins.filter(
              instance => instance.constructor.name !== 'ESLintWebpackPlugin',
            )
          }

          return webpackConfig
        },
      },
      options: {
        swcLoaderOptions: {
          jsc: {
            externalHelpers: true,
            target: 'es2015',
            parser: {
              syntax: 'typescript',
              tsx: true,
              dynamicImport: true,
              exportDefaultFrom: true,
            },
          },
        },
      },
    },
  ],
  devServer: devServerConfig => {
    devServerConfig.allowedHosts = 'all'
    return devServerConfig
  },
  jest: {
    configure: {
      moduleNameMapper: pathsToModuleNameMapper(compilerOptions.paths, { prefix: '<rootDir>/' }),
    },
  },
}
