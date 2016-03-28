--------------------------------------------------------
-- 	CREATE TABLE STRUCTURE WITHOUT PK 
--------------------------------------------------------

CREATE TABLE "WEBSTORE"."T_GENERATOR" 
   (	
   "GEN_KEY" VARCHAR2(255 BYTE) NOT NULL,   
	"GEN_VALUE" NUMBER NOT NULL
   );
   

CREATE TABLE "WEBSTORE"."T_PRODUCT_TYPE" 
(
	"ID" NUMBER NOT NULL,
	"NAME" VARCHAR2 (500 BYTE) NOT NULL
);

CREATE TABLE "WEBSTORE"."T_ORDER_TYPE" 
(
	"ID" NUMBER NOT NULL,
	"NAME" VARCHAR2 (50 BYTE) NOT NULL
);

CREATE TABLE "WEBSTORE"."T_ROLE" 
(
	"ID" NUMBER NOT NULL,
	"NAME" VARCHAR2 (50 BYTE) NOT NULL
);

CREATE TABLE "WEBSTORE"."T_CURRENCY" 
(
	"ID" NUMBER NOT NULL,
	"NAME" VARCHAR2 (50 BYTE) NOT NULL,
	"RATE" NUMBER NOT NULL
);


CREATE TABLE "WEBSTORE"."T_USER" 
(
	"ID" NUMBER NOT NULL,
	"USERNAME" VARCHAR2 (30 BYTE) NOT NULL,
	"PASSWORD" VARCHAR2(50 BYTE) NOT NULL,
	"ROLE_ID" NUMBER NOT NULL
);

CREATE TABLE "WEBSTORE"."T_PRODUCT" 
(
	"ID" NUMBER NOT NULL,
	"NAME" VARCHAR2 (50 BYTE) NOT NULL,
	"DESCRIPTION" VARCHAR2 (500 BYTE), 
	"PRODUCT_TYPE_ID" NUMBER NOT NULL,
	"CURRENCY_ID" NUMBER NOT NULL,
	"SINGLE_PRICE" NUMBER NOT NULL,
	"QUANTITY" NUMBER NOT NULL,
	"PICTURE_NAME" VARCHAR2 (50 BYTE),
	"ACTIVE" NUMBER NOT NULL
);

CREATE TABLE "WEBSTORE"."T_CUSTOMER" 
(
	"ID" NUMBER NOT NULL,
	"NAME" VARCHAR2 (50 BYTE) NOT NULL,
	"BIRTH_DATE" DATE NOT NULL,
	"ADDRESS" VARCHAR2 (100 BYTE),
	"USER_ID" NUMBER NOT NULL,
	"ACTIVE" NUMBER NOT NULL
);

CREATE TABLE "WEBSTORE"."T_ORDER" 
(
	"ID" NUMBER NOT NULL,
	"CUSTOMER_ID" NUMBER NOT NULL,
	"ORDER_TYPE_ID" NUMBER NOT NULL,
	"TOTAL" NUMBER NOT NULL,
	"PURCHASE_DATE" DATE NOT NULL,
	"COMMENT" VARCHAR2 (200 BYTE)
);


CREATE TABLE "WEBSTORE"."T_ORDER_DETAILS" 
(
	"ID" NUMBER NOT NULL,
	"ORDER_ID" NUMBER NOT NULL,
	"PRODUCT_ID" NUMBER NOT NULL,
	"QUANTITY" NUMBER NOT NULL,
	"PRICE" NUMBER NOT NULL,
	"CURRENCY_ID" NUMBER NOT NULL,
);


--------------------------------------------------------
-- 	CREATE TABLE PRIMARY KEYS 
--------------------------------------------------------

ALTER TABLE "WEBSTORE"."T_USER" ADD CONSTRAINT "T_USER_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_ROLE" ADD CONSTRAINT "T_ROLE_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_PRODUCT" ADD CONSTRAINT "T_PRODUCT_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_PRODUCT_TYPE" ADD CONSTRAINT "T_PRODUCT_TYPE_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_CUSTOMER" ADD CONSTRAINT "T_CUSTOMER_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_ORDER_TYPE" ADD CONSTRAINT "T_ORDER_TYPE_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_ORDER" ADD CONSTRAINT "T_ORDER_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_ORDER_DETAILS" ADD CONSTRAINT "T_ORDER_DETAILS_PK" PRIMARY KEY ("ID");
ALTER TABLE "WEBSTORE"."T_CURRENCY" ADD CONSTRAINT "T_CURRENCY_PK" PRIMARY KEY ("ID");



--------------------------------------------------------
-- 	CREATE TABLE FOREIGN KEYS 
--------------------------------------------------------

ALTER TABLE "WEBSTORE"."T_USER" ADD CONSTRAINT "T_USER_ROLE_FK1" FOREIGN KEY ("ROLE_ID")
	  REFERENCES "WEBSTORE"."T_ROLE" ("ID") ENABLE;
	  
ALTER TABLE "WEBSTORE"."T_PRODUCT" ADD CONSTRAINT "T_PRODUCT_PRODUCT_TYPE_FK1" FOREIGN KEY ("PRODUCT_TYPE_ID")
	  REFERENCES "WEBSTORE"."T_PRODUCT_TYPE" ("ID") ENABLE;
ALTER TABLE "WEBSTORE"."T_PRODUCT" ADD CONSTRAINT "T_PRODUCT_CURRENCY_FK1" FOREIGN KEY ("CURRENCY_ID")
	  REFERENCES "WEBSTORE"."T_CURRENCY" ("ID") ENABLE;

