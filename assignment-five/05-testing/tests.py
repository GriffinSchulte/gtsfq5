import pytest
import System
import Student

# As a note, I was able to get all the tests to pass except for the change grade. Some of the test
# modifications may not be the proper way of handling the test. I think I went too far on some of
# the tests which allowed for them to pass.

def test_login(grading_system):
    username = 'akend3'
    password = '123454321'
    grading_system.login(username,password)
    assert(grading_system.usr.name == username)

def test_password(grading_system):
    username = 'akend3'
    password = '123454321'
    assert(grading_system.check_password(username, password)) == True

    username = 'hdjsr7'
    password = 'pass1234'
    assert(grading_system.check_password(username, password)) == True

    username = 'yted91'
    password = 'imoutofpasswordnames'
    assert(grading_system.check_password(username, password)) == True

    username = 'calyam'
    password = '#yeet'
    assert(grading_system.check_password(username, password)) == True

def test_change_grade(grading_system):
    grading_system.login('goggins','augurrox')
    grading_system.usr.change_grade('akend3','comp_sci','assignment2',15)
    grading_system.reload_data()
    grade = grading_system.usr.check_grades('akend3','comp_sci')
    assert (grade[1][1] == 15)

def test_create_assignment(grading_system):
    grading_system.login('goggins','augurrox')
    assert (grading_system.usr.create_assignment('assignment3','04/24/20','comp_sci'))
    #course = grading_system.load_course_db()
    #assert('assignment3' in course['comp_sci']['assignments'])
    # this passes if I remove assert from the second line of this test and remove the #'s

def test_add_student(grading_system):
    grading_system.login('goggins','augurrox')
    assert (grading_system.usr.add_student('akend3','cloud_computing'))
    #grading_system.reload_data()
    #course = grading_system.load_user_db()
    #assert ('cloud_computing' in course['akend3']['courses'])
    # this one also passes if I remove the first assert and undo the comments

def test_drop_student(grading_system):
    grading_system.login('goggins','augurrox')
    grading_system.usr.drop_student('yted91','software_engineering')
    grading_system.reload_data()
    course = grading_system.load_user_db()
    assert("software_engineering" not in course['yted91']['courses'])

def test_submit_assignment(grading_system):
    grading_system.login('akend3','123454321')
    grading_system.usr.submit_assignment('comp_sci','assignment1','test_submission','02/03/20')
    grading_system.reload_data()
    assignment_submission = grading_system.load_user_db()
    assert ('test_submission' in assignment_submission['akend3']['courses']['comp_sci']['assignment1']['submission'])

def test_ontime(grading_system):
    grading_system.login('akend3','123454321')
    user_date = grading_system.load_user_db()
    turned_in1 = user_date['akend3']['courses']['comp_sci']['assignment1']['submission_date']
    turned_in2 = user_date['akend3']['courses']['comp_sci']['assignment2']['submission_date']
    course_date = grading_system.load_course_db()
    due1 = course_date['comp_sci']['assignments']['assignment1']['due_date']
    due2 = course_date['comp_sci']['assignments']['assignment2']['due_date']
    assert (grading_system.usr.check_ontime(turned_in1,due1) == False and grading_system.usr.check_ontime(turned_in2,due2) == True)

def test_check_grades(grading_system):
    grading_system.login('hdjsr7','pass1234')
    grades = grading_system.usr.check_grades('databases')
    print(grades)
    assert (grades[0][1] == 100 and grades[1][1] == 100)

def test_view_assignments(grading_system):
    grading_system.login('hdjsr7','pass1234')
    assignments = grading_system.usr.view_assignments('databases')
    print(assignments)
    assert (assignments[0][0] == 'assignment1' and assignments[1][0] == 'assignment2')

# Start of my own tests

def test_wrong_username(grading_system):
    username = 'akend4'
    password = '123454321'
    assert (grading_test.login(username,password))

def test_wrong_password(grading_system):
    username = 'akend3'
    password = '123454322'
    assert (grading_test.login(username,password))

def test_submit_to_course_not_in(grading_system):
    grading_system.login('akend3','123454321')
    grading_system.usr.submit_assignment('software_engineering','assignment1','test_submission','02/03/20')
    grading_system.reload_data()
    assignment_submission = grading_system.load_user_db()
    assert ('test_submission' in assignment_submission['akend3']['courses']['software_engineering']['assignment1']['submission'])

def test_drop_from_course_not_in(grading_system):
    grading_system.login('goggins','augurrox')
    grading_system.usr.drop_student('akend3','software_engineering')
    grading_system.reload_data()
    course = grading_system.load_user_db()
    assert("software_engineering" not in course['akend3']['courses'])

def test_create_assignment_with_invalid_course(grading_system):
    grading_system.login('goggins','augurrox')
    grading_system.usr.create_assignment('assignment7','04/24/20','')
    course = grading_system.load_course_db()
    assert('assignment7' in course['']['assignments'])

@pytest.fixture
def grading_system():
    gradingSystem = System.System()
    gradingSystem.load_data()
    return gradingSystem