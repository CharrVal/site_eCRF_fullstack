INSERT INTO roles (libelle) VALUES
                                ('ADMIN'),
                                ('STUDY COORDINATOR'),
                                ('INVESTIGATOR'),
                                ('CRA'),
                                ('USER');

INSERT INTO users (username, password, id_roles) VALUES
    ('admin', '$2a$10$YiM3lmvkJrjrAhTwEqHYtOHe68uKNqCNyIIhqCPiXfLp7RHrWZvBu', 1),
    ('studyco', '$2a$10$YiM3lmvkJrjrAhTwEqHYtOHe68uKNqCNyIIhqCPiXfLp7RHrWZvBu', 2),
    ('investigator', '$2a$10$YiM3lmvkJrjrAhTwEqHYtOHe68uKNqCNyIIhqCPiXfLp7RHrWZvBu', 3),
    ('cra', '$2a$10$YiM3lmvkJrjrAhTwEqHYtOHe68uKNqCNyIIhqCPiXfLp7RHrWZvBu', 4),
    ('user', '$2a$10$YiM3lmvkJrjrAhTwEqHYtOHe68uKNqCNyIIhqCPiXfLp7RHrWZvBu', 5);


INSERT INTO studies (name, description, user_id) VALUES
                                            ('Étude Covid', 'Étude sur le site A', 1),
                                            ('Étude Diabète', 'Étude sur le site B', 1);


INSERT INTO sites (name, start_date, end_date, study_id) VALUES
                                                             ('Hôpital La Rochelle', '2026-01-01', '2026-12-31', 1),
                                                             ('CHU Bordeaux', '2026-01-01', '2026-12-31', 1),
                                                             ('Hôpital Nantes', '2026-02-01', '2026-12-31', 2);


INSERT INTO patients (subject_number, site_id) VALUES
                                                   (1001, 1),
                                                   (1002, 1),
                                                   (1003, 2),
                                                   (2001, 3),
                                                   (2002, 3);


INSERT INTO visits (name, visit_date, patient_id, study_id) VALUES
                                                                ('Visite Initiale', '2026-03-01', 1, 1),
                                                                ('Visite Initiale', '2026-03-01', 2, 1),
                                                                ('Visite Initiale', '2026-03-02', 3, 1),
                                                                ('Visite Initiale', '2026-03-04', 4, 2),
                                                                ('Visite Initiale', '2026-03-04', 5, 2),
                                                                ('Visite Suivi 1', '2026-03-05', 1, 1),
                                                                ('Visite Suivi 2', '2026-03-10', 1, 1),
                                                                ('Visite Suivi', '2026-03-06', 2, 1),
                                                                ('Visite Suivi', '2026-03-07', 3, 1),
                                                                ('Visite Suivi', '2026-03-08', 4, 2),
                                                                ('Visite Suivi 2', '2026-03-12', 5, 2),
                                                                ('Visite Suivi 3', '2026-03-15', 5, 2),
    ('Visite Fin d''étude', '2026-03-15', 3, 1),
    ('Visite Fin d''étude', '2026-03-18', 5, 2);

