create schema if not exists test collate utf8mb4_general_ci;

create table if not exists contact
(
	id int auto_increment
		primary key,
	first_name varchar(32) not null,
	phone varchar(32) not null,
    constraint contact_name_uindex
    unique (first_name)
);

INSERT INTO contact
VALUES
(1, "John", "+79991234567"),
(2, "Bob", "+79210987654"),
(3, "Emil", "+79534567812|+79114328901"),
(4, "Kaine", "+79218947654");
