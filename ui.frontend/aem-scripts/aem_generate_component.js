const fs = require('fs')
const { templateComponent, templateScss, templateTypes } = require('./aem_component_templates')

// grab component name from terminal argument
const [name] = process.argv.slice(2)
if (!name) throw new Error('You must include a component name.')

const dir = `./src/components/${name}/`

// throw an error if the file already exists
if (fs.existsSync(dir)) throw new Error('A component with that name already exists.')

// create the folder
fs.mkdirSync(dir)

function writeFileErrorHandler(err) {
  if (err) throw err
}

let kebabCase = str =>
  str
    .match(/[A-Z]{2,}(?=[A-Z][a-z]+[0-9]*|\b)|[A-Z]?[a-z]+[0-9]*|[A-Z]|[0-9]+/g)
    .map(x => x.toLowerCase())
    .join('-')

// component.tsx
fs.writeFile(`${dir}/${name}.tsx`, templateComponent(name), writeFileErrorHandler)
// component.scss
fs.writeFile(`${dir}/${name}.scss`, templateScss(name), writeFileErrorHandler)
// component-data.ts
fs.writeFile(`${dir}/${kebabCase(name)}-data.ts`, templateTypes(name), writeFileErrorHandler)
