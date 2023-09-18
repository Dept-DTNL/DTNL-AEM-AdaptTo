
# Inspired by: https://nextjs.org/docs/deployment#docker-image
# ---- Base Node ----
FROM node:14-alpine as dependencies
# Install build dependencies that are missing in the alpine image
# Check https://github.com/nodejs/docker-node/tree/b4117f9333da4138b03a546ec926ef50a31506c3#nodealpine to understand why libc6-compat might be needed.
RUN apk add --no-cache libc6-compat \
                       alpine-sdk \
                       python3
RUN apk add --no-cache vips-dev
WORKDIR /adapttoApp

# Copy package and lockfile
COPY package.json package-lock.json ./

# install dependencies
RUN npm install

# ---- Build ----
FROM node:14-alpine AS build
WORKDIR /adapttoApp
COPY . .

# copy project dependencies from dependencies step
COPY --from=dependencies /adapttoApp/node_modules ./node_modules

# build project
RUN npm run build-with-express

# ---- Release ----
FROM node:14-alpine as release
WORKDIR /adapttoApp

# enable run as production
ENV NODE_ENV=production

# create custom group and user
RUN addgroup -g 1001 -S nodejs
RUN adduser -S nodejs -u 1001

# copy build
# make sure to add all your custom folders/files that you need on runtime here
COPY --from=build /adapttoApp .
# dont run as root
USER nodejs

# expose and set port number to 3000
EXPOSE 3233
ENV PORT 3233

# start app
CMD ["npm", "run", "start-ssr-express"]
