DROP DATABASE `selection-committee-db`;
CREATE DATABASE `selection-committee-db`;
USE `selection-committee-db`;

CREATE TABLE language
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(120) NOT NULL UNIQUE
);


CREATE TABLE user
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    login    NVARCHAR(120)            NOT NULL,
    password NVARCHAR(120)            NOT NULL,
    role     ENUM ('admin','entrant') NOT NULL
);


CREATE TABLE entrant
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    full_name   NVARCHAR(120)              NOT NULL,
    email       NVARCHAR(120)              NOT NULL,
    city        NVARCHAR(120)              NOT NULL,
    region      NVARCHAR(120)              NOT NULL,
    school_name NVARCHAR(120)              NOT NULL,
    state       ENUM ('unlocked','locked') NOT NULL DEFAULT 'unlocked',
    user_id     INT                        NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE RESTRICT
);



CREATE TABLE subject
(
    id INT PRIMARY KEY AUTO_INCREMENT
);


CREATE TABLE faculty
(
    id                  INT PRIMARY KEY AUTO_INCREMENT,
    students_fin_by_gov INT NOT NULL,
    commercial_students INT NOT NULL
);



CREATE TABLE faculty_translation
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    faculty_id  INT           NOT NULL,
    language_id INT           NOT NULL,
    name        NVARCHAR(120) NOT NULL,
    description TEXT          NOT NULL,
    FOREIGN KEY (faculty_id) REFERENCES faculty (id) ON DELETE CASCADE,
    FOREIGN KEY (language_id) REFERENCES language (id) ON DELETE RESTRICT
);


CREATE TABLE faculty_subject
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    faculty_id  INT           NOT NULL,
    subject_id  INT           NOT NULL,
    coefficient DECIMAL(4, 2) NOT NULL,
    FOREIGN KEY (faculty_id) REFERENCES faculty (id) ON DELETE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE
);

CREATE TABLE entrant_faculty_subject
(
    id                 INT PRIMARY KEY AUTO_INCREMENT,
    entrant_id         INT           NOT NULL,
    faculty_id         INT           NOT NULL,
    faculty_subject_id INT           NOT NULL,
    subject_mark       DECIMAL(5, 2) NOT NULL,
    FOREIGN KEY (entrant_id) REFERENCES entrant (id)
        ON DELETE CASCADE,
    FOREIGN KEY (faculty_id) REFERENCES faculty (id)
        ON DELETE CASCADE,
    FOREIGN KEY (faculty_subject_id) REFERENCES faculty_subject (id)
        ON DELETE CASCADE
);


CREATE TABLE acceptance
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    faculty_id INT NOT NULL,
    entrant_id INT NOT NULL,
    is_final   BOOL DEFAULT FALSE,
    FOREIGN KEY (entrant_id) REFERENCES entrant (id)
        ON DELETE CASCADE,
    FOREIGN KEY (faculty_id) REFERENCES faculty (id)
        ON DELETE CASCADE

);


CREATE TABLE subject_translation
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        NVARCHAR(120) NOT NULL,
    subject_id  INT           NOT NULL,
    language_id INT           NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subject (id)
        ON DELETE CASCADE,
    FOREIGN KEY (language_id) REFERENCES language (id)
        ON DELETE CASCADE
);



INSERT INTO language(name)
VALUES ('eng'),
       ('ukr');

INSERT INTO user(login, password, role)
VALUES ('admin', 'admin', 'admin');
INSERT INTO user(login, password, role)
VALUES ('entrant1', 'entrant1', 'entrant');
INSERT INTO user(login, password, role)
VALUES ('entrant2', 'entrant2', 'entrant');
INSERT INTO user(login, password, role)
VALUES ('entrant3', 'entrant3', 'entrant');
INSERT INTO user(login, password, role)
VALUES ('entrant4', 'entrant4', 'entrant');

INSERT INTO entrant(full_name, email, city, region, school_name, user_id)
    VALUE ('James Smith', 'james.smith_gmail.com', 'Lviv', 'Lvivska oblast',
           'School #123', 2);

INSERT INTO entrant(full_name, email, city, region, school_name, user_id)
    VALUE ('Michael Smith', 'michael.smith_gmail.com', 'Lviv', 'Lvivska oblast',
           'School #123', 3);

INSERT INTO entrant(full_name, email, city, region, school_name, user_id)
    VALUE ('Maria Garcia', 'maria.garcia_gmail.com', 'Lviv', 'Lvivska oblast',
           'School #123', 4);

INSERT INTO entrant(full_name, email, city, region, school_name, user_id)
    VALUE ('James Johnson', 'james.johnson_gmail.com', 'Lviv', 'Lvivska oblast',
           'School #123', 5);


INSERT INTO subject(id)
VALUES (1),
       (2),
       (3),
       (4),
       (5);

