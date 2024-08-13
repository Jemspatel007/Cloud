FROM node:latest

COPY config2.env ./

WORKDIR $directory

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE $PORT

CMD ["node", "index.js"]d