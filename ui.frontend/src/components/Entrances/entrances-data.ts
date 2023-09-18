import { ContentTileProps } from '@partials/ContentTile/ContentTile'

export type EntrancesTypes = {
  runMode?: string
  content: Content
}

type Content = {
  id?: string
  headline?: string
  description?: string
  tiles: ContentTileProps[]
}

export const entrancesData = (): EntrancesTypes => ({
  content: {
    id: 'entrances',
    headline: 'Entrances headline text',
    description:
      'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit',
    tiles: [
      {
        headline: 'headline entrance one',
        description: 'Lorem ipsum dolor sit amet.',
        image: {
          url: 'https://picsum.photos/id/64/600/500',
          alt: '',
          title: '',
        },
        cta: { url: '#', label: 'More info' },
      },
      {
        headline: 'headline entrance two',
        description:
          'Lorem ipsum dolor sit amet.',
        image: {
          url: 'https://picsum.photos/id/37/600/500',
          alt: '',
          title: '',
        },
        cta: { url: '#', label: 'More info' },
      },
      {
        headline: 'headline entrance three',
        description:
          'Lorem ipsum dolor sit amet.',
        image: {
          url: 'https://picsum.photos/id/88/600/500',
          alt: '',
          title: '',
        },
        cta: { url: '#', label: 'More info' },
      },
    ],
  },
})

export const entrancesData2 = (): EntrancesTypes => ({
  content: {
    id: 'entrances',
    headline: 'Entrance headline text',
    description:
      'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit',
    tiles: [
      {
        headline: 'Entrance one',
        description: 'Lorem ipsum dolor sit amet',
        image: {
          url: 'https://picsum.photos/id/64/600/500',
          alt: '',
          title: '',
        },

        usps: [
          {
            label: 'usp one Lorem ipsum',
          },
          {
            label: 'usp two Lorem ipsum',
          },
          {
            label: 'usp three Lorem ipsum',
          },
        ],
      },
      {
        headline: 'Entrance two',
        description: 'Lorem ipsum dolor sit amet',
        image: {
          url: 'https://picsum.photos/id/37/600/500',
          alt: '',
          title: '',
        },
        usps: [
          {
            label: 'usp one Lorem ipsum',
          },
          {
            label: 'usp two Lorem ipsum',
          },
          {
            label: 'usp three Lorem ipsum',
          },
        ],
      },
    ],
  },
})
