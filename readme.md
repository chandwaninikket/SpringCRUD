REST Api based on SpringBoot with database in Postgres SQL

Functions available:
Create a customer.
Get all customers
Get a single customer using CustomerID passed in as pathVariable
Get a single customer using email and mobile and validation using OTP
Delete a customer
Modifying a customer.


Validations done using Bean Annotations
Mobile numbers have to be 10 digits.
The queries can't be empty and can't miss any parameter.
Email and Mobile are unique.
Primary ID is StringBased generated using a random function for now. 

Query: {
        "first_name": "Nikket", //String variable - Can't be empty
        "last_name": "Chandwani", // String Variable 
        "email": "nikketpchandwani@gmail.con", // Email - String 
        "email_alt": "tehzezhc@gmail.com", // Email - String
        "mobile": 7977180541, //Long Variable - Restricted to exactly 10 digits
        "mobile_alt": 702102030, // Long Variable - Restricted to exactly 10 digits
        "city": "Navi Mumbai", // String - cant be empty
        "address": "Sion, Mumbai", // String cant be empty
        "address_alt": "Sion Koliwada W", // String cant be empty
        "state": "Maharashtra", // String can't be empty
        "country": "India", // String cant be empty
        "pincode": 400037 // String cant be empty
}

For Update Query - The following can be updated.
{
    "city": "Navi Mumbai",
    "state": "Maharashtra",
    "mobile_alt": 702154030,
    "address_alt": "Sion Koliwada W",
    "email_alt": "tehzezhc@gmail.com"
}
