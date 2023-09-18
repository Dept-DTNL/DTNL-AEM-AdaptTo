import { CoreContainerState } from '@adobe/aem-core-components-react-spa'
import { CircleCheck, CircleCheckFilled } from '@assets/svg/components'
import { CTA, Image, imageIsValid, linkIsValid } from '@models/common'
import ImageEmpty from '@partials/ImageEmpty/ImageEmpty'
import { Component } from 'react'

require('./ContentTile.scss')

export type ContentTileProps = {
  headline: string
  description: string
  cta?: CTA | null
  image?: Image | null
  usps?: USP[]
}

export type USP = {
  label: string
}

class ContentTile extends Component<ContentTileProps, CoreContainerState> {
  // eslint-disable-next-line jsx-a11y/img-redundant-alt
  hasUsps = this.props.usps && this.props.usps.length > 0
  render() {
    return (
      <div className="content-tile">
        {this.props.image && imageIsValid(this.props.image) ? (
          <div className="content-tile__image">
            <img src={this.props.image.url} alt={this.props.image.alt} />
          </div>
        ) : (
          <ImageEmpty class="content-tile__image" />
        )}
        <div className="content-tile__content">
          <h3 className="content-tile__headline">{this.props.headline}</h3>
          <p className="content-tile__description">{this.props.description}</p>
          {this.props.cta && linkIsValid(this.props.cta) && (
            <div className="content-tile__buttons">
              <a className="button" href={this.props.cta.url}>
                <span>{this.props.cta.label}</span>
              </a>
            </div>
          )}

          {this.hasUsps && (
            <ul className="content-tile__usps">
              {this.props.usps?.map((usp, index) => {
                return (
                  <li key={'contenttile' + index}>
                    <CircleCheckFilled />
                    <span>{usp.label}</span>
                  </li>
                )
              })}
            </ul>
          )}
        </div>
      </div>
    )
  }
}

export default ContentTile
