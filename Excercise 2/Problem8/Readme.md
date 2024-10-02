# Virtual Classroom Manager - Singleton, Observer, and Command Patterns

## Overview
This repository demonstrates the implementation of a **Virtual Classroom Manager** using design patterns. The Virtual Classroom Manager handles classroom creation, student enrollment, and assignment submissions. It uses a command-line interface to interact with the system and applies the **Singleton**, **Observer**, and **Command** patterns for managing and controlling the operations.

### Design Patterns:
1. **Singleton Pattern**: Ensures that there is only one instance of the Virtual Classroom Manager.
2. **Observer Pattern**: Notifies users when classroom events, such as assignment submissions, occur.
3. **Command Pattern**: Encapsulates operations like adding classrooms, enrolling students, and submitting assignments as commands.

---

## Key Concepts
1. **VirtualClassroomManager**: Manages the overall system, including classrooms and students.
2. **Concrete Classes (Classroom, Student)**: 
   - **Classroom**: Manages students and assignments for a specific class.
   - **Student**: Represents a student with an ID, enrolled in a classroom.
3. **Command Line Interface**: The main method in the `VirtualClassroomManager` class allows interaction through commands for creating classrooms, enrolling students, and managing assignments.

---

## Features
- **Add Classroom**: Create virtual classrooms.
- **Enroll Student**: Enroll students in specific classrooms.
- **Schedule Assignments**: Add assignments for a class.
- **Submit Assignments**: Submit assignments for students in a class.
- **Command-line interface**: Supports user input for managing classrooms and students.

---

