use sample

create Login user_test
with password ='345123'

create login user_test5
with password ='345123'

create user user_test for login user_test
create user user_test5 for login user_test5

grant update, insert to user_test

revoke update, insert to user_test

create role quanlyproject authorization user_test
drop role quanlyproject

grant select
on project
to quanlyproject

revoke select on project to quanlyproject

sp_addRoleMember 'quanlyproject','user_test'
sp_dropRoleMember 'quanlyproject','user_test'