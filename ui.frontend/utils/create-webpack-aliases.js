const tsconfig = require('../tsconfig.base.json')
const path = require('path')

// get aliases from tsconfig
const aliases = tsconfig.compilerOptions.paths
const aliasKeys = Object.keys(aliases)

const stripSlashStar = string => string.replace('/*', '')

const createWebpackAliases = () =>
  aliasKeys.reduce((obj, key) => {
    const aliasPath = stripSlashStar(aliases[key][0]).replace('./', '')
    obj[stripSlashStar(key)] = path.join(process.cwd(), aliasPath)
    return obj
  }, {})

module.exports = {
  createWebpackAliases,
}
