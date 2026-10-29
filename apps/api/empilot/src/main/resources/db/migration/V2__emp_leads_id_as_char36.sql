ALTER TABLE emp_leads ADD COLUMN id_new CHAR(36);

UPDATE emp_leads
SET id_new = LOWER(CONCAT_WS('-',
    HEX(SUBSTR(id, 1, 4)),
    HEX(SUBSTR(id, 5, 2)),
    HEX(SUBSTR(id, 7, 2)),
    HEX(SUBSTR(id, 9, 2)),
    HEX(SUBSTR(id, 11, 6))));

ALTER TABLE emp_leads
    DROP PRIMARY KEY,
    DROP COLUMN id,
    CHANGE id_new id CHAR(36) NOT NULL,
    ADD PRIMARY KEY (id);
