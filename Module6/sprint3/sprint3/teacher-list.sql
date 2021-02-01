use project3_thesis_management;

#Student_Group
INSERT INTO project3_thesis_management.student_group (id, file_url, group_name, quantity, teacher_id) VALUES (1, null, 'Nhóm 1', 3, null);
INSERT INTO project3_thesis_management.student_group (id, file_url, group_name, quantity, teacher_id) VALUES (2, null, 'Nhóm 2', 4, null);
INSERT INTO project3_thesis_management.student_group (id, file_url, group_name, quantity, teacher_id) VALUES (3, null, 'Nhóm 3', 5, null);

#Student
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đoàn Ngọc Lĩnh', '0775123456', true, 1);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Trương Tấn Hải', '0775123456', false, 1);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đỗ Văn Liêm', '0775123456', false, 1);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đoàn Ngọc Lĩnh', '0775123456', true, 2);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Trương Tấn Hải', '0775123456', false, 2);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Trương Tấn Hải', '0775123456', false, 2);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Trương Tấn Hải', '0775123456', false, 2);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đỗ Văn Liêm', '0775123456', true, 3);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đỗ Văn Liêm', '0775123456', false, 3);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đỗ Văn Liêm', '0775123456', false, 3);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đỗ Văn Liêm', '0775123456', false, 3);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đỗ Văn Liêm', '0775123456', false, 3);
INSERT INTO project3_thesis_management.student (email, full_name, phone, position, group_id) VALUES ('linhdn@codegym.vn', 'Đỗ Văn Liêm', '0775123456', false, null);

#Techer
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (1, 'trungdoan@codegym.vn', 'Đoàn Phước Trung', '123567991',10,  '0901171603', 'CG-1111', null);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (2, 'trungdang@codegym.vn', 'Đặng Chí Trung', '201675711',10, '0776401281', 'CG-2222', null);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (3, 'haitantruong@codegym.vn', 'Trương Tấn Hải', '258222223',15, '0905085170', 'CG-3333', null);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (4, 'tiennvt@codegym.vn', 'Nguyễn Vũ Thành Tiến', '985005556',15, '0903123456', 'CG-4444', null);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (5, 'chanhtv@codegym.vn', 'Trần Văn Chánh', '789632510',5, '0901174116', 'CG-5555', null);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (6, 'linhdn@codegym.vn', 'Đoàn Ngọc Lĩnh', '123698520',10, '0775123456', 'CG-6666', null);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (7, 'nguyenlv@codegym.vn', 'Lê Vũ Nguyên', '201075123',10, '0775123456', 'CG-7777', null);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, number_student, phone, teacher_code, app_account_id) VALUES (8, 'tamttt@codegym.vn', 'Trần Thị Tố Tâm', '201075189',15, '0775123456', 'CG-8888', null);

CREATE VIEW instruction_status AS
    SELECT 
        project3_thesis_management.teacher.id AS id,
        project3_thesis_management.teacher.full_name AS fullName,
        project3_thesis_management.teacher.email AS email,
        project3_thesis_management.teacher.phone AS phone,
        project3_thesis_management.teacher.number_student AS limitStudentRegister,
        project3_thesis_management.student_group.quantity AS numberStudentRegister,
        SUM(project3_thesis_management.student_group.quantity) AS totalStudentRegister
    FROM
        project3_thesis_management.teacher
            LEFT JOIN
        project3_thesis_management.student_group ON teacher.id = student_group.teacher_id
    GROUP BY project3_thesis_management.teacher.id