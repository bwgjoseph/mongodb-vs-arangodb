# Pre-setup

If you wish to create data volume and manage externally:

```
docker volume create mongo_db
docker volume create mongo_configdb
docker volume create arango_data
docker volume create arango_apps
```

# Startup

Run `docker compose -p mva up -d`

# Remove

Run `docker compose down [-v]`

`-v` will enable automatic removal of docker volume(s) attached to the container

# Post-setup

Launch your browser, and navigate to

- [mongo-express](http://localhost:8091)
- [arrango](http://localhost:8529)