INSERT INTO vital_signs (type, value, unit, measured_at, visit_id) VALUES
                                                                       ('TEMPERATURE', 37.2, '°C', '2026-03-01 10:00', 1),
                                                                       ('HEART_RATE', 80, 'bpm', '2026-03-01 10:05', 1),
                                                                       ('SYSTOLIC_PRESSURE', 120, 'mmHg', '2026-03-01 10:10', 1),
                                                                       ('DIASTOLIC_PRESSURE', 80, 'mmHg', '2026-03-01 10:10', 1),
                                                                       ('WEIGHT', 70, 'kg', '2026-03-01 10:15', 1),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-01 10:15', 1),

                                                                       ('TEMPERATURE', 37.0, '°C', '2026-03-05 09:30', 2),
                                                                       ('HEART_RATE', 78, 'bpm', '2026-03-05 09:35', 2),
                                                                       ('SYSTOLIC_PRESSURE', 118, 'mmHg', '2026-03-05 09:40', 2),
                                                                       ('DIASTOLIC_PRESSURE', 77, 'mmHg', '2026-03-05 09:40', 2),
                                                                       ('WEIGHT', 69.5, 'kg', '2026-03-05 09:45', 2),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-05 09:45', 2),

                                                                       ('TEMPERATURE', 36.9, '°C', '2026-03-10 09:30', 3),
                                                                       ('HEART_RATE', 79, 'bpm', '2026-03-10 09:35', 3),
                                                                       ('SYSTOLIC_PRESSURE', 119, 'mmHg', '2026-03-10 09:40', 3),
                                                                       ('DIASTOLIC_PRESSURE', 78, 'mmHg', '2026-03-10 09:40', 3),
                                                                       ('WEIGHT', 69.8, 'kg', '2026-03-10 09:45', 3),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-10 09:45', 3),

                                                                       ('TEMPERATURE', 36.8, '°C', '2026-03-01 10:10', 4),
                                                                       ('HEART_RATE', 77, 'bpm', '2026-03-01 10:15', 4),
                                                                       ('SYSTOLIC_PRESSURE', 115, 'mmHg', '2026-03-01 10:20', 4),
                                                                       ('DIASTOLIC_PRESSURE', 75, 'mmHg', '2026-03-01 10:20', 4),
                                                                       ('WEIGHT', 68.5, 'kg', '2026-03-01 10:25', 4),
                                                                       ('HEIGHT', 174, 'cm', '2026-03-01 10:25', 4),

                                                                       ('TEMPERATURE', 37.0, '°C', '2026-03-06 09:30', 5),
                                                                       ('HEART_RATE', 78, 'bpm', '2026-03-06 09:35', 5),
                                                                       ('SYSTOLIC_PRESSURE', 117, 'mmHg', '2026-03-06 09:40', 5),
                                                                       ('DIASTOLIC_PRESSURE', 76, 'mmHg', '2026-03-06 09:40', 5),
                                                                       ('WEIGHT', 68.8, 'kg', '2026-03-06 09:45', 5),
                                                                       ('HEIGHT', 174, 'cm', '2026-03-06 09:45', 5),

                                                                       ('TEMPERATURE', 37.1, '°C', '2026-03-02 10:00', 6),
                                                                       ('HEART_RATE', 82, 'bpm', '2026-03-02 10:05', 6),
                                                                       ('SYSTOLIC_PRESSURE', 122, 'mmHg', '2026-03-02 10:10', 6),
                                                                       ('DIASTOLIC_PRESSURE', 79, 'mmHg', '2026-03-02 10:10', 6),
                                                                       ('WEIGHT', 71, 'kg', '2026-03-02 10:15', 6),
                                                                       ('HEIGHT', 176, 'cm', '2026-03-02 10:15', 6),

                                                                       ('TEMPERATURE', 37.3, '°C', '2026-03-07 09:30', 7),
                                                                       ('HEART_RATE', 83, 'bpm', '2026-03-07 09:35', 7),
                                                                       ('SYSTOLIC_PRESSURE', 123, 'mmHg', '2026-03-07 09:40', 7),
                                                                       ('DIASTOLIC_PRESSURE', 80, 'mmHg', '2026-03-07 09:40', 7),
                                                                       ('WEIGHT', 71.2, 'kg', '2026-03-07 09:45', 7),
                                                                       ('HEIGHT', 176, 'cm', '2026-03-07 09:45', 7),

                                                                       ('TEMPERATURE', 37.2, '°C', '2026-03-15 10:00', 8),
                                                                       ('HEART_RATE', 81, 'bpm', '2026-03-15 10:05', 8),
                                                                       ('SYSTOLIC_PRESSURE', 121, 'mmHg', '2026-03-15 10:10', 8),
                                                                       ('DIASTOLIC_PRESSURE', 78, 'mmHg', '2026-03-15 10:10', 8),
                                                                       ('WEIGHT', 70.5, 'kg', '2026-03-15 10:15', 8),
                                                                       ('HEIGHT', 176, 'cm', '2026-03-15 10:15', 8),

                                                                       ('TEMPERATURE', 36.9, '°C', '2026-03-04 09:30', 9),
                                                                       ('HEART_RATE', 79, 'bpm', '2026-03-04 09:35', 9),
                                                                       ('SYSTOLIC_PRESSURE', 118, 'mmHg', '2026-03-04 09:40', 9),
                                                                       ('DIASTOLIC_PRESSURE', 77, 'mmHg', '2026-03-04 09:40', 9),
                                                                       ('WEIGHT', 70, 'kg', '2026-03-04 09:45', 9),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-04 09:45', 9),

                                                                       ('TEMPERATURE', 37.0, '°C', '2026-03-08 09:30', 10),
                                                                       ('HEART_RATE', 81, 'bpm', '2026-03-08 09:35', 10),
                                                                       ('SYSTOLIC_PRESSURE', 120, 'mmHg', '2026-03-08 09:40', 10),
                                                                       ('DIASTOLIC_PRESSURE', 78, 'mmHg', '2026-03-08 09:40', 10),
                                                                       ('WEIGHT', 70.2, 'kg', '2026-03-08 09:45', 10),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-08 09:45', 10),

                                                                       ('TEMPERATURE', 37.1, '°C', '2026-03-04 09:30', 11),
                                                                       ('HEART_RATE', 82, 'bpm', '2026-03-04 09:35', 11),
                                                                       ('SYSTOLIC_PRESSURE', 122, 'mmHg', '2026-03-04 09:40', 11),
                                                                       ('DIASTOLIC_PRESSURE', 79, 'mmHg', '2026-03-04 09:40', 11),
                                                                       ('WEIGHT', 70.8, 'kg', '2026-03-04 09:45', 11),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-04 09:45', 11),

                                                                       ('TEMPERATURE', 37.2, '°C', '2026-03-12 09:30', 12),
                                                                       ('HEART_RATE', 83, 'bpm', '2026-03-12 09:35', 12),
                                                                       ('SYSTOLIC_PRESSURE', 123, 'mmHg', '2026-03-12 09:40', 12),
                                                                       ('DIASTOLIC_PRESSURE', 80, 'mmHg', '2026-03-12 09:40', 12),
                                                                       ('WEIGHT', 71, 'kg', '2026-03-12 09:45', 12),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-12 09:45', 12),

                                                                       ('TEMPERATURE', 37.3, '°C', '2026-03-15 09:30', 13),
                                                                       ('HEART_RATE', 84, 'bpm', '2026-03-15 09:35', 13),
                                                                       ('SYSTOLIC_PRESSURE', 124, 'mmHg', '2026-03-15 09:40', 13),
                                                                       ('DIASTOLIC_PRESSURE', 81, 'mmHg', '2026-03-15 09:40', 13),
                                                                       ('WEIGHT', 71.5, 'kg', '2026-03-15 09:45', 13),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-15 09:45', 13),

                                                                       ('TEMPERATURE', 37.2, '°C', '2026-03-18 09:30', 14),
                                                                       ('HEART_RATE', 83, 'bpm', '2026-03-18 09:35', 14),
                                                                       ('SYSTOLIC_PRESSURE', 123, 'mmHg', '2026-03-18 09:40', 14),
                                                                       ('DIASTOLIC_PRESSURE', 80, 'mmHg', '2026-03-18 09:40', 14),
                                                                       ('WEIGHT', 71, 'kg', '2026-03-18 09:45', 14),
                                                                       ('HEIGHT', 175, 'cm', '2026-03-18 09:45', 14);