import { CTA, Image } from '@models/common'

export type HeroBannerTypes = {
  runMode?: string
  content: Content
}

type Content = {
  id?: string
  placeHeadlineInTop?: boolean
  decreaseFontSize?: boolean
  headline: string
  cta?: CTA
  category?: string
  imageDesktop: Image
  imageMobile: Image
  isForProduct?: boolean
  targetSwitch?: TargetSwitch
  scrollTitle: string
}

type TargetSwitch = {
  headline: string
  cta: CTA
}

export const heroBannerData = (): HeroBannerTypes => ({
  content: {
    id: 'hero1',
    placeHeadlineInTop: false,
    decreaseFontSize: false,
    headline: 'Headline Lorem ipsum',
    imageDesktop: {
      title: 'Title',
      url: 'https://picsum.photos/id/56/1600/900',
      alt: 'alt',
    },
    imageMobile: { title: 'Title', url: 'https://picsum.photos/id/56/500/900', alt: 'alt' },
    cta: { url: '#anchor1', label: 'Lorem ipsum dolor sit amet' },
    scrollTitle: 'Scroll down',
  },
})
export const heroBannerData2 = (): HeroBannerTypes => ({
  content: {
    id: 'hero2',
    placeHeadlineInTop: false,
    decreaseFontSize: true,
    headline: 'Lorem ipsum dolor sit amet',
    imageDesktop: {
      title: 'Title',
      url: 'https://picsum.photos/id/56/1600/900',
      alt: 'alt',
    },
    imageMobile: { title: 'Title', url: 'https://picsum.photos/id/56/500/900', alt: 'alt' },
    cta: { url: '#anchor1', label: 'Lorem ipsum dolor sit amet' },
    scrollTitle: 'Scroll down',
  },
})
export const heroBannerData3 = (): HeroBannerTypes => ({
  content: {
    id: 'hero3',
    placeHeadlineInTop: true,
    decreaseFontSize: true,
    headline: 'Lorem ipsum dolor sit amet',
    imageDesktop: {
      title: 'Title',
      url: 'https://picsum.photos/id/56/1600/900',
      alt: 'alt',
    },
    imageMobile: { title: 'Title', url: 'https://picsum.photos/id/56/500/900', alt: 'alt' },
    cta: { url: '#anchor1', label: 'Lorem ipsum dolor sit amet' },
    scrollTitle: 'Scroll down',
  },
})
export const heroBannerData4 = (): HeroBannerTypes => ({
  content: {
    id: 'hero4',
    placeHeadlineInTop: true,
    decreaseFontSize: false,
    headline: 'Headline Lorem ipsum',
    imageDesktop: {
      title: 'Title',
      url: 'https://picsum.photos/id/56/1600/900',
      alt: 'alt',
    },
    imageMobile: { title: 'Title', url: 'https://picsum.photos/id/56/500/900', alt: 'alt' },
    cta: { url: '#anchor1', label: 'Lorem ipsum dolor sit amet' },
    targetSwitch: {
      headline: 'Headline Lorem ipsum',
      cta: { url: '#anchor1', label: 'Lorem ipsum dolor sit amet' },
    },
    scrollTitle: 'Scroll down',
  },
})
export const heroBannerData5 = (): HeroBannerTypes => ({
  content: {
    id: 'hero5',
    isForProduct: true,
    headline: 'Lorem ipsum dolor sit amet',
    imageDesktop: {
      title: 'Title',
      url: 'https://picsum.photos/id/35/1800/500',
      alt: 'alt',
    },
    imageMobile: { title: 'Title', url: 'https://picsum.photos/id/35/500/900', alt: 'alt' },
    category: 'Cateogry',
    cta: { url: '#', label: 'Lorem ipsum dolor sit amet' },
    scrollTitle: 'Scroll down',
  },
})
