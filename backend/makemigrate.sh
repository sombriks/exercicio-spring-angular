# makemigrate.sh
# script para ajudar na criação de migrações
if [ -z "$1" ]; then
  echo "uso: $0 node_do_novo_migrate"
  exit
fi
NEW_MIGRATE="changeset_$(date '+%Y_%m_%d_%H_%M_%S')-$1.sql"
echo "Novo arquivo criado:
src/main/resources/db/changelog/migrations/$NEW_MIGRATE

para executar a migração execute:

sh ./gradlew update

para desfazer a migração execute:

sh ./gradlew rollbackCount -PliquibaseCommandValue=1

"

cat << EOF > src/main/resources/db/changelog/migrations/$NEW_MIGRATE
-- liquibase formatted sql
-- changeset $USER:$NEW_MIGRATE

-- os dois comentários acima são obrigatórios
-- substitua os demais comentários com seus inserts/updates/deletes/create table
-- alter table/drop table etc

-- create table pet(id integer not null auto_increment, name varchar(255) not null);

-- rollback drop table if exists pet

-- comentários 'rollback' são opcionais mas úteis durante a criação do migrate

EOF
