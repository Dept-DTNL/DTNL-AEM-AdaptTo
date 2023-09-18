import fetch from 'cross-fetch'

declare global {
  interface Window {
    digitalData: {
      event: any
      page: any
    }
  }
  namespace NodeJS {
    export interface Global {
      fetch: typeof fetch
      console: typeof console
    }
  }
}

export type Modify<T, R> = Omit<T, keyof R> & R

export interface SvgrComponent extends React.FC<React.SVGAttributes<SVGElement>> {}

declare module '*.svg' {
  const value: SvgrComponent
  export default value
}

declare global {
  namespace NodeJS {
    interface ProcessEnv {
      PUBLIC_URL: string
      REACT_APP_PROXY_ENABLED?: boolean
      REACT_APP_PAGE_MODEL_PATH: string
      REACT_APP_API_HOST: string
      REACT_APP_AEM_AUTHORIZATION_HEADER: string
      REACT_APP_ROOT: string

      AIO_RUNTIME_NAMESPACE: string
      AIO_RUNTIME_AUTH: string
      AIO_RUNTIME_APIHOST: string
      OW_NAMESPACE: string
      OW_AUTH: string
      OW_APIHOST: string
    }
  }
}
