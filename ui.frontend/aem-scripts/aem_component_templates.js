let kebabCase = str =>
  str
    .match(/[A-Z]{2,}(?=[A-Z][a-z]+[0-9]*|\b)|[A-Z]?[a-z]+[0-9]*|[A-Z]|[0-9]+/g)
    .map(x => x.toLowerCase())
    .join('-')

exports.templateComponent =
  name => `import { CoreContainerState } from '@adobe/aem-core-components-react-spa';
import { EditConfig, MappedComponentProperties } from '@adobe/aem-react-editable-components'
import DebugBar from '@partials/DebugBar/DebugBar'
import { Component } from 'react'
import { InView } from 'react-intersection-observer'

import { ${name}Types } from './${kebabCase(name)}-data'

require('./${name}.scss');

export type ${name}Props = ${name}Types

const isEmptyTest = (props: ${name}Props) => {
    return !props
}

export type ${name}State = {
    inView: boolean
} & Partial<CoreContainerState>

class ${name} extends Component<${name}Props, ${name}State> {
    constructor(props: ${name}Props) {
        super(props)

        this.state = {
            inView: false
        }
    }
    render() {
        if (isEmptyTest(this.props)) {
            return <DebugBar title="${name}" />
        }
        return (<InView
            className={this.state.inView ? 'section in-view' : 'section'}
            as="section"
            onChange={(inView: boolean) => this.setState({ inView: inView })}
            triggerOnce>
            <div className="${kebabCase(name)}">
                <div>Hello 👋, I am a ${name} component.</div>
            </div>
        </InView>)
    }
}

export const ${name}Config: EditConfig<${name}Props & MappedComponentProperties> = {
    emptyLabel: '${name} Component ',
    isEmpty: isEmptyTest
};

export default ${name};`

exports.templateScss = name => `@import '@assets/scss/base';

.${kebabCase(name)} {
    $module: '.${kebabCase(name)}';

}`

exports.templateTypes = name => `export type ${name}Types = {
  id?: string
}

export const ${
  name.split('')[0].toLowerCase() + name.split('').slice(1, name.length).join('')
}Data = (): ${name}Types => ({
    id: '${name}'
})`
