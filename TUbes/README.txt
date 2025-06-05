hapus Profile di validation user, controller user, sama services user

.env 

PORT=3000
NODE_ENV=development

DB_HOST=localhost
DB_USERNAME=root
DB_PASSWORD=
DB_DATABASE=mangportal
DB_DIALECT=mysql
DB_PORT=3306
DB_LOGS=false
DB_TIMEZONE=+07:00

BASE_URL=http://localhost:3000

buat migrate
npx sequelize-cli db:migrate