INSERT INTO subject_translation(name, subject_id, language_id)
VALUES ('ЗНО Українська мова', 1, 1),
       ('ЗНО Математика', 2, 1),
       ('ЗНО Фізика', 3, 1),
       ('ЗНО Іноземна мова', 4, 1),
       ('Середній
бал атестата', 5, 1);

INSERT INTO subject_translation(name, subject_id, language_id)
VALUES ('EIT Ukrainian language', 1, 2),
       ('EIT Math', 2, 2),
       ('EIT Physics', 3, 2),
       ('EIT Foreign language', 4, 2),
       ('School GPA', 5, 2);

INSERT INTO faculty(faculty.students_fin_by_gov,
                    faculty
                        .commercial_students)
VALUES (1, 2),
       (2, 1),
       (2, 2);



INSERT INTO faculty_translation(faculty_id, language_id, name, description)
VALUES (1, 1, 'Management', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.
Etiam facilisis ligula vel metus bibendum venenatis.');

INSERT INTO faculty_translation(faculty_id, language_id, name, description)
VALUES (1, 2, 'Менеджмент', 'Протягом цієї п''ятирічки в ґрунт
було висаджено гарбуз, шпинат та цілющий фенхель');


INSERT INTO faculty_translation(faculty_id, language_id, name, description)
VALUES (2, 1, 'Civil Engineering', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.
Etiam facilisis ligula vel metus bibendum venenatis.');

INSERT INTO faculty_translation(faculty_id, language_id, name, description)
VALUES (2, 2, 'Будівництво', 'Протягом цієї п''ятирічки в ґрунт
було висаджено гарбуз, шпинат та цілющий фенхель');

INSERT INTO faculty_translation(faculty_id, language_id, name, description)
VALUES (3, 1, 'Information Technology', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.
Etiam facilisis ligula vel metus bibendum venenatis.');

INSERT INTO faculty_translation(faculty_id, language_id, name, description)
VALUES (3, 2, 'Інформаційні технології', 'Протягом цієї п''ятирічки в ґрунт
було висаджено гарбуз, шпинат та цілющий фенхель');

INSERT INTO faculty_subject(faculty_id, subject_id, coefficient)
VALUES (1, 1, 0.3),
       (1, 2, 0.3),
       (1, 4, 0.3),
       (1, 5, 0.1);

INSERT INTO faculty_subject(faculty_id, subject_id, coefficient)
VALUES (2, 1, 0.3),
       (2, 2, 0.3),
       (2, 3, 0.3),
       (2, 5, 0.1);

INSERT INTO faculty_subject(faculty_id, subject_id, coefficient)
VALUES (3, 1, 0.3),
       (3, 2, 0.3),
       (3, 3, 0.3),
       (3, 5, 0.1);

INSERT INTO acceptance(faculty_id, entrant_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);
INSERT INTO acceptance(faculty_id, entrant_id)
VALUES (2, 1),
       (2, 2),
       (3, 4);
INSERT INTO acceptance(faculty_id, entrant_id)
VALUES (3, 1),
       (3, 2),
       (3, 3),
       (3, 4);

-- James Smith - Management
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (1, 1, 1, 190.01),
       (1, 1, 2, 190.02),
       (1, 1, 4, 180.03),
       (1, 1, 5, 170.03);


-- James Smith - Civil Engineering
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (1, 2, 1, 190),
       (1, 2, 2, 190),
       (1, 2, 3, 180),
       (1, 2, 5, 170);

-- James Smith - IT
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (1, 2, 1, 190),
       (1, 2, 2, 190),
       (1, 2, 3, 180),
       (1, 2, 5, 170);



-- Michael Smith - Management
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (2, 1, 1, 191),
       (2, 1, 2, 191),
       (2, 1, 4, 181),
       (2, 1, 5, 171);


-- Michael Smith - Civil Engineering
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (2, 2, 1, 191),
       (2, 2, 2, 191),
       (2, 2, 3, 181),
       (2, 2, 5, 171);

-- Michael Smith - IT
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (2, 2, 1, 191),
       (2, 2, 2, 191),
       (2, 2, 3, 181),
       (2, 2, 5, 171);


-- Maria Garcia - Management
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (3, 1, 1, 192),
       (3, 1, 2, 192),
       (3, 1, 4, 182),
       (3, 1, 5, 172);



-- Maria Garcia - IT
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (3, 3, 1, 192),
       (3, 3, 2, 192),
       (3, 3, 3, 182),
       (3, 3, 5, 172);

-- James Johnson - Civil Engineering
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (4, 2, 1, 193),
       (4, 2, 2, 193),
       (4, 2, 3, 183),
       (4, 2, 5, 173);

-- James Johnson - IT
INSERT INTO entrant_faculty_subject(entrant_id, faculty_id, faculty_subject_id,
                                    subject_mark)
VALUES (4, 2, 1, 193),
       (4, 2, 2, 193),
       (4, 2, 3, 183),
       (4, 2, 5, 173);

