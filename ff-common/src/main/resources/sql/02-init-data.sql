SET SCHEMA Central;

INSERT INTO Lookup (LookupGUID, Type, Code, Name, RecordStatus, CreatedBy, CreationDate, LastUpdatedBy, LastUpdateDate) VALUES(RANDOM_UUID(), 'GENDER','M','Male',1,RANDOM_UUID(), CURRENT_TIMESTAMP, RANDOM_UUID(), CURRENT_TIMESTAMP);
INSERT INTO Lookup (LookupGUID, Type, Code, Name, RecordStatus, CreatedBy, CreationDate, LastUpdatedBy, LastUpdateDate) VALUES(RANDOM_UUID(), 'GENDER','F','Female',1,RANDOM_UUID(), CURRENT_TIMESTAMP, RANDOM_UUID(), CURRENT_TIMESTAMP);