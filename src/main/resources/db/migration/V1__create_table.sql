create schema if not exists store;

set search_path=store,pg_sql;

CREATE TABLE IF NOT EXISTS store.book(
id UUID PRIMARY KEY,
isbn varchar(13) unique,
book_name VARCHAR(255) NOT NULL,
book_author VARCHAR(255) NOT NULL,
category VARCHAR(255),
created_on timestamp,
modified_on timestamp,
unique(book_name,book_author)
);
