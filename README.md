# Setup postgresql

    docker run --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -p 15432:5432 -d postgres
    
# Setup vault
## Run vault server locally in dev env
    
    vault server -dev
    
Unseal Key: 27d1DDy9ViBE8VupbSEVwIMsJlMUJU6QbiTKJqvThO4=
Root Token: s.Su8RCiQUgIqZmjAFstfsmxR1

    
    export VAULT_ADDR='http://127.0.0.1:8200'
    
    export VAULT_TOKEN="s.Su8RCiQUgIqZmjAFstfsmxR1"
## Enable vault key value engine 
### Spring cloud vault
    /secret/{application}/{profile}
    /secret/{application}
    /secret/{default-context}/{profile}
    /secret/{default-context}
### Set vault key value secret

     ./vault kv put secret/hello test.password=bar
     
## Enable vault database engine

    vault secrets enable database

Output:
    
    Success! Enabled the database secrets engine at: database/
  
## Create postgresql database config

    vault write database/config/my-postgresql-database `
        plugin_name=postgresql-database-plugin `
        allowed_roles="my-role" `
        connection_url="postgresql://{{username}}:{{password}}@localhost:15432/postgres?sslmode=disable" `
        username="admin" `
        password="admin"
        
    ./vault write database/config/my-postgresql-database \
        plugin_name=postgresql-database-plugin \
        allowed_roles="my-role" \
        connection_url="postgresql://{{username}}:{{password}}@localhost:15432/postgres?sslmode=disable" \
        username="admin" \
        password="admin"
      
## Create role for postgres

    vault write database/roles/my-role `
        db_name=my-postgresql-database `
        creation_statements="CREATE ROLE ""{{name}}"" WITH LOGIN PASSWORD '{{password}}' VALID UNTIL '{{expiration}}'; GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO ""{{name}}"";" `
        default_ttl="1h" `
        max_ttl="24h"
      
    ./vault write database/roles/my-role \
        db_name=my-postgresql-database \
        creation_statements="CREATE ROLE \"{{name}}\" WITH LOGIN PASSWORD '{{password}}' VALID UNTIL '{{expiration}}'; \
        GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO \"{{name}}\";
        GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO \"{{name}}\";" \
        default_ttl="20s" \
        max_ttl="1m"

Output:

    Success! Data written to: database/roles/my-role
    
## Read my role

    vault read database/creds/my-role

## Use http client to get config

curl --header "X-Vault-Token: s.Xjq8H2OzAvjJrL1BhuvTodoL" `
    --request GET http://127.0.0.1:8200/v1/database/config/my-postgresql-database
    
curl --header "X-Vault-Token: s.Xjq8H2OzAvjJrL1BhuvTodoL" --request DELETE http://127.0.0.1:8200/v1/database/config/my-postgresql-database 

curl --header "X-Vault-Token: s.5nMK4V9q5i9PBmmzkLAgi0l8" --request DELETE http://127.0.0.1:8200/v1/database/roles/my-role

    
curl --header "X-Vault-Token: s.Xjq8H2OzAvjJrL1BhuvTodoL" http://127.0.0.1:8200/v1/database/creds/my-role


s.5nMK4V9q5i9PBmmzkLAgi0l8

curl --header "X-Vault-Token: s.5nMK4V9q5i9PBmmzkLAgi0l8" --request PUT -d '{"lease_id":"database/creds/my-role/ReLrjDds8ywWA97iOY9UUpTm", "increment":"60"}'  http://127.0.0.1:8200/v1/sys/leases/renew
 