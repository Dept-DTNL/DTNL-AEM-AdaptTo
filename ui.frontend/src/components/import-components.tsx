/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2020 Adobe Systems Incorporated
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
import {
  BreadCrumbV2,
  BreadCrumbV2IsEmptyFn,
  BreadCrumbV2Model,
  ButtonV1,
  ButtonV1IsEmptyFn,
  CoreComponentModel,
  DownloadV1,
  DownloadV1IsEmptyFn,
  DownloadV1Model,
  ImageV2,
  ImageV2IsEmptyFn,
  ImageV2Model,
  LanguageNavigationV1,
  LanguageNavigationV1Model,
  ListV2,
  ListV2IsEmptyFn,
  ListV2Model,
  NavigationV1,
  NavigationV1Model,
  SeparatorV1,
  SeparatorV1IsEmptyFn,
  TeaserV1,
  TeaserV1IsEmptyFn,
  TeaserV1Model,
  TitleV2IsEmptyFn,
  TitleV2Model,
} from '@adobe/aem-core-components-react-base'
import {
  AccordionV1,
  AccordionV1IsEmptyFn,
  AccordionV1Properties,
  CarouselV1IsEmptyFn,
  CarouselV1Properties,
  ContainerV1,
  ContainerV1IsEmptyFn,
  ContainerV1Properties,
  TabsV1,
  TabsV1IsEmptyFn,
  TabsV1Properties,
} from '@adobe/aem-core-components-react-spa'
import {
  AllowedComponentsProperties,
  MappedComponentProperties,
  MapTo,
} from '@adobe/aem-react-editable-components'
import { EntrancesConfig, EntrancesProps } from '@components/Entrances/Entrances'
import { HeroSliderConfig } from '@components/HeroSlider/HeroSlider'
import { IntroductionConfig, IntroductionProps } from '@components/Introduction/Introduction'

import { withAsyncImport } from '@utils/withAsyncImport'

import { ContainerConfig } from './Container/Container'
import { ExperienceFragmentConfig } from './ExperienceFragment/ExperienceFragment'
import { HeroBannerConfig } from './HeroBanner/HeroBanner'
import { PageProps } from './Page/Page'
const TitleV2 = withAsyncImport(
  () => import(`@adobe/aem-core-components-react-base/dist/authoring/title/v2/TitleV2`),
)
const CarouselV1 = withAsyncImport(
  () => import(`@adobe/aem-core-components-react-spa/dist/container/carousel/v1/CarouselV1`),
)

MapTo<DownloadV1Model & MappedComponentProperties>('dtnl-aem-adaptto/components/download')(
  DownloadV1,
  {
    isEmpty: DownloadV1IsEmptyFn,
  },
)

MapTo<ListV2Model & MappedComponentProperties>('dtnl-aem-adaptto/components/list')(ListV2, {
  isEmpty: ListV2IsEmptyFn,
})

MapTo<CoreComponentModel & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/separator',
)(SeparatorV1, {
  isEmpty: SeparatorV1IsEmptyFn,
})

MapTo('dtnl-aem-adaptto/components/button')(ButtonV1, {
  isEmpty: ButtonV1IsEmptyFn,
})

MapTo<TeaserV1Model & MappedComponentProperties>('dtnl-aem-adaptto/components/teaser')(
  TeaserV1,
  {
    isEmpty: TeaserV1IsEmptyFn,
  },
)

MapTo<ImageV2Model & MappedComponentProperties>('dtnl-aem-adaptto/components/image')(
  ImageV2,
  {
    isEmpty: ImageV2IsEmptyFn,
  },
)

MapTo<TitleV2Model & MappedComponentProperties>('dtnl-aem-adaptto/components/title')(
  TitleV2,
  {
    isEmpty: TitleV2IsEmptyFn,
  },
)

MapTo<BreadCrumbV2Model & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/breadcrumb',
)(BreadCrumbV2, {
  isEmpty: BreadCrumbV2IsEmptyFn,
})

MapTo<NavigationV1Model & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/navigation',
)(NavigationV1)

MapTo<LanguageNavigationV1Model & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/languagenavigation',
)(LanguageNavigationV1)

MapTo<TabsV1Properties & MappedComponentProperties>('dtnl-aem-adaptto/components/tabs')(
  TabsV1,
  {
    isEmpty: TabsV1IsEmptyFn,
  },
)

MapTo<AccordionV1Properties & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/accordion',
)(AccordionV1, {
  isEmpty: AccordionV1IsEmptyFn,
})

MapTo<CarouselV1Properties & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/carousel',
)(CarouselV1, {
  isEmpty: CarouselV1IsEmptyFn,
})

MapTo<ContainerV1Properties & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/container',
)(ContainerV1, {
  isEmpty: ContainerV1IsEmptyFn,
})

//lazy load of internal component

const Page = withAsyncImport(() => import(`./Page/Page`))
MapTo<PageProps & MappedComponentProperties>('dtnl-aem-adaptto/components/page')(Page)

const Container = withAsyncImport(() => import(`./Container/Container`))
MapTo<AllowedComponentsProperties & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/container',
)(Container, ContainerConfig)

const ExperienceFragment = withAsyncImport(() => import(`./ExperienceFragment/ExperienceFragment`))
MapTo<MappedComponentProperties>('dtnl-aem-adaptto/components/experiencefragment')(
  ExperienceFragment,
  ExperienceFragmentConfig,
)

// content components

const HeroBanner = withAsyncImport(() => import(`./HeroBanner/HeroBanner`))
MapTo<MappedComponentProperties>('dtnl-aem-adaptto/components/herobanner')(
  HeroBanner,
  HeroBannerConfig,
)

const HeroSlider = withAsyncImport(() => import(`./HeroSlider/HeroSlider`))
MapTo<MappedComponentProperties>('dtnl-aem-adaptto/components/heroslider')(
  HeroSlider,
  HeroSliderConfig,
)

const IntroductionComponent = withAsyncImport(() => import('./Introduction/Introduction'))
MapTo<IntroductionProps & MappedComponentProperties>(
  'dtnl-aem-adaptto/components/introduction',
)(IntroductionComponent, IntroductionConfig)

const EntrancesComponent = withAsyncImport(() => import('./Entrances/Entrances'))
MapTo<EntrancesProps & MappedComponentProperties>('dtnl-aem-adaptto/components/entrances')(
  EntrancesComponent,
  EntrancesConfig,
)

