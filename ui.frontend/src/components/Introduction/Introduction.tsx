import { CoreContainerState } from '@adobe/aem-core-components-react-spa'
import { EditConfig, MappedComponentProperties } from '@adobe/aem-react-editable-components'
import { ComponentSize } from '@constants/component-size'
import DebugBar from '@partials/DebugBar/DebugBar'
import React, { Component } from 'react'
import { InView } from 'react-intersection-observer'

import { IntroductionTypes } from './introduction-data'

require('./Introduction.scss')

export type IntroductionProps = IntroductionTypes

const isEmptyTest = (props: IntroductionProps) => {
  return !props || !props.size
}

export type IntroductionState = {
  inView: boolean
} & Partial<CoreContainerState>

class Introduction extends Component<IntroductionProps, IntroductionState> {
  constructor(props: IntroductionProps) {
    super(props)
    this.state = {
      inView: false,
    }
  }
  render() {
    if (isEmptyTest(this.props)) {
      return <DebugBar title="Introduction" runMode={this.props?.runMode} />
    }
    let classNames
    switch (this.props.size) {
      case ComponentSize.XSMALL:
        classNames = 'introduction introduction--small-body'
        break
      case ComponentSize.LARGE:
        classNames = 'introduction introduction--extended'
        break
      case ComponentSize.XLARGE:
        classNames = 'introduction introduction--full'
        break
      default:
        classNames = 'introduction introduction--default'
    }
    if (this.props.isInverted) classNames += ' introduction--inverted'
    if (this.props.isReversed) classNames += ' introduction--reversed'

    return (
      <InView
        className={this.state.inView ? 'section in-view' : 'section'}
        as="section"
        onChange={(inView: boolean) => this.setState({ inView: inView })}
        triggerOnce>
        <div className={classNames} id={this.props.id}>
          <div
            className={`introduction__inner ${
              this.props.mobileImageFirst && this.props.size === ComponentSize.XLARGE
                ? 'image-first'
                : ''
            }`}>
            <div className="introduction__content">
              {this.props.headline && (
                <div className="introduction__headline">
                  <h2>{this.props.headline}</h2>
                </div>
              )}

              <div className="introduction__description">
                {this.props.description && <p>{this.props.description}</p>}

                {this.props.cta && (
                  <div className="introduction__cta">
                    <a className="button" href={this.props.cta.url}>
                      <span>{this.props.cta.label}</span>
                    </a>
                  </div>
                )}
              </div>
            </div>
            {this.props.image && (
              <div className="introduction__image">
                <img src={this.props.image.url} alt={this.props.image.alt} />
              </div>
            )}
          </div>
        </div>
      </InView>
    )
  }
}

export const IntroductionConfig: EditConfig<IntroductionProps & MappedComponentProperties> = {
  emptyLabel: 'Introduction Component',

  isEmpty: isEmptyTest,
}

export default Introduction
