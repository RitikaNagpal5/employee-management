# Management Tree Algorithm 

##Perquisites:

Java 1.8 version

## Steps to Run:
1. Management Tree is the main class to run
2. Input data file are in resource folder (json format) that 
includes the json array of employees.
3. To run different test cases, add the input file in resources folder and 
change the name of file in ManagementTree Class.

Example:

Input-

{
  "employees": [

    {
      "id" :5,
      "name" : "Sarah",
      "mId" :10
    },
    {
      "id" :7,
      "name" : "John",
      "mId" :2
    },

    {
      "id" :3,
      "name" : "Jerry",
      "mId" :10
    },

    {
      "id" :2,
      "name" : "Mikey",
      "mId" :10
    },

    {
      "id" :10,
      "name" : "Tom",
      "mId" :0
    }
  ]
}

Output-

->Jerry 

->->Philip

->->->David

->->->->Alice

->->->->->John

->->->->Mike

->->->Ken

->->->->Peter

->->->Tom

->->Stacie
