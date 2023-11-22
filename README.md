# ContactList


The test cases are designed to validate key functionalities of a contact list application hosted on https://thinking-tester-contact-list.herokuapp.com/. They cover a range of scenarios including user registration ("Sign Up"), ensuring mandatory fields are enforced, creating new contacts, handling missing mandatory information, deleting existing contacts, and editing contact details. These test cases aim to verify the accuracy of user interactions, data input validations, successful data manipulation, and proper system behavior in response to user actions such as signing up, managing contacts, and editing information.

# "Sign Up" Test Case:

1. Open the site (https://thinking-tester-contact-list.herokuapp.com/).
2. Click the "SIGN UP" button.
3. Fill in all mandatory details.
4. Click the "SUBMIT" button.
5. Verify successful registration by confirming the new user is signed in.
6. Logout from the account.
7. Verify the user is successfully signed out.

# "Cannot Sign Up Without Mandatory Fields" Test Case:

1. Open the site (https://thinking-tester-contact-list.herokuapp.com/).
2. Click the "SIGN UP" button.
3. Submit the form without filling in mandatory fields.
4. Verify that appropriate error messages are displayed indicating missing values for mandatory fields.

# "Create Contact" Test Case:

1. Open the site (https://thinking-tester-contact-list.herokuapp.com/).
2. Log in using the previously created account.
3. Confirm successful login.
4. Click "ADD A NEW CONTACT."
5. Enter information into all necessary fields.
6. Click "SUBMIT."
7. Verify the creation of the new contact.
8. Ensure all fields of the new contact display the correct information.

# "Cannot Create Contact Without Mandatory Fields" Test Case:

1. Open the site (https://thinking-tester-contact-list.herokuapp.com/).
2. Log in using the previously created account.
3. Confirm successful login.
4. Click "ADD A NEW CONTACT."
5. Submit the form without filling in mandatory fields.
6. Verify that appropriate error messages are displayed indicating missing values for mandatory fields.

# "Delete Contact" Test Case:

1. Open the site (https://thinking-tester-contact-list.herokuapp.com/).
2. Log in using the previously created account.
3. Confirm successful login.
4. Click on an existing contact.
5. Verify that the contact details are displayed.
6. Click the "DELETE CONTACT" button.
7. Confirm that the contact is successfully removed.

# "Edit Contact" Test Case:

1. Open the site (https://thinking-tester-contact-list.herokuapp.com/).
2. Log in using the previously created account.
3. Confirm successful login.
4. Click on an existing contact.
5. Verify that the contact details are displayed.
6. Click the "EDIT CONTACT" button.
7. Modify all contact details.
8. Click "SUBMIT."
9. Confirm that all changes are successfully saved.
10. Click "RETURN TO CONTACT LIST."
11. Confirm that the edited values are displayed correctly on the contact list.