ALTER TABLE "WEBSTORE"."T_CUSTOMER" ADD CONSTRAINT "T_CUSTOMER_ROLE_FK1" FOREIGN KEY ("USER_ID")
	  REFERENCES "WEBSTORE"."T_USER" ("ID") ENABLE;


ALTER TABLE "WEBSTORE"."T_ORDER" ADD CONSTRAINT "T_ORDER_CUSTOMER_FK1" FOREIGN KEY ("CUSTOMER_ID")
	  REFERENCES "WEBSTORE"."T_CUSTOMER" ("ID") ENABLE;
ALTER TABLE "WEBSTORE"."T_ORDER" ADD CONSTRAINT "T_ORDER_ORDER_TYPE_FK1" FOREIGN KEY ("ORDER_TYPE_ID")
	  REFERENCES "WEBSTORE"."T_ORDER_TYPE" ("ID") ENABLE;


ALTER TABLE "WEBSTORE"."T_ORDER_DETAILS" ADD CONSTRAINT "T_ORDER_DETAILS_ORDER_FK1" FOREIGN KEY ("ORDER_ID")
	  REFERENCES "WEBSTORE"."T_ORDER" ("ID") ENABLE;
ALTER TABLE "WEBSTORE"."T_ORDER_DETAILS" ADD CONSTRAINT "T_ORDER_DETAILS_PRODUCT__FK1" FOREIGN KEY ("PRODUCT_ID")
	  REFERENCES "WEBSTORE"."T_PRODUCT" ("ID") ENABLE;

--------------------------------------------------------
-- 	INSERT DATA 
--------------------------------------------------------
INSERT INTO WEBSTORE.T_CURRENCY (ID, NAME, RATE) VALUES  (1, 'BGN', 1.00);

INSERT INTO WEBSTORE.T_ROLE (ID, NAME) VALUES  (1, 'ROLE_ADMIN');
INSERT INTO WEBSTORE.T_ROLE (ID, NAME) VALUES  (2, 'ROLE_USER');


INSERT INTO WEBSTORE.T_USER (ID, USERNAME, PASSWORD, ROLE_ID) VALUES  (1, 'admin', '96e79218965eb72c92a549dd5a330112', 1);
INSERT INTO WEBSTORE.T_USER (ID, USERNAME, PASSWORD, ROLE_ID) VALUES  (2, 'user','96e79218965eb72c92a549dd5a330112', 2);

INSERT INTO WEBSTORE.T_PRODUCT_TYPE (ID, NAME) VALUES  (1, 'electronics,photo,cameras');
INSERT INTO WEBSTORE.T_PRODUCT_TYPE (ID, NAME) VALUES  (2, 'electronics,photo,video');
INSERT INTO WEBSTORE.T_PRODUCT_TYPE (ID, NAME) VALUES  (3, 'electronics,tv,lcd');

INSERT INTO WEBSTORE.T_PRODUCT (ID, NAME, DESCRIPTION, PRODUCT_TYPE_ID, CURRENCY_ID, SINGLE_PRICE, QUANTITY, PICTURE_NAME, ACTIVE) VALUES (1, 'Nikon D5200 24.1MP Digital SLR Camera (Black)', 'Equipped with a 24.1 megapixel DX-format sensor,Powered with EXPEED 3 engine,Sensitivity range from ISO 100 to ISO 6400 and the best in class 39 point AF system', 1, 1, 500, 20, 'pic1.jpg', 1);
INSERT INTO WEBSTORE.T_PRODUCT (ID, NAME, DESCRIPTION, PRODUCT_TYPE_ID, CURRENCY_ID, SINGLE_PRICE, QUANTITY, PICTURE_NAME, ACTIVE) VALUES (2, 'Canon IXUS 275 HS 20.2 MP', 'Ultra-slim IXUS and Canon quality in your pocket,Get closer to the moments that matter with a 12x zoom,Capture stunning photos and movies with 20.2 MP and Intelligent IS,Share easily and shoot remotely using Wi-Fi and NFC,Play with your creativity using Creative shot', 1, 1, 300, 10,'pic2.jpg', 1);
INSERT INTO WEBSTORE.T_PRODUCT (ID, NAME, DESCRIPTION, PRODUCT_TYPE_ID, CURRENCY_ID, SINGLE_PRICE, QUANTITY, PICTURE_NAME, ACTIVE) VALUES (3, 'Sony DSC W830 Cyber-shot 20.1 MP', 'Super HAD CCD sensor with 20.1 effective megapixels,720p MP4 movie mode the camera shoots 1280 x 720 high definition movies at 30 fps,8x optical zoom Carl Zeiss Vario Tessar lens,Equipped with sweep panorama, intelligent auto and picture effect,2.7-inch (230K dots) clear photo LCD display', 1, 1, 2000, 30, 'pic3.jpg', 1);
INSERT INTO WEBSTORE.T_PRODUCT (ID, NAME, DESCRIPTION, PRODUCT_TYPE_ID, CURRENCY_ID, SINGLE_PRICE, QUANTITY, PICTURE_NAME, ACTIVE) VALUES (4, 'Nikon Coolpix S2900 20.1MP', '20.1 megapixels camera,5x optical zoom,2.7 inch TFT LCD, and 5-level brightness adjustment,Control : TTL auto flash with monitor preflashes,Shutter type : Mechanical and CCD electronic shutter', 1, 1, 200, 30, 'pic4.jpg', 1);

   
--------------------------------------------------------
-- 	SET ORACLE SESSION TO COMPARE INSENSITIVE DATA LIKE 'aAA' == 'AAA' 
--------------------------------------------------------
   
ALTER SESSION SET NLS_COMP=LINGUISTIC;