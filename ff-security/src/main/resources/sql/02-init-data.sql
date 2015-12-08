SET SCHEMA Central;

INSERT INTO User(UserGUID, Username, Password) VALUES(RANDOM_UUID(), 'admin','password');