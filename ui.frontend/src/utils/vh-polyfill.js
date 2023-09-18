import { rInterval } from './raf-interval'

export default function vhPolyfill() {
  rInterval(() => {
    let vh = window.innerHeight * 0.01
    try {
      document.documentElement.style.setProperty('--vh', `${vh}px`)
    } catch (err) {
      //no doc
    }
  }, 100)
}
