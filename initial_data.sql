CREATE TABLE person
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100),
    joined_at  TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE TABLE category
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    created_at      TIMESTAMP    NOT NULL DEFAULT now(),
    last_updated_at TIMESTAMP    NOT NULL DEFAULT now()
);

CREATE TABLE quantity
(
    id    SERIAL PRIMARY KEY,
    value VARCHAR(50) NOT NULL
);

CREATE TABLE item
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    category_id INT          NOT NULL,
    quantity_id INT NULL,
    CONSTRAINT fk_item_category
        FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT fk_item_quantity
        FOREIGN KEY (quantity_id) REFERENCES quantity (id)
);

CREATE TABLE cost
(
    id             SERIAL PRIMARY KEY,
    price          NUMERIC(10, 2) NOT NULL,
    effective_date DATE           NOT NULL,
    item_id        INT            NOT NULL,
    CONSTRAINT fk_cost_item
        FOREIGN KEY (item_id) REFERENCES item (id)
);

CREATE TABLE receipt
(
    id           SERIAL PRIMARY KEY,
    person_id    INT            NOT NULL,
    purchased_at TIMESTAMP      NOT NULL,
    total_cost   NUMERIC(12, 2) NOT NULL,
    CONSTRAINT fk_receipt_person
        FOREIGN KEY (person_id) REFERENCES person (id)
);

CREATE TABLE items_in_receipt
(
    id         SERIAL PRIMARY KEY,
    item_id    INT NOT NULL,
    quantity   INT NOT NULL,
    receipt_id INT NOT NULL,
    CONSTRAINT fk_iir_item
        FOREIGN KEY (item_id) REFERENCES item (id),
    CONSTRAINT fk_iir_receipt
        FOREIGN KEY (receipt_id) REFERENCES receipt (id)
);

INSERT INTO person
VALUES (1, 'bartosz', 'andrzejewski', '2004-05-04 12:00:00');

INSERT INTO category
VALUES (1, 'food', '2004-05-04 12:00:00', '2004-05-04 13:20:00');

INSERT INTO quantity
VALUES (1, '50');

INSERT INTO item
VALUES (1, 'apple', 1, 1);

INSERT INTO cost
VALUES (1, 2.50, '2004-05-04 22:00:00', 1);

INSERT INTO receipt
VALUES (1, 1, '2004-05-04 14:00:00', 50);

INSERT INTO items_in_receipt
VALUES (1, 1, 1, 1);

CREATE SEQUENCE category_seq;
SELECT setval('category_seq',(SELECT MAX(id) FROM category));

CREATE SEQUENCE person_seq;
SELECT setval('person_seq', (SELECT MAX(id) FROM person));

CREATE SEQUENCE cost_seq;
SELECT setval('cost_seq', (SELECT MAX(id) FROM cost));

CREATE SEQUENCE item_seq;
SELECT setval('item_seq', (SELECT MAX(id) FROM item));

CREATE SEQUENCE items_in_receipt_seq;
SELECT setval('items_in_receipt_seq', (SELECT MAX(id) FROM items_in_receipt));

CREATE SEQUENCE quantity_seq;
SELECT setval('quantity_seq', (SELECT MAX(id) FROM quantity));

CREATE SEQUENCE receipt_seq;
SELECT setval('receipt_seq', (SELECT MAX(id) FROM receipt));