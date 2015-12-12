SET SCHEMA Central;

DROP TABLE IF EXISTS Role CASCADE;
DROP TABLE IF EXISTS User CASCADE;
DROP TABLE IF EXISTS Registration CASCADE;

CREATE TABLE Role(
	RoleGUID VARCHAR(50) PRIMARY KEY,
	Code VARCHAR(50),
	Name VARCHAR(50),
	Description VARCHAR(50),
	IsInitialRole boolean,
	RecordStatus INT,
	CreatedBy VARCHAR(50),
	CreationDate DATE,
	LastUpdatedBy VARCHAR(50),
	LastUpdateDate DATE
);

CREATE TABLE User(
	UserGUID VARCHAR(50) PRIMARY KEY, 
	Username VARCHAR(50),
	Password VARCHAR(50),
	SourceGUID VARCHAR(50),
	SourceTypeId INT,
	TenantGUID VARCHAR(50),
	RecordStatus INT,
	CreatedBy VARCHAR(50),
	CreationDate DATE,
	LastUpdatedBy VARCHAR(50),
	LastUpdateDate DATE
);

CREATE TABLE UserRole(
	UserGUID VARCHAR(50),
	RoleGUID VARCHAR(50)
);

CREATE TABLE Registration (
	RegistrationGUID VARCHAR(50) PRIMARY KEY,
	TenantName VARCHAR(50),
	Email VARCHAR(50),
	Username VARCHAR(50),
	Password VARCHAR(100),
	RecordStatus INT,
	CreatedBy VARCHAR(50),
	CreationDate DATE,
	LastUpdatedBy VARCHAR(50),
	LastUpdateDate DATE
);

CREATE TABLE Menu (
	MenuGUID VARCHAR(50) PRIMARY KEY,
	Code VARCHAR(30),
	Name VARCHAR(50),
	Path VARCHAR(100),
	RecordStatus INT,
	CreatedBy VARCHAR(50),
	CreationDate DATE,
	LastUpdatedBy VARCHAR(50),
	LastUpdateDate DATE
);

CREATE TABLE RoleMenu (
	RoleGUID VARCHAR(50),
	MenuGUID VARCHAR(50)
);

CREATE TABLE Tenant (
	TenantGUID VARCHAR(50),
	Code VARCHAR(30),
	Name VARCHAR(50),
	DbHostname VARCHAR(100),
	DbUsername VARCHAR(50),
	DbPassword VARCHAR(50),
	RecordStatus INT,
	CreatedBy VARCHAR(50),
	CreationDate DATE,
	LastUpdatedBy VARCHAR(50),
	LastUpdateDate DATE
);

