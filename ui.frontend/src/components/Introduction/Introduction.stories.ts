import type { Meta, StoryObj } from '@storybook/react';

import  Introduction  from './Introduction';
import { ComponentSize } from '@constants/component-size';
import { introductionData, introductionData2, introductionData3, introductionData4, introductionData5, introductionData6, introductionData7 } from './introduction-data';

// More on how to set up stories at: https://storybook.js.org/docs/react/writing-stories/introduction#default-export
const meta: Meta<typeof Introduction> = {
  title: 'Introduction',
  component: Introduction,
  parameters: {
    // Optional parameter to center the component in the Canvas. More info: https://storybook.js.org/docs/react/configure/story-layout
    layout: 'centered',
  },
  // This component will have an automatically generated Autodocs entry: https://storybook.js.org/docs/react/writing-docs/autodocs
  tags: ['autodocs'],
  // More on argTypes: https://storybook.js.org/docs/react/api/argtypes
  argTypes: {
    //backgroundColor: { control: 'color' },
  },
};

export default meta;
type Story = StoryObj<typeof Introduction>;

// More on writing stories with args: https://storybook.js.org/docs/react/writing-stories/args
export const Primary: Story = {
  args: {
    //primary: true,
    headline: 'Introduction Component',
    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation',
    image: {
      url: 'https://picsum.photos/800/700',
      alt: 'storybook-image',
    },
    id: 'id-id',
    size: ComponentSize.XLARGE
  },
};

export const XSmall: Story = {
  args: {
    ...introductionData()
  },
};

export const Small: Story = {
  args: {
    ...introductionData2()
  },
};

export const Medium: Story = {
  args: {
    ...introductionData3()
  },
};

export const Large: Story = {
  args: {
    ...introductionData4()
  },
};

export const XLarge: Story = {
  args: {
    ...introductionData5()
  },
};

export const XLargeInverted: Story = {
  args: {
    ...introductionData6()
  },
};

export const XLargeReversed: Story = {
  args: {
    ...introductionData7()
  },
};

