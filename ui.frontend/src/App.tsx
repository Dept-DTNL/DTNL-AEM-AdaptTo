import '@assets/scss/global.scss'

import {
  ContainerState,
  Page,
  PageProperties,
  withModel,
} from '@adobe/aem-react-editable-components'

class App extends Page<PageProperties, ContainerState> {
  render() {
    return (
      <>
        {this.childComponents}
        {this.childPages}
      </>
    )
  }
}
export default withModel(App);
