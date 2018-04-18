-- CREATE TABLE category
-- (
--   id bigint NOT NULL,
--   addprice bigint,
--   categoryname character varying(255),
--   categoryprice bigint,
--   CONSTRAINT category_pkey PRIMARY KEY (id)
-- )
--
-- CREATE TABLE room
-- (
--   id bigint NOT NULL,
--   category_id bigint,
--   CONSTRAINT room_pkey PRIMARY KEY (id),
--   CONSTRAINT fkllkgnps1iryk3347aokxwbxxm FOREIGN KEY (category_id)
--       REFERENCES category (id) MATCH SIMPLE
--       ON UPDATE NO ACTION ON DELETE NO ACTION
-- )

-- INSERT INTO boock (id, name) VALUES (1, 'Spring Boot - Spring Data JPA with Hibernate and H2 Web Console');

INSERT INTO category (id, addprice,categoryname,categoryprice) VALUES (1,5, 'r',10);
INSERT INTO category (id, addprice,categoryname,categoryprice) VALUES (2,10, 'l',20);
INSERT INTO room (id, category_id) VALUES (1,1);
INSERT INTO room (id, category_id) VALUES (2,2);
INSERT INTO usertable (id, username) VALUES (1,'vasya');
INSERT INTO usertable (id, username) VALUES (2,'givi');

