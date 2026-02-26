CREATE TABLE patients
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    subject_number      INT NULL,
    CONSTRAINT pk_patients PRIMARY KEY (id)
);

CREATE TABLE visits
(
    patient_id      BIGINT NOT NULL,
    visits_id       BIGINT NOT NULL
);

CREATE TABLE studies
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    name            VARCHAR(255) NULL,
    description     VARCHAR(255) NULL,
    CONSTRAINT pk_studies PRIMARY KEY (id)
);

CREATE TABLE studies_patients
(
    study_id            BIGINT NOT NULL,
    patients_id         BIGINT NOT NULL
);

CREATE TABLE visits
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NULL,
    date          date         NULL,
    vital_sign_id BIGINT       NULL,
    CONSTRAINT pk_visits PRIMARY KEY (id)
);

CREATE TABLE vital_signs
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    name                VARCHAR(255) NULL,
    description         VARCHAR(255) NULL,
    temperature         DOUBLE NULL,
    pulse               INT NULL,
    systolic_pressure   INT NULL,
    diastolic_pressure  INT NULL,
    weight              DOUBLE NULL,
    height              DOUBLE NULL,
    CONSTRAINT pk_vitalsigns PRIMARY KEY (id)
);

ALTER TABLE visits
    ADD CONSTRAINT uc_patients_visits_visits UNIQUE (visits_id);

ALTER TABLE studies_patients
    ADD CONSTRAINT uc_studies_patients_patients UNIQUE (patients_id);

ALTER TABLE visits
    ADD CONSTRAINT FK_VISITS_ON_VITALSIGN FOREIGN KEY (vital_sign_id) REFERENCES vital_signs (id);

ALTER TABLE visits
    ADD CONSTRAINT fk_patvis_on_patient FOREIGN KEY (patient_id) REFERENCES patients (id);

ALTER TABLE visits
    ADD CONSTRAINT fk_patvis_on_visit FOREIGN KEY (visits_id) REFERENCES visits (id);

ALTER TABLE studies_patients
    ADD CONSTRAINT fk_stupat_on_patient FOREIGN KEY (patients_id) REFERENCES patients (id);

ALTER TABLE studies_patients
    ADD CONSTRAINT fk_stupat_on_study FOREIGN KEY (study_id) REFERENCES studies (id);