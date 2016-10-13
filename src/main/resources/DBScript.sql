CREATE SCHEMA sport;

CREATE TABLE sport.coach ( 
	coach_id             bigint  NOT NULL  AUTO_INCREMENT,
	name                 varchar(100)    ,
	surname              varchar(100)    ,
	login                varchar(100)    ,
	password             varchar(100)    ,
	phone                varchar(100)    ,
	email                varchar(100)    ,
	city                 varchar(100)    ,
	country              varchar(100)    ,
	district             varchar(100)    ,
	CONSTRAINT pk_coach PRIMARY KEY ( coach_id )
 ) engine=InnoDB;

CREATE TABLE sport.comment ( 
	comment_id           bigint  NOT NULL  AUTO_INCREMENT,
	comment_text         varchar(250)    ,
	created              timestamp    ,
	updated              time    ,
	deleted              bool    ,
	CONSTRAINT pk_comment_id PRIMARY KEY ( comment_id )
 ) engine=InnoDB;

CREATE TABLE sport.customer_card ( 
	card_id              bigint  NOT NULL  AUTO_INCREMENT,
	created              timestamp    ,
	updated              date    ,
	deleted              bool    ,
	comment              varchar(255)    ,
	CONSTRAINT pk_customer_card PRIMARY KEY ( card_id )
 ) engine=InnoDB;

CREATE TABLE sport.`group` ( 
	group_id             bigint  NOT NULL  AUTO_INCREMENT,
	name                 varchar(100)    ,
	discription          varchar(255)    ,
	CONSTRAINT pk_group PRIMARY KEY ( group_id )
 ) engine=InnoDB;

CREATE TABLE sport.sport ( 
	sport_id             bigint  NOT NULL  AUTO_INCREMENT,
	country              varchar(100)    ,
	sport                varchar(100)    ,
	CONSTRAINT pk_sport PRIMARY KEY ( sport_id )
 ) engine=InnoDB;

CREATE TABLE sport.status ( 
	status_id            bigint  NOT NULL  AUTO_INCREMENT,
	title                varchar(100)    ,
	discription          varchar(255)    ,
	CONSTRAINT pk_status PRIMARY KEY ( status_id )
 ) engine=InnoDB;

CREATE TABLE sport.`user` ( 
	user_id              bigint  NOT NULL  AUTO_INCREMENT,
	name                 varchar(100)    ,
	surname              varchar(100)    ,
	email                varchar(100)    ,
	birthday             date    ,
	phone_id             bigint    ,
	comment_id           bigint    ,
	status_id            bigint    ,
	card_id              bigint    ,
	CONSTRAINT pk_user PRIMARY KEY ( user_id ),
	CONSTRAINT pk_user_0 UNIQUE ( comment_id ) 
 ) engine=InnoDB;

CREATE INDEX idx_user ON sport.`user` ( status_id );

CREATE INDEX idx_user_1 ON sport.`user` ( card_id );

CREATE TABLE sport.user_group ( 
	user_id              bigint    ,
	group_id             bigint    
 ) engine=InnoDB;

CREATE INDEX idx_user_group ON sport.user_group ( user_id );

CREATE INDEX idx_group_user ON sport.user_group ( group_id );

CREATE TABLE sport.user_sport ( 
	user_id              bigint    ,
	sport_id             bigint    
 ) engine=InnoDB;

CREATE INDEX idx_sport_user ON sport.user_sport ( sport_id );

CREATE INDEX idx_user_sport ON sport.user_sport ( user_id );

CREATE TABLE sport.coach_group ( 
	coach_id             bigint    ,
	group_id             bigint    
 ) engine=InnoDB;

CREATE INDEX coach_id ON sport.coach_group ( coach_id );

CREATE INDEX group_id ON sport.coach_group ( group_id );

CREATE TABLE sport.coach_sport ( 
	coach_id             bigint    ,
	sport_id             bigint    
 ) engine=InnoDB;

CREATE INDEX idx_coach_sport ON sport.coach_sport ( coach_id );

CREATE INDEX idx_sport_coach ON sport.coach_sport ( sport_id );

ALTER TABLE sport.coach_group ADD CONSTRAINT fk_coach_group_coach FOREIGN KEY ( coach_id ) REFERENCES sport.coach( coach_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.coach_group ADD CONSTRAINT fk_coach_group_group FOREIGN KEY ( group_id ) REFERENCES sport.`group`( group_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.coach_sport ADD CONSTRAINT coach_id FOREIGN KEY ( coach_id ) REFERENCES sport.coach( coach_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.coach_sport ADD CONSTRAINT fk_coach_sport_sport FOREIGN KEY ( sport_id ) REFERENCES sport.sport( sport_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.`user` ADD CONSTRAINT fk_user FOREIGN KEY ( comment_id ) REFERENCES sport.comment( comment_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.`user` ADD CONSTRAINT fk_user_0 FOREIGN KEY ( status_id ) REFERENCES sport.status( status_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.`user` ADD CONSTRAINT fk_user_2 FOREIGN KEY ( card_id ) REFERENCES sport.customer_card( card_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.user_group ADD CONSTRAINT fk_user_group_user FOREIGN KEY ( user_id ) REFERENCES sport.`user`( user_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.user_group ADD CONSTRAINT fk_user_group_group FOREIGN KEY ( group_id ) REFERENCES sport.`group`( group_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.user_sport ADD CONSTRAINT fk_user_sport_sport FOREIGN KEY ( sport_id ) REFERENCES sport.sport( sport_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sport.user_sport ADD CONSTRAINT fk_user_sport_user FOREIGN KEY ( user_id ) REFERENCES sport.`user`( user_id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

