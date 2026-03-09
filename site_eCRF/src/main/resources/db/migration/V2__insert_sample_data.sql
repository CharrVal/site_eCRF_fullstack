INSERT INTO roles (libelle) VALUES
                                ('ADMIN'),
                                ('USER');

INSERT INTO users (username, password, id_roles) VALUES
    ('admin', '$2a$10$YiM3lmvkJrjrAhTwEqHYtOHe68uKNqCNyIIhqCPiXfLp7RHrWZvBu', 1);

INSERT INTO studies (name, description, user_id) VALUES
                                                     ('Étude COVID-19', 'Suivi des patients COVID-19', 1),
                                                     ('Étude Diabète', 'Suivi des patients diabétiques', 1);

INSERT INTO sites (name, start_date, end_date, study_id) VALUES
                                                             ('Hôpital La Rochelle', '2026-01-01', '2026-12-31', 1),
                                                             ('CHU Bordeaux', '2026-01-01', '2026-12-31', 1),
                                                             ('Hôpital Nantes', '2026-02-01', '2026-12-31', 2);

INSERT INTO patients (subject_number, site_id) VALUES
                                                   (1001, 1),
                                                   (1002, 1),
                                                   (1003, 2),
                                                   (2001, 3);

INSERT INTO visits (name, visit_date, patient_id) VALUES
                                                      ('Visite Initiale', '2026-03-01', 1),
                                                      ('Visite Suivi', '2026-03-05', 1),
                                                      ('Visite Initiale', '2026-03-02', 2),
                                                      ('Visite Initiale', '2026-03-03', 3),
                                                      ('Visite Initiale', '2026-03-04', 4);

INSERT INTO vital_signs (type, value, unit, measured_at, visit_id) VALUES
                                                                       ('TEMPERATURE', 37.2, '°C', '2026-03-01 10:00', 1),
                                                                       ('HEART_RATE', 80, 'bpm', '2026-03-01 10:05', 1),
                                                                       ('WEIGHT', 70, 'kg', '2026-03-01 10:10', 1),

                                                                       ('TEMPERATURE', 36.8, '°C', '2026-03-05 09:30', 2),
                                                                       ('HEART_RATE', 78, 'bpm', '2026-03-05 09:35', 2),

                                                                       ('TEMPERATURE', 37.5, '°C', '2026-03-02 11:00', 3),
                                                                       ('HEART_RATE', 85, 'bpm', '2026-03-02 11:05', 3),

                                                                       ('TEMPERATURE', 36.9, '°C', '2026-03-03 09:45', 4),

                                                                       ('TEMPERATURE', 37.1, '°C', '2026-03-04 10:15', 5),
                                                                       ('HEART_RATE', 82, 'bpm', '2026-03-04 10:20', 5);
