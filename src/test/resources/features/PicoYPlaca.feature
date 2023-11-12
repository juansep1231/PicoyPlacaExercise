Feature: Check plate restriction

In this feature, we are going to test the functionalities of the program to
obtain check the car circulation restriction based on the plate, the day and 
the time.

Scenario Outline: Check car restriction
   Given a car with plate <plateNumber>
   And a valid date <date> and time <time>
   When the program check the restriction
   Then the restriction is <restriction>
   Examples:
    | plateNumber | date          | time    | restriction |
    | "PVC-0391"  | "06/11/2023"  | "07:20" |   "true"    |
    | "PTC-0392"  | "13/11/2023"  | "15:20" |   "false"   |
    | "PXC-0390"  | "20/11/2023"  | "18:00" |   "false"   |
    | "PVC-0393"  | "05/12/2023"  | "18:45" |   "true"    |
    | "PTC-0394"  | "12/12/2023"  | "12:20" |   "false"   |
    | "PXC-0397"  | "19/12/2023"  | "18:00" |   "false"   |
    | "TVC-0395"  | "07/02/2024"  | "08:43" |   "true"    |
    | "ETC-0396"  | "14/02/2024"  | "15:20" |   "false"   |
    | "CXC-0397"  | "21/02/2024"  | "17:21" |   "false"   |
    | "IVC-0397"  | "04/04/2024"  | "16:45" |   "true"    |
    | "IAC-0398"  | "11/04/2024"  | "13:25" |   "false"   |
    | "EXC-0393"  | "18/04/2024"  | "18:59" |   "false"   |
    | "GVC-0399"  | "05/07/2024"  | "07:43" |   "true"    |
    | "GIC-0390"  | "12/07/2024"  | "05:20" |   "false"   |
    | "PIC-0392"  | "19/07/2024"  | "09:21" |   "false"   |
    | "TVC-0395"  | "03/08/2024"  | "08:43" |   "false"   |
    | "ETC-0396"  | "11/08/2024"  | "17:20" |   "false"   |
    | "CXC-0397"  | "17/08/2024"  | "13:21" |   "false"   |