import { createTheme } from '@mui/material'

export const AdapttoTheme = createTheme({
  palette: {
    primary: {
      main: '#00B3E3', //seablue
      light: '#00B3E3', //seablue
      dark: '#00B3E3', //seablue
    },
    secondary: {
      main: '#00C382', //faketeal
      light: '#00C382', //faketeal
      dark: '#00C382', //faketeal
    },
    error: {
      main: '#d32f2f', //formerror
      light: '#d32f2f', //formerror
      dark: '#d32f2f', //formerror
    },
    warning: {
      main: '#d32f2f', //formerror
      light: '#d32f2f', //formerror
      dark: '#d32f2f', //formerror
    },
    success: {
      main: '#00C382', //faketeal
      light: '#00C382', //faketeal
      dark: '#00C382', //faketeal
    },
    grey: {
      50: '#F7F7F7', //lightgrey
      100: '#F5F5F5', //grey5
      200: '#EAEAEA', //grey4
      300: '#DDDDDD', //grey3
      400: '#AAAAAA', //grey2
      500: '#555555', //grey1
    },
    divider: '#DDDDDD', //grey3 (border-colors)
  },
  typography: {
    fontFamily: 'AdapttoOne',
  },
  components: {
    MuiCssBaseline: {
      styleOverrides: `
      @font-face {
        font-family: "RobotoLight";
        font-style: normal;
        font-weight: 400;
        src: url("~fonts/Roboto-Light.ttf") format("truetype");
      },
      @font-face {
        font-family: "RobotoBold";
        font-style: normal;
        font-weight: 700;
        src: url("~fonts/Roboto-Bold.ttf") format("truetype");
      },
      @font-face {
        font-family: "RobotoRegular";
        font-style: normal;
        font-weight: 400;
        src: url("~fonts/Roboto-Regular.ttf") format("truetype");
      },
      @font-face {
        font-family: "RobotoMedium";
        font-style: normal;
        font-weight: 500;
        src: url("~fonts/Roboto-Medium.ttf") format("truetype");
      },
      @font-face {
        font-family: "RobotoBold";
        font-style: normal;
        font-weight: 700;
        src: url("~fonts/Roboto-Bold.ttf") format("truetype");
      },`,
    },
  },
})
