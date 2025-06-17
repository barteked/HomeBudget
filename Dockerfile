# Dockerfile for PostgreSQL database for HomeBudget project
FROM postgres
ENV POSTGRES_DB="homebudget_db"
COPY initial_data.sql /docker-entrypoint-initdb.d/