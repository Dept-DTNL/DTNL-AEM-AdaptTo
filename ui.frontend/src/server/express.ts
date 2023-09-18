/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2021 Adobe Systems Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
// Expose XMLHttpRequest globally so ModelManager can use it
import bodyParser from 'body-parser'
import express from 'express'
import React from 'react'
import { render } from 'react-dom'

import processSPA from './aem-processor.functions'

const exapp = express()
//Here we are configuring express to use body-parser as middle-ware.
exapp.use(bodyParser.json({limit: "50mb"}));
exapp.use(bodyParser.urlencoded({limit: "50mb", extended: true, parameterLimit:50000}));
exapp.use(express.static('dist'))

exapp.post('/api/v1/web/guest/dtnl-aem-adaptto-0.1.0/ssr/*', async (req, res) => {
  const args = {
    pagePath: req.path.replace('.html', ''),
    pageRoot: req.header('root-page-path'),
    wcmmode: req.header('wcm-mode'),
    data: req.body,
    method: 'POST',
  }

  return processSPA(args)
    .then(response => {
      res.send(response)
    })
    .catch(error => {
      console.error(error)
      //send the error message to the response so AEM can log it as well.
      const msg = error.stack ? `${error} stack: ${error.stack}` : error
      res.status(500).send(msg)
    })
})

exapp.listen(3233, () => console.log('Express SSR handler running on 3233!'))
