# 🚀 Ultimate Setup & Installation Guide: EdTech CRM

This documentation contains all the steps required to configure, run, and test the project locally from scratch.

---

## 📋 Step 1: Prerequisites Check
Ensure your machine has the following installed before proceeding:
1. Java Development Kit (JDK 17 or 21): Verify by running `java -version` in your terminal.
2. VS Code Extensions: Make sure "Extension Pack for Java" and "Spring Boot Extension Pack" are installed.

---

## 📂 Step 2: Extract & Folder Structure Alignment
1. Extract (unzip) the project folder downloaded from Spring Initializr.
2. Open VS Code, go to File -> Open Folder, and select the extracted folder.
3. Verify in the left sidebar that your structure matches this exact layout:
   
   src/main/java/leads/Leads/
   ├── config/          --> DataInitializer.java
   ├── controller/      --> SalesController.java
   ├── model/           --> Lead.java
   ├── repository/      --> LeadRepository.java
   └── service/         --> LeadService.java

---

## ⚙️ Step 3: Application Configuration Setup
Open the `src/main/resources/application.properties` file, delete any existing text, paste the following configuration, and save it (Ctrl + S):

spring.datasource.url=jdbc:h2:file:./data/edtech_crm
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

---

## 🛠️ Step 4: Workspace Refresh & Build Optimization
If you see red error underlines on your files in VS Code, execute these two steps:
1. Press `Ctrl + Shift + P` to open the Command Palette. Type `Java: Clean Java Language Server Workspace`, select it, and choose Restart.
2. Open the `pom.xml` file located at the root directory, add a blank space anywhere, and save the file. When a notification appears at the bottom right asking to update configurations, click Now or Always.

---

## 🏃 Step 5: How to Run the Application

### Method A (Via VS Code UI):
1. Navigate to `src/main/java/leads/Leads/` in the Explorer and open `LeadsApplication.java`.
2. Click the small "Run" link appearing directly above the `public class LeadsApplication` line (or click the Play icon in the top right corner).

### Method B (Via Terminal):
1. Open a new terminal window in VS Code (Terminal -> New Terminal).
2. Type the following command and hit Enter:
   ./mvnw spring-boot:run
   (Note: If you face PowerShell restrictions on Windows, type `mvn spring-boot:run` instead).

Success Indicator: The terminal logs will scroll down. Once the application starts successfully, you will see this exact message printed at the bottom:
>>> System Initialized with package leads.Leads! <<<

---

## 📊 Step 6: Testing & Validation Metrics

### 1. Inspect the In-Memory Web Database:
* Open your browser and navigate to: http://localhost:8080/h2-console
* Clear the default text in the JDBC URL field and replace it exactly with: jdbc:h2:file:./data/edtech_crm
* Leave the Username as `sa` and keep the Password completely blank.
* Click Connect. You will see the LEADS table in the left sidebar schema window.

### 2. Test the Lead Priority Pipeline API:
* Open a new browser tab and navigate to: http://localhost:8080/api/sales/daily-queue
* You will see a raw JSON data array. According to our processing algorithm, the highest priority profile (Rahul Sharma - B.Tech, 3 Yrs Exp) will automatically be sorted and displayed at the very top of the calling queue.
