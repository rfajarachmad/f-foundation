SET SCHEMA Central;

DROP TABLE IF EXISTS User;

CREATE TABLE User(
	UserGUID VARCHAR(50) PRIMARY KEY, 
	Username VARCHAR(50),
	Password VARCHAR(50),
	RecordStatus INT,
	CreatedBy VARCHAR(50),
	CreationDate DATE,
	LastUpdateadBy VARCHAR(50),
	LastUpdateDate DATE
)