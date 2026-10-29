CREATE TABLE emp_leads (
    id             BINARY(16)   NOT NULL,
    first_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255) NOT NULL,
    email          VARCHAR(255) NOT NULL,
    phone_number   VARCHAR(255),
    company_name   VARCHAR(255) NOT NULL,
    source         VARCHAR(255) NOT NULL,
    employee_count VARCHAR(255) NOT NULL,
    lead_source    VARCHAR(255) NOT NULL,
    lead_status    VARCHAR(255) NOT NULL,
    created_at     TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at     TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    is_active      BOOLEAN      NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id)
);
