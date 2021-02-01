-- create view instruction_status as
-- SELECT project3_thesis_management.teacher.id as id,
--        project3_thesis_management.teacher.full_name as fullName,
--        SUM(project3_thesis_management.student_group.quantity) as totalStudentRegister,
--        project3_thesis_management.teacher.number_student as numberStudent
-- FROM project3_thesis_management.student_group
--          inner join project3_thesis_management.teacher on student_group.teacher_id = teacher.id
-- GROUP BY project3_thesis_management.student_group.teacher_id;

create view instruction_status as
select project3_thesis_management.teacher.id          as id,
       project3_thesis_management.teacher.full_name      as fullName,
       project3_thesis_management.teacher.number_student as limitStudentRegister,
       project3_thesis_management.student_group.quantity as numberStudentRegister,
       sum(project3_thesis_management.student_group.quantity) as totalStudentRegister
from project3_thesis_management.teacher
         left join project3_thesis_management.student_group on teacher.id = student_group.teacher_id
group by project3_thesis_management.teacher.id



