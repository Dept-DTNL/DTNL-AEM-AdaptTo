import { BgColor } from '@constants/bgcolor'
import { TagStyle } from '@constants/tag-style'
import { CTA, Image } from '@models/common'

export type HeroSliderTypes = {
  runMode?: string
  id?: string
  content: Content
}

type Content = {
  slides: Tab[]
}

type Tab = {
  slideTitle: string
  date?: string
  headline: string
  description: string
  bgColor?: string
  cta: CTA
  tags?: Tag[]
  image?: Image
}

type Tag = {
  label: string
  style: string
}

export const heroSliderData = (): HeroSliderTypes => ({
  id: 'heroSlider',
  content: {
    slides: [
      {
        slideTitle: 'Optimise your energy use',
        date: 'Slide 1 | 30-08/2022',
        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.BLACK,
        cta: {
          url: '#',
          label: 'Read more',
        },
        tags: [
          {
            label: 'Press Release',
            style: TagStyle.FAKE_TEAL,
          },
          {
            label: 'EHS',
            style: TagStyle.LAVENDER,
          },
        ],
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
      {
        slideTitle: 'Optimise your energy use',
        date: 'Slide 1 | 30-08/2022',
        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.LIGHT,
        cta: {
          url: '#',
          label: 'Read more',
        },
        tags: [
          {
            label: 'Press Release',
            style: TagStyle.FAKE_TEAL,
          },
          {
            label: 'EHS',
            style: TagStyle.LAVENDER,
          },
        ],
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
      {
        slideTitle: 'Optimise your energy use',
        date: 'Slide 1 | 30-08/2022',
        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.LAVENDER,
        cta: {
          url: '#',
          label: 'Read more',
        },
        tags: [
          {
            label: 'Press Release',
            style: TagStyle.FAKE_TEAL,
          },
          {
            label: 'EHS',
            style: TagStyle.LAVENDER,
          },
        ],
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
      {
        slideTitle: 'Optimise your energy use',
        date: 'Slide 1 | 30-08/2022',
        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.DARK_GREY,
        cta: {
          url: '#',
          label: 'Read more',
        },
        tags: [
          {
            label: 'Press Release',
            style: TagStyle.FAKE_TEAL,
          },
          {
            label: 'EHS',
            style: TagStyle.LAVENDER,
          },
        ],
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
    ],
  },
})

export const heroSliderData2 = (): HeroSliderTypes => ({
  id: 'heroSlider',
  content: {
    slides: [
      {
        slideTitle: 'Optimise your energy use',
        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.BLACK,
        cta: {
          url: '#',
          label: 'Read more',
        },
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
      {
        slideTitle: 'Optimise your energy use',
        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.LIGHT,
        cta: {
          url: '#',
          label: 'Read more',
        },
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
      {
        slideTitle: 'Optimise your energy use',

        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.LAVENDER,
        cta: {
          url: '#',
          label: 'Read more',
        },
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
      {
        slideTitle: 'Optimise your energy use',
        headline: 'Reduce energy usage and save money',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipiscing elit, massa semper in sit habitasse sit quam...',
        bgColor: BgColor.DARK_GREY,
        cta: {
          url: '#',
          label: 'Read more',
        },
        image: {
          url: 'https://www.realsimple.com/thmb/7lvQzpW0q__D-y1pjQYV-3ROYXA=/2000x1500/filters:fill(auto,1)/living-room-paint-colors-2000-4d25f9b7578b471491cb95479e01709e.jpg',
          alt: 'label',
          title: 'title',
        },
      },
    ],
  },
})
