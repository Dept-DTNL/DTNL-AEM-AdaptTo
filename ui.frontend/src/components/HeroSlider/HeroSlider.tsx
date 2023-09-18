import 'swiper/swiper.min.css'
import 'swiper/components/pagination/pagination.min.css'
import 'swiper/components/effect-fade/effect-fade.min.css'

import { CoreContainerState } from '@adobe/aem-core-components-react-spa'
import { EditConfig, MappedComponentProperties } from '@adobe/aem-react-editable-components'
import { ChevronLeft, ChevronRight } from '@assets/svg/components'
import { TagStyle } from '@constants/tag-style'
import { imageIsValid, linkIsValid } from '@models/common'
import DebugBar from '@partials/DebugBar/DebugBar'
import { Component } from 'react'
import { InView } from 'react-intersection-observer'
import SwiperCore, { Autoplay, EffectFade, Pagination } from 'swiper/core'
import { Swiper, SwiperSlide } from 'swiper/react'

SwiperCore.use([EffectFade])
SwiperCore.use([Pagination])
SwiperCore.use([Autoplay])

import cuid from 'cuid'

import { HeroSliderTypes } from './hero-slider-data'

require('./HeroSlider.scss')

export type HeroSliderProps = HeroSliderTypes

const isEmptyTest = (props: HeroSliderProps) => {
  return !props || !props.content || !props.content.slides || props.content.slides.length == 0
}

type HeroSliderState = {
  inView: boolean
  swiperRef: any
  currentSlide: number
  bgColor?: string
  cuid: string
} & Partial<CoreContainerState>

class HeroSlider extends Component<HeroSliderProps, HeroSliderState> {
  constructor(props: HeroSliderProps) {
    super(props)

    this.state = {
      inView: false,
      swiperRef: null,
      currentSlide: 0,
      bgColor: this.props?.content?.slides[0]?.bgColor,
      cuid: cuid(),
    }
  }

  componentDidMount() {
    const vh = window.innerHeight * 0.01
    document.documentElement.style.setProperty('--hero-slider-vh', `${vh}px`)
  }

  getTagStyle(style: string) {
    switch (style) {
      case TagStyle.LAVENDER:
        return 'tag tag--lavender'
      case TagStyle.FAKE_TEAL:
        return 'tag tag--fake-teal'
    }
  }

  swiperReady = (swiperRef: any) => {
    this.setState({ swiperRef: swiperRef })
  }

  changeSlideContent = (e: any) => {
    const { slides } = this.props.content

    if (slides[e.activeIndex].bgColor) {
      this.setState({ bgColor: slides[e.activeIndex].bgColor })
    } else {
      this.setState({ bgColor: '' })
    }
  }

  render() {
    if (isEmptyTest(this.props)) {
      return <DebugBar title="HeroSlider" runMode={this.props?.runMode} />
    }

    const paginationTitles = [] as any
    this.props.content.slides.map(slide => {
      paginationTitles.push(slide.slideTitle)
    }) as any

    const { slides } = this.props.content

    return (
      <InView
        className={this.state.inView ? 'section in-view' : 'section'}
        as="section"
        onChange={(inView: boolean) => this.setState({ inView: inView })}
        triggerOnce>
        <div
          id={this.props.id ? this.props.id : ''}
          className={`hero-slider ${this.state.bgColor}`}>
          <Swiper
            autoplay={{
              delay: 5500,
              disableOnInteraction: false,
              pauseOnMouseEnter: true,
            }}
            className="hero-slider__slides"
            freeMode={false}
            slidesPerView={1}
            onSwiper={this.swiperReady}
            onSlideChange={this.changeSlideContent}
            touchEventsTarget="wrapper"
            effect="fade"
            fadeEffect={{
              crossFade: true,
            }}
            speed={500}
            pagination={{
              el: '#heroSwiperPagination' + this.state.cuid,
              clickable: true,
              renderBullet: function (index, className) {
                return `<span class="${className}"><span>${paginationTitles[index]}</span><b class="timer"></b></span>`
              },
            }}
            navigation={{
              nextEl: '.swiper-button-next',
              prevEl: '.swiper-button-prev',
            }}>
            {this.props.content.slides.map((slide, index) => (
              <SwiperSlide key={'herosliderslide' + index}>
                <div className="hero-slider__slide">
                  {slide.image && imageIsValid(slide.image) && (
                    <>
                      <img
                        className="hero-slider__slide__media"
                        src={slide.image.url}
                        alt={slide.image.alt}
                      />
                      <div className="hero-slider__slide__image-overlay"></div>
                    </>
                  )}
                  {/* {tab.video && tab.video.videoSrc && videoIsValid(tab.video) && (
                    <>
                      <div className="hero-slider__slide__media">
                        <NativePlayer
                          muted={true}
                          controls={false}
                          volume={0}
                          videoUrl={tab.video?.videoSrc}
                          onEnded={undefined}
                        />
                      </div>
                    </>
                  )} */}
                  <div className={`hero-slider__slide__content ${slide.image ? 'has-media' : ''}`}>
                    {slide.date && <h5 className="hero-slider__slide__trumpet">{slide.date}</h5>}
                    {slide.tags && slide.tags.length && (
                      <ul className="hero-slider__tags">
                        {slide.tags.map((tag, index) => (
                          <li key={'tag' + index} className={this.getTagStyle(tag.style)}>
                            {tag.label}
                          </li>
                        ))}
                      </ul>
                    )}
                    <h3 className="hero-slider__slide__headline">{slide.headline}</h3>
                    <p className="hero-slider__slide__description">{slide.description}</p>
                    {slide.cta && linkIsValid(slide.cta) && (
                      <a href={slide.cta.url} className="hero-slider__slide__button">
                        <span>{slide.cta.label}</span>
                      </a>
                    )}
                  </div>
                </div>
              </SwiperSlide>
            ))}
            <div className="hero-slider__controls">
              <ul
                className="hero-slider__controls__pagination"
                id={'heroSwiperPagination' + this.state.cuid}></ul>
            </div>
          </Swiper>

          <div className="swiper-button swiper-button-prev">
            <ChevronLeft />
          </div>
          <div className="swiper-button swiper-button-next">
            <ChevronRight />
          </div>
        </div>
      </InView>
    )
  }
}

export const HeroSliderConfig: EditConfig<HeroSliderProps & MappedComponentProperties> = {
  emptyLabel: 'HeroSlider Component ',
  isEmpty: isEmptyTest,
}

export default HeroSlider
