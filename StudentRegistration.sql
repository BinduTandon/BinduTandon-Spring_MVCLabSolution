create database studentRegistrationManagement;
Use studentRegistrationManagement;
create table student (studentId int primary key, studentName varchar(50),
department varchar(50), country varchar(50));
select * from student;
Insert into student values (1, 'Suresh', 'B.Tech', 'India');
insert into student values (2, 'Muri', 'B.Arch', 'Canada');

