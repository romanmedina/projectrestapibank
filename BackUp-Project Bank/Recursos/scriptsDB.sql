Create database proyectosemana01;
use proyectosemana01;
Create table person(
 idPerson int auto_increment,
 fullName varchar(30),
 typeDoc int,
 numberDoc char(8),
 DateBirth date,
 email varchar(30),
 phone int,
 status boolean,
 userCreation varchar(30),
 ipCreation varchar(30),
 constraint pk_person_id primary key(idPerson));

Create table holder(
idHolder int auto_increment,
idperson int,
dateOfEntry date,
userCreation varchar(30),
ipCreation varchar(30),
constraint pk_holder_id primary key(idHolder),
constraint fk_person_holder_id foreign key(idPerson) references person(idPerson)
);

create table employee(
idEmployee int auto_increment,
idPerson int,
dateOfEntry date,
userCreation varchar(30),
ipCreation varchar(30),
constraint pk_employee_id primary key(idEmployee),
constraint fk_person_employee_id foreign key(idPerson) references person(idPerson)
);

create table client(
idClient int auto_increment,
idPerson int,
idTypeClient int,
dateOfEntry date,
userCreation varchar(30),
ipCreation varchar(30),
constraint pk_client_id primary key(idClient),
constraint fk_person_client_id foreign key(idPerson) references person(idPerson)
);

create table account_saving(
idSaving int auto_increment,
idClient int,
typeSaving varchar(30),
typeCurrency varchar(10),
accountNumber int,
typeAccount varchar(30),
registDate date,
balance decimal,
interest decimal,
constraint pk_account_saving_id primary key(idSaving),
constraint fk_client_account_sav_id foreign key(idClient) references client(idClient)
);

create table account_fixed(
idFixed int auto_increment,
idClient int,
typeCurrency varchar(10),
accountNumber int,
depositDate date,
deposit decimal,
balance decimal,
countMonth int,
interestPay varchar(30),
constraint pk_account_fixed_id primary key(idfixed),
constraint fk_client_account_fix_id foreign key(idClient) references client(idClient)
);

create table account_credit(
idCredit int auto_increment,
idClient int,
typeCurrency varchar(10),
accountNumber int,
depositDate date,
balanceTotal decimal,
balanceConsumed decimal,
countMonth int,
interest varchar(30),
constraint pk_account_credit_id primary key(idCredit),
constraint fk_client_account_cred_id foreign key(idClient) references client(idClient)
);

create table movement(
idMovementFixed int auto_increment,
idCredit int,
idFixed int,
idSaving int,
dateMovement date,
type varchar(30),
interest decimal,
balance decimal,
constraint pk_movement_id primary key(idMovementFixed)
);

create table comission(
idComission int auto_increment,
idSaving int,
rate decimal,
constraint pk_comission_id primary key(idComission),
constraint fk_saving_comission foreign key(idSaving) references account_saving(idSaving)
);
