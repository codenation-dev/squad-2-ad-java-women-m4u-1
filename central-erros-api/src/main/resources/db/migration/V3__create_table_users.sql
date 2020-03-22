CREATE TABLE IF NOT EXISTS users (
    ID  uuid DEFAULT uuid_generate_v4(),
    NAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    TOKEN_ACCESS VARCHAR(50)
);

INSERT INTO users(name, email, password)
VALUES ('admin', 'admin', '$2a$10$iHPrrMYnHwnRtmirMJLgK.uwQmpS5e0kad901jaMASr7TOKJlWBVi');