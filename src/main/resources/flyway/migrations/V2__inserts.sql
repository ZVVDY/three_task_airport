insert into passenger (id, first_name, sur_name, dob, sex, passport_number)
values (1, 'Ivan', 'Ivanov', '25.10.1983', 'male', 'HB6523882'),
       (2, 'Anna', 'Semenova', '22.12.1989', 'female', 'HB353567'),
       (3, 'Alex', 'Egorov', '15.04.1994', 'male', 'HB464667'),
       (4, 'Evgen', 'Kolos', '18.03.1981', 'male', 'HB5464667'),
       (5, 'Olga', 'Kukushkina', '25.06.1998', 'female', 'HB353567');

insert into city (id, title, country)
VALUES (1, 'Moscow', 'Russia'),
       (2, 'Minsk', 'Belarus'),
       (3, 'Warsaw', 'Poland'),
       (4, 'Berlin', 'Germany'),
       (5, 'Sochi', 'Russia');

insert into plane (id, model, manufacturer, number_of_seats)
VALUES (1, 'Boeing 737-8', 'Boeing, USA', 174),
       (2, 'Embraer 195', 'Embraer , Brazil', 107),
       (3, 'Boeing 737-300', 'Boeing, USA', 148);

insert into crew (id, first_name, sur_name, post, plane_id)
VALUES (1, 'Victor', 'Shadrin', 'Pilot', 1),
       (2, 'Sergey', 'Doronin', 'Pilot-1', 1),
       (3, 'Fedor', 'Chepcov', 'Pilot-2', 1),
       (4, 'Artem', 'Efreev', 'Engineer', 1),
       (5, 'Anna', 'Subot', 'stewardes', 1),
       (6, 'Elena', 'Gerasimova', 'stewardes', 1);

insert into route (id, title, arrival_date_time, duration, departure_city_id, arrival_city_id)
VALUES (1, 'Minsk - Moscow', '12/04/2023', 85.00, 2, 1),
       (2, 'Minsk - Warsaw', '22/04/2023', 70.00, 2, 3),
       (3, 'Minsk - Berlin', '21/04/2023', 120.00, 2, 4),
       (4, 'Minsk - Sochi', '15/04/2023', 165.00, 2, 5);

insert into plane_route (id, plane_id, route_id)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 1, 4);

insert into order_status (id, status_order)
VALUES (1, 'new'),
       (2, 'payment received'),
       (3, 'payment failed'),
       (4, 'in progress'),
       (5, 'completed'),
       (6, 'closed'),
       (7, 'canceled');

insert into air_crew (id, plane_id, crew_id)
VALUES (1, 1, 1),
       (2, 1, 2),
       (3, 1, 3),
       (4, 1, 4),
       (5, 1, 5),
       (6, 1, 6);

insert into payment_status (id, status_payment)
VALUES
    (1, 'unpaid'),
    (2, 'paid'),
    (3, 'failed'),
    (4, 'expired'),
    (5, 'refunding'),
    (6, 'refunded');












