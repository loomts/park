npm i || npx -p npm@6 npm install --legacy-peer-deps
npm run lint --fix
SET NODE_OPTIONS=--openssl-legacy-provider
npm run serve