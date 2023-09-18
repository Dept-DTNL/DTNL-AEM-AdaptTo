import { CoreContainerState } from '@adobe/aem-core-components-react-spa'
import { EditConfig, MappedComponentProperties } from '@adobe/aem-react-editable-components'
import { imageIsValid, linkIsValid } from '@models/common'
import DebugBar from '@partials/DebugBar/DebugBar'
import ImageEmpty from '@partials/ImageEmpty/ImageEmpty'
import { Component, createRef } from 'react'
import { InView } from 'react-intersection-observer'

import { HeroBannerTypes } from './hero-banner-data'

require('./HeroBanner.scss')

const isEmptyTest = (props: HeroBannerProps) => {
  return !props || !props.content || !props.content.headline
}

export type HeroBannerProps = HeroBannerTypes
export type HeroBannerState = {
  inView: boolean
} & Partial<CoreContainerState>

class HeroBanner extends Component<HeroBannerProps, HeroBannerState> {
  constructor(props: HeroBannerProps) {
    super(props)
    this.state = {
      inView: false,
    }
  }

  private contentWrapper = createRef<HTMLDivElement>() as any

  componentDidMount() {
    const vh = window.innerHeight * 0.01
    document.documentElement.style.setProperty('--vh', `${vh}px`)
  }

  render() {
    if (isEmptyTest(this.props)) {
      return <DebugBar title="HeroBanner" runMode={this.props?.runMode} />
    }
    return (
      <InView
        className={this.state.inView ? 'section in-view' : 'section'}
        as="section"
        onChange={(inView: boolean) => this.setState({ inView: inView })}
        triggerOnce>
        <div
          className={`hero-banner ${
            this.props.content.isForProduct ? 'hero-banner--product' : ''
          } ${this.props.content?.placeHeadlineInTop ? 'hero-banner--headline-top' : ''} ${
            this.props.content?.decreaseFontSize ? 'hero-banner--headline-small' : ''
          }`}
          id={this.props.content.id ? this.props.content.id : ''}>
          <div className="hero-banner__inner">
            <div className="hero-banner__content" ref={this.contentWrapper}>
              <h1 className="hero-banner__headline">{this.props.content.headline}</h1>

              {this.props.content.cta &&
                this.props.content.cta.label &&
                linkIsValid(this.props.content.cta) && (
                  <div className="hero-banner__buttons">
                    <a className="button" href={this.props.content.cta.url}>
                      <span>{this.props.content.cta.label}</span>
                    </a>
                  </div>
                )}
              {this.props.content.category && (
                <h5 className="hero-banner__category">{this.props.content.category}</h5>
              )}
              <div className="hero-banner__scroll-indicator">
                <p className="hero-banner__scroll-indicator-title">
                  {this.props.content.scrollTitle}
                </p>
                <div className="hero-banner__scroll-indicator-animation">
                  <div className="hero-banner__scroll-indicator-animation-inner"></div>
                </div>
              </div>
            </div>
            <div className="hero-banner__image">
              {this.props.content.imageMobile && imageIsValid(this.props.content.imageMobile) ? (
                <img
                  className="hero-banner__image__mobile"
                  src={this.props.content.imageMobile?.url}
                  alt={this.props.content.imageMobile?.alt}
                />
              ) : (
                <ImageEmpty class="hero-banner__image__mobile" />
              )}
              {this.props.content.imageDesktop && imageIsValid(this.props.content.imageDesktop) ? (
                <img
                  className="hero-banner__image__desktop"
                  src={this.props.content.imageDesktop?.url}
                  alt={this.props.content.imageDesktop?.alt}
                />
              ) : (
                <ImageEmpty class="hero-banner__image__desktop" />
              )}
            </div>
          </div>

          {this.props.content.targetSwitch && (
            <div className="hero-banner__installer">
              <div className="hero-banner__installer-inner">
                <div className="hero-banner__installer-inner__content">
                  <h2 className="headline">{this.props.content.targetSwitch?.headline}</h2>

                  {this.props.content.targetSwitch?.cta &&
                    linkIsValid(this.props.content.targetSwitch?.cta) && (
                      <a href={this.props.content.targetSwitch?.cta.url} className="button">
                        {this.props.content.targetSwitch?.cta.label}
                      </a>
                    )}
                </div>
              </div>
            </div>
          )}
        </div>
      </InView>
    )
  }
}

export const HeroBannerConfig: EditConfig<HeroBannerProps & MappedComponentProperties> = {
  emptyLabel: 'Hero Banner Component',
  isEmpty: props => {
    return !props || !props.content.headline
  },
}

export default HeroBanner
