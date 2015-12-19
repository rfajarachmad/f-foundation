SET SCHEMA Central;

INSERT INTO Role(RoleGUID, Code, Name, Description, IsInitialRole) VALUES (RANDOM_UUID(), 'TO', 'Tenant Owner', 'Tenant Owner', 1);

INSERT INTO User(UserGUID, Username, Password, RecordStatus) VALUES('d7a435ee954046238242abdc6b04861f', 'system','system', 1);