export type CTA = {
  url: string
  label: string
}

export type Image = {
  url: string
  alt?: string
  title?: string
}

export type Video = {
  title?: string
  videoSrc?: string
  posterSrc?: string
}

export function imageIsValid(image: Image): any {
  return image && image?.url && !!image.url?.length
}

export function linkIsValid(link: CTA): any {
  return link && link?.url && !!link.url?.length
}
