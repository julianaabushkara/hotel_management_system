# Hotel Management System (HRS) - Java GUI Application
 Designed and developed a fully functional hotel management system using Java and object-oriented principles.
## Requirements
- Java 8 

## How to Run
1. Download the project folder
2. Open terminal/command prompt in project folder
3. javac -d bin --release 8 -cp "jcalendar-1.4.jar" src/View/*.java src/model/*.java src/utils/*.java src/exceptions/*.java src/autopilot/*.java
4. Run: `java -cp "bin;jcalendar-1.4.jar" View.Login`

## If you get errors
- Make sure Java is installed: `java -version`
- Use semicolon (;) on Windows, colon (:) on Mac/Linux


## Project Overview

A comprehensive **Hotel Reservation System (HRS)** built with Java GUI that manages hotel operations including room bookings, customer management, employee administration, and department organization. This system demonstrates advanced Object-Oriented Programming concepts including inheritance, abstract classes, interfaces, and serialization.

## 🏨 System Features

### Core Functionality
- **Room Management**: Standard rooms, superior rooms, and suites
- **Customer Management**: Regular customers and VIP customers  
- **Employee Management**: Staff and department managers
- **Booking System**: Reservation handling and management
- **Department Organization**: Multi-department structure with managers

### User Authentication & Authorization
- **Admin Access**: Full system privileges
  - Add/remove all entities
  - Execute all queries
  - View all system data
- **Employee Access**: Limited privileges
  - Cannot add/remove employees or managers
  - Can perform all other operations

##Architecture

### Package Structure
```
src/
├── model/                 # Core business logic
│   ├── Hotel.java        # Main hotel class (Singleton pattern)
│   ├── Room.java         # Abstract room class
│   ├── StandardRoom.java # Standard room implementation
│   ├── SuperiorRoom.java # Superior room implementation
│   ├── Suite.java        # Suite implementation
│   ├── Person.java       # Abstract person class
│   ├── Customer.java     # Customer implementation
│   ├── VIPCustomer.java  # VIP customer implementation
│   ├── Employee.java     # Employee implementation
│   ├── DepartmentManager.java # Manager implementation
│   ├── Booking.java      # Booking management
│   └── Department.java   # Department structure
├── View/                 # GUI components (Swing/JavaFX)
├── Utils/                # Utility classes and enums
│   ├── Area.java         # Geographical areas enum
│   ├── Gender.java       # Gender enum
│   ├── Specialization.java # Employee specializations enum
│   └── MyFileLogWriter.java # File output utilities
├── Exceptions/           # Custom exception classes
└── autopilot/           # File handling utilities
```

### Key Design Patterns
- **Singleton Pattern**: Hotel class ensures single instance
- **Inheritance Hierarchy**: Person → Customer/Employee → VIPCustomer/DepartmentManager
- **Abstract Classes**: Room, Person base classes
- **Serialization**: Data persistence via Hotel.ser file


### Development Environment
- **Java Version**: Java 8 
- **IDE**: Eclipse (recommended) or any Java IDE
- **GUI Framework**: Swing (recommended) or JavaFX
- **Build Tool**: Standard Java compilation

### System Requirements
- Windows/Mac/Linux operating system
- Minimum 512MB RAM
- 50MB storage space


## Usage

### System Startup
1. **First Launch**: System creates new Hotel.ser file
2. **Subsequent Launches**: Loads existing data from Hotel.ser
3. **Login Screen**: Authentication required

### Default Credentials
```
Admin Access:
Username: admin
Password: admin
```

### Main Features

#### 🏨 Hotel Management
- Add/remove rooms of different types
- Set room prices and availability
- Manage room bookings

#### 👥 Customer Operations
- Register new customers
- Upgrade to VIP status
- Track customer booking history

#### 👨‍💼 Employee Management
- Add employees with specializations
- Assign department managers
- Set employee credentials

#### 📊 Reporting & Queries
- Find most profitable rooms
- Employee salary reports
- Booking statistics
- Customer analytics

## 🛠️ Key Implementation Details

### Data Persistence
- **Serialization**: All data saved to `Hotel.ser` file
- **Auto-save**: Data persisted on system shutdown
- **Data Recovery**: Automatic loading on startup

### Exception Handling
Custom exception classes in `Exceptions` package:
- **Business Logic Exceptions**: Invalid operations
- **Data Validation Exceptions**: Input validation
- **File I/O Exceptions**: Serialization errors

## 📈 Bonus Features (Optional)
- **Video Background**: Animated hotel background (10 pts))
- **Creative Implementation**: Innovative features
- **Advanced UI/UX**: Animations, sounds, effects
- **Performance Optimization**: Efficient algorithms



## Troubleshooting

### Common Issues
1. **Compilation Errors**: Check Java version compatibility
2. **File Not Found**: Ensure Hotel.ser is in correct directory
3. **GUI Issues**: Verify Swing/JavaFX setup
4. **Login Problems**: Use default admin credentials


## 📚 Learning Objectives

This project demonstrates mastery of:
- **OOP Principles**: Inheritance, polymorphism, encapsulation
- **Design Patterns**: Singleton, Factory patterns
- **GUI Development**: Event-driven programming
- **Data Persistence**: Object serialization
- **Exception Handling**: Custom exception hierarchies
- **Software Architecture**: Multi-layer application design

