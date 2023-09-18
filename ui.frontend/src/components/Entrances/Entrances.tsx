import { CoreContainerState } from '@adobe/aem-core-components-react-spa'
import { EditConfig, MappedComponentProperties } from '@adobe/aem-react-editable-components'
import ContentTile from '@partials/ContentTile/ContentTile'
import DebugBar from '@partials/DebugBar/DebugBar'
import { Component } from 'react'
import { InView } from 'react-intersection-observer'

import { EntrancesTypes } from './entrances-data'

require('./Entrances.scss')

export type EntrancesProps = EntrancesTypes

const isEmptyTest = (props: EntrancesProps) => {
  return (
    !props ||
    !props.content ||
    !props.content.headline ||
    !props.content.tiles ||
    !props.content.tiles.length
  )
}

type EntrancesState = {
  inView: boolean
} & Partial<CoreContainerState>

class Entrances extends Component<EntrancesProps, EntrancesState> {
  constructor(props: EntrancesProps) {
    super(props)

    this.state = {
      inView: false,
    }
  }

  render() {
    if (isEmptyTest(this.props)) {
      return <DebugBar title="Entrances" runMode={this.props?.runMode} />
    }

    let classNames
    switch (this.props.content?.tiles?.length) {
      case 1:
        classNames = 'entrances entrances--single'
        break
      case 2:
      case 4:
        classNames = 'entrances entrances--double'
        break
      default:
        classNames = 'entrances'
    }

    return (
      <InView
        className={this.state.inView ? 'section in-view' : 'section'}
        as="section"
        onChange={(inView: boolean) => this.setState({ inView: inView })}
        triggerOnce>
        <div className={classNames} id={this.props.content.id ? this.props.content.id : ''}>
          <div className="entrances__inner">
            <div className="entrances__content">
              {this.props.content.headline && (
                <div className="entrances__headline">
                  <h2>{this.props.content.headline}</h2>
                </div>
              )}
              {this.props.content.description && (
                <div className="entrances__description">
                  <p>{this.props.content.description}</p>
                </div>
              )}
            </div>

            {this.props.content.tiles && (
              <div className="entrances__tiles">
                <ul className="entrances__tiles__list">
                  {this.props.content.tiles.map((tile, index) => {
                    return (
                      <li className="entrances__tile" key={'entrancetile' + index}>
                        <ContentTile {...tile} />
                      </li>
                    )
                  })}
                </ul>
              </div>
            )}
          </div>
        </div>
      </InView>
    )
  }
}

export const EntrancesConfig: EditConfig<EntrancesProps & MappedComponentProperties> = {
  emptyLabel: 'Entrances component empty',
  isEmpty: isEmptyTest,
}

export default Entrances
