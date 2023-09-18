// @ts-nocheck
import '@components/import-components'

import { Constants, EditorContext } from '@adobe/aem-react-editable-components'
import { ModelManager } from '@adobe/aem-spa-page-model-manager'
import React from 'react'
import ReactDOMServer from 'react-dom/server'
import { StaticRouter } from 'react-router-dom'

import App from '../App'

function renderModelToHTMLString(
  model,
  pagePath,
  requestUrl,
  requestPath,
  pageModelRootPath,
  isInEditor,
) {
  const html = ReactDOMServer.renderToString(
    <StaticRouter location={requestUrl} context={{}}>
      <EditorContext.Provider value={isInEditor}>
        <App
          cqChildren={model[Constants.CHILDREN_PROP]}
          cqItems={model[Constants.ITEMS_PROP]}
          cqItemsOrder={model[Constants.ITEMS_ORDER_PROP]}
          cqPath={pageModelRootPath}
          locationPathname={requestPath}
        />
      </EditorContext.Provider>
    </StaticRouter>,
  )

  // We are using ' for the string to we need to make sure we are encoding all other '
  const state = {
    rootModel: model,
    rootModelUrl: ModelManager.rootPath,
    pagePath,
  }
  const stateStr = JSON.stringify(state)

  return `${html}
     <script type="application/json" id="__INITIAL_STATE__">
         ${stateStr}
     </script>`
}
const processSPA = async args => {
  const APP_ROOT_PATH = '/content/dtnl-aem-adaptto/us/en'
  const wcmMode = args.wcmmode
  const isInEditor = (wcmMode && wcmMode === 'EDIT') || wcmMode === 'PREVIEW'
  const pageModelRootPath = args.pageRoot || APP_ROOT_PATH
  const modelData = args.data
  const pagePath = args.pagePath.replace('.html', '')
  await ModelManager.initialize({ path: pageModelRootPath, model: modelData })
  const response = await renderModelToHTMLString(
    modelData,
    pagePath,
    args.pagePath,
    args.pagePath,
    pageModelRootPath,
    isInEditor,
  )
  return response
}

export default processSPA
