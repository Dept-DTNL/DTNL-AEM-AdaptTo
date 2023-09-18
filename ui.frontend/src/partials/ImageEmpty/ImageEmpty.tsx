import { CoreContainerState } from '@adobe/aem-core-components-react-spa'
import { Component } from 'react'

require('./ImageEmpty.scss')

export type ImageEmptyProps = {
  class: string
}

export type ImageEmptyState = {
  inView: boolean
} & Partial<CoreContainerState>

class ImageEmpty extends Component<ImageEmptyProps, ImageEmptyState> {
  render() {
    return <div className={`image-empty ${this.props.class}`}>No image added</div>
  }
}

export default ImageEmpty
