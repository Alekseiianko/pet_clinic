    CREATE TABLE doctor (
		id SERIAL PRIMARY KEY,
		"name" VARCHAR(30) NOT NULL,
		doctor_position_id SMALLINT NOT NULL,
		phone VARCHAR(13) UNIQUE,
		clinic_id SMALLINT NOT NULL,
		schedule_doctor_id int NOT NULL,
		cabinet SMALLSERIAL NOT NULL,
		review_id SMALLINT
	);

	CREATE TABLE pet (
		id SERIAL PRIMARY KEY,
		pet_type_id SMALLINT NOT NULL,
		"name" VARCHAR(30) NOT NULL,
		birthday DATE,
		client_id SMALLINT
	);

	CREATE TABLE client (
		id SERIAL PRIMARY KEY,
		"name" VARCHAR (30) NOT NULL,
		phone VARCHAR(13) NOT NULL,
		email VARCHAR(30),
		pet_id SMALLINT,
		user_id SMALLINT
	);

	CREATE TABLE session_list (
		id SERIAL PRIMARY KEY,
		client_id SMALLINT NOT NULL,
		clinic_id SMALLINT NOT NULL,
		doctor_id SMALLINT NOT NULL,
		time_of_session TIME UNIQUE,
		price_list_id SMALLINT NOT NULL,
		session_status VARCHAR (15) NOT NULL

	);

	CREATE TABLE price_list (
		id SERIAL PRIMARY KEY,
		service VARCHAR (30) UNIQUE,
		price SMALLINT NOT NULL
	);

	 CREATE TABLE user_list (
		id SERIAL PRIMARY KEY,
		"name" VARCHAR (30) NOT NULL,
		phoneNumber VARCHAR(13) UNIQUE,
		email VARCHAR(30) UNIQUE,
		birthday DATE,
		user_role_id SMALLINT NOT NULL
	);

	 CREATE TABLE review (
		id SERIAL PRIMARY KEY,
		doctor_id SMALLINT,
		review_text VARCHAR (200) NOT NULL,
		rating SMALLINT CHECK(Rating > 0 AND Rating < 11)

	);

	CREATE TABLE pet_type (
		id SERIAL PRIMARY KEY,
		type VARCHAR (30) UNIQUE NOT NULL
	);

	CREATE TABLE doctor_position (
		id SERIAL PRIMARY KEY,
		position VARCHAR (20) UNIQUE NOT NULL
	);

	CREATE TABLE clinic (
		id SERIAL PRIMARY KEY,
		address VARCHAR (50) UNIQUE NOT NULL,
		clinic_start_time TIME NOT NULL,
		clinic_stop_time TIME NOT NULL,
		phone VARCHAR (20) UNIQUE NOT NULL
	);

	CREATE TABLE schedule_doctor (
		id SERIAL PRIMARY KEY,
		start_time TIME NOT NULL,
		stop_time TIME NOT NULL
	);

	CREATE TABLE schedule_day (
		id SERIAL PRIMARY KEY
		"date" DATE NOT NULL
	);

	CREATE TABLE user_role (
		id SERIAL PRIMARY KEY,
		role VARCHAR (15)
	);

alter TABLE review add constraint fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor (id);

alter TABLE session_list add constraint fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES  doctor (id);
alter TABLE session_list add constraint fk_client_id FOREIGN KEY (client_id) REFERENCES  client (id);
alter TABLE session_list add constraint fk_price_list_id FOREIGN KEY (price_list_id) REFERENCES  price_list (id);
alter TABLE session_list add constraint fk_clinic_id FOREIGN KEY (clinic_id) REFERENCES clinic (id);

alter TABLE client add constraint fk_pet_id  FOREIGN KEY (pet_id) REFERENCES pet(id);
alter TABLE client add constraint fk_user_id  FOREIGN KEY (user_id) REFERENCES user_list(id);

alter TABLE pet add constraint fk_client_id FOREIGN KEY (client_id) REFERENCES client(id);
alter TABLE pet add constraint fk_pet_type_id FOREIGN KEY (pet_type_id) REFERENCES pet_type(id);

alter TABLE doctor add constraint fk_pet_id FOREIGN KEY (pet_id) REFERENCES  pet(id);
alter TABLE doctor add constraint fk_review_id FOREIGN KEY (review_id) REFERENCES review(id);
alter TABLE doctor add constraint fk_doctor_position_id FOREIGN KEY (doctor_position_id) REFERENCES doctor_position(id);
alter TABLE doctor add constraint fk_clinic_id FOREIGN KEY (clinic_id) REFERENCES clinic(id);
alter TABLE doctor add constraint fk_schedule_doctor_id FOREIGN KEY (schedule_doctor_id) REFERENCES schedule_doctor(id);
alter TABLE doctor add constraint fk_schedule_day_id FOREIGN KEY (schedule_day_id) REFERENCES  schedule_day(id);

alter TABLE user_list add constraint fk_user_role_id FOREIGN KEY (user_role_id) REFERENCES user_role(id);