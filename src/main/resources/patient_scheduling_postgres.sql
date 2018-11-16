create table public.patient(
  id serial PRIMARY KEY,
  first_name varchar(20),
  last_name varchar(30),
  phone varchar(30),
  provider_name varchar(30),
  copay decimal(10,5)
)

create table public.doctor(
  id serial PRIMARY KEY,
  first_name varchar(20),
  last_name varchar(30),
  speciality varchar(30)
)

create table public.patients_doctors(
  patient_id int,
  doctor_id int,
  FOREIGN KEY (patient_id)
  REFERENCES public.patient(id),
  FOREIGN KEY (doctor_id)
  REFERENCES public.doctor(id)
)

create table public.appointment (
  id               SERIAL PRIMARY KEY,
  patient_id       INT,
  doctor_id        INT,
  appointment_time TIMESTAMP,
  started          BOOLEAN,
  ended            BOOLEAN,
  reason           VARCHAR(200),
  FOREIGN KEY (patient_id)
  REFERENCES public.patient (id),
  FOREIGN KEY (doctor_id)
  REFERENCES public.doctor (id)
)