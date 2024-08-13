FROM node:latest

COPY config1.env ./

WORKDIR $directory

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE $PORT

CMD ["node", "index.js"]