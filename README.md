# Pico y Placa Predictor Exercise

This program allows the user to check if a car has a "Pico y Placa" restriction given the car's license plate number, the date and the time. For the purposes of the exercise the following considerations were taken into account:

1.  The exercise is designed for **cars only** (motorcycles were not part of the requirements).
2. The restrictions in the car license plate numbers are given by the table shown below. (Weekends has no restriction).

| Day        | Last digit of the license plate number |
| --------   | -------                                |
| Monday     | 1,2                                   |
| Tuesday    | 3,4                                    |
| Wednesday  | 5,6                                   |
| Thursday   | 7,8                                   |
| Friday     | 9,0                                   |
3. The range of restricted hours is from 07:00 to 9:30 in the morning, and from 16:00 to 19:30 at night.
4. The **date format** is `dd/MM/yyyy`. Every other format is invalid.
5. The **time format** is `HH:mm` using the 24-hour time format. Every other format is invalid.

## Table of Content
- [Used Technologies](https://github.com/juansep1231/PicoyPlacaExercise/new/main?readme=1#used-technologies)
- [Code Structure](https://github.com/juansep1231/PicoyPlacaExercise/new/main?readme=1#code-structure)
- [Usage examples](https://github.com/juansep1231/PicoyPlacaExercise/new/main?readme=1#usage-examples)
- [Testing](https://github.com/juansep1231/PicoyPlacaExercise/new/main?readme=1#usage-examples)
## Used Technologies
- Java language.
- Jform and JOptionPane - input and output data.
- Cucumber - testing tool.
- Git and Github - version control.
- NetBeans 12.0 - IDE

## Code Structure

The code is organized into four packages `model` , `form` and `exceptions`.
1. The `model` package contains the classes that handle business rules. 
2. The `form` package contains the form used for input and output data.
3. The `exceptions` package contains custom exceptions for day and time format.

#### `model` package

Contains the following classes:
1. **Car** - Represents a car with it's respective license plate number.
2. **DateTime** - Contains attributes and methods to handle date and time input.
3. **PicoYPlaca** - Contains attributes and methods to check the circulation restriction, using the given license plate number from a `Car` object, and a `DateTime` object. 

And the enum:
1. **DaysWithPlateRestrictions** - Contains the days of the week, each day has a list of it's corresponding restrictions.

#### `form` package
Contains the **JFInputData** class, to handle the user's input and output.

#### `form` package
Contains the custom exceptions **InvalidDateException** and **InvalidDateException**.

# Usage examples

## 1. Checking car with restriction.

In this usage example the input is:
- License plate number: PVC-0390
- Date: 01/12/2023 (Friday)
- Time: 18:30

As shown in the image below:

![restricted_plate_example](https://github.com/juansep1231/PicoyPlacaExercise/assets/78103491/e25b2438-e32e-432f-8de4-ac9ad1cd4d86)


The output in this case is warning because the car has circulation restriction. As shown in the image below.

![output_restriction](https://github.com/juansep1231/PicoyPlacaExercise/assets/78103491/3c7a90e4-9654-41c6-b7b2-17cdd904416f)

## 2. Checking car without restriction.
In this usage example the input is:
- License plate number: EVC-0395
- Date: 15/11/2023 (Wednesday)
- Time: 15:30

As shown in the image below:

![plate_no_restriction](https://github.com/juansep1231/PicoyPlacaExercise/assets/78103491/3dc25467-3026-417f-a66e-3027e50e1c6c)

The output in this case is an information message because the car has no cirulation restriction. As shown in the image below.

![no_restricttion_result](https://github.com/juansep1231/PicoyPlacaExercise/assets/78103491/bca72d46-3b57-4fb7-ab64-5975bda481a1)


# Testing

For testing purposes I used the Cucumber framework, and the test cases shown in the image below. 

![imagen](https://github.com/juansep1231/PicoyPlacaExercise/assets/78103491/8df6508b-cbda-4228-baa0-920e9027de17)

