function template({ template }, _opts, { componentName, jsx }) {
  const typeScriptTpl = template.smart({ plugins: ['typescript'] })

  componentName.name = componentName.name.slice(3) + 'Icon'

  return typeScriptTpl.ast`
    import React, { forwardRef } from 'react';
  
  
    const ${componentName} = forwardRef<SVGSVGElement>(({ ...props }, svgRef) => {
      return ${jsx};
    })
  
    export default ${componentName};
  `
}
module.exports = template
