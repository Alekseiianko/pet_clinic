INSERT INTO schedule_day (day)
SELECT d::date
FROM generate_series ('2021-01-01' :: TIMESTAMP , '2022-01-01' :: TIMESTAMP, '1 day' :: INTERVAL) as d
where extract (dow from d) not in (0,6);


INSERT INTO schedule_doctor  (start_time, stop_time)
VALUES
('09:00:00', '15:00:00'),
('15:00:00', '21:00:00')


INSERT INTO user_role (role)
VALUES
('user'),
('administrator'),
('moderator')


INSERT INTO clinic  (address, phone, clinic_start_time, clinic_stop_time)
VALUES
('г.Санкт-Петербург, пр.Королева, д.57',  '+7(812)123-45-67', '09:00:00', '21:00:00')


INSERT INTO doctor_position  (position)
VALUES
('Хирург')


INSERT INTO pet_type  (type)
VALUES
('Собака')


INSERT INTO user_list  (name, phonenumber, email, birthday, user_role_id)
VALUES
('Янко Алексей', '+79520967410', 'esoesfiit@icloud.com', '16.04.1996', 1)


INSERT INTO price_list  (service, price)
VALUES
('Кастрация собаки', 5000)


INSERT INTO review  (review_text, rating)
VALUES
('Все отлично! Спасибо Галине петровне', 9)


INSERT INTO doctor  (name, doctor_position_id, phone, clinic_id, schedule_doctor_id
					, schedule_day_id, cabinet, review_id)
VALUES
('Иванова Галина Петровна', 1, '+79153255050', 1, 1, 1, 34, 1 )


update review
set doctor_id = 1
where id = 1


INSERT INTO client  (name, phone, email, user_id)
VALUES
('Алексей Янко', '+79520967410', 'esoesfiit@icloud.com', 1)


INSERT INTO pet  (pet_type_id, name, birthday, client_id)
VALUES
(1, 'Тейлор', '2017', 1)


update client
set pet_id = 1
where id = 1


INSERT INTO session_list  (client_id, clinic_id, doctor_id, time_of_session,
						   price_list_id, session_status)
VALUES
(1, 1, 1, '10:00:00', 1 , 'Ожидается' )