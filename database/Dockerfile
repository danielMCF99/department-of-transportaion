FROM postgres:17.0

RUN apt update

#RUN sudo chown -R 999:999 /var/lib/postgresql/data
USER postgres

# Bad practice. Update when possible
ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword
ENV POSTGRES_DB=transportation-db

EXPOSE 5432

# Custom initialization scripts
COPY ./scripts/init.sql /docker-entrypoint-initdb.d/