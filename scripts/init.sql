DROP DATABASE `selection-committee-db`;
CREATE DATABASE `selection-committee-db`;
USE `selection-committee-db`;

CREATE TABLE language
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name CHAR(120) CHARACTER SET UTF8MB4 NOT NULL UNIQUE
);


CREATE TABLE user_type
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    type_name CHAR(120) CHARACTER SET UTF8MB4 NOT NULL UNIQUE
);

INSERT INTO user_type(type_name)
VALUES ('Абітурієнт'),
       ('Адміністратор');

CREATE TABLE user
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    login    CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    password CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    type_id  INT                             NOT NULL DEFAULT 1,
    FOREIGN KEY (type_id) REFERENCES user_type (id) ON DELETE RESTRICT
);

INSERT INTO user(login, password, type_id)
VALUES ('admin', 'admin', 2);
INSERT INTO user(login, password, type_id)
VALUES ('entrant', 'entrant', 1);

CREATE TABLE entrant_state
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    state_name CHAR(120) CHARACTER SET UTF8MB4 NOT NULL UNIQUE
);

INSERT INTO entrant_state(state_name)
VALUES ('Розблокований'),
       ('Заблокований');

CREATE TABLE entrant
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    full_name   CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    email       CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    city        CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    region      CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    school_name CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    state_id    INT                             NOT NULL DEFAULT 1,
    user_id     INT                             NOT NULL,
    FOREIGN KEY (state_id) REFERENCES entrant_state (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT
);

# INSERT INTO entrant(full_name)
# VALUES ('James Smith'),
#        ('Michael Smith'),
#        ('Maria Garcia'),
#        ('James Johnson');

CREATE TABLE subject_type
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name CHAR(120) CHARACTER SET UTF8MB4 NOT NULL
);

INSERT INTO subject_type(name)
VALUES ('ЗНО'),
       ('Творчий конкурс'),
       ('Середній
бал атестата');

CREATE TABLE subject
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    name         CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    subject_type INT                             NOT NULL,
    FOREIGN KEY (subject_type) REFERENCES subject_type (id) ON DELETE CASCADE
);


CREATE TABLE exams_type
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name CHAR(120) CHARACTER SET UTF8MB4 NOT NULL
);

CREATE TABLE coefficient
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    value DECIMAL                         NOT NULL
);

CREATE TABLE faculty
(
    id                  INT PRIMARY KEY AUTO_INCREMENT,
    students_fin_by_gov INT NOT NULL,
    commercial_students INT NOT NULL
);

INSERT INTO faculty(students_fin_by_gov, commercial_students)
VALUES (20, 5),
       (50, 10);

CREATE TABLE faculty_translation
(
    faculty_id  INT                             NOT NULL,
    language_id INT                             NOT NULL,
    name        CHAR(120) CHARACTER SET UTF8MB4 NOT NULL,
    description TEXT                            NOT NULL,
    FOREIGN KEY (faculty_id) REFERENCES faculty (id) ON DELETE CASCADE,
    FOREIGN KEY (language_id) REFERENCES language (id) ON DELETE RESTRICT
);


CREATE TABLE faculty_exams
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    faculty_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (faculty_id) REFERENCES faculty (id) ON DELETE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE
);

CREATE TABLE entrant_exams
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    entrant_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (entrant_id) REFERENCES entrant (id)
        ON DELETE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subject (id)
        ON DELETE CASCADE
);

INSERT INTO exams_type(name)
VALUES ('ЗНО'),
       ('Середній бал документа про
освіту'),
       ('Бал за мотиваційний лист'),
       ('Бал за підготовчі курси'),
       ('Бал за
особливі успіхи');

CREATE TABLE acceptance
(
    faculty_id INT NOT NULL,
    entrant_id INT NOT NULL
)