/*
 *  Copyright 2020 Adobe
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import { MappedComponentProperties } from '@adobe/aem-react-editable-components';
import React, { Component, ComponentType } from 'react';
import { Route } from 'react-router-dom';

/**
 * Helper that facilitate the use of the {@link Route} component
 */

/**
 * Returns a composite component where a {@link Route} component wraps the provided component
 */
export const withRoute = <P extends MappedComponentProperties>(
  WrappedComponent: ComponentType<P>,
  extension?: string,
) => {
  return class CompositeRoute extends Component<P> {
    render() {
      const routePath = this.props.cqPath;
      if (!routePath) {
        return <WrappedComponent {...this.props} />;
      }

      extension = extension || 'html';

      // Context path + route path + extension
      return (
        <Route
          key={routePath}
          path={'(.*)' + routePath + '.' + extension}
          render={(routeProps: unknown) => {
            return <WrappedComponent {...this.props} {...routeProps} />;
          }}
        />
      );
    }
  };
};
