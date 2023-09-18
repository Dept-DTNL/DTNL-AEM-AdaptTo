import { ComponentSize } from '@constants/component-size'
import { CTA, Image } from '@models/common'

export type IntroductionTypes = {
  isInverted?: boolean
  isReversed?: boolean
  id: string
  runMode?: string
  headline?: string
  description?: string
  cta?: CTA
  image?: Image
  size: ComponentSize
  mobileImageFirst?: boolean
}

export const introductionData = (): IntroductionTypes => ({
  id: 'intro1',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
  size: ComponentSize.XSMALL,
})
export const introductionData2 = (): IntroductionTypes => ({
  id: 'intro2',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
  cta: { url: '#', label: 'More Info' },
  size: ComponentSize.SMALL,
})
export const introductionData3 = (): IntroductionTypes => ({
  id: 'intro3',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
  cta: { url: '#', label: 'More Info' },
  size: ComponentSize.MEDIUM,
})
export const introductionData4 = (): IntroductionTypes => ({
  id: 'intro4',
  headline: 'Headline',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
  cta: { url: '#', label: 'More Info' },
  size: ComponentSize.LARGE,
})
export const introductionData5 = (): IntroductionTypes => ({
  id: 'intro5',
  headline: 'Headline',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
  image: { title: 'Title', url: 'https://picsum.photos/id/38/600/500', alt: 'alt' },
  cta: { url: '#', label: 'More Info' },
  size: ComponentSize.XLARGE,
  mobileImageFirst: true,
})
export const introductionData6 = (): IntroductionTypes => ({
  isInverted: true,
  id: 'intro6',
  headline: 'Headline',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
  image: { title: 'Title', url: 'https://picsum.photos/id/38/600/500', alt: 'alt' },
  cta: { url: '#', label: 'More Info' },
  size: ComponentSize.XLARGE,
  mobileImageFirst: true,
})
export const introductionData7 = (): IntroductionTypes => ({
  isReversed: true,
  id: 'intro7',
  headline: 'Headline',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
  image: { title: 'Title', url: 'https://picsum.photos/id/38/600/500', alt: 'alt' },
  cta: { url: '#', label: 'More Info' },
  size: ComponentSize.XLARGE,
  mobileImageFirst: false,
})
